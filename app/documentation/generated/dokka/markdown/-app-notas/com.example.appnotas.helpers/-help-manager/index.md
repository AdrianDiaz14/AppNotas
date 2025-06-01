//[AppNotas](../../../index.md)/[com.example.appnotas.helpers](../index.md)/[HelpManager](index.md)

# HelpManager

object [HelpManager](index.md)

Obtiene el recurso de string de ayuda contextual para una pantalla específica.

#### Return

ID del recurso de string que contiene el mensaje de ayuda.

##  Ejemplo de uso:

```kotlin
val helpResId = HelpManager.getHelpForScreen(R.id.nav_home)
HelpManager.showContextHelp(context, helpResId)
```

#### Parameters

androidJvm

| | |
|---|---|
| screenId | ID de la pantalla (puede ser un ID de menú o fragmento). |

#### See also

| | |
|---|---|
| AllNotesFragment | Para acceso al contexto de la pantalla principal. |
| EditNoteFragment | Para acceso al contexto de edición de notas. |

## Functions

| Name | Summary |
|---|---|
| [getHelpForScreen](get-help-for-screen.md) | [androidJvm]<br>@[StringRes](https://developer.android.com/reference/kotlin/androidx/annotation/StringRes.html)<br>fun [getHelpForScreen](get-help-for-screen.md)(screenId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html)?): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html)<br>Obtiene el recurso de string que corresponde a un mensaje de ayuda contextual según la pantalla actual. |
| [showContextHelp](show-context-help.md) | [androidJvm]<br>fun [showContextHelp](show-context-help.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), @[StringRes](https://developer.android.com/reference/kotlin/androidx/annotation/StringRes.html)helpTextRes: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html))<br>Muestra un mensaje de ayuda contextual mediante un Toast. Usa un temporizador interno para evitar mostrar mensajes duplicados en rápida sucesión. |

## Properties

| Name | Summary |
|---|---|
| [lastHelpShownTime](last-help-shown-time.md) | [androidJvm]<br>private var [lastHelpShownTime](last-help-shown-time.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html) |
