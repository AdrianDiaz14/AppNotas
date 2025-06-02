//[AppNotas](../../../index.md)/[com.example.appnotas.volumenestres.alto](../index.md)/[HighVolumeTests](index.md)

# HighVolumeTests

[androidJvm]\
class [HighVolumeTests](index.md)

Pruebas de alto volumen para evaluar el rendimiento con grandes cantidades de datos.

Estas pruebas verifican:

- 
   La capacidad de manejar miles de notas
- 
   El rendimiento con contenido de gran tamaño
- 
   La escalabilidad del sistema

## Constructors

| | |
|---|---|
| [HighVolumeTests](-high-volume-tests.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)() |
| [tearDown](tear-down.md) | [androidJvm]<br>fun [tearDown](tear-down.md)() |
| [testHighVolumeNoteInsertion](test-high-volume-note-insertion.md) | [androidJvm]<br>fun [testHighVolumeNoteInsertion](test-high-volume-note-insertion.md)()<br>Prueba la inserción masiva de notas en lotes para evaluar rendimiento. |
| [testLargeNoteContent](test-large-note-content.md) | [androidJvm]<br>fun [testLargeNoteContent](test-large-note-content.md)()<br>Prueba el manejo de notas con contenido muy grande (1MB+). |

## Properties

| Name | Summary |
|---|---|
| [rule](rule.md) | [androidJvm]<br>val [rule](rule.md): [InstantTaskExecutorRule](https://developer.android.com/reference/kotlin/androidx/arch/core/executor/testing/InstantTaskExecutorRule.html) |
