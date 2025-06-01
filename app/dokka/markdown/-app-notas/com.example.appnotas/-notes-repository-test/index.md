//[AppNotas](../../../index.md)/[com.example.appnotas](../index.md)/[NotesRepositoryTest](index.md)

# NotesRepositoryTest

[androidJvm]\
class [NotesRepositoryTest](index.md)

## Constructors

| | |
|---|---|
| [NotesRepositoryTest](-notes-repository-test.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [insertNote_andGetAllNotes](insert-note_and-get-all-notes.md) | [androidJvm]<br>fun [insertNote_andGetAllNotes](insert-note_and-get-all-notes.md)()<br>Verifica que una nota se inserta y recupera correctamente. |
| [restoreNote_fromTrash](restore-note_from-trash.md) | [androidJvm]<br>fun [restoreNote_fromTrash](restore-note_from-trash.md)()<br>Verifica que una nota eliminada puede restaurarse correctamente. |
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)()<br>Configura una base de datos en memoria antes de cada prueba. Esto permite probar la funcionalidad del repositorio sin afectar datos reales. |
| [softDeleteNote_andCheckTrash](soft-delete-note_and-check-trash.md) | [androidJvm]<br>fun [softDeleteNote_andCheckTrash](soft-delete-note_and-check-trash.md)()<br>Verifica que una nota puede marcarse como eliminada y aparecer en la papelera. |
| [tearDown](tear-down.md) | [androidJvm]<br>fun [tearDown](tear-down.md)()<br>Cierra la base de datos después de cada prueba. Esto asegura que no haya fugas de recursos. |
| [updateNote_andVerifyChanges](update-note_and-verify-changes.md) | [androidJvm]<br>fun [updateNote_andVerifyChanges](update-note_and-verify-changes.md)()<br>Verifica que se puede actualizar el contenido de una nota correctamente. |

## Properties

| Name | Summary |
|---|---|
| [database](database.md) | [androidJvm]<br>private lateinit var [database](database.md): [NotesRoomDatabase](../../com.example.appnotas.database/-notes-room-database/index.md) |
| [instantTaskExecutorRule](instant-task-executor-rule.md) | [androidJvm]<br>val [instantTaskExecutorRule](instant-task-executor-rule.md): [InstantTaskExecutorRule](https://developer.android.com/reference/kotlin/androidx/arch/core/executor/testing/InstantTaskExecutorRule.html) |
| [notesDao](notes-dao.md) | [androidJvm]<br>private lateinit var [notesDao](notes-dao.md): [NotesDao](../../com.example.appnotas.database/-notes-dao/index.md) |
| [repository](repository.md) | [androidJvm]<br>private lateinit var [repository](repository.md): [NotesRepository](../../com.example.appnotas.database/-notes-repository/index.md) |
