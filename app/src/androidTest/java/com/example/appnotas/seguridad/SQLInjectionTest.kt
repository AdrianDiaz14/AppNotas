package com.example.appnotas.seguridad

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.appnotas.database.Notes
import com.example.appnotas.database.NotesDao
import com.example.appnotas.database.NotesRoomDatabase
import com.example.appnotas.getOrAwaitValue
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.IOException

class SQLInjectionTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var notesDao: NotesDao
    private lateinit var db: NotesRoomDatabase

    /**
     * Configura una base de datos en memoria antes de cada prueba.
     * Esto permite probar la seguridad sin modificar datos reales.
     */
    @Before
    fun setup() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NotesRoomDatabase::class.java
        ).allowMainThreadQueries()
            .build()
        notesDao = db.notesDao()
    }

    /**
     * Cierra la base de datos después de cada prueba para liberar recursos.
     */
    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    /**
     * Simula un intento de inyección SQL mediante la inserción de una nota con un título malicioso.
     * - Inserta una nota cuyo título incluye una cadena de inyección SQL (`DROP TABLE notes`).
     * - Recupera todas las notas y verifica si la base de datos sigue operativa.
     * - Si la tabla se hubiera eliminado, la prueba fallaría, indicando una vulnerabilidad.
     */
    @Test
    fun testSQLInjection() = runBlocking {
        val maliciousNote = Notes(
            title = "Nota maliciosa'; DROP TABLE notes;--",
            description = "Contenido peligroso"
        )

        notesDao.insertNote(maliciousNote)

        // Recupera las notas para verificar la integridad de la tabla
        val notes = notesDao.getAllNotes().getOrAwaitValue()
        assert(notes.isNotEmpty())
    }
}