//[AppNotas](../../../index.md)/[com.example.appnotas.regresion](../index.md)/[NotesDaoTestRegresion](index.md)

# NotesDaoTestRegresion

[androidJvm]\
class [NotesDaoTestRegresion](index.md)

Clase de pruebas de regresión para [NotesDao](../../com.example.appnotas.database/-notes-dao/index.md) que verifica que las funcionalidades básicas del DAO continúen funcionando correctamente después de cambios en el código.

Estas pruebas utilizan una base de datos en memoria para verificar el comportamiento del DAO con operaciones CRUD y manejo de la papelera de notas.

## Constructors

| | |
|---|---|
| [NotesDaoTestRegresion](-notes-dao-test-regresion.md) | [androidJvm]<br>constructor()<br>Crea una instancia de pruebas para el DAO de notas |

## Functions

| Name | Summary |
|---|---|
| [deleteNote_shouldMoveToTrash](delete-note_should-move-to-trash.md) | [androidJvm]<br>fun [deleteNote_shouldMoveToTrash](delete-note_should-move-to-trash.md)()<br>Prueba que verifica el funcionamiento del borrado lógico de notas. Comprueba que al marcar una nota como eliminada, esta aparece en la papelera. |
| [insertNote_shouldStillWork](insert-note_should-still-work.md) | [androidJvm]<br>fun [insertNote_shouldStillWork](insert-note_should-still-work.md)()<br>Prueba que verifica que la inserción de notas sigue funcionando correctamente. |
| [permanentlyDeleteOldNotes_shouldRemoveFromTrash](permanently-delete-old-notes_should-remove-from-trash.md) | [androidJvm]<br>fun [permanentlyDeleteOldNotes_shouldRemoveFromTrash](permanently-delete-old-notes_should-remove-from-trash.md)()<br>Prueba que verifica el borrado permanente de notas antiguas de la papelera. Comprueba que las notas con más de 7 días en la papelera son eliminadas permanentemente. |
| [restoreNote_shouldStillWork](restore-note_should-still-work.md) | [androidJvm]<br>fun [restoreNote_shouldStillWork](restore-note_should-still-work.md)()<br>Prueba que verifica que la restauración de notas desde la papelera sigue funcionando. Comprueba que una nota restaurada vuelve a aparecer en la lista principal de notas. |
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)() |
| [tearDown](tear-down.md) | [androidJvm]<br>fun [tearDown](tear-down.md)() |

## Properties

| Name | Summary |
|---|---|
| [instantTaskExecutorRule](instant-task-executor-rule.md) | [androidJvm]<br>val [instantTaskExecutorRule](instant-task-executor-rule.md): [InstantTaskExecutorRule](https://developer.android.com/reference/kotlin/androidx/arch/core/executor/testing/InstantTaskExecutorRule.html) |
