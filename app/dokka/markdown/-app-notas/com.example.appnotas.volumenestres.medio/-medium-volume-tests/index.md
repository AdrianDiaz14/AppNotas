//[AppNotas](../../../index.md)/[com.example.appnotas.volumenestres.medio](../index.md)/[MediumVolumeTests](index.md)

# MediumVolumeTests

[androidJvm]\
class [MediumVolumeTests](index.md)

Pruebas de volumen medio para evaluar rendimiento en condiciones realistas.

Estas pruebas verifican:

- 
   El rendimiento con cientos de notas
- 
   El manejo de contenido de tamaño moderado
- 
   La escalabilidad en escenarios típicos

## Constructors

| | |
|---|---|
| [MediumVolumeTests](-medium-volume-tests.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)() |
| [tearDown](tear-down.md) | [androidJvm]<br>fun [tearDown](tear-down.md)() |
| [testMediumNoteContent](test-medium-note-content.md) | [androidJvm]<br>fun [testMediumNoteContent](test-medium-note-content.md)()<br>Prueba el manejo de notas con contenido de tamaño moderado. |
| [testMediumVolumeNoteInsertion](test-medium-volume-note-insertion.md) | [androidJvm]<br>fun [testMediumVolumeNoteInsertion](test-medium-volume-note-insertion.md)()<br>Prueba inserción de volumen medio de notas. |

## Properties

| Name | Summary |
|---|---|
| [db](db.md) | [androidJvm]<br>private lateinit var [db](db.md): [NotesRoomDatabase](../../com.example.appnotas.database/-notes-room-database/index.md) |
| [rule](rule.md) | [androidJvm]<br>val [rule](rule.md): [InstantTaskExecutorRule](https://developer.android.com/reference/kotlin/androidx/arch/core/executor/testing/InstantTaskExecutorRule.html) |
| [viewModel](view-model.md) | [androidJvm]<br>private lateinit var [viewModel](view-model.md): [NotesViewModel](../../com.example.appnotas.database/-notes-view-model/index.md) |
