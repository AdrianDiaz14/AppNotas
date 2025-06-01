//[AppNotas](../../../index.md)/[com.example.appnotas.database](../index.md)/[NotesRepository](index.md)

# NotesRepository

class [NotesRepository](index.md)(val noteDao: [NotesDao](../-notes-dao/index.md))

Repositorio que abstrae el acceso a los datos de notas. Actúa como intermediario entre el ViewModel y el DAO.

#### Author

Adrian Diaz

#### Since

1.0

#### See also

| | |
|---|---|
| [NotesDao](../-notes-dao/index.md) | Para las operaciones de base de datos. |
| [NotesViewModel](../-notes-view-model/index.md) | Para comunicación con la UI. |

## Constructors

| | |
|---|---|
| [NotesRepository](-notes-repository.md) | [androidJvm]<br>constructor(noteDao: [NotesDao](../-notes-dao/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [cleanOldDeletedNotes](clean-old-deleted-notes.md) | [androidJvm]<br>suspend fun [cleanOldDeletedNotes](clean-old-deleted-notes.md)()<br>Elimina permanentemente notas en la papelera más antiguas de 7 días. |
| [deleteNote](delete-note.md) | [androidJvm]<br>suspend fun [deleteNote](delete-note.md)(note: [Notes](../-notes/index.md))<br>Elimina una nota permanentemente. |
| [insertNote](insert-note.md) | [androidJvm]<br>suspend fun [insertNote](insert-note.md)(note: [Notes](../-notes/index.md))<br>Inserta una nueva nota. |
| [restoreNote](restore-note.md) | [androidJvm]<br>suspend fun [restoreNote](restore-note.md)(noteId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html))<br>Restaura una nota desde la papelera. |
| [softDeleteNote](soft-delete-note.md) | [androidJvm]<br>suspend fun [softDeleteNote](soft-delete-note.md)(note: [Notes](../-notes/index.md))<br>Marca una nota como eliminada (mueve a la papelera). |
| [updateNote](update-note.md) | [androidJvm]<br>suspend fun [updateNote](update-note.md)(note: [Notes](../-notes/index.md))<br>Actualiza una nota existente. |

## Properties

| Name | Summary |
|---|---|
| [allNotes](all-notes.md) | [androidJvm]<br>val [allNotes](all-notes.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Notes](../-notes/index.md)&gt;&gt;<br>Lista observable de todas las notas activas |
| [deletedNotes](deleted-notes.md) | [androidJvm]<br>val [deletedNotes](deleted-notes.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Notes](../-notes/index.md)&gt;&gt;<br>Lista observable de notas en la papelera |
| [noteDao](note-dao.md) | [androidJvm]<br>private val [noteDao](note-dao.md): [NotesDao](../-notes-dao/index.md)<br>Objeto de acceso a datos para las notas |
