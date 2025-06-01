//[AppNotas](../../../../index.md)/[com.example.appnotas](../../index.md)/[ImagePagerAdapter](../index.md)/[ViewHolder](index.md)

# ViewHolder

[androidJvm]\
inner class [ViewHolder](index.md)(view: [View](https://developer.android.com/reference/kotlin/android/view/View.html)) : [RecyclerView.ViewHolder](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.ViewHolder.html)

ViewHolder para gestionar la visualización de imágenes individuales.

## Constructors

| | |
|---|---|
| [ViewHolder](-view-holder.md) | [androidJvm]<br>constructor(view: [View](https://developer.android.com/reference/kotlin/android/view/View.html)) |

## Functions

| Name | Summary |
|---|---|
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
| [setIsRecyclable](../../-trash-adapter/-trash-view-holder/index.md#-1860912636%2FFunctions%2F-1837990189) | [androidJvm]<br>fun [setIsRecyclable](../../-trash-adapter/-trash-view-holder/index.md#-1860912636%2FFunctions%2F-1837990189)(p0: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html)) |
| [toString](../../-trash-adapter/-trash-view-holder/index.md#-1200015593%2FFunctions%2F-1837990189) | [androidJvm]<br>open override fun [toString](../../-trash-adapter/-trash-view-holder/index.md#-1200015593%2FFunctions%2F-1837990189)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [imageView](image-view.md) | [androidJvm]<br>val [imageView](image-view.md): [ImageView](https://developer.android.com/reference/kotlin/android/widget/ImageView.html)<br>Vista en la que se mostrará la imagen. |
| [itemView](../../-trash-adapter/-trash-view-holder/index.md#29975211%2FProperties%2F-1837990189) | [androidJvm]<br>@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)<br>val [itemView](../../-trash-adapter/-trash-view-holder/index.md#29975211%2FProperties%2F-1837990189): [View](https://developer.android.com/reference/kotlin/android/view/View.html) |
| [mIsRecyclableCount](../../-trash-adapter/-trash-view-holder/index.md#-2018828937%2FProperties%2F-1837990189) | [androidJvm]<br>private var [mIsRecyclableCount](../../-trash-adapter/-trash-view-holder/index.md#-2018828937%2FProperties%2F-1837990189): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html) |
| [mWasImportantForAccessibilityBeforeHidden](../../-trash-adapter/-trash-view-holder/index.md#1167875491%2FProperties%2F-1837990189) | [androidJvm]<br>private var [mWasImportantForAccessibilityBeforeHidden](../../-trash-adapter/-trash-view-holder/index.md#1167875491%2FProperties%2F-1837990189): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html) |
