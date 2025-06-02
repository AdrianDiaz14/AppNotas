//[AppNotas](../../../index.md)/[com.example.appnotas.seguridad](../index.md)/[SecureFlagTest](index.md)

# SecureFlagTest

[androidJvm]\
class [SecureFlagTest](index.md)

Pruebas para verificar que los fragments críticos de la aplicación tienen establecido el flag FLAG_SECURE para prevenir capturas de pantalla o grabación.

Estas pruebas verifican que las pantallas que muestran información sensible (como notas) tienen configurada la protección contra capturas de pantalla.

## Constructors

| | |
|---|---|
| [SecureFlagTest](-secure-flag-test.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [testAllNotesFragmentHasSecureFlag](test-all-notes-fragment-has-secure-flag.md) | [androidJvm]<br>fun [testAllNotesFragmentHasSecureFlag](test-all-notes-fragment-has-secure-flag.md)()<br>Verifica que AllNotesFragment tiene establecido el flag FLAG_SECURE. Este flag previene que se puedan tomar capturas de pantalla o grabar la pantalla cuando se muestra la lista de notas. |
| [testEditNoteFragmentHasSecureFlag](test-edit-note-fragment-has-secure-flag.md) | [androidJvm]<br>fun [testEditNoteFragmentHasSecureFlag](test-edit-note-fragment-has-secure-flag.md)()<br>Verifica que EditNoteFragment tiene establecido el flag FLAG_SECURE. Este flag previene que se puedan tomar capturas de pantalla o grabar la pantalla cuando se está editando una nota, protegiendo así información sensible. |
