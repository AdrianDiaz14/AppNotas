//[AppNotas](../../../index.md)/[com.example.appnotas.regresion](../index.md)/[NotesDaoTestRegresion](index.md)/[permanentlyDeleteOldNotes_shouldRemoveFromTrash](permanently-delete-old-notes_should-remove-from-trash.md)

# permanentlyDeleteOldNotes_shouldRemoveFromTrash

[androidJvm]\
fun [permanentlyDeleteOldNotes_shouldRemoveFromTrash](permanently-delete-old-notes_should-remove-from-trash.md)()

Prueba que verifica el borrado permanente de notas antiguas de la papelera. Comprueba que las notas con más de 7 días en la papelera son eliminadas permanentemente.

#### Throws

| | |
|---|---|
| [AssertionError](https://developer.android.com/reference/kotlin/java/lang/AssertionError.html) | si la nota antigua sigue presente en la papelera después del borrado |
