package com.example.appnotas.integracion

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.appnotas.database.Notes
import com.example.appnotas.database.NotesDao
import com.example.appnotas.database.NotesRoomDatabase
import com.example.appnotas.database.NotesRepository
import com.example.appnotas.getOrAwaitValue
import com.example.appnotas.testHelpers.FakeNotesRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.Assert.assertFalse
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.runner.RunWith

/**
 * Pruebas especializadas en la funcionalidad de la papelera.
 *
 * Incluye pruebas de:
 * - Restauración masiva de notas
 * - Manejo de errores
 * - Mediciones de rendimiento
 *
 * @see NotesRepository Implementación real bajo prueba.
 * @see FakeNotesRepository Implementación fake para casos de error.
 */
@RunWith(AndroidJUnit4::class)
class TrashIntegrationTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: NotesRoomDatabase
    private lateinit var notesDao: NotesDao
    private lateinit var realRepository: NotesRepository
    private lateinit var testRepository: FakeNotesRepository

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NotesRoomDatabase::class.java
        ).allowMainThreadQueries().build()

        notesDao = database.notesDao()
        realRepository = NotesRepository(notesDao)
        testRepository = FakeNotesRepository(realRepository)
    }

    @After
    fun tearDown() {
        database.close()
    }

    /**
     * Prueba la restauración de múltiples notas eliminadas.
     */
    @Test
    fun restoreMultipleDeletedNotes() = runBlocking {
        val notesList = listOf(
            Notes(title = "Nota 1 eliminada", description = "Texto 1"),
            Notes(title = "Nota 2 eliminada", description = "Texto 2")
        )

        notesList.forEach { realRepository.insertNote(it) }
        realRepository.allNotes.getOrAwaitValue() // Espera a que se complete la inserción

        notesList.forEach { realRepository.softDeleteNote(it) }
        realRepository.deletedNotes.getOrAwaitValue() // Espera a que se complete la eliminación

        notesList.forEach { realRepository.restoreNote(it.noteId) }
        val restoredNotes = realRepository.allNotes.getOrAwaitValue()
    }

    /**
     * Prueba de rendimiento para restauración masiva (500 notas).
     * Mide el tiempo de ejecución y verifica la integridad de los datos.
     */
    @Test
    fun restoreLargeVolume_ofDeletedNotes_andMeasurePerformance() = runBlocking {
        val largeList = (1..500).map {
            Notes(title = "Nota eliminada $it", description = "Texto $it")
        }

        largeList.forEach { realRepository.insertNote(it) }
        delay(500)

        largeList.forEach { realRepository.softDeleteNote(it) }
        delay(500)

        val startTime = System.currentTimeMillis()
        largeList.forEach { realRepository.restoreNote(it.noteId) }
        delay(500)
        val endTime = System.currentTimeMillis()

        val executionTime = endTime - startTime
        println("Tiempo de ejecución para restaurar 500 notas: $executionTime ms")

        val restoredNotes = realRepository.allNotes.getOrAwaitValue()
        println("Notas después de restaurar: $restoredNotes")

        Assert.assertEquals("No se restauraron todas las notas correctamente.", 500, restoredNotes.size)
    }

    /**
     * Verifica el manejo de errores al restaurar notas inexistentes.
     */
    @Test
    fun restoreNonExistentNote_shouldThrowException() = runBlocking {
        // 1. Verificar que lanza excepción
        val exception = assertThrows(IllegalStateException::class.java) {
            runBlocking {
                testRepository.restoreNote(99999)
            }
        }

        // 2. Verificar mensaje de error
        assertTrue(
            "El mensaje de error debería contener el ID de nota",
            exception.message?.contains("99999") == true
        )
    }

    /**
     * Prueba el flujo completo de restauración para una nota existente.
     */
    @Test
    fun restoreExistingDeletedNote_shouldWork() = runBlocking {
        // 1. Insertar una nota (obtenemos el ID generado)
        val note = Notes(title = "Nota a restaurar", description = "Texto")
        realRepository.insertNote(note)
        delay(100)

        // Obtener la nota con ID generado
        val insertedNote = realRepository.allNotes.getOrAwaitValue().first()

        // 2. Eliminar la nota (mover a papelera)
        realRepository.softDeleteNote(insertedNote)
        delay(100)

        // Verificar que está en la papelera
        val deletedNotesBefore = realRepository.deletedNotes.getOrAwaitValue()
        assertTrue("La nota debería estar en la papelera",
            deletedNotesBefore.any { it.noteId == insertedNote.noteId })

        // 3. Restaurar la nota
        testRepository.restoreNote(insertedNote.noteId)
        delay(100)

        // 4. Verificaciones finales
        val deletedNotesAfter = realRepository.deletedNotes.getOrAwaitValue()
        val restoredNotes = realRepository.allNotes.getOrAwaitValue()

        assertFalse("La nota no debería estar en la papelera",
            deletedNotesAfter.any { it.noteId == insertedNote.noteId })

        assertTrue("La nota debería estar restaurada",
            restoredNotes.any { it.noteId == insertedNote.noteId })
    }
}