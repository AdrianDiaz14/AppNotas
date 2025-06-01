package com.example.appnotas.unitaria

import com.example.appnotas.database.Notes

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.appnotas.testHelpers.FakeNotesDao
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class NotesDaoTest {

    private lateinit var fakeNotesDao: FakeNotesDao

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    /**
     * Configura un DAO falso antes de cada prueba.
     */
    @Before
    fun setup() {
        fakeNotesDao = FakeNotesDao()
    }

    /**
     * Verifica que se pueda insertar una nota y recuperarla correctamente.
     * - Inserta una nota
     * - Recupera todas las notas
     * - Comprueba que la nota insertada esté presente
     */
    @Test
    fun insertNote_andGetAllNotes() = runBlocking {
        val note = Notes(title = "Test Note", description = "Contenido de prueba")
        fakeNotesDao.insertNote(note)

        val notes = fakeNotesDao.getAllNotes().value
        Assert.assertNotNull(notes)
        Assert.assertTrue(notes!!.isNotEmpty())
        Assert.assertEquals("Test Note", notes[0].title)
    }

    /**
     * Verifica que una nota se puede actualizar correctamente.
     * - Inserta una nota inicial
     * - Actualiza el título de la nota
     * - Comprueba que la actualización se refleje en la base de datos
     */
    @Test
    fun updateNote() = runBlocking {
        val note = Notes(title = "Nota Original", description = "Texto inicial")
        fakeNotesDao.insertNote(note)

        val updatedNote = note.copy(title = "Nota Actualizada")
        fakeNotesDao.updateNote(updatedNote)

        val notes = fakeNotesDao.getAllNotes().value
        Assert.assertNotNull(notes)
        Assert.assertEquals("Nota Actualizada", notes!![0].title)
    }

    /**
     * Verifica que una nota se puede eliminar correctamente.
     * - Inserta una nota
     * - La elimina
     * - Comprueba que la lista de notas está vacía tras la eliminación
     */
    @Test
    fun deleteNote() = runBlocking {
        val note = Notes(title = "Nota a eliminar", description = "Texto a borrar")
        fakeNotesDao.insertNote(note)

        fakeNotesDao.deleteNote(note)
        val notes = fakeNotesDao.getAllNotes().value

        Assert.assertNotNull(notes)
        Assert.assertTrue(notes!!.isEmpty())
    }
}
