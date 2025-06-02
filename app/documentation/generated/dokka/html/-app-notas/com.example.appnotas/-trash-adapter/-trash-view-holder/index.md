//[AppNotas](../../../../index.md)/[com.example.appnotas](../../index.md)/[TrashAdapter](../index.md)/[TrashViewHolder](index.md)

# TrashViewHolder

[androidJvm]\
inner class [TrashViewHolder](index.md)(binding: &lt;Error class: unknown class&gt;) : [RecyclerView.ViewHolder](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.ViewHolder.html), [View.OnCreateContextMenuListener](https://developer.android.com/reference/kotlin/android/view/View.OnCreateContextMenuListener.html)

ViewHolder para notas en la papelera. Maneja la visualización de elementos individuales y eventos de interacción.

## Constructors

| | |
|---|---|
| [TrashViewHolder](-trash-view-holder.md) | [androidJvm]<br>constructor(binding: &lt;Error class: unknown class&gt;)<br>Crea un nuevo ViewHolder para notas eliminadas |

## Functions

| Name | Summary |
|---|---|
| [bind](bind.md) | [androidJvm]<br>fun [bind](bind.md)(note: [Notes](../../../com.example.appnotas.database/-notes/index.md))<br>Vincula los datos de una nota a las vistas del ViewHolder. |
| [getAbsoluteAdapterPosition](index.md#358648312%2FFunctions%2F310006415) | [androidJvm]<br>fun [getAbsoluteAdapterPosition](index.md#358648312%2FFunctions%2F310006415)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html) |
| [getAdapterPosition](index.md#644519777%2FFunctions%2F310006415) | [androidJvm]<br>fun [~~getAdapterPosition~~](index.md#644519777%2FFunctions%2F310006415)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html) |
| [getBindingAdapter](index.md#-646392777%2FFunctions%2F310006415) | [androidJvm]<br>@[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)<br>fun [getBindingAdapter](index.md#-646392777%2FFunctions%2F310006415)(): [RecyclerView.Adapter](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.Adapter.html)&lt;out [RecyclerView.ViewHolder](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.ViewHolder.html)&gt;? |
| [getBindingAdapterPosition](index.md#1427640590%2FFunctions%2F310006415) | [androidJvm]<br>fun [getBindingAdapterPosition](index.md#1427640590%2FFunctions%2F310006415)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html) |
| [getItemId](index.md#1378485811%2FFunctions%2F310006415) | [androidJvm]<br>fun [getItemId](index.md#1378485811%2FFunctions%2F310006415)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html) |
| [getItemViewType](index.md#-1649344625%2FFunctions%2F310006415) | [androidJvm]<br>fun [getItemViewType](index.md#-1649344625%2FFunctions%2F310006415)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html) |
| [getLayoutPosition](index.md#-1407255826%2FFunctions%2F310006415) | [androidJvm]<br>fun [getLayoutPosition](index.md#-1407255826%2FFunctions%2F310006415)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html) |
| [getOldPosition](index.md#-1203059319%2FFunctions%2F310006415) | [androidJvm]<br>fun [getOldPosition](index.md#-1203059319%2FFunctions%2F310006415)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html) |
| [getPosition](index.md#-1155470344%2FFunctions%2F310006415) | [androidJvm]<br>fun [~~getPosition~~](index.md#-1155470344%2FFunctions%2F310006415)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html) |
| [isRecyclable](index.md#-1703443315%2FFunctions%2F310006415) | [androidJvm]<br>fun [isRecyclable](index.md#-1703443315%2FFunctions%2F310006415)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html) |
| [onCreateContextMenu](on-create-context-menu.md) | [androidJvm]<br>open override fun [onCreateContextMenu](on-create-context-menu.md)(menu: [ContextMenu](https://developer.android.com/reference/kotlin/android/view/ContextMenu.html), v: [View](https://developer.android.com/reference/kotlin/android/view/View.html)?, menuInfo: [ContextMenu.ContextMenuInfo](https://developer.android.com/reference/kotlin/android/view/ContextMenu.ContextMenuInfo.html)?)<br>Crea el menú contextual al realizar una pulsación larga. |
| [setIsRecyclable](index.md#-1860912636%2FFunctions%2F310006415) | [androidJvm]<br>fun [setIsRecyclable](index.md#-1860912636%2FFunctions%2F310006415)(p0: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html)) |
| [toString](index.md#-1200015593%2FFunctions%2F310006415) | [androidJvm]<br>open override fun [toString](index.md#-1200015593%2FFunctions%2F310006415)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [itemView](index.md#29975211%2FProperties%2F310006415) | [androidJvm]<br>@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)<br>val [itemView](index.md#29975211%2FProperties%2F310006415): [View](https://developer.android.com/reference/kotlin/android/view/View.html) |
