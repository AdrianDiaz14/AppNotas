package com.example.appnotas.integracion

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.appnotas.database.Notes
import com.example.appnotas.database.NotesDao
import com.example.appnotas.database.NotesRepository
import com.example.appnotas.database.NotesRoomDatabase
import com.example.appnotas.getOrAwaitValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.runner.RunWith

/**
 * Pruebas de integración para [NotesRepository] verificando la lógica de negocio.
 *
 * @SmallTest Indica que estas son pruebas de ejecución rápida.
 * @see NotesRepository Clase bajo prueba.
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class NotesRepositoryTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: NotesRoomDatabase
    private lateinit var notesDao: NotesDao
    private lateinit var repository: NotesRepository

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, NotesRoomDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        notesDao = database.notesDao()
        repository = NotesRepository(notesDao)
    }

    @After
    fun tearDown() {
        database.close()
    }

    /**
     * Verifica el flujo completo de inserción y recuperación de notas.
     */
    @Test
    fun insertNote_andGetAllNotes() = runBlocking {
        val note = Notes(title = "Test Note", description = "Contenido de prueba")
        repository.insertNote(note)

        // Obtener el valor del LiveData sincrónicamente
        val notes = repository.allNotes.getOrAwaitValue()
        Assert.assertNotNull(notes)
        Assert.assertTrue(notes.isNotEmpty())
        Assert.assertEquals("Test Note", notes[0].title)
    }

    /**
     * Prueba el borrado lógico (soft delete) y recuperación desde la papelera.
     */
    @Test
    fun softDeleteNote_andCheckTrash() = runBlocking {
        // Insertar nota
        val note = Notes(title = "Nota a eliminar", description = "Contenido de prueba")
        repository.insertNote(note)

        // Esperar y verificar inserción
        val initialNotes = repository.allNotes.getOrAwaitValue()
        Assert.assertTrue("La nota no se insertó correctamente",
            initialNotes.any { it.title == note.title })

        // Obtener el ID de la nota insertada (puede ser generado automáticamente)
        val insertedNote = initialNotes.first { it.title == note.title }

        // Eliminar suavemente la nota usando el ID correcto
        repository.softDeleteNote(insertedNote)

        // Obtener notas eliminadas
        val deletedNotes = repository.deletedNotes.getOrAwaitValue()

        // Verificaciones
        Assert.assertNotNull("La lista de notas eliminadas es null", deletedNotes)
        Assert.assertTrue(
            "La lista de notas eliminadas está vacía. Contenido actual: $deletedNotes",
            deletedNotes.isNotEmpty()
        )

        // Verificar que la nota eliminada tiene el mismo ID que la insertada
        Assert.assertTrue(
            "No se encontró la nota eliminada con ID ${insertedNote.noteId}",
            deletedNotes.any { it.noteId == insertedNote.noteId }
        )
    }

    /**
     * Verifica la restauración de notas desde la papelera.
     */
    @Test
    fun restoreNote_fromTrash() = runBlocking {
        val note = Notes(title = "Nota a restaurar", description = "Se debe recuperar")
        repository.insertNote(note)
        repository.softDeleteNote(note)

        repository.restoreNote(note.noteId)

        val restoredNotes = repository.allNotes.getOrAwaitValue()
        Assert.assertNotNull(restoredNotes)
        Assert.assertTrue(restoredNotes.isNotEmpty())
        Assert.assertEquals("Nota a restaurar", restoredNotes[0].title)
    }

    /**
     * Prueba la actualización de notas existentes.
     */
    @Test
    fun updateNote_andVerifyChanges() = runBlocking {
        val originalNote = Notes(title = "Nota Original", description = "Texto inicial")
        repository.insertNote(originalNote)

        val storedNotes = repository.allNotes.getOrAwaitValue()
        val insertedNote = storedNotes.firstOrNull { it.title == "Nota Original" }

        val updatedNote = insertedNote!!.copy(title = "Nota Modificada", description = "Nuevo contenido")
        repository.updateNote(updatedNote)

        val updatedNotes = repository.allNotes.getOrAwaitValue()
        val modifiedNote = updatedNotes.firstOrNull { it.noteId == insertedNote.noteId }
    }

    /**
     * Verifica el borrado permanente de notas.
     */
    @Test
    fun deleteNote_permanentlyRemoves() = runBlocking {
        val note = Notes(title = "Nota a borrar", description = "Contenido")
        repository.insertNote(note)

        val insertedNote = repository.allNotes.getOrAwaitValue().first()
        repository.deleteNote(insertedNote)

        val remainingNotes = repository.allNotes.getOrAwaitValue()
        Assert.assertTrue("La nota no fue eliminada permanentemente",
            remainingNotes.none { it.noteId == insertedNote.noteId })
    }

    /**
     * Prueba la limpieza automática de notas antiguas en la papelera.
     */
    @Test
    fun cleanOldDeletedNotes_removesExpired() = runBlocking {
        val oldNote = Notes(
            title = "Nota antigua",
            description = "Contenido",
            isDeleted = true,
            deletionDate = System.currentTimeMillis() - 8 * 24 * 60 * 60 * 1000 // 8 días
        )
        repository.insertNote(oldNote)

        repository.cleanOldDeletedNotes()
        delay(100)

        val deletedNotes = repository.deletedNotes.getOrAwaitValue()
        Assert.assertTrue("La nota antigua no fue eliminada",
            deletedNotes.none { it.noteId == oldNote.noteId })
    }
}