//[AppNotas](../../../index.md)/[com.example.appnotas.integracion](../index.md)/[NotesDaoIntegrationTest](index.md)

# NotesDaoIntegrationTest

class [NotesDaoIntegrationTest](index.md)

Pruebas de integración para [NotesDao](../../com.example.appnotas.database/-notes-dao/index.md) verificando operaciones directas con Room Database.

Utiliza una base de datos en memoria para garantizar el aislamiento de las pruebas.

#### See also

| | |
|---|---|
| [NotesDao](../../com.example.appnotas.database/-notes-dao/index.md) | Interfaz bajo prueba. |
| [NotesRoomDatabase](../../com.example.appnotas.database/-notes-room-database/index.md) | Configuración de la base de datos. |

## Constructors

| | |
|---|---|
| [NotesDaoIntegrationTest](-notes-dao-integration-test.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)()<br>Configura una base de datos Room en memoria antes de cada prueba. Permite ejecutar consultas en el hilo principal solo para pruebas. |
| [tearDown](tear-down.md) | [androidJvm]<br>fun [tearDown](tear-down.md)()<br>Cierra la base de datos después de cada prueba para liberar recursos. |
| [updateNoteTitle_updatesDatabase](update-note-title_updates-database.md) | [androidJvm]<br>fun [updateNoteTitle_updatesDatabase](update-note-title_updates-database.md)()<br>Verifica que [NotesDao.updateNote](../../com.example.appnotas.database/-notes-dao/update-note.md) actualiza correctamente el título de una nota. |

## Properties

| Name | Summary |
|---|---|
| [instantTaskExecutorRule](instant-task-executor-rule.md) | [androidJvm]<br>val [instantTaskExecutorRule](instant-task-executor-rule.md): [InstantTaskExecutorRule](https://developer.android.com/reference/kotlin/androidx/arch/core/executor/testing/InstantTaskExecutorRule.html) |
