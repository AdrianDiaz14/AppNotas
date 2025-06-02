//[AppNotas](../../../index.md)/[com.example.appnotas.seguridad](../index.md)/[SQLInjectionTest](index.md)

# SQLInjectionTest

[androidJvm]\
class [SQLInjectionTest](index.md)

## Constructors

| | |
|---|---|
| [SQLInjectionTest](-s-q-l-injection-test.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [closeDb](close-db.md) | [androidJvm]<br>fun [closeDb](close-db.md)()<br>Cierra la base de datos después de cada prueba para liberar recursos. |
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)()<br>Configura una base de datos en memoria antes de cada prueba. Esto permite probar la seguridad sin modificar datos reales. |
| [testSQLInjection](test-s-q-l-injection.md) | [androidJvm]<br>fun [testSQLInjection](test-s-q-l-injection.md)()<br>Simula un intento de inyección SQL mediante la inserción de una nota con un título malicioso. |

## Properties

| Name | Summary |
|---|---|
| [instantTaskExecutorRule](instant-task-executor-rule.md) | [androidJvm]<br>val [instantTaskExecutorRule](instant-task-executor-rule.md): [InstantTaskExecutorRule](https://developer.android.com/reference/kotlin/androidx/arch/core/executor/testing/InstantTaskExecutorRule.html) |
