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
import kotlin.system.measureTimeMillis

/**
 * Pruebas de bajo volumen para verificar comportamiento básico del sistema.
 *
 * Estas pruebas verifican:
 * - El funcionamiento con pocas notas
 * - El manejo de contenido pequeño
 * - El rendimiento en condiciones mínimas
 */
@RunWith(AndroidJUnit4::class)
class LowVolumeTests {

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
     * Prueba inserción de pocas notas para verificar comportamiento básico.
     *
     * @throws AssertionError si no se completan las inserciones
     */
    @Test
    fun testLowVolumeNoteInsertion() = runBlocking {
        val noteCount = 100 // Nivel bajo
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
            val batchSize = 20
            val batches = noteCount / batchSize

            val totalTimeMs = measureTimeMillis {
                repeat(batches) { batch ->
                    withContext(Dispatchers.IO) {
                        val start = batch * batchSize
                        val end = start + batchSize

                        for (i in start until end) {
                            val note = Notes(
                                title = "Low Note $i",
                                description = "Content for low note $i"
                            )
                            viewModel.insertNote(note)
                        }
                    }
                    delay(200) // Pausa más larga para bajo volumen
                }
            }

            val memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
            val memoryUsed = (memoryAfter - memoryBefore) / 1024
            val totalTimeSec = totalTimeMs / 1000.0

            println("[BAJO] Tiempo inserción $noteCount notas: ${"%.3f".format(totalTimeSec)}s")
            println("[BAJO] Memoria usada: ${memoryUsed}KB")

            Assert.assertTrue(
                "Inserciones completadas: $notesInserted/$noteCount",
                latch.await(15, TimeUnit.SECONDS)
            )
        } finally {
            viewModel.allNotes.removeObserver(observer)
        }
    }

    /**
     * Prueba el manejo de notas con contenido pequeño.
     *
     * @throws AssertionError si la nota no se guarda correctamente
     */
    @Test
    fun testSmallNoteContent() = runBlocking {
        // Contenido pequeño (10KB)
        val smallContent = buildString {
            repeat(10 * 1024) {
                append("X")
            }
        }

        val note = Notes(
            title = "Nota con contenido pequeño",
            description = smallContent
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

            println("[BAJO] Tiempo inserción nota pequeña: ${"%.3f".format(insertionTimeSec)}s")
            println("[BAJO] Memoria usada: ${memoryUsed}KB")

            Assert.assertTrue(
                "No se completó la inserción",
                latch.await(5, TimeUnit.SECONDS)
            )
            Assert.assertEquals(smallContent.length, savedNote?.description?.length)
        } finally {
            viewModel.allNotes.removeObserver(observer)
        }
    }
}