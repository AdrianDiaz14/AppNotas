package com.example.appnotas.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * ViewModel que gestiona la interacción entre la UI y el repositorio de notas.
 * Proporciona datos a la UI y maneja las operaciones asíncronas.
 *
 * @property repository Repositorio que maneja el acceso a los datos
 * @property allNotes Lista observable de todas las notas activas
 * @property deletedNotes Lista observable de notas en la papelera
 *
 * @author Adrian Diaz
 * @since 1.0
 */
class NotesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: NotesRepository
    val allNotes: LiveData<List<Notes>>
    val deletedNotes: LiveData<List<Notes>>

    init {
        val notesDao = NotesRoomDatabase.getDatabase(application, viewModelScope).notesDao()
        repository = NotesRepository(notesDao)
        allNotes = repository.allNotes
        deletedNotes = repository.deletedNotes
    }

    /**
     * Inserta una nueva nota en la base de datos.
     * @param note Nota a insertar
     */
    fun insertNote(note: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertNote(note)
    }

    /**
     * Elimina una nota permanentemente de la base de datos.
     * @param note Nota a eliminar
     */
    fun deleteNote(note: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteNote(note)
    }

    /**
     * Actualiza una nota existente en la base de datos.
     * @param note Nota con los datos actualizados
     */
    fun updateNote(note: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateNote(note)
    }

    /**
     * Marca una nota como eliminada (mueve a la papelera).
     * @param note Nota a marcar como eliminada
     */
    fun softDeleteNote(note: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.softDeleteNote(note)
    }

    /**
     * Restaura una nota desde la papelera.
     * @param noteId ID de la nota a restaurar
     */
    fun restoreNote(noteId: Long) = viewModelScope.launch(Dispatchers.IO) {
        repository.restoreNote(noteId)
    }

    /**
     * Limpia permanentemente las notas en la papelera más antiguas que 7 días.
     */
    fun cleanOldDeletedNotes() = viewModelScope.launch(Dispatchers.IO) {
        repository.cleanOldDeletedNotes()
    }

}