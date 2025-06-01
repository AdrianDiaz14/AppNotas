//[AppNotas](../../../index.md)/[com.example.appnotas.volumenestres](../index.md)/[VolumeTests](index.md)/[testLargeNoteContent](test-large-note-content.md)

# testLargeNoteContent

[androidJvm]\
fun [testLargeNoteContent](test-large-note-content.md)()

Evalúa la capacidad del sistema para manejar notas con contenido extenso.

- 
   Crea una nota con 3000 caracteres en su descripción.
- 
   Inserta la nota y espera su confirmación en `LiveData`.
- 
   Verifica que el contenido se haya guardado correctamente sin truncarse.
