package com.example.appnotas.seguridad

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * Obtiene el valor actual de un `LiveData`, esperando hasta que se emita.
 *
 * Esta función está diseñada para pruebas en las que se necesita acceder al valor de `LiveData`
 * de manera síncrona. Usa `CountDownLatch` para bloquear la ejecución hasta que el valor
 * sea emitido o se alcance el tiempo límite.
 *
 * @param time Tiempo máximo de espera antes de lanzar una excepción.
 * @param timeUnit Unidad de tiempo para la espera (por defecto, segundos).
 * @return El valor emitido por `LiveData`.
 * @throws RuntimeException Si `LiveData` no emite un valor dentro del tiempo límite.
 *
 * ## Ejemplo de uso:
 * ```kotlin
 * val result = liveDataInstance.getOrAwaitValue()
 * assertEquals(expectedValue, result)
 * ```
 */
fun <T> LiveData<T>.getOrAwaitValue(
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS
): T {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(value: T) {
            data = value
            latch.countDown()
            this@getOrAwaitValue.removeObserver(this)
        }
    }

    this.observeForever(observer)

    // No esperar indefinidamente si el valor no se emite
    if (!latch.await(time, timeUnit)) {
        throw RuntimeException("LiveData nunca recibió un valor")
    }

    @Suppress("UNCHECKED_CAST")
    return data as T
}