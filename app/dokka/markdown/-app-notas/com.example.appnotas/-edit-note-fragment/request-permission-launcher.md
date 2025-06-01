//[AppNotas](../../../index.md)/[com.example.appnotas](../index.md)/[EditNoteFragment](index.md)/[requestPermissionLauncher](request-permission-launcher.md)

# requestPermissionLauncher

[androidJvm]\
private val [requestPermissionLauncher](request-permission-launcher.md): [ActivityResultLauncher](https://developer.android.com/reference/kotlin/androidx/activity/result/ActivityResultLauncher.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)&gt;

Registro para solicitar permisos y manejar el resultado de la solicitud.

Este launcher se usa para solicitar acceso a los archivos multimedia o almacenamiento según la versión del sistema operativo, permitiendo adjuntar imágenes en las notas.

- 
   **Si el usuario concede el permiso**, se ejecuta `pickImage()`, permitiendo la selección de imágenes.
- 
   **Si el usuario lo deniega**, se muestra un `Toast` informando que el permiso ha sido rechazado.
- 
   **Si el usuario marca &quot;No volver a preguntar&quot;**, se muestra un diálogo guiando al usuario a los ajustes de la aplicación para habilitar manualmente el permiso.

Android 13 o superior: Usa `READ_MEDIA_IMAGES` en lugar de `READ_EXTERNAL_STORAGE`.

##  Ejemplo de uso:

```kotlin
requestPermissionLauncher.launch(android.Manifest.permission.READ_MEDIA_IMAGES)
```
