package com.example.appnotas.seguridad

import android.view.WindowManager
import androidx.navigation.findNavController
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.appnotas.MainActivity
import com.example.appnotas.R
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Pruebas para verificar que los fragments críticos de la aplicación tienen establecido
 * el flag FLAG_SECURE para prevenir capturas de pantalla o grabación.
 *
 * Estas pruebas verifican que las pantallas que muestran información sensible (como notas)
 * tienen configurada la protección contra capturas de pantalla.
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class SecureFlagTest {

    /**
     * Verifica que AllNotesFragment tiene establecido el flag FLAG_SECURE.
     * Este flag previene que se puedan tomar capturas de pantalla o grabar la pantalla
     * cuando se muestra la lista de notas.
     */
    @Test
    fun testAllNotesFragmentHasSecureFlag() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        scenario.onActivity { activity ->
            onView(withId(R.id.nav_host_fragment))

            // Verificar que el flag está establecido
            val flags = activity.window.attributes.flags
            Assert.assertTrue(
                "FLAG_SECURE no está establecido en AllNotesFragment",
                flags and WindowManager.LayoutParams.FLAG_SECURE != 0
            )
        }

        scenario.close()
    }

    /**
     * Verifica que EditNoteFragment tiene establecido el flag FLAG_SECURE.
     * Este flag previene que se puedan tomar capturas de pantalla o grabar la pantalla
     * cuando se está editando una nota, protegiendo así información sensible.
     */
    @Test
    fun testEditNoteFragmentHasSecureFlag() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        scenario.onActivity { activity ->
            val navController = activity.findNavController(R.id.nav_host_fragment)
            navController.navigate(R.id.action_allNotesFragment_to_editNoteFragment)

            // Verificar que el flag está establecido
            val flags = activity.window.attributes.flags
            Assert.assertTrue(
                "FLAG_SECURE no está establecido en EditNoteFragment",
                flags and WindowManager.LayoutParams.FLAG_SECURE != 0
            )
        }

        scenario.close()
    }
}