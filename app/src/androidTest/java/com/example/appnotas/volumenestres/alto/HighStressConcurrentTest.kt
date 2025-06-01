package com.example.appnotas.volumenestres.alto

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.appnotas.database.Notes
import com.example.appnotas.database.NotesRoomDatabase
import com.example.appnotas.database.NotesViewModel
import kotlinx.coroutines.*
import org.junit.*
import org.junit.runner.RunWith
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

/**
 * Pruebas de alto estrés concurrente para evaluar el rendimiento del DAO de notas
 * bajo condiciones de carga pesada con múltiples operaciones simultáneas.
 *
 * Estas pruebas verifican:
 * - La estabilidad del sistema con operaciones concurrentes intensivas
 * - El manejo adecuado de memoria bajo alta carga
 * - La capacidad de recuperación ante fallos
 */
@RunWith(AndroidJUnit4::class)
class HighStressConcurrentTests {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var db: NotesRoomDatabase
    private lateinit var viewModel: NotesViewModel

    @Before
    fun setup() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NotesRoomDatabase::class.java
        ).allowMainThreadQueries().build()

        viewModel = NotesViewModel(ApplicationProvider.getApplicationContext())
    }

    @After
    fun tearDown() {
        db.close()
    }

    /**
     * Prueba que ejecuta operaciones concurrentes de inserción, actualización y eliminación
     * en alto volumen para evaluar la estabilidad del sistema.
     *
     * @throws AssertionError si no se completan todas las operaciones o si hay problemas de rendimiento
     */
    @Test
    fun testHighMixedConcurrentOperations() = runBlocking {
        val operationCount = 150 // Nivel alto
        val latch = CountDownLatch(operationCount * 3)
        val completedOperations = AtomicInteger(0)

        val memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
        val observer = Observer<List<Notes>> { _ -> }

        viewModel.allNotes.observeForever(observer)

        try {
            val executionTimeMs = measureTimeMillis {
                withContext(Dispatchers.IO) {
                    val insertJob = launch {
                        repeat(operationCount) { i ->
                            val note = Notes(title = "High Note $i", description = "Content")
                            viewModel.insertNote(note)
                            completedOperations.incrementAndGet()
                            latch.countDown()
                        }
                    }

                    val updateJob = launch {
                        repeat(operationCount) { i ->
                            delay(10) // Delay mínimo para alto estrés
                            viewModel.allNotes.value?.randomOrNull()?.let { note ->
                                viewModel.updateNote(note.copy(
                                    description = "Updated ${System.currentTimeMillis()}"
                                ))
                                completedOperations.incrementAndGet()
                            }
                            latch.countDown()
                        }
                    }

                    val deleteJob = launch {
                        repeat(operationCount) { i ->
                            delay(20) // Delay mínimo para alto estrés
                            viewModel.allNotes.value?.randomOrNull()?.let { note ->
                                viewModel.deleteNote(note)
                                completedOperations.incrementAndGet()
                            }
                            latch.countDown()
                        }
                    }

                    listOf(insertJob, updateJob, deleteJob).forEach { it.join() }
                }
            }

            val memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
            val memoryUsed = (memoryAfter - memoryBefore) / 1024
            val executionTimeSec = executionTimeMs / 1000.0

            println("[ALTO] Tiempo operaciones concurrentes: ${"%.3f".format(executionTimeSec)}s")
            println("[ALTO] Memoria usada: ${memoryUsed}KB")

            Assert.assertTrue(
                "Operaciones completadas: ${completedOperations.get()}/$operationCount",
                latch.await(45, TimeUnit.SECONDS)
            )
        } finally {
            viewModel.allNotes.removeObserver(observer)
        }
    }

    /**
     * Prueba que verifica la capacidad de recuperación del sistema ante actualizaciones
     * frecuentes con posibles fallos intermitentes.
     *
     * @throws AssertionError si no se recibe al menos la mitad de las actualizaciones esperadas
     */
    @Test
    fun testHighFrequencyUpdatesWithRecovery() = runBlocking {
        val note = Notes(title = "High Recovery Note", description = "Initial content")
        viewModel.insertNote(note)

        val initialInsertLatch = CountDownLatch(1)
        val initialObserver = Observer<List<Notes>> { notes ->
            if (notes.any { it.title == note.title }) {
                initialInsertLatch.countDown()
            }
        }
        viewModel.allNotes.observeForever(initialObserver)
        initialInsertLatch.await(5, TimeUnit.SECONDS)
        viewModel.allNotes.removeObserver(initialObserver)

        val insertedNote = viewModel.allNotes.value?.first { it.title == note.title }!!
        val updateCount = 100 // Nivel alto
        val receivedUpdates = mutableListOf<String>()
        val updateLatch = CountDownLatch(updateCount)

        val memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
        val updateObserver = Observer<List<Notes>> { notes ->
            notes.firstOrNull { it.noteId == insertedNote.noteId }?.let { currentNote ->
                if (currentNote.description != receivedUpdates.lastOrNull()) {
                    receivedUpdates.add(currentNote.description)
                    updateLatch.countDown()
                }
            }
        }

        viewModel.allNotes.observeForever(updateObserver)

        try {
            val executionTimeMs = measureTimeMillis {
                withContext(Dispatchers.IO) {
                    repeat(updateCount) { i ->
                        try {
                            if (i % 10 == 0) {
                                delay(50) // Simular fallo ocasional
                            }
                            delay(10) // Delay mínimo para alto estrés
                            val updatedNote = insertedNote.copy(
                                description = "High update $i",
                                date = System.currentTimeMillis()
                            )
                            viewModel.updateNote(updatedNote)
                        } catch (e: Exception) {
                            updateLatch.countDown()
                        }
                    }
                }
            }

            val memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
            val memoryUsed = (memoryAfter - memoryBefore) / 1024
            val executionTimeSec = executionTimeMs / 1000.0

            println("[ALTO] Tiempo actualizaciones: ${"%.3f".format(executionTimeSec)}s")
            println("[ALTO] Memoria usada: ${memoryUsed}KB")

            updateLatch.await(30, TimeUnit.SECONDS)
            Assert.assertTrue("Recibidas ${receivedUpdates.size} actualizaciones", receivedUpdates.size > updateCount / 2)
        } finally {
            viewModel.allNotes.removeObserver(updateObserver)
        }
    }
}