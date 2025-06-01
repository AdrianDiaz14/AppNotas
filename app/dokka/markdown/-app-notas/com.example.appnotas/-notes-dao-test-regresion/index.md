//[AppNotas](../../../index.md)/[com.example.appnotas](../index.md)/[NotesDaoTestRegresion](index.md)

# NotesDaoTestRegresion

[androidJvm]\
class [NotesDaoTestRegresion](index.md)

## Constructors

| | |
|---|---|
| [NotesDaoTestRegresion](-notes-dao-test-regresion.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [insertNote_shouldSaveCorrectly](insert-note_should-save-correctly.md) | [androidJvm]<br>fun [insertNote_shouldSaveCorrectly](insert-note_should-save-correctly.md)()<br>Verifica que la inserción de una nota se realiza correctamente. |
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)()<br>Configura una base de datos en memoria antes de cada prueba. Esto permite probar la funcionalidad del DAO sin afectar datos reales. |
| [tearDown](tear-down.md) | [androidJvm]<br>fun [tearDown](tear-down.md)()<br>Cierra la base de datos después de cada prueba. Esto asegura que no haya fugas de recursos. |

## Properties

| Name | Summary |
|---|---|
| [dao](dao.md) | [androidJvm]<br>private lateinit var [dao](dao.md): [NotesDao](../../com.example.appnotas.database/-notes-dao/index.md) |
| [database](database.md) | [androidJvm]<br>private lateinit var [database](database.md): [NotesRoomDatabase](../../com.example.appnotas.database/-notes-room-database/index.md) |
