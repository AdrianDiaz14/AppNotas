//[AppNotas](../../../index.md)/[com.example.appnotas](../index.md)/[EditNoteFragment](index.md)/[saveNote](save-note.md)

# saveNote

[androidJvm]\
private fun [saveNote](save-note.md)()

Guarda la nota actual en la base de datos.

Este método valida los datos introducidos por el usuario, guarda una nueva nota o actualiza la existente, y luego navega de regreso a la lista de notas. También actualiza el estado de las imágenes adjuntas.

Flujo del método:

- 
   Si el título y la descripción están vacíos, muestra un mensaje y no guarda la nota.
- 
   Si la nota es nueva, la crea en la base de datos.
- 
   Si la nota ya existe, actualiza sus datos en la base de datos.
- 
   Al completar la acción, se oculta el teclado y se navega de regreso.

#### Throws

| | |
|---|---|
| [IllegalArgumentException](https://developer.android.com/reference/kotlin/java/lang/IllegalArgumentException.html) | Si los datos proporcionados son inválidos. |
