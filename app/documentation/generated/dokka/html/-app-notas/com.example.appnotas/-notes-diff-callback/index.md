//[AppNotas](../../../index.md)/[com.example.appnotas](../index.md)/[NotesDiffCallback](index.md)

# NotesDiffCallback

[androidJvm]\
class [NotesDiffCallback](index.md) : [DiffUtil.ItemCallback](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/DiffUtil.ItemCallback.html)&lt;[Notes](../../com.example.appnotas.database/-notes/index.md)&gt; 

Callback para comparar notas y optimizar actualizaciones del RecyclerView.

## Constructors

| | |
|---|---|
| [NotesDiffCallback](-notes-diff-callback.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [areContentsTheSame](are-contents-the-same.md) | [androidJvm]<br>open override fun [areContentsTheSame](are-contents-the-same.md)(oldItem: [Notes](../../com.example.appnotas.database/-notes/index.md), newItem: [Notes](../../com.example.appnotas.database/-notes/index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html) |
| [areItemsTheSame](are-items-the-same.md) | [androidJvm]<br>open override fun [areItemsTheSame](are-items-the-same.md)(oldItem: [Notes](../../com.example.appnotas.database/-notes/index.md), newItem: [Notes](../../com.example.appnotas.database/-notes/index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html) |
| [getChangePayload](index.md#1207618104%2FFunctions%2F310006415) | [androidJvm]<br>@[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)<br>open fun [getChangePayload](index.md#1207618104%2FFunctions%2F310006415)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Notes](../../com.example.appnotas.database/-notes/index.md), @[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p1: [Notes](../../com.example.appnotas.database/-notes/index.md)): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-any/index.html)? |
