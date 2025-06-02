//[AppNotas](../../../index.md)/[com.example.appnotas](../index.md)/[ImageAdapter](index.md)/[onCreateViewHolder](on-create-view-holder.md)

# onCreateViewHolder

[androidJvm]\
open override fun [onCreateViewHolder](on-create-view-holder.md)(parent: [ViewGroup](https://developer.android.com/reference/kotlin/android/view/ViewGroup.html), viewType: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html)): [ImageAdapter.ImageViewHolder](-image-view-holder/index.md)

Crea un nuevo ViewHolder para el RecyclerView. Este método infla el diseño definido en `ImageItemBinding` y lo asocia al ViewHolder que se utilizará para mostrar cada elemento.

#### Return

Instancia de `ImageViewHolder` con el diseño inflado.

#### Parameters

androidJvm

| | |
|---|---|
| parent | Vista padre del RecyclerView. |
| viewType | Tipo de vista, no usado en este caso. |
