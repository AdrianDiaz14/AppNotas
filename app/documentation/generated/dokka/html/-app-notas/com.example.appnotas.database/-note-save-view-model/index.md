//[AppNotas](../../../index.md)/[com.example.appnotas.database](../index.md)/[NoteSaveViewModel](index.md)

# NoteSaveViewModel

[androidJvm]\
class [NoteSaveViewModel](index.md)(application: [Application](https://developer.android.com/reference/kotlin/android/app/Application.html)) : [AndroidViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/AndroidViewModel.html)

ViewModel especializado para operaciones de guardado y actualización de notas. Se diferencia de NotesViewModel al enfocarse solo en operaciones de persistencia.

#### Author

Adrian Diaz

#### Since

1.0

## Constructors

| | |
|---|---|
| [NoteSaveViewModel](-note-save-view-model.md) | [androidJvm]<br>constructor(application: [Application](https://developer.android.com/reference/kotlin/android/app/Application.html)) |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](../-notes-view-model/index.md#383812252%2FFunctions%2F310006415) | [androidJvm]<br>open fun [addCloseable](../-notes-view-model/index.md#383812252%2FFunctions%2F310006415)(closeable: [AutoCloseable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-auto-closeable/index.html))<br>fun [addCloseable](../-notes-view-model/index.md#1722490497%2FFunctions%2F310006415)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html), closeable: [AutoCloseable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-auto-closeable/index.html)) |
| [getApplication](../-notes-view-model/index.md#1696759283%2FFunctions%2F310006415) | [androidJvm]<br>open fun &lt;[T](../-notes-view-model/index.md#1696759283%2FFunctions%2F310006415) : [Application](https://developer.android.com/reference/kotlin/android/app/Application.html)&gt; [getApplication](../-notes-view-model/index.md#1696759283%2FFunctions%2F310006415)(): [T](../-notes-view-model/index.md#1696759283%2FFunctions%2F310006415) |
| [getCloseable](../-notes-view-model/index.md#1102255800%2FFunctions%2F310006415) | [androidJvm]<br>fun &lt;[T](../-notes-view-model/index.md#1102255800%2FFunctions%2F310006415) : [AutoCloseable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-auto-closeable/index.html)&gt; [getCloseable](../-notes-view-model/index.md#1102255800%2FFunctions%2F310006415)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)): [T](../-notes-view-model/index.md#1102255800%2FFunctions%2F310006415)? |
| [insertNote](insert-note.md) | [androidJvm]<br>fun [insertNote](insert-note.md)(note: [Notes](../-notes/index.md)): Job<br>Inserta una nueva nota en la base de datos. |
| [updateNote](update-note.md) | [androidJvm]<br>fun [updateNote](update-note.md)(note: [Notes](../-notes/index.md)): Job<br>Actualiza una nota existente en la base de datos. |
