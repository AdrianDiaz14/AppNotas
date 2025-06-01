//[AppNotas](../../../index.md)/[com.example.appnotas.database](../index.md)/[NotesViewModel](index.md)

# NotesViewModel

[androidJvm]\
class [NotesViewModel](index.md)(application: [Application](https://developer.android.com/reference/kotlin/android/app/Application.html)) : [AndroidViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/AndroidViewModel.html)

ViewModel que gestiona la interacción entre la UI y el repositorio de notas. Proporciona datos a la UI y maneja las operaciones asíncronas.

#### Author

Adrian Diaz

#### Since

1.0

## Constructors

| | |
|---|---|
| [NotesViewModel](-notes-view-model.md) | [androidJvm]<br>constructor(application: [Application](https://developer.android.com/reference/kotlin/android/app/Application.html)) |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](index.md#383812252%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun [addCloseable](index.md#383812252%2FFunctions%2F-1837990189)(closeable: [AutoCloseable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-auto-closeable/index.html))<br>fun [addCloseable](index.md#1722490497%2FFunctions%2F-1837990189)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html), closeable: [AutoCloseable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-auto-closeable/index.html)) |
| [cleanOldDeletedNotes](clean-old-deleted-notes.md) | [androidJvm]<br>fun [cleanOldDeletedNotes](clean-old-deleted-notes.md)(): Job<br>Limpia permanentemente las notas en la papelera más antiguas que 7 días. |
| [deleteNote](delete-note.md) | [androidJvm]<br>fun [deleteNote](delete-note.md)(note: [Notes](../-notes/index.md)): Job<br>Elimina una nota permanentemente de la base de datos. |
| [getApplication](index.md#1696759283%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun &lt;[T](index.md#1696759283%2FFunctions%2F-1837990189) : [Application](https://developer.android.com/reference/kotlin/android/app/Application.html)&gt; [getApplication](index.md#1696759283%2FFunctions%2F-1837990189)(): [T](index.md#1696759283%2FFunctions%2F-1837990189) |
| [getCloseable](index.md#1102255800%2FFunctions%2F-1837990189) | [androidJvm]<br>fun &lt;[T](index.md#1102255800%2FFunctions%2F-1837990189) : [AutoCloseable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-auto-closeable/index.html)&gt; [getCloseable](index.md#1102255800%2FFunctions%2F-1837990189)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)): [T](index.md#1102255800%2FFunctions%2F-1837990189)? |
| [insertNote](insert-note.md) | [androidJvm]<br>fun [insertNote](insert-note.md)(note: [Notes](../-notes/index.md)): Job<br>Inserta una nueva nota en la base de datos. |
| [restoreNote](restore-note.md) | [androidJvm]<br>fun [restoreNote](restore-note.md)(noteId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html)): Job<br>Restaura una nota desde la papelera. |
| [softDeleteNote](soft-delete-note.md) | [androidJvm]<br>fun [softDeleteNote](soft-delete-note.md)(note: [Notes](../-notes/index.md)): Job<br>Marca una nota como eliminada (mueve a la papelera). |
| [updateNote](update-note.md) | [androidJvm]<br>fun [updateNote](update-note.md)(note: [Notes](../-notes/index.md)): Job<br>Actualiza una nota existente en la base de datos. |

## Properties

| Name | Summary |
|---|---|
| [allNotes](all-notes.md) | [androidJvm]<br>val [allNotes](all-notes.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Notes](../-notes/index.md)&gt;&gt;<br>Lista observable de todas las notas activas |
| [application](index.md#-1589994147%2FProperties%2F-1837990189) | [androidJvm]<br>private val [application](index.md#-1589994147%2FProperties%2F-1837990189): [Application](https://developer.android.com/reference/kotlin/android/app/Application.html) |
| [deletedNotes](deleted-notes.md) | [androidJvm]<br>val [deletedNotes](deleted-notes.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Notes](../-notes/index.md)&gt;&gt;<br>Lista observable de notas en la papelera |
| [impl](index.md#-1914838072%2FProperties%2F-1837990189) | [androidJvm]<br>private val [impl](index.md#-1914838072%2FProperties%2F-1837990189): ViewModelImpl? |
| [repository](repository.md) | [androidJvm]<br>private val [repository](repository.md): [NotesRepository](../-notes-repository/index.md)<br>Repositorio que maneja el acceso a los datos |
