//[AppNotas](../../../index.md)/[com.example.appnotas](../index.md)/[EditNoteFragment](index.md)/[loadNoteData](load-note-data.md)

# loadNoteData

[androidJvm]\
private fun [loadNoteData](load-note-data.md)()

Carga los datos de una nota existente o prepara la interfaz para crear una nueva nota.

Este método utiliza los argumentos proporcionados al fragmento para determinar si se debe editar una nota existente o crear una nueva. Si se proporciona una nota existente:

- 
   Carga el título, descripción y última fecha de edición en los campos correspondientes.
- 
   Carga las imágenes adjuntas y las muestra en el RecyclerView asociado.

Si no hay datos, la interfaz se prepara para crear una nueva nota sin contenido preestablecido.

Flujo del método:

- 
   Recupera los datos de los argumentos del fragmento.
- 
   Si se proporciona una nota, actualiza los campos de texto y las imágenes.
- 
   Si no se proporciona una nota, la interfaz permanece vacía.

#### Throws

| | |
|---|---|
| [IllegalArgumentException](https://developer.android.com/reference/kotlin/java/lang/IllegalArgumentException.html) | Si los argumentos del fragmento no son válidos. |
