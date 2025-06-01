//[AppNotas](../../../index.md)/[com.example.appnotas](../index.md)/[EditNoteFragment](index.md)/[addImage](add-image.md)

# addImage

[androidJvm]\
private fun [addImage](add-image.md)()

Solicita los permisos necesarios y permite al usuario añadir una imagen desde el almacenamiento del dispositivo.

Este método verifica si el permiso correspondiente al acceso a los archivos multimedia o almacenamiento externo ha sido otorgado. Si el permiso es válido:

- 
   Lanza el proceso para que el usuario pueda seleccionar una imagen.

Si no se ha otorgado el permiso:

- 
   Solicita al usuario que lo conceda.

#### Throws

| | |
|---|---|
| [SecurityException](https://developer.android.com/reference/kotlin/java/lang/SecurityException.html) | Si el usuario rechaza el permiso requerido. |
