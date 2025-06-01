//[AppNotas](../../../index.md)/[com.example.appnotas.volumenestres.bajo](../index.md)/[LowStressImageTests](index.md)

# LowStressImageTests

[androidJvm]\
class [LowStressImageTests](index.md)

Pruebas de manejo de imágenes en condiciones de bajo estrés.

Estas pruebas verifican:

- 
   El funcionamiento básico con pocas imágenes
- 
   El comportamiento con pocas notas con imágenes
- 
   Los límites inferiores del convertidor de URIs

## Constructors

| | |
|---|---|
| [LowStressImageTests](-low-stress-image-tests.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)() |
| [tearDown](tear-down.md) | [androidJvm]<br>fun [tearDown](tear-down.md)() |
| [testFewNotesWithImages](test-few-notes-with-images.md) | [androidJvm]<br>fun [testFewNotesWithImages](test-few-notes-with-images.md)()<br>Prueba la inserción de pocas notas con imágenes. |
| [testImageConverterLowLimits](test-image-converter-low-limits.md) | [androidJvm]<br>fun [testImageConverterLowLimits](test-image-converter-low-limits.md)()<br>Prueba los límites inferiores del convertidor de URIs de imágenes. |
| [testNotesWithFewImages](test-notes-with-few-images.md) | [androidJvm]<br>fun [testNotesWithFewImages](test-notes-with-few-images.md)()<br>Prueba el manejo de notas con pocas imágenes. |

## Properties

| Name | Summary |
|---|---|
| [dao](dao.md) | [androidJvm]<br>private lateinit var [dao](dao.md): [NotesDao](../../com.example.appnotas.database/-notes-dao/index.md) |
| [db](db.md) | [androidJvm]<br>private lateinit var [db](db.md): [NotesRoomDatabase](../../com.example.appnotas.database/-notes-room-database/index.md) |
| [repository](repository.md) | [androidJvm]<br>private lateinit var [repository](repository.md): [NotesRepository](../../com.example.appnotas.database/-notes-repository/index.md) |
| [rule](rule.md) | [androidJvm]<br>val [rule](rule.md): TestRule |
| [viewModel](view-model.md) | [androidJvm]<br>private lateinit var [viewModel](view-model.md): [NotesViewModel](../../com.example.appnotas.database/-notes-view-model/index.md) |
