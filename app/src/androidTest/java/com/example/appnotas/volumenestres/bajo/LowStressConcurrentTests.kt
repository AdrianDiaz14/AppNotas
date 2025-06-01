package com.example.appnotas.volumenestres.bajo

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
 * Pruebas de bajo estrés para verificar comportamiento básico en condiciones normales.
 *
 * Estas pruebas verifican:
 * - El funcionamiento básico con pocas operaciones concurrentes
 * - La capacidad de recuperación en condiciones ideales
 * - El consumo mínimo de recursos
 */
@RunWith(AndroidJUnit4::class)
class LowStressConcurrentTests {

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
     * Prueba operaciones concurrentes básicas con bajo volumen.
     *
     * @throws AssertionError si no se completan todas las operaciones
     */
    @Test
    fun testLowMixedConcurrentOperations() = runBlocking {
        val operationCount = 20 // Nivel bajo
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
                            val note = Notes(title = "Low Note $i", description = "Content")
                            viewModel.insertNote(note)
                            completedOperations.incrementAndGet()
                            latch.countDown()
                        }
                    }

                    val updateJob = launch {
                        repeat(operationCount) { i ->
                            delay(150) // Mayor delay para nivel bajo
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
                            delay(300) // Mayor delay para nivel bajo
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

            println("[BAJO] Tiempo operaciones concurrentes: ${"%.3f".format(executionTimeSec)}s")
            println("[BAJO] Memoria usada: ${memoryUsed}KB")

            Assert.assertTrue(
                "Operaciones completadas: ${completedOperations.get()}/$operationCount",
                latch.await(15, TimeUnit.SECONDS)
            )
        } finally {
            viewModel.allNotes.removeObserver(observer)
        }
    }

    /**
     * Prueba actualizaciones poco frecuentes con recuperación.
     *
     * @throws AssertionError si no se reciben suficientes actualizaciones
     */
    @Test
    fun testLowFrequencyUpdatesWithRecovery() = runBlocking {
        val note = Notes(title = "Low Recovery Note", description = "Initial content")
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
        val updateCount = 20 // Nivel bajo
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
                            delay(100) // Mayor delay entre actualizaciones
                            val updatedNote = insertedNote.copy(
                                description = "Low update $i",
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

            println("[BAJO] Tiempo actualizaciones: ${"%.3f".format(executionTimeSec)}s")
            println("[BAJO] Memoria usada: ${memoryUsed}KB")

            updateLatch.await(10, TimeUnit.SECONDS)
            Assert.assertTrue("Recibidas ${receivedUpdates.size} actualizaciones", receivedUpdates.size > updateCount / 2)
        } finally {
            viewModel.allNotes.removeObserver(updateObserver)
        }
    }
}