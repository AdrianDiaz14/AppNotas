package com.example.appnotas.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * ViewModel especializado para operaciones de guardado y actualización de notas.
 * Se diferencia de NotesViewModel al enfocarse solo en operaciones de persistencia.
 *
 * @property repository Repositorio que maneja el acceso a los datos
 *
 * @author Adrian Diaz
 * @since 1.0
 */
class NoteSaveViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: NotesRepository

    init {
        val notesDao = NotesRoomDatabase.getDatabase(application, viewModelScope).notesDao()
        repository = NotesRepository(notesDao)
    }

    /**
     * Inserta una nueva nota en la base de datos.
     * @param note Nota a insertar
     */
    fun insertNote(note: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertNote(note)
    }

    /**
     * Actualiza una nota existente en la base de datos.
     * @param note Nota con los datos actualizados
     */
    fun updateNote(note: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateNote(note)
    }
}