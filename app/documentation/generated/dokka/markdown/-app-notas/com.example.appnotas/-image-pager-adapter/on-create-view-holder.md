//[AppNotas](../../../index.md)/[com.example.appnotas](../index.md)/[ImagePagerAdapter](index.md)/[onCreateViewHolder](on-create-view-holder.md)

# onCreateViewHolder

[androidJvm]\
open override fun [onCreateViewHolder](on-create-view-holder.md)(parent: [ViewGroup](https://developer.android.com/reference/kotlin/android/view/ViewGroup.html), viewType: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html)): [ImagePagerAdapter.ViewHolder](-view-holder/index.md)

Crea un nuevo ViewHolder para el RecyclerView. Este método se encarga de inflar el diseño de los elementos individuales y asociarlo al ViewHolder.

#### Return

Instancia de ViewHolder para gestionar cada elemento.

#### Parameters

androidJvm

| | |
|---|---|
| parent | Vista padre que contendrá los elementos del RecyclerView. |
| viewType | Tipo de vista, no usado en este adaptador. |
