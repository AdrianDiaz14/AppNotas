//[AppNotas](../../../../index.md)/[com.example.appnotas.database](../../index.md)/[NotesRoomDatabase](../index.md)/[Companion](index.md)

# Companion

[androidJvm]\
object [Companion](index.md)

## Functions

| Name | Summary |
|---|---|
| [getDatabase](get-database.md) | [androidJvm]<br>fun [getDatabase](get-database.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), scope: CoroutineScope): [NotesRoomDatabase](../index.md)<br>Obtiene la instancia de la base de datos. |

## Properties

| Name | Summary |
|---|---|
| [INSTANCE](-i-n-s-t-a-n-c-e.md) | [androidJvm]<br>@[Volatile](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.jvm/-volatile/index.html)<br>private var [INSTANCE](-i-n-s-t-a-n-c-e.md): [NotesRoomDatabase](../index.md)? |
| [MIGRATION_1_2](-m-i-g-r-a-t-i-o-n_1_2.md) | [androidJvm]<br>private val [MIGRATION_1_2](-m-i-g-r-a-t-i-o-n_1_2.md): NotesRoomDatabase.Companion.&lt;no name provided&gt;<br>Migración de la versión 1 a la versión 2 de la base de datos. En esta migración, se añade el campo `imageUris` a la tabla `Notes`. |
| [MIGRATION_2_3](-m-i-g-r-a-t-i-o-n_2_3.md) | [androidJvm]<br>private val [MIGRATION_2_3](-m-i-g-r-a-t-i-o-n_2_3.md): NotesRoomDatabase.Companion.&lt;no name provided&gt;<br>Migración de la versión 2 a la versión 3 de la base de datos. En esta migración, se añaden los campos `isDeleted` y `deletionDate` a la tabla `Notes`. |
