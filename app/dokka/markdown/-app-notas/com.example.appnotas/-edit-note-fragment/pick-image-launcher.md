//[AppNotas](../../../index.md)/[com.example.appnotas](../index.md)/[EditNoteFragment](index.md)/[pickImageLauncher](pick-image-launcher.md)

# pickImageLauncher

[androidJvm]\
private val [pickImageLauncher](pick-image-launcher.md): [ActivityResultLauncher](https://developer.android.com/reference/kotlin/androidx/activity/result/ActivityResultLauncher.html)&lt;[Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)&gt;&gt;

Registro para manejar la selección de imágenes desde el sistema. Utiliza `ActivityResultContracts.OpenDocument` para abrir un selector de documentos y permite la persistencia del URI seleccionado.

Al seleccionar una imagen:

- 
   El URI se agrega a la lista de imágenes de la nota.
- 
   La visibilidad del RecyclerView se actualiza automáticamente.
- 
   La lista de imágenes se notifica al adaptador para que se redibuje.

#### Throws

| | |
|---|---|
| [SecurityException](https://developer.android.com/reference/kotlin/java/lang/SecurityException.html) | Si no se pueden otorgar permisos persistentes para el URI. |
