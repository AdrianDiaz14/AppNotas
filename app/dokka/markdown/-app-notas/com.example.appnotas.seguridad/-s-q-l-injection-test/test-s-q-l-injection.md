//[AppNotas](../../../index.md)/[com.example.appnotas.seguridad](../index.md)/[SQLInjectionTest](index.md)/[testSQLInjection](test-s-q-l-injection.md)

# testSQLInjection

[androidJvm]\
fun [testSQLInjection](test-s-q-l-injection.md)()

Simula un intento de inyección SQL mediante la inserción de una nota con un título malicioso.

- 
   Inserta una nota cuyo título incluye una cadena de inyección SQL (`DROP TABLE notes`).
- 
   Recupera todas las notas y verifica si la base de datos sigue operativa.
- 
   Si la tabla se hubiera eliminado, la prueba fallaría, indicando una vulnerabilidad.
