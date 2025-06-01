package com.example.appnotas.samples

import android.content.Context
import com.example.appnotas.R
import com.example.appnotas.helpers.HelpManager

/**
 * Proporciona ejemplos prácticos para los métodos de `HelpManager`.
 * Incluye simulaciones para mostrar mensajes de ayuda contextual y recuperar
 * mensajes específicos según la pantalla actual.
 *
 * @author Adrian Diaz
 * @since 1.3
 */
object HelpManagerSamples {

    /**
     * Ejemplo de cómo obtener ayuda para la pantalla principal.
     *
     * @param context Contexto necesario para acceder a los recursos de la app.
     * @sample com.sba.notes.samples.HelpManagerSamples.getHelpSample
     */
    fun getHelpSample(context: Context) {
        val helpMessageRes = HelpManager.getHelpForScreen(R.id.nav_home)
        HelpManager.showContextHelp(context, helpMessageRes)
    }

    /**
     * Ejemplo de cómo mostrar un mensaje de ayuda contextual.
     *
     * @param context Contexto para mostrar el Toast de ayuda.
     * @sample com.sba.notes.samples.HelpManagerSamples.showHelpSample
     */
    fun showHelpSample(context: Context) {
        HelpManager.showContextHelp(context, R.string.help_home)
    }
}