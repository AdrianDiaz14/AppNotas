//[AppNotas](../../../index.md)/[com.example.appnotas.database](../index.md)/[NotesDao](index.md)

# NotesDao

interface [NotesDao](index.md)

Data Access Object para operaciones con notas en la base de datos. Proporciona métodos para:

- 
   Insertar, actualizar y eliminar notas
- 
   Gestionar la papelera de notas
- 
   Recuperar notas activas y eliminadas

#### Author

Adrian Diaz

#### Since

1.0

#### See also

| | |
|---|---|
| [Notes](../-notes/index.md) | Para conocer la estructura de datos. |
| [NotesRepository](../-notes-repository/index.md) | Para interacción con la capa de negocio. |

## Functions

| Name | Summary |
|---|---|
| [deleteNote](delete-note.md) | [androidJvm]<br>abstract suspend fun [deleteNote](delete-note.md)(note: [Notes](../-notes/index.md))<br>Elimina una nota de forma permanente. |
| [getAllNotes](get-all-notes.md) | [androidJvm]<br>abstract fun [getAllNotes](get-all-notes.md)(): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Notes](../-notes/index.md)&gt;&gt;<br>Obtiene todas las notas activas (no eliminadas), ordenadas por fecha descendente. |
| [getDeletedNotes](get-deleted-notes.md) | [androidJvm]<br>abstract fun [getDeletedNotes](get-deleted-notes.md)(): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Notes](../-notes/index.md)&gt;&gt;<br>Obtiene las notas en la papelera, ordenadas por fecha de eliminación. |
| [insertNote](insert-note.md) | [androidJvm]<br>abstract suspend fun [insertNote](insert-note.md)(note: [Notes](../-notes/index.md))<br>Inserta una nueva nota ignorando conflictos. |
| [permanentlyDeleteOldNotes](permanently-delete-old-notes.md) | [androidJvm]<br>abstract suspend fun [permanentlyDeleteOldNotes](permanently-delete-old-notes.md)(thresholdDate: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html))<br>Elimina permanentemente notas antiguas de la papelera. |
| [restoreNote](restore-note.md) | [androidJvm]<br>abstract suspend fun [restoreNote](restore-note.md)(noteId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html))<br>Restaura una nota de la papelera. |
| [updateNote](update-note.md) | [androidJvm]<br>abstract suspend fun [updateNote](update-note.md)(note: [Notes](../-notes/index.md))<br>Actualiza los datos de una nota existente. |
