//[AppNotas](../../../index.md)/[com.example.appnotas.database](../index.md)/[Converters](index.md)

# Converters

[androidJvm]\
class [Converters](index.md)

Convertidores personalizados para Room que permiten almacenar tipos complejos. Convierte entre List<String> y String para almacenar URIs de imágenes.

#### Author

Adrian Diaz

#### Since

1.0

## Constructors

| | |
|---|---|
| [Converters](-converters.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [fromStringList](from-string-list.md) | [androidJvm]<br>fun [fromStringList](from-string-list.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)&gt;?): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)?<br>Convierte una List<String> a un String separado por comas. |
| [toStringList](to-string-list.md) | [androidJvm]<br>fun [toStringList](to-string-list.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)?): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)&gt;?<br>Convierte un String separado por comas a List<String>. |
