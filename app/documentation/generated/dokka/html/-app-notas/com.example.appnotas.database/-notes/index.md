//[AppNotas](../../../index.md)/[com.example.appnotas.database](../index.md)/[Notes](index.md)

# Notes

data class [Notes](index.md)(var noteId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html) = 0, var date: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html) = System.currentTimeMillis(), var title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html), var description: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html), var imageUris: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)&gt;? = null, var isDeleted: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html) = false, var deletionDate: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html)? = null) : [Serializable](https://developer.android.com/reference/kotlin/java/io/Serializable.html)

Entidad principal que representa una nota en la aplicación.

##  Ejemplo de uso:

```kotlin
val note = Notes(
    title = "Mi nota",
    description = "Contenido de ejemplo"
)
```

#### Author

Adrian Diaz

#### Since

1.0

#### See also

| | |
|---|---|
| [NotesDao](../-notes-dao/index.md) | Para operaciones de base de datos |
| [NotesRepository](../-notes-repository/index.md) | Para acceso a los datos desde el ViewModel. |

## Constructors

| | |
|---|---|
| [Notes](-notes.md) | [androidJvm]<br>constructor(noteId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html) = 0, date: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html) = System.currentTimeMillis(), title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html), description: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html), imageUris: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)&gt;? = null, isDeleted: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html) = false, deletionDate: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html)? = null)<br>Crea una nueva instancia de nota |

## Properties

| Name | Summary |
|---|---|
| [date](date.md) | [androidJvm]<br>var [date](date.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html)<br>Fecha de creación en milisegundos desde la época (1970-01-01). |
| [deletionDate](deletion-date.md) | [androidJvm]<br>var [deletionDate](deletion-date.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html)?<br>Fecha de eliminación en milisegundos (nullable, solo aplica si `isDeleted = true`). |
| [description](description.md) | [androidJvm]<br>var [description](description.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)<br>Contenido principal de la nota (puede ser vacío). |
| [imageUris](image-uris.md) | [androidJvm]<br>var [imageUris](image-uris.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)&gt;?<br>Lista de URIs de imágenes adjuntas (opcional, nullable). |
| [isDeleted](is-deleted.md) | [androidJvm]<br>var [isDeleted](is-deleted.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html)<br>Indica si la nota está en la papelera (default: `false`). |
| [noteId](note-id.md) | [androidJvm]<br>var [noteId](note-id.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html)<br>Identificador único generado automáticamente por Room. |
| [title](title.md) | [androidJvm]<br>var [title](title.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)<br>Título de la nota (no puede ser nulo ni vacío). |
