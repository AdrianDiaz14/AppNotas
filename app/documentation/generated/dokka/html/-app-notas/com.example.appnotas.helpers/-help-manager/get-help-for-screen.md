//[AppNotas](../../../index.md)/[com.example.appnotas.helpers](../index.md)/[HelpManager](index.md)/[getHelpForScreen](get-help-for-screen.md)

# getHelpForScreen

[androidJvm]\

@[StringRes](https://developer.android.com/reference/kotlin/androidx/annotation/StringRes.html)

fun [getHelpForScreen](get-help-for-screen.md)(screenId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html)?): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html)

Obtiene el recurso de string que corresponde a un mensaje de ayuda contextual según la pantalla actual.

#### Return

ID del recurso de string con el mensaje de ayuda correspondiente.

##  Ejemplo de uso:

```kotlin
val helpMessageRes = HelpManager.getHelpForScreen(R.id.nav_home)
HelpManager.showContextHelp(context, helpMessageRes)
```

#### Parameters

androidJvm

| | |
|---|---|
| screenId | ID de la pantalla (puede ser un ID de menú o fragmento). |

#### Samples

com.sba.notes.samples.HelpManagerSamples.getHelpSample
