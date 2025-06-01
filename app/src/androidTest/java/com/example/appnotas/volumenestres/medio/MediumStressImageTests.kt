package com.example.appnotas.volumenestres.medio

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
 * Pruebas de manejo de imágenes en condiciones de estrés medio.
 *
 * Estas pruebas verifican:
 * - El rendimiento con cantidades moderadas de imágenes
 * - La estabilidad del convertidor de URIs
 * - El consumo de recursos en escenarios realistas
 */
@RunWith(AndroidJUnit4::class)
class MediumStressImageTests {

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
     * Prueba el manejo de notas con cantidad media de imágenes.
     *
     * @throws AssertionError si hay problemas con la inserción o manejo de URIs
     */
    @Test
    fun testNotesWithMediumImages() = runBlocking {
        val imageCount = 50 // Nivel medio
        val imageUris = List(imageCount) { "content://image/$it" }
        val note = Notes(
            title = "Nota con cantidad media de imágenes",
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
            val insertionTime = measureTimeMillis {
                viewModel.insertNote(note)
            }
            val memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
            val memoryUsed = memoryAfter - memoryBefore

            println("[MEDIO] Tiempo para insertar nota con $imageCount imágenes: ${insertionTime}ms")
            println("[MEDIO] Memoria usada: ${memoryUsed / 1024} KB")

            Assert.assertTrue("No se completó la inserción", latch.await(10, TimeUnit.SECONDS))

            Assert.assertEquals(imageCount, savedNote?.imageUris?.size)
        } finally {
            viewModel.allNotes.removeObserver(observer)
        }
    }

    /**
     * Prueba la inserción de muchas notas con pocas imágenes cada una.
     *
     * @throws AssertionError si no se completan todas las inserciones
     */
    @Test
    fun testMediumNotesWithImages() = runBlocking {
        val noteCount = 100 // Nivel medio
        val latch = CountDownLatch(noteCount)
        val insertedNotes = mutableSetOf<Notes>()

        val observer = Observer<List<Notes>> { notes ->
            notes.filter { it.title.startsWith("Medium note") }
                .forEach { note ->
                    if (insertedNotes.add(note)) {
                        latch.countDown()
                    }
                }
        }

        viewModel.allNotes.observeForever(observer)

        try {
            val memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
            val creationTime = measureTimeMillis {
                repeat(noteCount) { index ->
                    val note = Notes(
                        title = "Medium note $index",
                        description = "Content",
                        imageUris = listOf("uri_$index", "uri_${index}_2")
                    )
                    viewModel.insertNote(note)
                }
            }
            val memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
            val memoryUsed = memoryAfter - memoryBefore

            println("[MEDIO] Tiempo para insertar $noteCount notas con imágenes: ${creationTime}ms")
            println("[MEDIO] Memoria usada: ${memoryUsed / 1024} KB")

            Assert.assertTrue(
                "Solo se insertaron ${insertedNotes.size} de $noteCount notas",
                latch.await(20, TimeUnit.SECONDS)
            )
        } finally {
            viewModel.allNotes.removeObserver(observer)
        }
    }

    /**
     * Prueba los límites medios del convertidor de URIs de imágenes.
     *
     * @throws AssertionError si no se pueden manejar todas las URIs
     */
    @Test
    fun testImageConverterMediumLimits() = runBlocking {
        val maxImageUris = 250 // Nivel medio
        val hugeImageList = List(maxImageUris) { "content://image/medium_$it" }

        val note = Notes(
            title = "Nota con lista media de imágenes",
            description = "Probando límites medios del convertidor",
            imageUris = hugeImageList
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
            val insertionTime = measureTimeMillis {
                viewModel.insertNote(note)
            }
            val memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
            val memoryUsed = memoryAfter - memoryBefore

            println("[MEDIO] Tiempo para insertar nota con $maxImageUris URIs: ${insertionTime}ms")
            println("[MEDIO] Memoria usada: ${memoryUsed / 1024} KB")

            Assert.assertTrue("No se completó la inserción", latch.await(15, TimeUnit.SECONDS))
            Assert.assertEquals(maxImageUris, savedNote?.imageUris?.size)
        } finally {
            viewModel.allNotes.removeObserver(observer)
        }
    }
}