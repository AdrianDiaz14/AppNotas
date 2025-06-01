//[AppNotas](../../../index.md)/[com.example.appnotas.volumenestres.bajo](../index.md)/[LowVolumeTests](index.md)

# LowVolumeTests

[androidJvm]\
class [LowVolumeTests](index.md)

Pruebas de bajo volumen para verificar comportamiento básico del sistema.

Estas pruebas verifican:

- 
   El funcionamiento con pocas notas
- 
   El manejo de contenido pequeño
- 
   El rendimiento en condiciones mínimas

## Constructors

| | |
|---|---|
| [LowVolumeTests](-low-volume-tests.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)() |
| [tearDown](tear-down.md) | [androidJvm]<br>fun [tearDown](tear-down.md)() |
| [testLowVolumeNoteInsertion](test-low-volume-note-insertion.md) | [androidJvm]<br>fun [testLowVolumeNoteInsertion](test-low-volume-note-insertion.md)()<br>Prueba inserción de pocas notas para verificar comportamiento básico. |
| [testSmallNoteContent](test-small-note-content.md) | [androidJvm]<br>fun [testSmallNoteContent](test-small-note-content.md)()<br>Prueba el manejo de notas con contenido pequeño. |

## Properties

| Name | Summary |
|---|---|
| [db](db.md) | [androidJvm]<br>private lateinit var [db](db.md): [NotesRoomDatabase](../../com.example.appnotas.database/-notes-room-database/index.md) |
| [rule](rule.md) | [androidJvm]<br>val [rule](rule.md): [InstantTaskExecutorRule](https://developer.android.com/reference/kotlin/androidx/arch/core/executor/testing/InstantTaskExecutorRule.html) |
| [viewModel](view-model.md) | [androidJvm]<br>private lateinit var [viewModel](view-model.md): [NotesViewModel](../../com.example.appnotas.database/-notes-view-model/index.md) |
