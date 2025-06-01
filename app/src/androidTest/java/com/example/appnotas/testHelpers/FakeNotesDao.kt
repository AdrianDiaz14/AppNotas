package com.example.appnotas.testHelpers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appnotas.database.Notes
import com.example.appnotas.database.NotesDao

/**
 * Implementación falsa de `NotesDao` para pruebas sin necesidad de usar Room.
 * Simula el almacenamiento de notas en memoria y proporciona métodos similares
 * a los de un DAO real.
 *
 * Evita la dependencia de una base de datos real.
 */
class FakeNotesDao : NotesDao {
    private val notesList = mutableListOf<Notes>()
    private val notesLiveData = MutableLiveData<List<Notes>>(notesList)

    /**
     * Inserta una nueva nota en la lista simulada.
     *
     * @param note La nota a insertar
     */
    override suspend fun insertNote(note: Notes) {
        notesList.add(note)
        updateLiveData()
    }

    /**
     * Elimina una nota de la lista simulada.
     *
     * @param note La nota a eliminar
     */
    override suspend fun deleteNote(note: Notes) {
        notesList.remove(note)
        updateLiveData()
    }

    /**
     * Actualiza una nota existente en la lista simulada.
     *
     * @param note Nota con los datos actualizados
     */
    override suspend fun updateNote(note: Notes) {
        notesList.replaceAll { if (it.noteId == note.noteId) note else it }
        updateLiveData()
    }

    /**
     * Obtiene todas las notas activas (no eliminadas).
     *
     * @return LiveData con la lista de notas activas
     */
    override fun getAllNotes(): LiveData<List<Notes>> {
        return notesLiveData
    }

    /**
     * Obtiene todas las notas eliminadas.
     *
     * @return LiveData con las notas en la papelera
     */
    override fun getDeletedNotes(): LiveData<List<Notes>> {
        return MutableLiveData(notesList.filter { it.isDeleted })
    }

    /**
     * Restaura una nota eliminada, quitando su estado de eliminación.
     *
     * @param noteId ID de la nota a restaurar
     */
    override suspend fun restoreNote(noteId: Long) {
        notesList.find { it.noteId == noteId }?.apply {
            isDeleted = false
            deletionDate = null
        }
        updateLiveData()
    }

    /**
     * Elimina permanentemente las notas que fueron movidas a la papelera
     * y cuya fecha de eliminación es anterior a la fecha límite proporcionada.
     *
     * @param thresholdDate Fecha límite para eliminar notas antiguas
     */
    override suspend fun permanentlyDeleteOldNotes(thresholdDate: Long) {
        notesList.removeIf { it.isDeleted && it.deletionDate != null && it.deletionDate!! < thresholdDate }
        updateLiveData()
    }

    /**
     * Actualiza el `LiveData` con la lista de notas actualizada.
     * Se usa internamente para reflejar cambios en la UI.
     */
    private fun updateLiveData() {
        notesLiveData.postValue(notesList.toList())
    }
}
