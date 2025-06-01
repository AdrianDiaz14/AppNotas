//[AppNotas](../../../index.md)/[com.example.appnotas.volumenestres](../index.md)/[VolumeTests](index.md)/[testMassiveNoteDeletion](test-massive-note-deletion.md)

# testMassiveNoteDeletion

[androidJvm]\
fun [testMassiveNoteDeletion](test-massive-note-deletion.md)()

Evalúa el rendimiento de la aplicación al eliminar un gran número de notas.

- 
   Inserta 100 notas primero.
- 
   Luego las elimina y espera hasta que `LiveData` refleje que están eliminadas.
- 
   Verifica que la lista de notas esté vacía al final de la prueba.
