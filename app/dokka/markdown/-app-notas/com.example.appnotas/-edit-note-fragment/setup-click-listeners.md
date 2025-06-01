//[AppNotas](../../../index.md)/[com.example.appnotas](../index.md)/[EditNoteFragment](index.md)/[setupClickListeners](setup-click-listeners.md)

# setupClickListeners

[androidJvm]\
private fun [setupClickListeners](setup-click-listeners.md)()

Configura los listeners de clic en los botones de la vista del fragmento.

Este método se encarga de vincular las acciones correspondientes a cada botón de la interfaz del usuario:

- 
   **Botón &quot;Añadir Imagen&quot;:** Llama al método `addImage()` para iniciar el proceso de selección de imágenes desde el almacenamiento.
- 
   **Botón &quot;Guardar Nota&quot;:** Llama al método `saveNote()` para validar y guardar los datos de la nota actual.

Flujo de trabajo del método:

- 
   Accede al binding de la vista actual (`fbind`) para identificar los botones interactivos.
- 
   Establece un listener para cada botón, asociándolo con la función correspondiente.

Este método garantiza que las interacciones de los usuarios con los botones sean procesadas de manera adecuada, manteniendo la funcionalidad esperada en la pantalla de edición de notas.

#### Throws

| | |
|---|---|
| [IllegalStateException](https://developer.android.com/reference/kotlin/java/lang/IllegalStateException.html) | Si el binding de la vista (`fbind`) no ha sido inicializado. |
