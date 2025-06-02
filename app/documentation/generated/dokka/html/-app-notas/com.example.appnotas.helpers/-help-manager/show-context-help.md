//[AppNotas](../../../index.md)/[com.example.appnotas.helpers](../index.md)/[HelpManager](index.md)/[showContextHelp](show-context-help.md)

# showContextHelp

[androidJvm]\
fun [showContextHelp](show-context-help.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), @[StringRes](https://developer.android.com/reference/kotlin/androidx/annotation/StringRes.html)helpTextRes: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html))

Muestra un mensaje de ayuda contextual mediante un Toast. Usa un temporizador interno para evitar mostrar mensajes duplicados en rápida sucesión.

#### Author

Adrian Diaz

#### Since

1.2

#### Parameters

androidJvm

| | |
|---|---|
| context | Contexto para mostrar el Toast. |
| helpTextRes | ID del recurso de string con el mensaje de ayuda.<br> Ejemplo de uso:<br>```kotlin HelpManager.showContextHelp(context, R.string.help_home) ``` |

#### Samples

com.sba.notes.samples.HelpManagerSamples.showHelpSample
