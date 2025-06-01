//[AppNotas](../../../index.md)/[com.example.appnotas.integracion](../index.md)/[NotesViewModelTest](index.md)

# NotesViewModelTest

class [NotesViewModelTest](index.md)

Pruebas para [NotesViewModel](../../com.example.appnotas.database/-notes-view-model/index.md) verificando la interacción entre UI y repositorio.

#### See also

| | |
|---|---|
| [NotesViewModel](../../com.example.appnotas.database/-notes-view-model/index.md) | Clase bajo prueba. |
| [NotesRepository](../../com.example.appnotas.database/-notes-repository/index.md) | Dependencia mockeada implícitamente. |

## Constructors

| | |
|---|---|
| [NotesViewModelTest](-notes-view-model-test.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [insertNote_updatesLiveData](insert-note_updates-live-data.md) | [androidJvm]<br>fun [insertNote_updatesLiveData](insert-note_updates-live-data.md)()<br>Verifica que la inserción de notas actualiza correctamente el LiveData. |
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)() |
| [tearDown](tear-down.md) | [androidJvm]<br>fun [tearDown](tear-down.md)() |

## Properties

| Name | Summary |
|---|---|
| [dao](dao.md) | [androidJvm]<br>private lateinit var [dao](dao.md): [NotesDao](../../com.example.appnotas.database/-notes-dao/index.md) |
| [db](db.md) | [androidJvm]<br>private lateinit var [db](db.md): [NotesRoomDatabase](../../com.example.appnotas.database/-notes-room-database/index.md) |
| [rule](rule.md) | [androidJvm]<br>val [rule](rule.md): TestRule |
| [viewModel](view-model.md) | [androidJvm]<br>private lateinit var [viewModel](view-model.md): [NotesViewModel](../../com.example.appnotas.database/-notes-view-model/index.md) |
