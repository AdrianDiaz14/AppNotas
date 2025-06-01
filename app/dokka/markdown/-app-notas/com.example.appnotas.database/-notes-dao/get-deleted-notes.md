//[AppNotas](../../../index.md)/[com.example.appnotas.database](../index.md)/[NotesDao](index.md)/[getDeletedNotes](get-deleted-notes.md)

# getDeletedNotes

[androidJvm]\
abstract fun [getDeletedNotes](get-deleted-notes.md)(): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Notes](../-notes/index.md)&gt;&gt;

Obtiene las notas en la papelera, ordenadas por fecha de eliminación.

#### Return

LiveData con las notas eliminadas

#### Throws

| | |
|---|---|
| [IllegalStateException](https://developer.android.com/reference/kotlin/java/lang/IllegalStateException.html) | Si la nota no puede ser restaurada. |
