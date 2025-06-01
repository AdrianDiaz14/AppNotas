//[AppNotas](../../../index.md)/[com.example.appnotas.database](../index.md)/[FakeNotesDao](index.md)

# FakeNotesDao

[androidJvm]\
class [FakeNotesDao](index.md) : [NotesDao](../-notes-dao/index.md)

Implementación falsa de `NotesDao` para pruebas sin necesidad de usar Room. Simula el almacenamiento de notas en memoria y proporciona métodos similares a los de un DAO real.

Evita la dependencia de una base de datos real.

## Constructors

| | |
|---|---|
| [FakeNotesDao](-fake-notes-dao.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [deleteNote](delete-note.md) | [androidJvm]<br>open suspend override fun [deleteNote](delete-note.md)(note: [Notes](../-notes/index.md))<br>Elimina una nota de la lista simulada. |
| [getAllNotes](get-all-notes.md) | [androidJvm]<br>open override fun [getAllNotes](get-all-notes.md)(): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Notes](../-notes/index.md)&gt;&gt;<br>Obtiene todas las notas activas (no eliminadas). |
| [getDeletedNotes](get-deleted-notes.md) | [androidJvm]<br>open override fun [getDeletedNotes](get-deleted-notes.md)(): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Notes](../-notes/index.md)&gt;&gt;<br>Obtiene todas las notas eliminadas. |
| [insertNote](insert-note.md) | [androidJvm]<br>open suspend override fun [insertNote](insert-note.md)(note: [Notes](../-notes/index.md))<br>Inserta una nueva nota en la lista simulada. |
| [permanentlyDeleteOldNotes](permanently-delete-old-notes.md) | [androidJvm]<br>open suspend override fun [permanentlyDeleteOldNotes](permanently-delete-old-notes.md)(thresholdDate: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html))<br>Elimina permanentemente las notas que fueron movidas a la papelera y cuya fecha de eliminación es anterior a la fecha límite proporcionada. |
| [restoreNote](restore-note.md) | [androidJvm]<br>open suspend override fun [restoreNote](restore-note.md)(noteId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html))<br>Restaura una nota eliminada, quitando su estado de eliminación. |
| [updateLiveData](update-live-data.md) | [androidJvm]<br>private fun [updateLiveData](update-live-data.md)()<br>Actualiza el `LiveData` con la lista de notas actualizada. Se usa internamente para reflejar cambios en la UI. |
| [updateNote](update-note.md) | [androidJvm]<br>open suspend override fun [updateNote](update-note.md)(note: [Notes](../-notes/index.md))<br>Actualiza una nota existente en la lista simulada. |

## Properties

| Name | Summary |
|---|---|
| [notesList](notes-list.md) | [androidJvm]<br>private val [notesList](notes-list.md): &lt;Error class: unknown class&gt; |
| [notesLiveData](notes-live-data.md) | [androidJvm]<br>private val [notesLiveData](notes-live-data.md): [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Notes](../-notes/index.md)&gt;&gt; |
