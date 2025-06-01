//[AppNotas](../../../../index.md)/[com.example.appnotas](../../index.md)/[NotesAdapter](../index.md)/[NotesViewHolder](index.md)

# NotesViewHolder

[androidJvm]\
inner class [NotesViewHolder](index.md)(val binding: &lt;Error class: unknown class&gt;) : [RecyclerView.ViewHolder](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.ViewHolder.html)

ViewHolder para mostrar notas individuales.

## Constructors

| | |
|---|---|
| [NotesViewHolder](-notes-view-holder.md) | [androidJvm]<br>constructor(binding: &lt;Error class: unknown class&gt;) |

## Functions

| Name | Summary |
|---|---|
| [bind](bind.md) | [androidJvm]<br>fun [bind](bind.md)(note: [Notes](../../../com.example.appnotas.database/-notes/index.md))<br>Vincula los datos de la nota a las vistas. |
| [bindNoteImages](bind-note-images.md) | [androidJvm]<br>private fun [bindNoteImages](bind-note-images.md)(note: [Notes](../../../com.example.appnotas.database/-notes/index.md))<br>Configura las imágenes adjuntas a la nota. |
| [createPayloadsIfNeeded](../../-trash-adapter/-trash-view-holder/index.md#1328516304%2FFunctions%2F-1837990189) | [androidJvm]<br>private open fun [createPayloadsIfNeeded](../../-trash-adapter/-trash-view-holder/index.md#1328516304%2FFunctions%2F-1837990189)() |
| [getAbsoluteAdapterPosition](../../-trash-adapter/-trash-view-holder/index.md#358648312%2FFunctions%2F-1837990189) | [androidJvm]<br>fun [getAbsoluteAdapterPosition](../../-trash-adapter/-trash-view-holder/index.md#358648312%2FFunctions%2F-1837990189)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html) |
| [getAdapterPosition](../../-trash-adapter/-trash-view-holder/index.md#644519777%2FFunctions%2F-1837990189) | [androidJvm]<br>fun [~~getAdapterPosition~~](../../-trash-adapter/-trash-view-holder/index.md#644519777%2FFunctions%2F-1837990189)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html) |
| [getBindingAdapter](../../-trash-adapter/-trash-view-holder/index.md#-646392777%2FFunctions%2F-1837990189) | [androidJvm]<br>@[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)<br>fun [getBindingAdapter](../../-trash-adapter/-trash-view-holder/index.md#-646392777%2FFunctions%2F-1837990189)(): [RecyclerView.Adapter](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.Adapter.html)&lt;out [RecyclerView.ViewHolder](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.ViewHolder.html)&gt;? |
| [getBindingAdapterPosition](../../-trash-adapter/-trash-view-holder/index.md#1427640590%2FFunctions%2F-1837990189) | [androidJvm]<br>fun [getBindingAdapterPosition](../../-trash-adapter/-trash-view-holder/index.md#1427640590%2FFunctions%2F-1837990189)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html) |
| [getItemId](../../-trash-adapter/-trash-view-holder/index.md#1378485811%2FFunctions%2F-1837990189) | [androidJvm]<br>fun [getItemId](../../-trash-adapter/-trash-view-holder/index.md#1378485811%2FFunctions%2F-1837990189)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html) |
| [getItemViewType](../../-trash-adapter/-trash-view-holder/index.md#-1649344625%2FFunctions%2F-1837990189) | [androidJvm]<br>fun [getItemViewType](../../-trash-adapter/-trash-view-holder/index.md#-1649344625%2FFunctions%2F-1837990189)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html) |
| [getLayoutPosition](../../-trash-adapter/-trash-view-holder/index.md#-1407255826%2FFunctions%2F-1837990189) | [androidJvm]<br>fun [getLayoutPosition](../../-trash-adapter/-trash-view-holder/index.md#-1407255826%2FFunctions%2F-1837990189)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html) |
| [getOldPosition](../../-trash-adapter/-trash-view-holder/index.md#-1203059319%2FFunctions%2F-1837990189) | [androidJvm]<br>fun [getOldPosition](../../-trash-adapter/-trash-view-holder/index.md#-1203059319%2FFunctions%2F-1837990189)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html) |
| [getPosition](../../-trash-adapter/-trash-view-holder/index.md#-1155470344%2FFunctions%2F-1837990189) | [androidJvm]<br>fun [~~getPosition~~](../../-trash-adapter/-trash-view-holder/index.md#-1155470344%2FFunctions%2F-1837990189)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html) |
| [isRecyclable](../../-trash-adapter/-trash-view-holder/index.md#-1703443315%2FFunctions%2F-1837990189) | [androidJvm]<br>fun [isRecyclable](../../-trash-adapter/-trash-view-holder/index.md#-1703443315%2FFunctions%2F-1837990189)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html) |
| [navigateToEditNote](navigate-to-edit-note.md) | [androidJvm]<br>private fun [navigateToEditNote](navigate-to-edit-note.md)()<br>Navega al fragmento de edición de nota. |
| [setIsRecyclable](../../-trash-adapter/-trash-view-holder/index.md#-1860912636%2FFunctions%2F-1837990189) | [androidJvm]<br>fun [setIsRecyclable](../../-trash-adapter/-trash-view-holder/index.md#-1860912636%2FFunctions%2F-1837990189)(p0: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html)) |
| [setupClickListener](setup-click-listener.md) | [androidJvm]<br>private fun [setupClickListener](setup-click-listener.md)()<br>Configura el listener para clicks simples. |
| [setupImageAdapter](setup-image-adapter.md) | [androidJvm]<br>private fun [setupImageAdapter](setup-image-adapter.md)(imageUris: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html)&gt;)<br>Configura el adaptador para imágenes adjuntas. |
| [setupLongClickListener](setup-long-click-listener.md) | [androidJvm]<br>private fun [setupLongClickListener](setup-long-click-listener.md)()<br>Configura el listener para selección larga. |
| [toString](../../-trash-adapter/-trash-view-holder/index.md#-1200015593%2FFunctions%2F-1837990189) | [androidJvm]<br>open override fun [toString](../../-trash-adapter/-trash-view-holder/index.md#-1200015593%2FFunctions%2F-1837990189)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [binding](binding.md) | [androidJvm]<br>private val [binding](binding.md): &lt;Error class: unknown class&gt; |
| [itemView](../../-trash-adapter/-trash-view-holder/index.md#29975211%2FProperties%2F-1837990189) | [androidJvm]<br>@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)<br>val [itemView](../../-trash-adapter/-trash-view-holder/index.md#29975211%2FProperties%2F-1837990189): [View](https://developer.android.com/reference/kotlin/android/view/View.html) |
| [mIsRecyclableCount](../../-trash-adapter/-trash-view-holder/index.md#-2018828937%2FProperties%2F-1837990189) | [androidJvm]<br>private var [mIsRecyclableCount](../../-trash-adapter/-trash-view-holder/index.md#-2018828937%2FProperties%2F-1837990189): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html) |
| [mWasImportantForAccessibilityBeforeHidden](../../-trash-adapter/-trash-view-holder/index.md#1167875491%2FProperties%2F-1837990189) | [androidJvm]<br>private var [mWasImportantForAccessibilityBeforeHidden](../../-trash-adapter/-trash-view-holder/index.md#1167875491%2FProperties%2F-1837990189): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html) |
