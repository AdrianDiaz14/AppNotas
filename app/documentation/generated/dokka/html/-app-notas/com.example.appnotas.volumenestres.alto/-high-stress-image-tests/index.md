//[AppNotas](../../../index.md)/[com.example.appnotas.volumenestres.alto](../index.md)/[HighStressImageTests](index.md)

# HighStressImageTests

[androidJvm]\
class [HighStressImageTests](index.md)

Pruebas de alto estrés para evaluar el manejo de notas con imágenes en condiciones extremas.

Estas pruebas verifican:

- 
   El rendimiento con grandes cantidades de imágenes
- 
   La estabilidad del convertidor de URIs de imágenes
- 
   El consumo de memoria en escenarios intensivos

## Constructors

| | |
|---|---|
| [HighStressImageTests](-high-stress-image-tests.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)() |
| [tearDown](tear-down.md) | [androidJvm]<br>fun [tearDown](tear-down.md)() |
| [testImageConverterHighLimits](test-image-converter-high-limits.md) | [androidJvm]<br>fun [testImageConverterHighLimits](test-image-converter-high-limits.md)()<br>Prueba los límites superiores del convertidor de URIs de imágenes. |
| [testManyNotesWithImages](test-many-notes-with-images.md) | [androidJvm]<br>fun [testManyNotesWithImages](test-many-notes-with-images.md)()<br>Prueba la inserción de muchas notas con imágenes para evaluar escalabilidad. |
| [testNotesWithManyImages](test-notes-with-many-images.md) | [androidJvm]<br>fun [testNotesWithManyImages](test-notes-with-many-images.md)()<br>Prueba el manejo de una nota con gran cantidad de imágenes adjuntas. |

## Properties

| Name | Summary |
|---|---|
| [rule](rule.md) | [androidJvm]<br>val [rule](rule.md): TestRule |
