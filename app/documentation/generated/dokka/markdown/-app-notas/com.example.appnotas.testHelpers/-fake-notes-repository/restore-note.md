//[AppNotas](../../../index.md)/[com.example.appnotas.testHelpers](../index.md)/[FakeNotesRepository](index.md)/[restoreNote](restore-note.md)

# restoreNote

[androidJvm]\
suspend fun [restoreNote](restore-note.md)(noteId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html))

Restaura una nota desde la papelera con validación adicional. Verifica que la nota exista en la papelera antes de restaurarla.

#### Parameters

androidJvm

| | |
|---|---|
| noteId | ID de la nota a restaurar |

#### Throws

| | |
|---|---|
| [IllegalStateException](https://developer.android.com/reference/kotlin/java/lang/IllegalStateException.html) | si la nota no se encuentra en la papelera |
