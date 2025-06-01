//[AppNotas](../../../index.md)/[com.example.appnotas.volumenestres.medio](../index.md)/[MediumStressImageTests](index.md)

# MediumStressImageTests

[androidJvm]\
class [MediumStressImageTests](index.md)

Pruebas de manejo de imágenes en condiciones de estrés medio.

Estas pruebas verifican:

- 
   El rendimiento con cantidades moderadas de imágenes
- 
   La estabilidad del convertidor de URIs
- 
   El consumo de recursos en escenarios realistas

## Constructors

| | |
|---|---|
| [MediumStressImageTests](-medium-stress-image-tests.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)() |
| [tearDown](tear-down.md) | [androidJvm]<br>fun [tearDown](tear-down.md)() |
| [testImageConverterMediumLimits](test-image-converter-medium-limits.md) | [androidJvm]<br>fun [testImageConverterMediumLimits](test-image-converter-medium-limits.md)()<br>Prueba los límites medios del convertidor de URIs de imágenes. |
| [testMediumNotesWithImages](test-medium-notes-with-images.md) | [androidJvm]<br>fun [testMediumNotesWithImages](test-medium-notes-with-images.md)()<br>Prueba la inserción de muchas notas con pocas imágenes cada una. |
| [testNotesWithMediumImages](test-notes-with-medium-images.md) | [androidJvm]<br>fun [testNotesWithMediumImages](test-notes-with-medium-images.md)()<br>Prueba el manejo de notas con cantidad media de imágenes. |

## Properties

| Name | Summary |
|---|---|
| [dao](dao.md) | [androidJvm]<br>private lateinit var [dao](dao.md): [NotesDao](../../com.example.appnotas.database/-notes-dao/index.md) |
| [db](db.md) | [androidJvm]<br>private lateinit var [db](db.md): [NotesRoomDatabase](../../com.example.appnotas.database/-notes-room-database/index.md) |
| [repository](repository.md) | [androidJvm]<br>private lateinit var [repository](repository.md): [NotesRepository](../../com.example.appnotas.database/-notes-repository/index.md) |
| [rule](rule.md) | [androidJvm]<br>val [rule](rule.md): TestRule |
| [viewModel](view-model.md) | [androidJvm]<br>private lateinit var [viewModel](view-model.md): [NotesViewModel](../../com.example.appnotas.database/-notes-view-model/index.md) |
