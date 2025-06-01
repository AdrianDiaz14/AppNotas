//[AppNotas](../../../index.md)/[com.example.appnotas.volumenestres](../index.md)/[StressTests](index.md)/[testConcurrentNoteOperations](test-concurrent-note-operations.md)

# testConcurrentNoteOperations

[androidJvm]\
fun [testConcurrentNoteOperations](test-concurrent-note-operations.md)()

Evalúa la capacidad del sistema para manejar múltiples inserciones concurrentes.

- 
   Inserta 50 notas simultáneamente desde múltiples coroutines.
- 
   Usa `CountDownLatch` para esperar la finalización de todas las operaciones.
- 
   Valida que todas las notas se insertaron correctamente.
