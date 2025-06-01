//[AppNotas](../../../index.md)/[com.example.appnotas.database](../index.md)/[FakeNotesDao](index.md)/[permanentlyDeleteOldNotes](permanently-delete-old-notes.md)

# permanentlyDeleteOldNotes

[androidJvm]\
open suspend override fun [permanentlyDeleteOldNotes](permanently-delete-old-notes.md)(thresholdDate: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html))

Elimina permanentemente las notas que fueron movidas a la papelera y cuya fecha de eliminación es anterior a la fecha límite proporcionada.

#### Parameters

androidJvm

| | |
|---|---|
| thresholdDate | Fecha límite para eliminar notas antiguas |
