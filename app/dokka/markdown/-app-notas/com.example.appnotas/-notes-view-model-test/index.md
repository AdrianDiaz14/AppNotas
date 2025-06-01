//[AppNotas](../../../index.md)/[com.example.appnotas](../index.md)/[NotesViewModelTest](index.md)

# NotesViewModelTest

[androidJvm]\
class [NotesViewModelTest](index.md)

## Constructors

| | |
|---|---|
| [NotesViewModelTest](-notes-view-model-test.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [insertNote_updatesLiveData](insert-note_updates-live-data.md) | [androidJvm]<br>fun [insertNote_updatesLiveData](insert-note_updates-live-data.md)()<br>Verifica que insertar una nota actualiza correctamente el `LiveData`. |
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)()<br>Configura una base de datos en memoria antes de cada prueba. Esto permite probar la funcionalidad del `ViewModel` sin afectar datos reales. |
| [tearDown](tear-down.md) | [androidJvm]<br>fun [tearDown](tear-down.md)()<br>Cierra la base de datos después de cada prueba. Esto evita fugas de memoria y asegura que las pruebas sean independientes. |

## Properties

| Name | Summary |
|---|---|
| [dao](dao.md) | [androidJvm]<br>private lateinit var [dao](dao.md): [NotesDao](../../com.example.appnotas.database/-notes-dao/index.md) |
| [db](db.md) | [androidJvm]<br>private lateinit var [db](db.md): [NotesRoomDatabase](../../com.example.appnotas.database/-notes-room-database/index.md) |
| [rule](rule.md) | [androidJvm]<br>val [rule](rule.md): TestRule |
| [viewModel](view-model.md) | [androidJvm]<br>private lateinit var [viewModel](view-model.md): [NotesViewModel](../../com.example.appnotas.database/-notes-view-model/index.md) |
