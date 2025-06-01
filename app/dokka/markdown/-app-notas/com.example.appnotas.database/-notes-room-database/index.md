//[AppNotas](../../../index.md)/[com.example.appnotas.database](../index.md)/[NotesRoomDatabase](index.md)

# NotesRoomDatabase

abstract class [NotesRoomDatabase](index.md) : [RoomDatabase](https://developer.android.com/reference/kotlin/androidx/room/RoomDatabase.html)

Clase abstracta que representa la base de datos de Room para las notas.

Esta clase utiliza Room como ORM para conectar las entidades con los DAOs.

#### Author

Adrian Diaz

#### Since

1.0

#### See also

| | |
|---|---|
| [Notes](../-notes/index.md) | Para las entidades gestionadas por la base de datos. |
| [NotesDao](../-notes-dao/index.md) | Para los métodos de acceso a datos. |

## Constructors

| | |
|---|---|
| [NotesRoomDatabase](-notes-room-database.md) | [androidJvm]<br>constructor() |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |
| [NoteDatabaseCallback](-note-database-callback/index.md) | [androidJvm]<br>private class [NoteDatabaseCallback](-note-database-callback/index.md)(val scope: CoroutineScope) : [RoomDatabase.Callback](https://developer.android.com/reference/kotlin/androidx/room/RoomDatabase.Callback.html)<br>Callback para poblar la base de datos al crearse. |

## Functions

| Name | Summary |
|---|---|
| [assertNotMainThread](index.md#-917214377%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun [assertNotMainThread](index.md#-917214377%2FFunctions%2F-1837990189)() |
| [assertNotSuspendingTransaction](index.md#1166251624%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun [assertNotSuspendingTransaction](index.md#1166251624%2FFunctions%2F-1837990189)() |
| [beginTransaction](index.md#1020009182%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun [~~beginTransaction~~](index.md#1020009182%2FFunctions%2F-1837990189)() |
| [clearAllTables](index.md#404244410%2FFunctions%2F-1837990189) | [androidJvm]<br>abstract fun [clearAllTables](index.md#404244410%2FFunctions%2F-1837990189)() |
| [close](index.md#1674273423%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun [close](index.md#1674273423%2FFunctions%2F-1837990189)() |
| [compileStatement](index.md#162913197%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun [compileStatement](index.md#162913197%2FFunctions%2F-1837990189)(sql: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)): [SupportSQLiteStatement](https://developer.android.com/reference/kotlin/androidx/sqlite/db/SupportSQLiteStatement.html) |
| [createAutoMigrations](index.md#1420085996%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun [createAutoMigrations](index.md#1420085996%2FFunctions%2F-1837990189)(autoMigrationSpecs: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-map/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.reflect/-k-class/index.html)&lt;out [AutoMigrationSpec](https://developer.android.com/reference/kotlin/androidx/room/migration/AutoMigrationSpec.html)&gt;, [AutoMigrationSpec](https://developer.android.com/reference/kotlin/androidx/room/migration/AutoMigrationSpec.html)&gt;): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Migration](https://developer.android.com/reference/kotlin/androidx/room/migration/Migration.html)&gt; |
| [endTransaction](index.md#622722960%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun [~~endTransaction~~](index.md#622722960%2FFunctions%2F-1837990189)() |
| [getAutoMigrations](index.md#178130989%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun [~~getAutoMigrations~~](index.md#178130989%2FFunctions%2F-1837990189)(autoMigrationSpecs: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-map/index.html)&lt;[Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;out [AutoMigrationSpec](https://developer.android.com/reference/kotlin/androidx/room/migration/AutoMigrationSpec.html)&gt;, [AutoMigrationSpec](https://developer.android.com/reference/kotlin/androidx/room/migration/AutoMigrationSpec.html)&gt;): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Migration](https://developer.android.com/reference/kotlin/androidx/room/migration/Migration.html)&gt; |
| [getCoroutineScope](index.md#-1278223499%2FFunctions%2F-1837990189) | [androidJvm]<br>fun [getCoroutineScope](index.md#-1278223499%2FFunctions%2F-1837990189)(): CoroutineScope |
| [getQueryContext](index.md#-779149974%2FFunctions%2F-1837990189) | [androidJvm]<br>fun [getQueryContext](index.md#-779149974%2FFunctions%2F-1837990189)(): [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.coroutines/-coroutine-context/index.html) |
| [getRequiredAutoMigrationSpecClasses](index.md#-432702106%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun [getRequiredAutoMigrationSpecClasses](index.md#-432702106%2FFunctions%2F-1837990189)(): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.reflect/-k-class/index.html)&lt;out [AutoMigrationSpec](https://developer.android.com/reference/kotlin/androidx/room/migration/AutoMigrationSpec.html)&gt;&gt; |
| [getRequiredAutoMigrationSpecs](index.md#1623281881%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun [~~getRequiredAutoMigrationSpecs~~](index.md#1623281881%2FFunctions%2F-1837990189)(): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;out [AutoMigrationSpec](https://developer.android.com/reference/kotlin/androidx/room/migration/AutoMigrationSpec.html)&gt;&gt; |
| [getTypeConverter](index.md#-1472154772%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun &lt;[T](index.md#-1472154772%2FFunctions%2F-1837990189) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-any/index.html)&gt; [~~getTypeConverter~~](index.md#-1472154772%2FFunctions%2F-1837990189)(klass: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[T](index.md#-1472154772%2FFunctions%2F-1837990189)&gt;): [T](index.md#-1472154772%2FFunctions%2F-1837990189)?<br>fun &lt;[T](index.md#2031305957%2FFunctions%2F-1837990189) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-any/index.html)&gt; [getTypeConverter](index.md#2031305957%2FFunctions%2F-1837990189)(klass: [KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.reflect/-k-class/index.html)&lt;[T](index.md#2031305957%2FFunctions%2F-1837990189)&gt;): [T](index.md#2031305957%2FFunctions%2F-1837990189) |
| [init](index.md#1039887154%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun [init](index.md#1039887154%2FFunctions%2F-1837990189)(configuration: [DatabaseConfiguration](https://developer.android.com/reference/kotlin/androidx/room/DatabaseConfiguration.html)) |
| [internalBeginTransaction](index.md#375494305%2FFunctions%2F-1837990189) | [androidJvm]<br>private fun [internalBeginTransaction](index.md#375494305%2FFunctions%2F-1837990189)() |
| [internalEndTransaction](index.md#1851101203%2FFunctions%2F-1837990189) | [androidJvm]<br>private fun [internalEndTransaction](index.md#1851101203%2FFunctions%2F-1837990189)() |
| [inTransaction](index.md#-1889647314%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun [inTransaction](index.md#-1889647314%2FFunctions%2F-1837990189)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html) |
| [notesDao](notes-dao.md) | [androidJvm]<br>abstract fun [notesDao](notes-dao.md)(): [NotesDao](../-notes-dao/index.md)<br>Proporciona acceso al DAO de notas. |
| [onClosed](index.md#141172712%2FFunctions%2F-1837990189) | [androidJvm]<br>private fun [onClosed](index.md#141172712%2FFunctions%2F-1837990189)() |
| [query](index.md#604106995%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun [query](index.md#604106995%2FFunctions%2F-1837990189)(query: [SupportSQLiteQuery](https://developer.android.com/reference/kotlin/androidx/sqlite/db/SupportSQLiteQuery.html), signal: [CancellationSignal](https://developer.android.com/reference/kotlin/android/os/CancellationSignal.html)?): [Cursor](https://developer.android.com/reference/kotlin/android/database/Cursor.html)<br>open fun [query](index.md#-1376474873%2FFunctions%2F-1837990189)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html), args: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-array/index.html)&lt;out [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-any/index.html)?&gt;?): [Cursor](https://developer.android.com/reference/kotlin/android/database/Cursor.html) |
| [runInTransaction](index.md#1063989044%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun [runInTransaction](index.md#1063989044%2FFunctions%2F-1837990189)(body: [Runnable](https://developer.android.com/reference/kotlin/java/lang/Runnable.html))<br>open fun &lt;[V](index.md#-1842697888%2FFunctions%2F-1837990189)&gt; [runInTransaction](index.md#-1842697888%2FFunctions%2F-1837990189)(body: [Callable](https://developer.android.com/reference/kotlin/java/util/concurrent/Callable.html)&lt;[V](index.md#-1842697888%2FFunctions%2F-1837990189)&gt;): [V](index.md#-1842697888%2FFunctions%2F-1837990189)<br>private fun &lt;[T](index.md#1507059828%2FFunctions%2F-1837990189)&gt; [runInTransaction](index.md#1507059828%2FFunctions%2F-1837990189)(body: () -&gt; [T](index.md#1507059828%2FFunctions%2F-1837990189)): [T](index.md#1507059828%2FFunctions%2F-1837990189) |
| [setTransactionSuccessful](index.md#954356125%2FFunctions%2F-1837990189) | [androidJvm]<br>open fun [~~setTransactionSuccessful~~](index.md#954356125%2FFunctions%2F-1837990189)() |
| [unwrapOpenHelper](index.md#233750123%2FFunctions%2F-1837990189) | [androidJvm]<br>private inline fun &lt;[T](index.md#233750123%2FFunctions%2F-1837990189) : [SupportSQLiteOpenHelper](https://developer.android.com/reference/kotlin/androidx/sqlite/db/SupportSQLiteOpenHelper.html)&gt; [unwrapOpenHelper](index.md#233750123%2FFunctions%2F-1837990189)(openHelper: [SupportSQLiteOpenHelper](https://developer.android.com/reference/kotlin/androidx/sqlite/db/SupportSQLiteOpenHelper.html)?): [T](index.md#233750123%2FFunctions%2F-1837990189)? |

## Properties

| Name | Summary |
|---|---|
| [allowMainThreadQueries](index.md#-1197604871%2FProperties%2F-1837990189) | [androidJvm]<br>private var [allowMainThreadQueries](index.md#-1197604871%2FProperties%2F-1837990189): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html) |
| [autoCloser](index.md#-184468406%2FProperties%2F-1837990189) | [androidJvm]<br>private var [autoCloser](index.md#-184468406%2FProperties%2F-1837990189): AutoCloser? |
| [connectionManager](index.md#-2008137096%2FProperties%2F-1837990189) | [androidJvm]<br>private lateinit var [connectionManager](index.md#-2008137096%2FProperties%2F-1837990189): [RoomConnectionManager](https://developer.android.com/reference/kotlin/androidx/room/RoomConnectionManager.html) |
| [coroutineScope](index.md#1109565015%2FProperties%2F-1837990189) | [androidJvm]<br>private lateinit var [coroutineScope](index.md#1109565015%2FProperties%2F-1837990189): CoroutineScope |
| [internalQueryExecutor](index.md#277982537%2FProperties%2F-1837990189) | [androidJvm]<br>private lateinit var [internalQueryExecutor](index.md#277982537%2FProperties%2F-1837990189): [Executor](https://developer.android.com/reference/kotlin/java/util/concurrent/Executor.html) |
| [internalTracker](index.md#-892619860%2FProperties%2F-1837990189) | [androidJvm]<br>private lateinit var [internalTracker](index.md#-892619860%2FProperties%2F-1837990189): [InvalidationTracker](https://developer.android.com/reference/kotlin/androidx/room/InvalidationTracker.html) |
| [internalTransactionExecutor](index.md#-1516567373%2FProperties%2F-1837990189) | [androidJvm]<br>private lateinit var [internalTransactionExecutor](index.md#-1516567373%2FProperties%2F-1837990189): [Executor](https://developer.android.com/reference/kotlin/java/util/concurrent/Executor.html) |
| [invalidationTracker](index.md#-990093491%2FProperties%2F-1837990189) | [androidJvm]<br>open val [invalidationTracker](index.md#-990093491%2FProperties%2F-1837990189): [InvalidationTracker](https://developer.android.com/reference/kotlin/androidx/room/InvalidationTracker.html) |
| [isOpen](index.md#-277138657%2FProperties%2F-1837990189) | [androidJvm]<br>open val [isOpen](index.md#-277138657%2FProperties%2F-1837990189): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html) |
| [isOpenInternal](index.md#475302114%2FProperties%2F-1837990189) | [androidJvm]<br>val [isOpenInternal](index.md#475302114%2FProperties%2F-1837990189): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html) |
| [openHelper](index.md#-1864821605%2FProperties%2F-1837990189) | [androidJvm]<br>open val [openHelper](index.md#-1864821605%2FProperties%2F-1837990189): [SupportSQLiteOpenHelper](https://developer.android.com/reference/kotlin/androidx/sqlite/db/SupportSQLiteOpenHelper.html) |
| [queryExecutor](index.md#-177284564%2FProperties%2F-1837990189) | [androidJvm]<br>open val [queryExecutor](index.md#-177284564%2FProperties%2F-1837990189): [Executor](https://developer.android.com/reference/kotlin/java/util/concurrent/Executor.html) |
| [suspendingTransactionId](index.md#1027959380%2FProperties%2F-1837990189) | [androidJvm]<br>val [suspendingTransactionId](index.md#1027959380%2FProperties%2F-1837990189): [ThreadLocal](https://developer.android.com/reference/kotlin/java/lang/ThreadLocal.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html)&gt; |
| [transactionContext](index.md#-1645968798%2FProperties%2F-1837990189) | [androidJvm]<br>private lateinit var [transactionContext](index.md#-1645968798%2FProperties%2F-1837990189): [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.coroutines/-coroutine-context/index.html) |
| [transactionExecutor](index.md#722320214%2FProperties%2F-1837990189) | [androidJvm]<br>open val [transactionExecutor](index.md#722320214%2FProperties%2F-1837990189): [Executor](https://developer.android.com/reference/kotlin/java/util/concurrent/Executor.html) |
| [typeConverters](index.md#486213670%2FProperties%2F-1837990189) | [androidJvm]<br>private val [typeConverters](index.md#486213670%2FProperties%2F-1837990189): [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-mutable-map/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.reflect/-k-class/index.html)&lt;*&gt;, [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-any/index.html)&gt; |
