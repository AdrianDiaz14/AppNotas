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
| [testBatteryDrainRate](test-battery-drain-rate.md) | [androidJvm]<br>fun [testBatteryDrainRate](test-battery-drain-rate.md)()<br>Mide el consumo de batería durante una operación intensiva simulada. Solo se ejecuta en dispositivos con API 21+ (Lollipop). |
| [testNoWakeLocksHeld](test-no-wake-locks-held.md) | [androidJvm]<br>fun [testNoWakeLocksHeld](test-no-wake-locks-held.md)()<br>Verifica que la aplicación no mantiene WakeLocks activas innecesariamente. Las WakeLocks pueden causar un consumo excesivo de batería. |
