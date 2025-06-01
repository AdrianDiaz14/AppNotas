//[AppNotas](../../../index.md)/[com.example.appnotas.uso_de_recursos](../index.md)/[BatteryUsageTest](index.md)

# BatteryUsageTest

[androidJvm]\
class [BatteryUsageTest](index.md)

Pruebas para medir y verificar el consumo de batería de la aplicación.

Estas pruebas verifican que la aplicación:

- 
   No mantiene WakeLocks innecesarias
- 
   Tiene un consumo de batería razonable durante operaciones intensivas

## Constructors

| | |
|---|---|
| [BatteryUsageTest](-battery-usage-test.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)() |
| [simulateIntensiveOperation](simulate-intensive-operation.md) | [androidJvm]<br>private fun [simulateIntensiveOperation](simulate-intensive-operation.md)()<br>Simula una operación intensiva insertando 1000 notas con imágenes. Esta operación sirve para medir el impacto en el consumo de batería. |
| [testBatteryDrainRate](test-battery-drain-rate.md) | [androidJvm]<br>fun [testBatteryDrainRate](test-battery-drain-rate.md)()<br>Mide el consumo de batería durante una operación intensiva simulada. Solo se ejecuta en dispositivos con API 21+ (Lollipop). |
| [testNoWakeLocksHeld](test-no-wake-locks-held.md) | [androidJvm]<br>fun [testNoWakeLocksHeld](test-no-wake-locks-held.md)()<br>Verifica que la aplicación no mantiene WakeLocks activas innecesariamente. Las WakeLocks pueden causar un consumo excesivo de batería. |

## Properties

| Name | Summary |
|---|---|
| [batteryManager](battery-manager.md) | [androidJvm]<br>private lateinit var [batteryManager](battery-manager.md): [BatteryManager](https://developer.android.com/reference/kotlin/android/os/BatteryManager.html) |
| [context](context.md) | [androidJvm]<br>private lateinit var [context](context.md): [Context](https://developer.android.com/reference/kotlin/android/content/Context.html) |
| [powerManager](power-manager.md) | [androidJvm]<br>private lateinit var [powerManager](power-manager.md): [PowerManager](https://developer.android.com/reference/kotlin/android/os/PowerManager.html) |
