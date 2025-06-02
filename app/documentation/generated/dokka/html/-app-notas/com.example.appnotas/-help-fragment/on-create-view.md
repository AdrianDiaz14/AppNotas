//[AppNotas](../../../index.md)/[com.example.appnotas](../index.md)/[HelpFragment](index.md)/[onCreateView](on-create-view.md)

# onCreateView

[androidJvm]\
open override fun [onCreateView](on-create-view.md)(inflater: [LayoutInflater](https://developer.android.com/reference/kotlin/android/view/LayoutInflater.html), container: [ViewGroup](https://developer.android.com/reference/kotlin/android/view/ViewGroup.html)?, savedInstanceState: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)?): [View](https://developer.android.com/reference/kotlin/android/view/View.html)

Infla la vista asociada al fragmento.

Este método se utiliza para inicializar el binding de la vista, que permite acceder fácilmente a los elementos de la interfaz definidos en `FragmentHelpBinding`.

#### Return

Vista raíz del fragmento generada a partir del layout.

#### Parameters

androidJvm

| | |
|---|---|
| inflater | Inflador usado para crear la vista del fragmento. |
| container | Contenedor que alojará la vista del fragmento. |
| savedInstanceState | Estado previamente guardado del fragmento, si aplica. |
