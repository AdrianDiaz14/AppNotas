package com.example.appnotas.volumenestres.bajo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.appnotas.database.*
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.runner.RunWith
import org.junit.rules.TestRule
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis

/**
 * Pruebas de manejo de imágenes en condiciones de bajo estrés.
 *
 * Estas pruebas verifican:
 * - El funcionamiento básico con pocas imágenes
 * - El comportamiento con pocas notas con imágenes
 * - Los límites inferiores del convertidor de URIs
 */
@RunWith(AndroidJUnit4::class)
class LowStressImageTests {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private lateinit var db: NotesRoomDatabase
    private lateinit var dao: NotesDao
    private lateinit var repository: NotesRepository
    private lateinit var viewModel: NotesViewModel

    @Before
    fun setup() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NotesRoomDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = db.notesDao()
        repository = NotesRepository(dao)
        viewModel = NotesViewModel(ApplicationProvider.getApplicationContext())
    }

    @After
    fun tearDown() {
        db.close()
    }

    /**
     * Prueba el manejo de notas con pocas imágenes.
     *
     * @throws AssertionError si hay problemas con la inserción o manejo de URIs
     */
    @Test
    fun testNotesWithFewImages() = runBlocking {
        val imageCount = 10
        val imageUris = List(imageCount) { "content://image/low_$it" }
        val note = Notes(
            title = "Nota con pocas imágenes",
            description = "Esta nota tiene $imageCount imágenes adjuntas",
            imageUris = imageUris
        )

        val latch = CountDownLatch(1)
        var savedNote: Notes? = null

        val observer = Observer<List<Notes>> { notes ->
            notes.find { it.title == note.title }?.let {
                savedNote = it
                latch.countDown()
            }
        }

        viewModel.allNotes.observeForever(observer)

        try {
            val memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
            val insertionTimeMs = measureTimeMillis {
                viewModel.insertNote(note)
            }
            val memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
            val memoryUsed = (memoryAfter - memoryBefore) / 1024
            val insertionTimeSec = insertionTimeMs / 1000.0

            println("[BAJO] Tiempo inserción nota ($imageCount imágenes): ${"%.3f".format(insertionTimeSec)}s")
            println("[BAJO] Memoria usada: ${memoryUsed}KB")

            Assert.assertTrue("No se completó la inserción", latch.await(5, TimeUnit.SECONDS))
            Assert.assertEquals(imageCount, savedNote?.imageUris?.size)
        } finally {
            viewModel.allNotes.removeObserver(observer)
        }
    }

    /**
     * Prueba la inserción de pocas notas con imágenes.
     *
     * @throws AssertionError si no se completan todas las inserciones
     */
    @Test
    fun testFewNotesWithImages() = runBlocking {
        val noteCount = 20
        val latch = CountDownLatch(noteCount)
        val insertedNotes = mutableSetOf<Notes>()

        val observer = Observer<List<Notes>> { notes ->
            notes.filter { it.title.startsWith("Low note") }
                .forEach { note ->
                    if (insertedNotes.add(note)) {
                        latch.countDown()
                    }
                }
        }

        viewModel.allNotes.observeForever(observer)

        try {
            val memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
            val creationTimeMs = measureTimeMillis {
                repeat(noteCount) { index ->
                    val note = Notes(
                        title = "Low note $index",
                        description = "Content",
                        imageUris = listOf("low_uri_$index")
                    )
                    viewModel.insertNote(note)
                }
            }
            val memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
            val memoryUsed = (memoryAfter - memoryBefore) / 1024
            val creationTimeSec = creationTimeMs / 1000.0

            println("[BAJO] Tiempo inserción $noteCount notas: ${"%.3f".format(creationTimeSec)}s")
            println("[BAJO] Memoria usada: ${memoryUsed}KB")

            Assert.assertTrue(
                "Solo se insertaron ${insertedNotes.size} de $noteCount notas",
                latch.await(10, TimeUnit.SECONDS)
            )
            Assert.assertEquals(noteCount, insertedNotes.size)
        } finally {
            viewModel.allNotes.removeObserver(observer)
        }
    }

    /**
     * Prueba los límites inferiores del convertidor de URIs de imágenes.
     *
     * @throws AssertionError si no se pueden manejar las URIs esperadas
     */
    @Test
    fun testImageConverterLowLimits() = runBlocking {
        val maxImageUris = 50
        val imageList = List(maxImageUris) { "content://image/low_limit_$it" }

        val note = Notes(
            title = "Nota con lista pequeña de imágenes",
            description = "Probando límites bajos del convertidor",
            imageUris = imageList
        )

        val latch = CountDownLatch(1)
        var savedNote: Notes? = null

        val observer = Observer<List<Notes>> { notes ->
            notes.find { it.title == note.title }?.let {
                savedNote = it
                latch.countDown()
            }
        }

        viewModel.allNotes.observeForever(observer)

        try {
            val memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
            val insertionTimeMs = measureTimeMillis {
                viewModel.insertNote(note)
            }
            val memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
            val memoryUsed = (memoryAfter - memoryBefore) / 1024
            val insertionTimeSec = insertionTimeMs / 1000.0

            println("[BAJO] Tiempo inserción nota ($maxImageUris URIs): ${"%.3f".format(insertionTimeSec)}s")
            println("[BAJO] Memoria usada: ${memoryUsed}KB")

            Assert.assertTrue("No se completó la inserción", latch.await(8, TimeUnit.SECONDS))
            Assert.assertEquals(maxImageUris, savedNote?.imageUris?.size)
        } finally {
            viewModel.allNotes.removeObserver(observer)
        }
    }
}