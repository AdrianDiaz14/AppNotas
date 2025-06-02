package com.example.appnotas.helpers

import android.content.Context
import android.view.Gravity
import android.widget.Toast
import androidx.annotation.StringRes
import com.example.appnotas.R

/**
 * Clase para manejar la ayuda contextual en la aplicación.
 *
 * Proporciona mensajes de ayuda basados en la pantalla actual. Además,
 * incorpora un temporizador interno para evitar la visualización repetitiva
 * del mismo mensaje en cortos intervalos de tiempo.
 */
object HelpManager {
    private var lastHelpShownTime = 0L

    /**
     * Obtiene el recurso de string que corresponde a un mensaje de ayuda contextual
     * según la pantalla actual.
     *
     * @param screenId ID de la pantalla (puede ser un ID de menú o fragmento).
     * @return ID del recurso de string con el mensaje de ayuda correspondiente.
     *
     * ## Ejemplo de uso:
     * ```kotlin
     * val helpMessageRes = HelpManager.getHelpForScreen(R.id.nav_home)
     * HelpManager.showContextHelp(context, helpMessageRes)
     * ```
     * @sample com.sba.notes.samples.HelpManagerSamples.getHelpSample
     */
    @StringRes
    fun getHelpForScreen(screenId: Int?): Int {
        return when (screenId) {
            R.id.nav_home -> R.string.help_home
            R.id.nav_trash -> R.string.help_trash
            R.id.nav_help -> R.string.help_help_section
            R.id.editNoteFragment -> R.string.help_edit_note
            else -> R.string.help_general
        }
    }

    /**
     * Muestra un mensaje de ayuda contextual mediante un Toast.
     * Usa un temporizador interno para evitar mostrar mensajes duplicados en rápida sucesión.
     *
     * @param context Contexto para mostrar el Toast.
     * @param helpTextRes ID del recurso de string con el mensaje de ayuda.
     *
     * ## Ejemplo de uso:
     * ```kotlin
     * HelpManager.showContextHelp(context, R.string.help_home)
     * ```
     * @sample com.sba.notes.samples.HelpManagerSamples.showHelpSample
     *
     * @author Adrian Diaz
     * @since 1.2
     */
    fun showContextHelp(context: Context, @StringRes helpTextRes: Int) {
        if (System.currentTimeMillis() - lastHelpShownTime < 2000) return

        lastHelpShownTime = System.currentTimeMillis()

        val message = context.getString(helpTextRes)
        val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 100)
        toast.show()
    }
}