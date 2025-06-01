//[AppNotas](../../../index.md)/[com.example.appnotas](../index.md)/[HelpFragment](index.md)/[onViewCreated](on-view-created.md)

# onViewCreated

[androidJvm]\
open override fun [onViewCreated](on-view-created.md)(view: [View](https://developer.android.com/reference/kotlin/android/view/View.html), savedInstanceState: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)?)

Configura el contenido mostrado en el `WebView` al inicializar la vista del fragmento.

Este método carga contenido HTML desde los assets y habilita JavaScript para garantizar que las características interactivas del contenido funcionen correctamente. En caso de errores al cargar el contenido, se muestra un contenido alternativo.

#### Parameters

androidJvm

| | |
|---|---|
| view | Vista raíz del fragmento generada por `onCreateView`. |
| savedInstanceState | Estado previamente guardado del fragmento, si aplica. |

#### Throws

| | |
|---|---|
| [Exception](https://developer.android.com/reference/kotlin/java/lang/Exception.html) | Si ocurre un error mientras se carga el contenido HTML. |
