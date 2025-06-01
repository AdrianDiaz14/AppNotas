package com.example.appnotas.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.io.Serializable


/**
 * Entidad principal que representa una nota en la aplicación.
 *
 * ## Ejemplo de uso:
 * ```kotlin
 * val note = Notes(
 *     title = "Mi nota",
 *     description = "Contenido de ejemplo"
 * )
 * ```
 *
 * @property noteId Identificador único generado automáticamente por Room.
 * @property date Fecha de creación en milisegundos desde la época (1970-01-01).
 * @property title Título de la nota (no puede ser nulo ni vacío).
 * @property description Contenido principal de la nota (puede ser vacío).
 * @property imageUris Lista de URIs de imágenes adjuntas (opcional, nullable).
 * @property isDeleted Indica si la nota está en la papelera (default: `false`).
 * @property deletionDate Fecha de eliminación en milisegundos (nullable, solo aplica si `isDeleted = true`).
 * @constructor Crea una nueva instancia de nota
 * @see NotesDao Para operaciones de base de datos
 * @see NotesRepository Para acceso a los datos desde el ViewModel.
 *
 *  @author Adrian Diaz
 *  @since 1.0
 */
@Entity
@TypeConverters(Converters::class)
data class Notes(
    @PrimaryKey(autoGenerate = true)
    var noteId: Long = 0L,
    var date: Long = System.currentTimeMillis(),
    var title: String,
    var description: String,
    var imageUris: List<String>? = null,
    var isDeleted: Boolean = false, // Nuevo campo para marcar como eliminado
    var deletionDate: Long? = null // Fecha cuando fue eliminada
) : Serializable