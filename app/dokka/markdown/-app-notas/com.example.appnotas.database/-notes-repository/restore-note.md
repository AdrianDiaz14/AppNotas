//[AppNotas](../../../index.md)/[com.example.appnotas.database](../index.md)/[NotesRepository](index.md)/[restoreNote](restore-note.md)

# restoreNote

[androidJvm]\
suspend fun [restoreNote](restore-note.md)(noteId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html))

Restaura una nota desde la papelera.

#### Parameters

androidJvm

| | |
|---|---|
| noteId | ID de la nota a restaurar |

#### Throws

| | |
|---|---|
| [IllegalStateException](https://developer.android.com/reference/kotlin/java/lang/IllegalStateException.html) | Si la nota no existe o no puede ser restaurada. |
