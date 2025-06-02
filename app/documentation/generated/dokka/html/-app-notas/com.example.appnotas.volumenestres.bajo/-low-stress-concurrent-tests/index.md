//[AppNotas](../../../index.md)/[com.example.appnotas.volumenestres.bajo](../index.md)/[LowStressConcurrentTests](index.md)

# LowStressConcurrentTests

[androidJvm]\
class [LowStressConcurrentTests](index.md)

Pruebas de bajo estrés para verificar comportamiento básico en condiciones normales.

Estas pruebas verifican:

- 
   El funcionamiento básico con pocas operaciones concurrentes
- 
   La capacidad de recuperación en condiciones ideales
- 
   El consumo mínimo de recursos

## Constructors

| | |
|---|---|
| [LowStressConcurrentTests](-low-stress-concurrent-tests.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)() |
| [tearDown](tear-down.md) | [androidJvm]<br>fun [tearDown](tear-down.md)() |
| [testLowFrequencyUpdatesWithRecovery](test-low-frequency-updates-with-recovery.md) | [androidJvm]<br>fun [testLowFrequencyUpdatesWithRecovery](test-low-frequency-updates-with-recovery.md)()<br>Prueba actualizaciones poco frecuentes con recuperación. |
| [testLowMixedConcurrentOperations](test-low-mixed-concurrent-operations.md) | [androidJvm]<br>fun [testLowMixedConcurrentOperations](test-low-mixed-concurrent-operations.md)()<br>Prueba operaciones concurrentes básicas con bajo volumen. |

## Properties

| Name | Summary |
|---|---|
| [rule](rule.md) | [androidJvm]<br>val [rule](rule.md): [InstantTaskExecutorRule](https://developer.android.com/reference/kotlin/androidx/arch/core/executor/testing/InstantTaskExecutorRule.html) |
