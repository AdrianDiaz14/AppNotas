//[AppNotas](../../../index.md)/[com.example.appnotas.volumenestres](../index.md)/[VolumeTests](index.md)

# VolumeTests

[androidJvm]\
class [VolumeTests](index.md)

## Constructors

| | |
|---|---|
| [VolumeTests](-volume-tests.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)()<br>Configura la base de datos en memoria antes de cada prueba. Permite simular operaciones intensivas sin afectar datos reales. |
| [tearDown](tear-down.md) | [androidJvm]<br>fun [tearDown](tear-down.md)()<br>Cierra la base de datos después de cada prueba para liberar recursos. |
| [testLargeNoteContent](test-large-note-content.md) | [androidJvm]<br>fun [testLargeNoteContent](test-large-note-content.md)()<br>Evalúa la capacidad del sistema para manejar notas con contenido extenso. |
| [testMassiveNoteDeletion](test-massive-note-deletion.md) | [androidJvm]<br>fun [testMassiveNoteDeletion](test-massive-note-deletion.md)()<br>Evalúa el rendimiento de la aplicación al eliminar un gran número de notas. |
| [testMassiveNoteInsertion](test-massive-note-insertion.md) | [androidJvm]<br>fun [testMassiveNoteInsertion](test-massive-note-insertion.md)()<br>Evalúa la capacidad de la aplicación para insertar grandes volúmenes de notas. |

## Properties

| Name | Summary |
|---|---|
| [db](db.md) | [androidJvm]<br>private lateinit var [db](db.md): [NotesRoomDatabase](../../com.example.appnotas.database/-notes-room-database/index.md) |
| [rule](rule.md) | [androidJvm]<br>val [rule](rule.md): [InstantTaskExecutorRule](https://developer.android.com/reference/kotlin/androidx/arch/core/executor/testing/InstantTaskExecutorRule.html) |
| [viewModel](view-model.md) | [androidJvm]<br>private lateinit var [viewModel](view-model.md): [NotesViewModel](../../com.example.appnotas.database/-notes-view-model/index.md) |
