package com.example.appnotas.volumenestres.medio

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
 * Pruebas de volumen medio para evaluar rendimiento en condiciones realistas.
 *
 * Estas pruebas verifican:
 * - El rendimiento con cientos de notas
 * - El manejo de contenido de tamaño moderado
 * - La escalabilidad en escenarios típicos
 */
@RunWith(AndroidJUnit4::class)
class MediumVolumeTests {

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
     * Prueba inserción de volumen medio de notas.
     *
     * @throws AssertionError si no se completan las inserciones o hay problemas de rendimiento
     */
    @Test
    fun testMediumVolumeNoteInsertion() = runBlocking {
        val noteCount = 500 // Nivel medio
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
            val batchSize = 50
            val batches = noteCount / batchSize

            val totalTimeMs = measureTimeMillis {
                repeat(batches) { batch ->
                    withContext(Dispatchers.IO) {
                        val start = batch * batchSize
                        val end = start + batchSize

                        for (i in start until end) {
                            val note = Notes(
                                title = "Medium Note $i",
                                description = "Content for medium note $i"
                            )
                            viewModel.insertNote(note)
                        }
                    }
                    delay(100) // Pausa media entre lotes
                }
            }

            val memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
            val memoryUsed = (memoryAfter - memoryBefore) / 1024
            val totalTimeSec = totalTimeMs / 1000.0

            println("[MEDIO] Tiempo inserción $noteCount notas: ${"%.3f".format(totalTimeSec)}s")
            println("[MEDIO] Memoria usada: ${memoryUsed}KB")

            Assert.assertTrue(
                "Inserciones completadas: $notesInserted/$noteCount",
                latch.await(30, TimeUnit.SECONDS)
            )
        } finally {
            viewModel.allNotes.removeObserver(observer)
        }
    }

    /**
     * Prueba el manejo de notas con contenido de tamaño moderado.
     *
     * @throws AssertionError si la nota no se guarda correctamente
     */
    @Test
    fun testMediumNoteContent() = runBlocking {
        // Contenido mediano (100KB)
        val mediumContent = buildString {
            repeat(100 * 1024) {
                append("X")
            }
        }

        val note = Notes(
            title = "Nota con contenido mediano",
            description = mediumContent
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

            println("[MEDIO] Tiempo inserción nota mediana: ${"%.3f".format(insertionTimeSec)}s")
            println("[MEDIO] Memoria usada: ${memoryUsed}KB")

            Assert.assertTrue(
                "No se completó la inserción",
                latch.await(10, TimeUnit.SECONDS)
            )
            Assert.assertEquals(mediumContent.length, savedNote?.description?.length)
        } finally {
            viewModel.allNotes.removeObserver(observer)
        }
    }
}