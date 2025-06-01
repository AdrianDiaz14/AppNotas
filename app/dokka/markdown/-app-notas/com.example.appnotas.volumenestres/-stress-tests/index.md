//[AppNotas](../../../index.md)/[com.example.appnotas.volumenestres](../index.md)/[StressTests](index.md)

# StressTests

[androidJvm]\
class [StressTests](index.md)

## Constructors

| | |
|---|---|
| [StressTests](-stress-tests.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)()<br>Configura la base de datos en memoria antes de cada prueba. Permite simular operaciones intensivas sin afectar datos reales. |
| [tearDown](tear-down.md) | [androidJvm]<br>fun [tearDown](tear-down.md)()<br>Cierra la base de datos después de cada prueba para liberar recursos. |
| [testConcurrentNoteOperations](test-concurrent-note-operations.md) | [androidJvm]<br>fun [testConcurrentNoteOperations](test-concurrent-note-operations.md)()<br>Evalúa la capacidad del sistema para manejar múltiples inserciones concurrentes. |
| [testHighFrequencyUpdates](test-high-frequency-updates.md) | [androidJvm]<br>fun [testHighFrequencyUpdates](test-high-frequency-updates.md)()<br>Evalúa el comportamiento del sistema ante actualizaciones frecuentes en un solo elemento. |

## Properties

| Name | Summary |
|---|---|
| [db](db.md) | [androidJvm]<br>private lateinit var [db](db.md): [NotesRoomDatabase](../../com.example.appnotas.database/-notes-room-database/index.md) |
| [rule](rule.md) | [androidJvm]<br>val [rule](rule.md): [InstantTaskExecutorRule](https://developer.android.com/reference/kotlin/androidx/arch/core/executor/testing/InstantTaskExecutorRule.html) |
| [viewModel](view-model.md) | [androidJvm]<br>private lateinit var [viewModel](view-model.md): [NotesViewModel](../../com.example.appnotas.database/-notes-view-model/index.md) |
