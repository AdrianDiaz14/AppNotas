package com.example.appnotas.integracion

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.appnotas.database.Notes
import com.example.appnotas.database.NotesDao
import com.example.appnotas.database.NotesRoomDatabase
import com.example.appnotas.getOrAwaitValue
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.runner.RunWith

/**
 * Pruebas de integración para [NotesDao] verificando operaciones directas con Room Database.
 *
 * Utiliza una base de datos en memoria para garantizar el aislamiento de las pruebas.
 *
 * @see NotesDao Interfaz bajo prueba.
 * @see NotesRoomDatabase Configuración de la base de datos.
 */
@RunWith(AndroidJUnit4::class)
class NotesDaoIntegrationTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule() // Ejecución de LiveData en pruebas

    private lateinit var database: NotesRoomDatabase
    private lateinit var notesDao: NotesDao

    /**
     * Configura una base de datos Room en memoria antes de cada prueba.
     * Permite ejecutar consultas en el hilo principal solo para pruebas.
     */
    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NotesRoomDatabase::class.java
        ).allowMainThreadQueries().build()

        notesDao = database.notesDao()
    }

    /**
     * Cierra la base de datos después de cada prueba para liberar recursos.
     */
    @After
    fun tearDown() {
        database.close()
    }

    /**
     * Verifica que [NotesDao.updateNote] actualiza correctamente el título de una nota.
     *
     * Pasos:
     * 1. Inserta una nota inicial con título original.
     * 2. Actualiza el título de la nota.
     * 3. Recupera la nota y verifica que el título fue modificado.
     */
    @Test
    fun updateNoteTitle_updatesDatabase() = runBlocking {
        val note = Notes(title = "Título original", description = "Contenido")
        notesDao.insertNote(note)

        val insertedNote = notesDao.getAllNotes().getOrAwaitValue().first()

        val updatedNote = insertedNote.copy(title = "Título actualizado")
        notesDao.updateNote(updatedNote)

        // Reemplazar delay(100) por:
        val retrievedNote = notesDao.getAllNotes().getOrAwaitValue().first()
        Assert.assertEquals("El título no se actualizó correctamente",
            "Título actualizado", retrievedNote.title)
    }
}
