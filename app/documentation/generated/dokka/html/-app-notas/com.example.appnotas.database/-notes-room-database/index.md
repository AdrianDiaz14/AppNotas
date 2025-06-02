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

## Functions

| Name | Summary |
|---|---|
| [assertNotMainThread](index.md#-917214377%2FFunctions%2F310006415) | [androidJvm]<br>open fun [assertNotMainThread](index.md#-917214377%2FFunctions%2F310006415)() |
| [assertNotSuspendingTransaction](index.md#1166251624%2FFunctions%2F310006415) | [androidJvm]<br>open fun [assertNotSuspendingTransaction](index.md#1166251624%2FFunctions%2F310006415)() |
| [beginTransaction](index.md#1020009182%2FFunctions%2F310006415) | [androidJvm]<br>open fun [~~beginTransaction~~](index.md#1020009182%2FFunctions%2F310006415)() |
| [clearAllTables](index.md#404244410%2FFunctions%2F310006415) | [androidJvm]<br>abstract fun [clearAllTables](index.md#404244410%2FFunctions%2F310006415)() |
| [close](index.md#1674273423%2FFunctions%2F310006415) | [androidJvm]<br>open fun [close](index.md#1674273423%2FFunctions%2F310006415)() |
| [compileStatement](index.md#162913197%2FFunctions%2F310006415) | [androidJvm]<br>open fun [compileStatement](index.md#162913197%2FFunctions%2F310006415)(sql: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)): [SupportSQLiteStatement](https://developer.android.com/reference/kotlin/androidx/sqlite/db/SupportSQLiteStatement.html) |
| [createAutoMigrations](index.md#1420085996%2FFunctions%2F310006415) | [androidJvm]<br>open fun [createAutoMigrations](index.md#1420085996%2FFunctions%2F310006415)(autoMigrationSpecs: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-map/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.reflect/-k-class/index.html)&lt;out [AutoMigrationSpec](https://developer.android.com/reference/kotlin/androidx/room/migration/AutoMigrationSpec.html)&gt;, [AutoMigrationSpec](https://developer.android.com/reference/kotlin/androidx/room/migration/AutoMigrationSpec.html)&gt;): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Migration](https://developer.android.com/reference/kotlin/androidx/room/migration/Migration.html)&gt; |
| [endTransaction](index.md#622722960%2FFunctions%2F310006415) | [androidJvm]<br>open fun [~~endTransaction~~](index.md#622722960%2FFunctions%2F310006415)() |
| [getAutoMigrations](index.md#178130989%2FFunctions%2F310006415) | [androidJvm]<br>open fun [~~getAutoMigrations~~](index.md#178130989%2FFunctions%2F310006415)(autoMigrationSpecs: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-map/index.html)&lt;[Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;out [AutoMigrationSpec](https://developer.android.com/reference/kotlin/androidx/room/migration/AutoMigrationSpec.html)&gt;, [AutoMigrationSpec](https://developer.android.com/reference/kotlin/androidx/room/migration/AutoMigrationSpec.html)&gt;): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Migration](https://developer.android.com/reference/kotlin/androidx/room/migration/Migration.html)&gt; |
| [getCoroutineScope](index.md#-1278223499%2FFunctions%2F310006415) | [androidJvm]<br>fun [getCoroutineScope](index.md#-1278223499%2FFunctions%2F310006415)(): CoroutineScope |
| [getQueryContext](index.md#-779149974%2FFunctions%2F310006415) | [androidJvm]<br>fun [getQueryContext](index.md#-779149974%2FFunctions%2F310006415)(): [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.coroutines/-coroutine-context/index.html) |
| [getRequiredAutoMigrationSpecClasses](index.md#-432702106%2FFunctions%2F310006415) | [androidJvm]<br>open fun [getRequiredAutoMigrationSpecClasses](index.md#-432702106%2FFunctions%2F310006415)(): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.reflect/-k-class/index.html)&lt;out [AutoMigrationSpec](https://developer.android.com/reference/kotlin/androidx/room/migration/AutoMigrationSpec.html)&gt;&gt; |
| [getRequiredAutoMigrationSpecs](index.md#1623281881%2FFunctions%2F310006415) | [androidJvm]<br>open fun [~~getRequiredAutoMigrationSpecs~~](index.md#1623281881%2FFunctions%2F310006415)(): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;out [AutoMigrationSpec](https://developer.android.com/reference/kotlin/androidx/room/migration/AutoMigrationSpec.html)&gt;&gt; |
| [getTypeConverter](index.md#-1472154772%2FFunctions%2F310006415) | [androidJvm]<br>open fun &lt;[T](index.md#-1472154772%2FFunctions%2F310006415) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-any/index.html)&gt; [~~getTypeConverter~~](index.md#-1472154772%2FFunctions%2F310006415)(klass: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[T](index.md#-1472154772%2FFunctions%2F310006415)&gt;): [T](index.md#-1472154772%2FFunctions%2F310006415)?<br>fun &lt;[T](index.md#2031305957%2FFunctions%2F310006415) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-any/index.html)&gt; [getTypeConverter](index.md#2031305957%2FFunctions%2F310006415)(klass: [KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.reflect/-k-class/index.html)&lt;[T](index.md#2031305957%2FFunctions%2F310006415)&gt;): [T](index.md#2031305957%2FFunctions%2F310006415) |
| [init](index.md#1039887154%2FFunctions%2F310006415) | [androidJvm]<br>open fun [init](index.md#1039887154%2FFunctions%2F310006415)(configuration: [DatabaseConfiguration](https://developer.android.com/reference/kotlin/androidx/room/DatabaseConfiguration.html)) |
| [inTransaction](index.md#-1889647314%2FFunctions%2F310006415) | [androidJvm]<br>open fun [inTransaction](index.md#-1889647314%2FFunctions%2F310006415)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html) |
| [notesDao](notes-dao.md) | [androidJvm]<br>abstract fun [notesDao](notes-dao.md)(): [NotesDao](../-notes-dao/index.md)<br>Proporciona acceso al DAO de notas. |
| [query](index.md#604106995%2FFunctions%2F310006415) | [androidJvm]<br>open fun [query](index.md#604106995%2FFunctions%2F310006415)(query: [SupportSQLiteQuery](https://developer.android.com/reference/kotlin/androidx/sqlite/db/SupportSQLiteQuery.html), signal: [CancellationSignal](https://developer.android.com/reference/kotlin/android/os/CancellationSignal.html)?): [Cursor](https://developer.android.com/reference/kotlin/android/database/Cursor.html)<br>open fun [query](index.md#-1376474873%2FFunctions%2F310006415)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html), args: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-array/index.html)&lt;out [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-any/index.html)?&gt;?): [Cursor](https://developer.android.com/reference/kotlin/android/database/Cursor.html) |
| [runInTransaction](index.md#1063989044%2FFunctions%2F310006415) | [androidJvm]<br>open fun [runInTransaction](index.md#1063989044%2FFunctions%2F310006415)(body: [Runnable](https://developer.android.com/reference/kotlin/java/lang/Runnable.html))<br>open fun &lt;[V](index.md#-1842697888%2FFunctions%2F310006415)&gt; [runInTransaction](index.md#-1842697888%2FFunctions%2F310006415)(body: [Callable](https://developer.android.com/reference/kotlin/java/util/concurrent/Callable.html)&lt;[V](index.md#-1842697888%2FFunctions%2F310006415)&gt;): [V](index.md#-1842697888%2FFunctions%2F310006415) |
| [setTransactionSuccessful](index.md#954356125%2FFunctions%2F310006415) | [androidJvm]<br>open fun [~~setTransactionSuccessful~~](index.md#954356125%2FFunctions%2F310006415)() |

## Properties

| Name | Summary |
|---|---|
| [invalidationTracker](index.md#-990093491%2FProperties%2F310006415) | [androidJvm]<br>open val [invalidationTracker](index.md#-990093491%2FProperties%2F310006415): [InvalidationTracker](https://developer.android.com/reference/kotlin/androidx/room/InvalidationTracker.html) |
| [isOpen](index.md#-277138657%2FProperties%2F310006415) | [androidJvm]<br>open val [isOpen](index.md#-277138657%2FProperties%2F310006415): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html) |
| [isOpenInternal](index.md#475302114%2FProperties%2F310006415) | [androidJvm]<br>val [isOpenInternal](index.md#475302114%2FProperties%2F310006415): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html) |
| [openHelper](index.md#-1864821605%2FProperties%2F310006415) | [androidJvm]<br>open val [openHelper](index.md#-1864821605%2FProperties%2F310006415): [SupportSQLiteOpenHelper](https://developer.android.com/reference/kotlin/androidx/sqlite/db/SupportSQLiteOpenHelper.html) |
| [queryExecutor](index.md#-177284564%2FProperties%2F310006415) | [androidJvm]<br>open val [queryExecutor](index.md#-177284564%2FProperties%2F310006415): [Executor](https://developer.android.com/reference/kotlin/java/util/concurrent/Executor.html) |
| [suspendingTransactionId](index.md#1027959380%2FProperties%2F310006415) | [androidJvm]<br>val [suspendingTransactionId](index.md#1027959380%2FProperties%2F310006415): [ThreadLocal](https://developer.android.com/reference/kotlin/java/lang/ThreadLocal.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html)&gt; |
| [transactionExecutor](index.md#722320214%2FProperties%2F310006415) | [androidJvm]<br>open val [transactionExecutor](index.md#722320214%2FProperties%2F310006415): [Executor](https://developer.android.com/reference/kotlin/java/util/concurrent/Executor.html) |
