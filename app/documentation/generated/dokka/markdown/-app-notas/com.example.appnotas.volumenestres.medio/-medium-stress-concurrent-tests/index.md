//[AppNotas](../../../index.md)/[com.example.appnotas.volumenestres.medio](../index.md)/[MediumStressConcurrentTests](index.md)

# MediumStressConcurrentTests

[androidJvm]\
class [MediumStressConcurrentTests](index.md)

Pruebas de estrés medio para evaluar el rendimiento en condiciones moderadas.

Estas pruebas verifican:

- 
   El comportamiento con operaciones concurrentes moderadas
- 
   La capacidad de recuperación ante fallos ocasionales
- 
   El consumo de recursos en escenarios típicos

## Constructors

| | |
|---|---|
| [MediumStressConcurrentTests](-medium-stress-concurrent-tests.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)() |
| [tearDown](tear-down.md) | [androidJvm]<br>fun [tearDown](tear-down.md)() |
| [testMediumFrequencyUpdatesWithRecovery](test-medium-frequency-updates-with-recovery.md) | [androidJvm]<br>fun [testMediumFrequencyUpdatesWithRecovery](test-medium-frequency-updates-with-recovery.md)()<br>Prueba actualizaciones frecuentes con recuperación ante fallos. |
| [testMediumMixedConcurrentOperations](test-medium-mixed-concurrent-operations.md) | [androidJvm]<br>fun [testMediumMixedConcurrentOperations](test-medium-mixed-concurrent-operations.md)()<br>Prueba operaciones concurrentes en volumen medio. |

## Properties

| Name | Summary |
|---|---|
| [db](db.md) | [androidJvm]<br>private lateinit var [db](db.md): [NotesRoomDatabase](../../com.example.appnotas.database/-notes-room-database/index.md) |
| [rule](rule.md) | [androidJvm]<br>val [rule](rule.md): [InstantTaskExecutorRule](https://developer.android.com/reference/kotlin/androidx/arch/core/executor/testing/InstantTaskExecutorRule.html) |
| [viewModel](view-model.md) | [androidJvm]<br>private lateinit var [viewModel](view-model.md): [NotesViewModel](../../com.example.appnotas.database/-notes-view-model/index.md) |
