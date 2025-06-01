//[AppNotas](../../../index.md)/[com.example.appnotas](../index.md)/[AllNotesFragment](index.md)/[onDestroyView](on-destroy-view.md)

# onDestroyView

[androidJvm]\
open override fun [onDestroyView](on-destroy-view.md)()

Método llamado cuando la vista asociada al fragmento se destruye.

Este método se utiliza para limpiar el binding y evitar fugas de memoria. Establece `_binding` en `null` para liberar los recursos asociados a la vista.

#### See also

| |
|---|
| [Fragment.onDestroyView](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html#ondestroyview) |
