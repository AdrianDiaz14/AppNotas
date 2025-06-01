//[AppNotas](../../../../index.md)/[com.example.appnotas.database](../../index.md)/[NotesRoomDatabase](../index.md)/[NoteDatabaseCallback](index.md)

# NoteDatabaseCallback

[androidJvm]\
private class [NoteDatabaseCallback](index.md)(val scope: CoroutineScope) : [RoomDatabase.Callback](https://developer.android.com/reference/kotlin/androidx/room/RoomDatabase.Callback.html)

Callback para poblar la base de datos al crearse.

## Constructors

| | |
|---|---|
| [NoteDatabaseCallback](-note-database-callback.md) | [androidJvm]<br>constructor(scope: CoroutineScope) |

## Functions

| Name | Summary |
|---|---|
| [onCreate](index.md#129191578%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun [onCreate](index.md#129191578%2FFunctions%2F-1837990189)(connection: [SQLiteConnection](https://developer.android.com/reference/kotlin/androidx/sqlite/SQLiteConnection.html))<br>[androidJvm]<br>open override fun [onCreate](on-create.md)(db: [SupportSQLiteDatabase](https://developer.android.com/reference/kotlin/androidx/sqlite/db/SupportSQLiteDatabase.html))<br>Callback que se ejecuta al crear la base de datos. Este método permite inicializar la base de datos con datos predeterminados al momento de su creación. |
| [onDestructiveMigration](index.md#1393147178%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun [onDestructiveMigration](index.md#1393147178%2FFunctions%2F-1837990189)(connection: [SQLiteConnection](https://developer.android.com/reference/kotlin/androidx/sqlite/SQLiteConnection.html))<br>open fun [onDestructiveMigration](index.md#-1350530802%2FFunctions%2F-1837990189)(db: [SupportSQLiteDatabase](https://developer.android.com/reference/kotlin/androidx/sqlite/db/SupportSQLiteDatabase.html)) |
| [onOpen](index.md#1627010316%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun [onOpen](index.md#1627010316%2FFunctions%2F-1837990189)(connection: [SQLiteConnection](https://developer.android.com/reference/kotlin/androidx/sqlite/SQLiteConnection.html))<br>open fun [onOpen](index.md#-2123104528%2FFunctions%2F-1837990189)(db: [SupportSQLiteDatabase](https://developer.android.com/reference/kotlin/androidx/sqlite/db/SupportSQLiteDatabase.html)) |
| [populateDatabase](populate-database.md) | [androidJvm]<br>suspend fun [populateDatabase](populate-database.md)(notesDao: [NotesDao](../../-notes-dao/index.md))<br>Inserta datos iniciales en la base de datos. |

## Properties

| Name | Summary |
|---|---|
| [scope](scope.md) | [androidJvm]<br>private val [scope](scope.md): CoroutineScope<br>CoroutineScope para operaciones asíncronas |
