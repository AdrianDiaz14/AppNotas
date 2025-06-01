package com.example.appnotas.database

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Data Access Object para operaciones con notas en la base de datos.
 * Proporciona métodos para:
 * - Insertar, actualizar y eliminar notas
 * - Gestionar la papelera de notas
 * - Recuperar notas activas y eliminadas
 *
 *   @see Notes Para conocer la estructura de datos.
 *   @see NotesRepository Para interacción con la capa de negocio.
 *
 *   @author Adrian Diaz
 *   @since 1.0
 */
@Dao
interface NotesDao {
    /**
     * Inserta una nueva nota ignorando conflictos.
     * @param note La nota a insertar
     *
     * @sample com.sba.notes.samples.NotesDaoSamples.insertNoteSample
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note: Notes)

    /**
     * Obtiene todas las notas activas (no eliminadas), ordenadas por fecha descendente.
     * @return LiveData con la lista de notas activas
     */
    @Query("SELECT * from notes WHERE isDeleted = 0 ORDER BY date DESC")
    fun getAllNotes(): LiveData<List<Notes>>

    /**
     * Elimina una nota de forma permanente.
     * @param note Nota a eliminar
     */
    @Delete
    suspend fun deleteNote(note: Notes)

    /**
     * Actualiza los datos de una nota existente.
     * @param note Nota con los datos actualizados
     */
    @Update
    suspend fun updateNote(note: Notes)

    /**
     * Obtiene las notas en la papelera, ordenadas por fecha de eliminación.
     * @return LiveData con las notas eliminadas
     * @throws IllegalStateException Si la nota no puede ser restaurada.
     */
    @Query("SELECT * FROM notes WHERE isDeleted = 1 ORDER BY deletionDate DESC")
    fun getDeletedNotes(): LiveData<List<Notes>>

    /**
     * Restaura una nota de la papelera.
     * @param noteId ID de la nota a restaurar
     */
    @Query("UPDATE notes SET isDeleted = 0, deletionDate = null WHERE noteId = :noteId")
    suspend fun restoreNote(noteId: Long)

    /**
     * Elimina permanentemente notas antiguas de la papelera.
     * @param thresholdDate Fecha límite en milisegundos
     */
    @Query("DELETE FROM notes WHERE isDeleted = 1 AND deletionDate < :thresholdDate")
    suspend fun permanentlyDeleteOldNotes(thresholdDate: Long)

}