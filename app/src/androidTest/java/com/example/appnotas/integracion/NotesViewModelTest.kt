package com.example.appnotas.integracion

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.appnotas.database.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.rules.TestRule

/**
 * Pruebas para [NotesViewModel] verificando la interacción entre UI y repositorio.
 *
 * @see NotesViewModel Clase bajo prueba.
 * @see NotesRepository Dependencia mockeada implícitamente.
 */
class NotesViewModelTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: NotesViewModel
    private lateinit var db: NotesRoomDatabase
    private lateinit var dao: NotesDao

    @Before
    fun setup() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NotesRoomDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = db.notesDao()
        val repository = NotesRepository(dao)
        viewModel = NotesViewModel(ApplicationProvider.getApplicationContext())

        // Se observa LiveData para asegurar de que se actualice en la prueba
        viewModel.allNotes.observeForever {}
    }

    @After
    fun tearDown() {
        db.close()
    }

    /**
     * Verifica que la inserción de notas actualiza correctamente el LiveData.
     */
    @Test
    fun insertNote_updatesLiveData() = runBlocking {
        val note = Notes(title = "Test Note", description = "Content")
        viewModel.insertNote(note)

        delay(1000)

        val notes = viewModel.allNotes.value

        Assert.assertNotNull(notes)
        Assert.assertTrue(notes!!.isNotEmpty())

        val foundNote = notes.find { it.title == "Test Note" }
        Assert.assertNotNull(foundNote)
    }
}
