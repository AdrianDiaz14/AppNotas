//[AppNotas](../../../index.md)/[com.example.appnotas.volumenestres](../index.md)/[ImageStressTests](index.md)

# ImageStressTests

[androidJvm]\
class [ImageStressTests](index.md)

## Constructors

| | |
|---|---|
| [ImageStressTests](-image-stress-tests.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)()<br>Configura la base de datos en memoria antes de cada prueba. Permite probar la gestión de notas sin afectar datos reales. |
| [tearDown](tear-down.md) | [androidJvm]<br>fun [tearDown](tear-down.md)()<br>Cierra la base de datos después de cada prueba para liberar recursos. |
| [testManyNotesWithImages](test-many-notes-with-images.md) | [androidJvm]<br>fun [testManyNotesWithImages](test-many-notes-with-images.md)(): &lt;Error class: unknown class&gt;<br>Prueba la inserción de múltiples notas con imágenes. |
| [testNotesWithManyImages](test-notes-with-many-images.md) | [androidJvm]<br>fun [testNotesWithManyImages](test-notes-with-many-images.md)()<br>Prueba la inserción de una nota con múltiples imágenes. |

## Properties

| Name | Summary |
|---|---|
| [dao](dao.md) | [androidJvm]<br>private lateinit var [dao](dao.md): [NotesDao](../../com.example.appnotas.database/-notes-dao/index.md) |
| [db](db.md) | [androidJvm]<br>private lateinit var [db](db.md): [NotesRoomDatabase](../../com.example.appnotas.database/-notes-room-database/index.md) |
| [repository](repository.md) | [androidJvm]<br>private lateinit var [repository](repository.md): [NotesRepository](../../com.example.appnotas.database/-notes-repository/index.md) |
| [rule](rule.md) | [androidJvm]<br>val [rule](rule.md): TestRule |
| [viewModel](view-model.md) | [androidJvm]<br>private lateinit var [viewModel](view-model.md): [NotesViewModel](../../com.example.appnotas.database/-notes-view-model/index.md) |
