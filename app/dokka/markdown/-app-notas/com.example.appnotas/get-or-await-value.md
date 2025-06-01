//[AppNotas](../../index.md)/[com.example.appnotas](index.md)/[getOrAwaitValue](get-or-await-value.md)

# getOrAwaitValue

[androidJvm]\
fun &lt;[T](get-or-await-value.md)&gt; [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[T](get-or-await-value.md)&gt;.[getOrAwaitValue](get-or-await-value.md)(time: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html) = 2, timeUnit: [TimeUnit](https://developer.android.com/reference/kotlin/java/util/concurrent/TimeUnit.html) = TimeUnit.SECONDS): [T](get-or-await-value.md)

Obtiene el valor actual de un `LiveData`, esperando hasta que esté disponible.

Esta función está diseñada para pruebas en las que se necesita acceder al valor de `LiveData` de manera síncrona. Usa `CountDownLatch` para bloquear la ejecución hasta que el valor sea emitido o se alcance el tiempo límite.

#### Return

El valor emitido por `LiveData`.

#### Parameters

androidJvm

| | |
|---|---|
| time | Tiempo máximo de espera antes de lanzar una excepción. |
| timeUnit | Unidad de tiempo para la espera (por defecto, segundos). |

#### Throws

| | |
|---|---|
| [TimeoutException](https://developer.android.com/reference/kotlin/java/util/concurrent/TimeoutException.html) | Si `LiveData` no emite un valor dentro del tiempo límite.<br> Ejemplo de uso:<br>```kotlin val result = liveDataInstance.getOrAwaitValue() assertEquals(expectedValue, result) ``` |
