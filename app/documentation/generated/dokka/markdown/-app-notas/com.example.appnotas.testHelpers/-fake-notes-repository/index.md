//[AppNotas](../../../index.md)/[com.example.appnotas.testHelpers](../index.md)/[FakeNotesRepository](index.md)

# FakeNotesRepository

[androidJvm]\
class [FakeNotesRepository](index.md)(val realRepository: [NotesRepository](../../com.example.appnotas.database/-notes-repository/index.md))

Implementación falsa de [NotesRepository](../../com.example.appnotas.database/-notes-repository/index.md) para propósitos de prueba.

Esta clase actúa como un proxy para el repositorio real, permitiendo:

- 
   Verificar el comportamiento del repositorio real en pruebas
- 
   Añadir lógica adicional para validaciones en pruebas
- 
   Simular condiciones específicas para testing

## Constructors

| | |
|---|---|
| [FakeNotesRepository](-fake-notes-repository.md) | [androidJvm]<br>constructor(realRepository: [NotesRepository](../../com.example.appnotas.database/-notes-repository/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [cleanOldDeletedNotes](clean-old-deleted-notes.md) | [androidJvm]<br>suspend fun [cleanOldDeletedNotes](clean-old-deleted-notes.md)()<br>Limpia notas eliminadas antiguas delegando al repositorio real. |
| [deleteNote](delete-note.md) | [androidJvm]<br>suspend fun [deleteNote](delete-note.md)(note: [Notes](../../com.example.appnotas.database/-notes/index.md))<br>Elimina una nota permanentemente delegando al repositorio real. |
| [insertNote](insert-note.md) | [androidJvm]<br>suspend fun [insertNote](insert-note.md)(note: [Notes](../../com.example.appnotas.database/-notes/index.md))<br>Inserta una nota delegando al repositorio real. |
| [restoreNote](restore-note.md) | [androidJvm]<br>suspend fun [restoreNote](restore-note.md)(noteId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html))<br>Restaura una nota desde la papelera con validación adicional. Verifica que la nota exista en la papelera antes de restaurarla. |
| [softDeleteNote](soft-delete-note.md) | [androidJvm]<br>suspend fun [softDeleteNote](soft-delete-note.md)(note: [Notes](../../com.example.appnotas.database/-notes/index.md))<br>Marca una nota como eliminada (borrado lógico) delegando al repositorio real. |
| [updateNote](update-note.md) | [androidJvm]<br>suspend fun [updateNote](update-note.md)(note: [Notes](../../com.example.appnotas.database/-notes/index.md))<br>Actualiza una nota delegando al repositorio real. |

## Properties

| Name | Summary |
|---|---|
| [allNotes](all-notes.md) | [androidJvm]<br>val [allNotes](all-notes.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Notes](../../com.example.appnotas.database/-notes/index.md)&gt;&gt; |
| [deletedNotes](deleted-notes.md) | [androidJvm]<br>val [deletedNotes](deleted-notes.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Notes](../../com.example.appnotas.database/-notes/index.md)&gt;&gt; |
| [realRepository](real-repository.md) | [androidJvm]<br>private val [realRepository](real-repository.md): [NotesRepository](../../com.example.appnotas.database/-notes-repository/index.md)<br>El repositorio real que será utilizado para las operaciones |
