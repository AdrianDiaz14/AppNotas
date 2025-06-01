package com.example.appnotas.testHelpers

import androidx.lifecycle.LiveData
import com.example.appnotas.database.Notes
import com.example.appnotas.database.NotesRepository
import com.example.appnotas.getOrAwaitValue

/**
 * Implementación falsa de [NotesRepository] para propósitos de prueba.
 *
 * Esta clase actúa como un proxy para el repositorio real, permitiendo:
 * - Verificar el comportamiento del repositorio real en pruebas
 * - Añadir lógica adicional para validaciones en pruebas
 * - Simular condiciones específicas para testing
 *
 * @property realRepository El repositorio real que será utilizado para las operaciones
 */
class FakeNotesRepository(private val realRepository: NotesRepository) {
    // Delegamos todas las propiedades/métodos al repositorio real
    val allNotes: LiveData<List<Notes>> get() = realRepository.allNotes
    val deletedNotes: LiveData<List<Notes>> get() = realRepository.deletedNotes

    /**
     * Inserta una nota delegando al repositorio real.
     * @param note La nota a insertar
     */
    suspend fun insertNote(note: Notes) = realRepository.insertNote(note)

    /**
     * Actualiza una nota delegando al repositorio real.
     * @param note La nota con los datos actualizados
     */
    suspend fun updateNote(note: Notes) = realRepository.updateNote(note)

    /**
     * Elimina una nota permanentemente delegando al repositorio real.
     * @param note La nota a eliminar
     */
    suspend fun deleteNote(note: Notes) = realRepository.deleteNote(note)

    /**
     * Marca una nota como eliminada (borrado lógico) delegando al repositorio real.
     * @param note La nota a marcar como eliminada
     */
    suspend fun softDeleteNote(note: Notes) = realRepository.softDeleteNote(note)

    /**
     * Limpia notas eliminadas antiguas delegando al repositorio real.
     */
    suspend fun cleanOldDeletedNotes() = realRepository.cleanOldDeletedNotes()

    /**
     * Restaura una nota desde la papelera con validación adicional.
     * Verifica que la nota exista en la papelera antes de restaurarla.
     *
     * @param noteId ID de la nota a restaurar
     * @throws IllegalStateException si la nota no se encuentra en la papelera
     */
    suspend fun restoreNote(noteId: Long) {
        // Esperar a que los datos estén disponibles
        val noteExists = try {
            realRepository.deletedNotes.getOrAwaitValue()
                .any { it.noteId == noteId }
        } catch (e: Exception) {
            false
        }

        if (!noteExists) {
            throw IllegalStateException("No se encontró la nota con ID $noteId en la papelera")
        }

        realRepository.restoreNote(noteId)
    }
}