//[AppNotas](../../../index.md)/[com.example.appnotas.volumenestres](../index.md)/[ImageStressTests](index.md)/[testNotesWithManyImages](test-notes-with-many-images.md)

# testNotesWithManyImages

[androidJvm]\
fun [testNotesWithManyImages](test-notes-with-many-images.md)()

Prueba la inserción de una nota con múltiples imágenes.

- 
   Crea una nota con 20 imágenes.
- 
   Inserta la nota en la base de datos y mide el tiempo de ejecución.
- 
   Usa `CountDownLatch` para esperar la actualización de `LiveData`.
- 
   Verifica que la nota se ha guardado correctamente con sus imágenes adjuntas.
