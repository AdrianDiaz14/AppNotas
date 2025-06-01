package com.example.appnotas.regresion

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.appnotas.database.Notes
import com.example.appnotas.database.NotesDao
import com.example.appnotas.database.NotesRoomDatabase
import com.example.appnotas.getOrAwaitValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.runner.RunWith

/**
 * Clase de pruebas de regresión para [NotesDao] que verifica que las funcionalidades básicas
 * del DAO continúen funcionando correctamente después de cambios en el código.
 *
 * Estas pruebas utilizan una base de datos en memoria para verificar el comportamiento
 * del DAO con operaciones CRUD y manejo de la papelera de notas.
 *
 * @constructor Crea una instancia de pruebas para el DAO de notas
 */
@RunWith(AndroidJUnit4::class)
class NotesDaoTestRegresion {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: NotesRoomDatabase
    private lateinit var dao: NotesDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NotesRoomDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.notesDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    /**
     * Prueba que verifica que la inserción de notas sigue funcionando correctamente.
     *
     * @throws AssertionError si la nota insertada no se encuentra en la base de datos
     */
    @Test
    fun insertNote_shouldStillWork() = runBlocking {
        val note = Notes(title = "Regresión", description = "Validamos que insertar aún funciona")
        dao.insertNote(note)

        val allNotes = dao.getAllNotes().getOrAwaitValue()
        Assert.assertTrue("La inserción ya no funciona correctamente", allNotes.any { it.title == "Regresión" })
    }

    /**
     * Prueba que verifica el funcionamiento del borrado lógico de notas.
     * Comprueba que al marcar una nota como eliminada, esta aparece en la papelera.
     *
     * @throws AssertionError si la nota eliminada no aparece en la papelera
     */
    @Test
    fun deleteNote_shouldMoveToTrash() = runBlocking {
        // 1. Insertar una nueva nota
        val note = Notes(title = "Nota a eliminar", description = "Texto de prueba")
        dao.insertNote(note)
        delay(100) // Pequeña espera para la inserción

        // 2. Obtener el ID de la nota insertada (puede ser auto-generado)
        val insertedNote = dao.getAllNotes().getOrAwaitValue().first()

        // 3. Marcar la nota como eliminada
        val deletedNote = insertedNote.copy(
            isDeleted = true,
            deletionDate = System.currentTimeMillis()
        )
        dao.updateNote(deletedNote)
        delay(100) // Pequeña espera para la actualización

        // 4. Verificar en la papelera (getDeletedNotes)
        val deletedNotes = dao.getDeletedNotes().getOrAwaitValue()

        Assert.assertTrue(
            "La nota eliminada no aparece en la papelera",
            deletedNotes.any { it.noteId == insertedNote.noteId }
        )
    }

    /**
     * Prueba que verifica el borrado permanente de notas antiguas de la papelera.
     * Comprueba que las notas con más de 7 días en la papelera son eliminadas permanentemente.
     *
     * @throws AssertionError si la nota antigua sigue presente en la papelera después del borrado
     */
    @Test
    fun permanentlyDeleteOldNotes_shouldRemoveFromTrash() = runBlocking {
        val note = Notes(title = "Nota antigua", description = "Texto viejo", deletionDate = System.currentTimeMillis() - (8 * 24 * 60 * 60 * 1000), isDeleted = true)
        dao.insertNote(note)
        delay(500)

        dao.permanentlyDeleteOldNotes(System.currentTimeMillis() - (7 * 24 * 60 * 60 * 1000))
        delay(500)

        val deletedNotes = dao.getDeletedNotes().getOrAwaitValue()
        Assert.assertFalse("La nota antigua sigue presente en la papelera", deletedNotes.any { it.title == "Nota antigua" })
    }

    /**
     * Prueba que verifica que la restauración de notas desde la papelera sigue funcionando.
     * Comprueba que una nota restaurada vuelve a aparecer en la lista principal de notas.
     *
     * @throws AssertionError si la nota restaurada no aparece en la lista principal
     */
    @Test
    fun restoreNote_shouldStillWork() = runBlocking {
        val note = Notes(title = "Nota a restaurar", description = "Texto restaurable")
        dao.insertNote(note)
        delay(500)

        dao.restoreNote(note.noteId)
        delay(500)

        val restoredNotes = dao.getAllNotes().getOrAwaitValue()
        Assert.assertTrue("La restauración ya no funciona correctamente", restoredNotes.any { it.title == "Nota a restaurar" })
    }
}