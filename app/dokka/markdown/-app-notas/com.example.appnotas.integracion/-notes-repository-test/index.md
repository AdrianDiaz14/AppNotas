//[AppNotas](../../../index.md)/[com.example.appnotas.integracion](../index.md)/[NotesRepositoryTest](index.md)

# NotesRepositoryTest

class [NotesRepositoryTest](index.md)

Pruebas de integración para [NotesRepository](../../com.example.appnotas.database/-notes-repository/index.md) verificando la lógica de negocio.

#### See also

| | |
|---|---|
| [NotesRepository](../../com.example.appnotas.database/-notes-repository/index.md) | Clase bajo prueba. |

## Constructors

| | |
|---|---|
| [NotesRepositoryTest](-notes-repository-test.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [cleanOldDeletedNotes_removesExpired](clean-old-deleted-notes_removes-expired.md) | [androidJvm]<br>fun [cleanOldDeletedNotes_removesExpired](clean-old-deleted-notes_removes-expired.md)()<br>Prueba la limpieza automática de notas antiguas en la papelera. |
| [deleteNote_permanentlyRemoves](delete-note_permanently-removes.md) | [androidJvm]<br>fun [deleteNote_permanentlyRemoves](delete-note_permanently-removes.md)()<br>Verifica el borrado permanente de notas. |
| [insertNote_andGetAllNotes](insert-note_and-get-all-notes.md) | [androidJvm]<br>fun [insertNote_andGetAllNotes](insert-note_and-get-all-notes.md)()<br>Verifica el flujo completo de inserción y recuperación de notas. |
| [restoreNote_fromTrash](restore-note_from-trash.md) | [androidJvm]<br>fun [restoreNote_fromTrash](restore-note_from-trash.md)()<br>Verifica la restauración de notas desde la papelera. |
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)() |
| [softDeleteNote_andCheckTrash](soft-delete-note_and-check-trash.md) | [androidJvm]<br>fun [softDeleteNote_andCheckTrash](soft-delete-note_and-check-trash.md)()<br>Prueba el borrado lógico (soft delete) y recuperación desde la papelera. |
| [tearDown](tear-down.md) | [androidJvm]<br>fun [tearDown](tear-down.md)() |
| [updateNote_andVerifyChanges](update-note_and-verify-changes.md) | [androidJvm]<br>fun [updateNote_andVerifyChanges](update-note_and-verify-changes.md)()<br>Prueba la actualización de notas existentes. |

## Properties

| Name | Summary |
|---|---|
| [database](database.md) | [androidJvm]<br>private lateinit var [database](database.md): [NotesRoomDatabase](../../com.example.appnotas.database/-notes-room-database/index.md) |
| [instantTaskExecutorRule](instant-task-executor-rule.md) | [androidJvm]<br>val [instantTaskExecutorRule](instant-task-executor-rule.md): [InstantTaskExecutorRule](https://developer.android.com/reference/kotlin/androidx/arch/core/executor/testing/InstantTaskExecutorRule.html) |
| [notesDao](notes-dao.md) | [androidJvm]<br>private lateinit var [notesDao](notes-dao.md): [NotesDao](../../com.example.appnotas.database/-notes-dao/index.md) |
| [repository](repository.md) | [androidJvm]<br>private lateinit var [repository](repository.md): [NotesRepository](../../com.example.appnotas.database/-notes-repository/index.md) |
