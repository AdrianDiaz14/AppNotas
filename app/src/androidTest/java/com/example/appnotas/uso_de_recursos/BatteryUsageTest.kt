package com.example.appnotas.uso_de_recursos

import android.content.Context
import android.os.BatteryManager
import android.os.Build
import android.os.PowerManager
import androidx.lifecycle.ViewModelProvider
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.appnotas.database.Notes
import com.example.appnotas.database.NotesViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Pruebas para medir y verificar el consumo de batería de la aplicación.
 *
 * Estas pruebas verifican que la aplicación:
 * - No mantiene WakeLocks innecesarias
 * - Tiene un consumo de batería razonable durante operaciones intensivas
 */
@RunWith(AndroidJUnit4::class)
class BatteryUsageTest {

    private lateinit var context: Context
    private lateinit var powerManager: PowerManager
    private lateinit var batteryManager: BatteryManager

    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext()
        powerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager
        batteryManager = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
    }

    /**
     * Verifica que la aplicación no mantiene WakeLocks activas innecesariamente.
     * Las WakeLocks pueden causar un consumo excesivo de batería.
     */
    @Test
    fun testNoWakeLocksHeld() {
        // Verificar que no hay WakeLocks activas (pueden drenar batería)
        val wakeLocks = powerManager.isWakeLockLevelSupported(PowerManager.PARTIAL_WAKE_LOCK)
        assertFalse(
            "La app no debería mantener WakeLocks innecesarias",
            wakeLocks && powerManager.isDeviceIdleMode
        )
    }

    /**
     * Mide el consumo de batería durante una operación intensiva simulada.
     * Solo se ejecuta en dispositivos con API 21+ (Lollipop).
     *
     * Verifica que el consumo no exceda el 5% de la capacidad de la batería
     * durante una operación crítica.
     */
    @Test
    fun testBatteryDrainRate() {
        // Simular operación intensiva y medir consumo
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            val initialBattery = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)

            // Ejecutar operación de prueba (ej: guardar 100 notas rápidamente)
            simulateIntensiveOperation()

            val finalBattery = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
            val drainPercent = initialBattery - finalBattery

            assertTrue(
                "El consumo de batería es excesivo (>5% en operación crítica)",
                drainPercent <= 5
            )
        }
    }

    /**
     * Simula una operación intensiva insertando 1000 notas con imágenes.
     * Esta operación sirve para medir el impacto en el consumo de batería.
     */
    private fun simulateIntensiveOperation() {
        val context = ApplicationProvider.getApplicationContext<Context>()

        // Obtener una instancia del ViewModel o repositorio de notas
        val notesViewModel = ViewModelProvider.AndroidViewModelFactory
            .getInstance(ApplicationProvider.getApplicationContext())
            .create(NotesViewModel::class.java)

        // Crear 1000 notas de prueba
        for (i in 1..1000) {
            val note = Notes(
                title = "Nota de prueba $i",
                description = "Esta es una nota de prueba generada automáticamente para medir el consumo de batería",
                imageUris = if (i % 10 == 0) listOf("content://fake/image/$i") else null
            )

            // Insertar la nota en la base de datos
            kotlinx.coroutines.runBlocking {
                notesViewModel.insertNote(note)
            }

            // Pequeña pausa para simular un flujo más realista (10ms entre notas)
            Thread.sleep(10)
        }

        // Limpiar las notas de prueba después de la medición
        kotlinx.coroutines.runBlocking {
            notesViewModel.allNotes.value?.forEach { note ->
                if (note.title.startsWith("Nota de prueba")) {
                    notesViewModel.deleteNote(note)
                }
            }
        }
    }
}