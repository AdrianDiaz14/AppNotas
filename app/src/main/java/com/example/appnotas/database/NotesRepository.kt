package com.example.appnotas.database

import androidx.lifecycle.LiveData

/**
 * Repositorio que abstrae el acceso a los datos de notas.
 * Actúa como intermediario entre el ViewModel y el DAO.
 *
 * @see NotesDao Para las operaciones de base de datos.
 * @see NotesViewModel Para comunicación con la UI.
 *
 * @property noteDao Objeto de acceso a datos para las notas
 * @property allNotes Lista observable de todas las notas activas
 * @property deletedNotes Lista observable de notas en la papelera
 *
 * @author Adrian Diaz
 * @since 1.0
 *
 */
class NotesRepository(private val noteDao: NotesDao) {

    val allNotes: LiveData<List<Notes>> = noteDao.getAllNotes()
    val deletedNotes: LiveData<List<Notes>> = noteDao.getDeletedNotes()

    /**
     * Inserta una nueva nota.
     * @param note Nota a insertar
     */
    suspend fun insertNote(note: Notes) {
        noteDao.insertNote(note)
    }

    /**
     * Actualiza una nota existente.
     * @param note Nota con datos actualizados
     */
    suspend fun updateNote(note: Notes) {
        noteDao.updateNote(note)
    }

    /**
     * Elimina una nota permanentemente.
     * @param note Nota a eliminar
     */
    suspend fun deleteNote(note: Notes) {
        noteDao.deleteNote(note)
    }

    /**
     * Marca una nota como eliminada (mueve a la papelera).
     * @param note Nota a marcar como eliminada
     */
    suspend fun softDeleteNote(note: Notes) {
        noteDao.updateNote(note.copy(
            isDeleted = true,
            deletionDate = System.currentTimeMillis()
        ))
    }

    /**
     * Restaura una nota desde la papelera.
     * @param noteId ID de la nota a restaurar
     * @throws IllegalStateException Si la nota no existe o no puede ser restaurada.
     */
    suspend fun restoreNote(noteId: Long) {
        noteDao.restoreNote(noteId)
    }

    /**
     * Elimina permanentemente notas en la papelera más antiguas de 7 días.
     */
    suspend fun cleanOldDeletedNotes() {
        val sevenDaysAgo = System.currentTimeMillis() - (7 * 24 * 60 * 60 * 1000)
        noteDao.permanentlyDeleteOldNotes(sevenDaysAgo)
    }
}