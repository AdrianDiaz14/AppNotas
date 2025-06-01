package com.example.appnotas.volumenestres.alto

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
 * Pruebas de alto estrés para evaluar el manejo de notas con imágenes en condiciones extremas.
 *
 * Estas pruebas verifican:
 * - El rendimiento con grandes cantidades de imágenes
 * - La estabilidad del convertidor de URIs de imágenes
 * - El consumo de memoria en escenarios intensivos
 */
@RunWith(AndroidJUnit4::class)
class HighStressImageTests {

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
     * Prueba el manejo de una nota con gran cantidad de imágenes adjuntas.
     *
     * @throws AssertionError si la inserción falla o no se mantienen todas las URIs
     */
    @Test
    fun testNotesWithManyImages() = runBlocking {
        val imageCount = 500 // Nivel alto
        val imageUris = List(imageCount) { "content://image/high_$it" }
        val note = Notes(
            title = "Nota con muchas imágenes",
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

            println("[ALTO] Tiempo para insertar nota con $imageCount imágenes: ${insertionTime}ms")
            println("[ALTO] Memoria usada: ${memoryUsed / 1024} KB")

            Assert.assertTrue("No se completó la inserción", latch.await(30, TimeUnit.SECONDS))

            Assert.assertEquals(imageCount, savedNote?.imageUris?.size)
        } finally {
            viewModel.allNotes.removeObserver(observer)
        }
    }

    /**
     * Prueba la inserción de muchas notas con imágenes para evaluar escalabilidad.
     *
     * @throws AssertionError si no se insertan todas las notas esperadas
     */
    @Test
    fun testManyNotesWithImages() = runBlocking {
        val noteCount = 500 // Nivel alto
        val latch = CountDownLatch(noteCount)
        val insertedNotes = mutableSetOf<Notes>()

        val observer = Observer<List<Notes>> { notes ->
            notes.filter { it.title.startsWith("High stress note") }
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
                        title = "High stress note $index",
                        description = "Content",
                        imageUris = listOf("high_uri_$index", "high_uri_${index}_2", "high_uri_${index}_3")
                    )
                    viewModel.insertNote(note)
                }
            }
            val memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
            val memoryUsed = memoryAfter - memoryBefore

            println("[ALTO] Tiempo para insertar $noteCount notas con imágenes: ${creationTime}ms")
            println("[ALTO] Memoria usada: ${memoryUsed / 1024} KB")

            Assert.assertTrue(
                "Solo se insertaron ${insertedNotes.size} de $noteCount notas",
                latch.await(60, TimeUnit.SECONDS)
            )
        } finally {
            viewModel.allNotes.removeObserver(observer)
        }
    }

    /**
     * Prueba los límites superiores del convertidor de URIs de imágenes.
     *
     * @throws AssertionError si no se pueden manejar todas las URIs o hay problemas de rendimiento
     */
    @Test
    fun testImageConverterHighLimits() = runBlocking {
        val maxImageUris = 1000 // Nivel alto
        val hugeImageList = List(maxImageUris) { "content://image/high_limit_$it" }

        val note = Notes(
            title = "Nota con lista enorme de imágenes",
            description = "Probando límites altos del convertidor",
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

            println("[ALTO] Tiempo para insertar nota con $maxImageUris URIs: ${insertionTime}ms")
            println("[ALTO] Memoria usada: ${memoryUsed / 1024} KB")

            Assert.assertTrue("No se completó la inserción", latch.await(45, TimeUnit.SECONDS))
            Assert.assertEquals(maxImageUris, savedNote?.imageUris?.size)
        } finally {
            viewModel.allNotes.removeObserver(observer)
        }
    }
}