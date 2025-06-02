package com.example.appnotas.samples

import android.content.Context
import androidx.room.Room
import com.example.appnotas.database.Notes
import com.example.appnotas.database.NotesDao
import com.example.appnotas.database.NotesRoomDatabase
import kotlinx.coroutines.runBlocking

/**
 * Proporciona ejemplos de uso para los métodos de `NotesDao`.
 * Esta clase incluye simulaciones utilizando una base de datos in-memory
 * para mostrar cómo interactuar con el DAO de notas en un entorno controlado.
 *
 * @author Adrian Diaz
 * @since 1.3
 */
object NotesDaoSamples {

    /**
     * Ejemplo de cómo insertar una nueva nota en la base de datos.
     *
     * @param context Contexto necesario para inicializar la base de datos.
     * @sample com.sba.notes.samples.NotesDaoSamples.insertNoteSample
     */
    fun insertNoteSample(context: Context) = runBlocking {
        val db = Room.inMemoryDatabaseBuilder(context, NotesRoomDatabase::class.java).build()
        val dao: NotesDao = db.notesDao()

        // Inserta una nueva nota
        val note = Notes(
            title = "Nueva Nota",
            description = "Esta es una nota de ejemplo"
        )
        dao.insertNote(note)
    }
}