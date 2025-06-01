//[AppNotas](../../../index.md)/[com.example.appnotas.integracion](../index.md)/[TrashIntegrationTest](index.md)

# TrashIntegrationTest

class [TrashIntegrationTest](index.md)

Pruebas especializadas en la funcionalidad de la papelera.

Incluye pruebas de:

- 
   Restauración masiva de notas
- 
   Manejo de errores
- 
   Mediciones de rendimiento

#### See also

| | |
|---|---|
| [NotesRepository](../../com.example.appnotas.database/-notes-repository/index.md) | Implementación real bajo prueba. |
| [FakeNotesRepository](../../com.example.appnotas.testHelpers/-fake-notes-repository/index.md) | Implementación fake para casos de error. |

## Constructors

| | |
|---|---|
| [TrashIntegrationTest](-trash-integration-test.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [restoreExistingDeletedNote_shouldWork](restore-existing-deleted-note_should-work.md) | [androidJvm]<br>fun [restoreExistingDeletedNote_shouldWork](restore-existing-deleted-note_should-work.md)()<br>Prueba el flujo completo de restauración para una nota existente. |
| [restoreLargeVolume_ofDeletedNotes_andMeasurePerformance](restore-large-volume_of-deleted-notes_and-measure-performance.md) | [androidJvm]<br>fun [restoreLargeVolume_ofDeletedNotes_andMeasurePerformance](restore-large-volume_of-deleted-notes_and-measure-performance.md)()<br>Prueba de rendimiento para restauración masiva (500 notas). Mide el tiempo de ejecución y verifica la integridad de los datos. |
| [restoreMultipleDeletedNotes](restore-multiple-deleted-notes.md) | [androidJvm]<br>fun [restoreMultipleDeletedNotes](restore-multiple-deleted-notes.md)()<br>Prueba la restauración de múltiples notas eliminadas. |
| [restoreNonExistentNote_shouldThrowException](restore-non-existent-note_should-throw-exception.md) | [androidJvm]<br>fun [restoreNonExistentNote_shouldThrowException](restore-non-existent-note_should-throw-exception.md)()<br>Verifica el manejo de errores al restaurar notas inexistentes. |
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)() |
| [tearDown](tear-down.md) | [androidJvm]<br>fun [tearDown](tear-down.md)() |

## Properties

| Name | Summary |
|---|---|
| [database](database.md) | [androidJvm]<br>private lateinit var [database](database.md): [NotesRoomDatabase](../../com.example.appnotas.database/-notes-room-database/index.md) |
| [instantTaskExecutorRule](instant-task-executor-rule.md) | [androidJvm]<br>val [instantTaskExecutorRule](instant-task-executor-rule.md): [InstantTaskExecutorRule](https://developer.android.com/reference/kotlin/androidx/arch/core/executor/testing/InstantTaskExecutorRule.html) |
| [notesDao](notes-dao.md) | [androidJvm]<br>private lateinit var [notesDao](notes-dao.md): [NotesDao](../../com.example.appnotas.database/-notes-dao/index.md) |
| [realRepository](real-repository.md) | [androidJvm]<br>private lateinit var [realRepository](real-repository.md): [NotesRepository](../../com.example.appnotas.database/-notes-repository/index.md) |
| [testRepository](test-repository.md) | [androidJvm]<br>private lateinit var [testRepository](test-repository.md): [FakeNotesRepository](../../com.example.appnotas.testHelpers/-fake-notes-repository/index.md) |
