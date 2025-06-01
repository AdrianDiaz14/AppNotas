//[AppNotas](../../../index.md)/[com.example.appnotas.volumenestres](../index.md)/[VolumeTests](index.md)/[testMassiveNoteInsertion](test-massive-note-insertion.md)

# testMassiveNoteInsertion

[androidJvm]\
fun [testMassiveNoteInsertion](test-massive-note-insertion.md)()

Evalúa la capacidad de la aplicación para insertar grandes volúmenes de notas.

- 
   Inserta 300 notas de manera concurrente.
- 
   Usa `CountDownLatch` para sincronizar la ejecución de la prueba.
- 
   Verifica que todas las notas fueron insertadas correctamente.
