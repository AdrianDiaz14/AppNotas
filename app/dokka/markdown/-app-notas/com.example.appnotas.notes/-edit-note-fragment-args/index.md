//[AppNotas](../../../index.md)/[com.example.appnotas.notes](../index.md)/[EditNoteFragmentArgs](index.md)

# EditNoteFragmentArgs

[androidJvm]\
open class [EditNoteFragmentArgs](index.md) : [NavArgs](https://developer.android.com/reference/kotlin/androidx/navigation/NavArgs.html)

Argumentos de navegación para `EditNoteFragment`, permitiendo pasar una nota para edición. Se usa en el sistema de navegación de Jetpack (`NavArgs`).

## Constructors

| | |
|---|---|
| [EditNoteFragmentArgs](-edit-note-fragment-args.md) | [androidJvm]<br>private constructor()private constructor(argumentsMap: [HashMap](https://developer.android.com/reference/kotlin/java/util/HashMap.html)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [androidJvm]<br>class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [androidJvm]<br>open fun [equals](equals.md)(object: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-any/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html) |
| [fromBundle](from-bundle.md) | [androidJvm]<br>@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)<br>open fun [fromBundle](from-bundle.md)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)): [EditNoteFragmentArgs](index.md)<br>Crea una instancia de `EditNoteFragmentArgs` a partir de un `Bundle`. |
| [fromSavedStateHandle](from-saved-state-handle.md) | [androidJvm]<br>@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)<br>open fun [fromSavedStateHandle](from-saved-state-handle.md)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)savedStateHandle: [SavedStateHandle](https://developer.android.com/reference/kotlin/androidx/lifecycle/SavedStateHandle.html)): [EditNoteFragmentArgs](index.md)<br>Crea una instancia de `EditNoteFragmentArgs` a partir de `SavedStateHandle`. |
| [getUpdateNote](get-update-note.md) | [androidJvm]<br>@[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)<br>open fun [getUpdateNote](get-update-note.md)(): [Notes](../../com.example.appnotas.database/-notes/index.md)<br>Obtiene la nota pasada como argumento. |
| [hashCode](hash-code.md) | [androidJvm]<br>open fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html) |
| [toBundle](to-bundle.md) | [androidJvm]<br>@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)<br>open fun [toBundle](to-bundle.md)(): [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)<br>Convierte los argumentos a `Bundle`. |
| [toSavedStateHandle](to-saved-state-handle.md) | [androidJvm]<br>@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)<br>open fun [toSavedStateHandle](to-saved-state-handle.md)(): [SavedStateHandle](https://developer.android.com/reference/kotlin/androidx/lifecycle/SavedStateHandle.html) |
| [toString](to-string.md) | [androidJvm]<br>open fun [toString](to-string.md)(): [String](https://developer.android.com/reference/kotlin/java/lang/String.html) |

## Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | [androidJvm]<br>private val [arguments](arguments.md): [HashMap](https://developer.android.com/reference/kotlin/java/util/HashMap.html) |
