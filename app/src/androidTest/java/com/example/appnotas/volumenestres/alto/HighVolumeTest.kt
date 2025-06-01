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
import kotlin.system.measureTimeMillis

/**
 * Pruebas de alto volumen para evaluar el rendimiento con grandes cantidades de datos.
 *
 * Estas pruebas verifican:
 * - La capacidad de manejar miles de notas
 * - El rendimiento con contenido de gran tamaño
 * - La escalabilidad del sistema
 */
@RunWith(AndroidJUnit4::class)
class HighVolumeTests {

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
     * Prueba la inserción masiva de notas en lotes para evaluar rendimiento.
     *
     * @throws AssertionError si no se completan todas las inserciones o hay problemas de memoria
     */
    @Test
    fun testHighVolumeNoteInsertion() = runBlocking {
        val noteCount = 2000 // Nivel alto
        val latch = CountDownLatch(1)
        var notesInserted = 0

        val memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
        val observer = Observer<List<Notes>> { notes ->
            notesInserted = notes.size
            if (notesInserted >= noteCount) {
                latch.countDown()
            }
        }

        viewModel.allNotes.observeForever(observer)

        try {
            val batchSize = 100
            val batches = noteCount / batchSize

            val totalTimeMs = measureTimeMillis {
                repeat(batches) { batch ->
                    withContext(Dispatchers.IO) {
                        val start = batch * batchSize
                        val end = start + batchSize

                        for (i in start until end) {
                            val note = Notes(
                                title = "High Note $i",
                                description = "Content for high note $i"
                            )
                            viewModel.insertNote(note)
                        }
                    }
                    delay(50) // Pausa corta para alto volumen
                }
            }

            val memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
            val memoryUsed = (memoryAfter - memoryBefore) / 1024
            val totalTimeSec = totalTimeMs / 1000.0

            println("[ALTO] Tiempo inserción $noteCount notas: ${"%.3f".format(totalTimeSec)}s")
            println("[ALTO] Memoria usada: ${memoryUsed}KB")

            Assert.assertTrue(
                "Inserciones completadas: $notesInserted/$noteCount",
                latch.await(60, TimeUnit.SECONDS)
            )
        } finally {
            viewModel.allNotes.removeObserver(observer)
        }
    }

    /**
     * Prueba el manejo de notas con contenido muy grande (1MB+).
     *
     * @throws AssertionError si la nota no se guarda correctamente o hay problemas de rendimiento
     */
    @Test
    fun testLargeNoteContent() = runBlocking {
        // Contenido grande (1MB)
        val largeContent = buildString {
            repeat(1024 * 1024) {
                append("X")
            }
        }

        val note = Notes(
            title = "Nota con contenido grande",
            description = largeContent
        )

        val latch = CountDownLatch(1)
        var savedNote: Notes? = null

        val memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
        val observer = Observer<List<Notes>> { notes ->
            notes.find { it.title == note.title }?.let {
                savedNote = it
                latch.countDown()
            }
        }

        viewModel.allNotes.observeForever(observer)

        try {
            val insertionTimeMs = measureTimeMillis {
                withContext(Dispatchers.IO) {
                    viewModel.insertNote(note)
                }
            }

            val memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
            val memoryUsed = (memoryAfter - memoryBefore) / 1024
            val insertionTimeSec = insertionTimeMs / 1000.0

            println("[ALTO] Tiempo inserción nota grande: ${"%.3f".format(insertionTimeSec)}s")
            println("[ALTO] Memoria usada: ${memoryUsed}KB")

            Assert.assertTrue(
                "No se completó la inserción",
                latch.await(20, TimeUnit.SECONDS)
            )
            Assert.assertEquals(largeContent.length, savedNote?.description?.length)
        } finally {
            viewModel.allNotes.removeObserver(observer)
        }
    }
}