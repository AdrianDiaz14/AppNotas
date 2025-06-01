//[AppNotas](../../../index.md)/[com.example.appnotas](../index.md)/[EditNoteFragment](index.md)/[pickImage](pick-image.md)

# pickImage

[androidJvm]\
private fun [pickImage](pick-image.md)()

Abre el selector de archivos del sistema para que el usuario pueda elegir una imagen.

Este método utiliza el contrato `ActivityResultContracts.OpenDocument` para lanzar un diálogo que permite al usuario seleccionar una imagen desde el almacenamiento. Una vez seleccionada:

- 
   La imagen es añadida a la lista `imageList`.
- 
   El adaptador del RecyclerView se actualiza para reflejar los cambios.
- 
   Se verifica y ajusta la visibilidad del RecyclerView.

#### Throws

| | |
|---|---|
| [IllegalArgumentException](https://developer.android.com/reference/kotlin/java/lang/IllegalArgumentException.html) | Si el tipo de archivo seleccionado no es compatible. |
