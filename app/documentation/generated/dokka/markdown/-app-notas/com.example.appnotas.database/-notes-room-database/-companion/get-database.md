//[AppNotas](../../../../index.md)/[com.example.appnotas.database](../../index.md)/[NotesRoomDatabase](../index.md)/[Companion](index.md)/[getDatabase](get-database.md)

# getDatabase

[androidJvm]\
fun [getDatabase](get-database.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), scope: CoroutineScope): [NotesRoomDatabase](../index.md)

Obtiene la instancia de la base de datos.

#### Return

Instancia singleton de la base de datos

#### Parameters

androidJvm

| | |
|---|---|
| context | Contexto de la aplicación |
| scope | CoroutineScope para operaciones asíncronas |

#### Throws

| | |
|---|---|
| [IllegalStateException](https://developer.android.com/reference/kotlin/java/lang/IllegalStateException.html) | Si la base de datos no puede ser inicializada. |
