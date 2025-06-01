package com.example.appnotas

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class WelcomeDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Bienvenido a AppNotas 🎉")
            .setMessage(
                "¡Gracias por descargar AppNotas! Con esta aplicación puedes gestionar tus notas de manera rápida y eficiente.\n\n" +
                        "✏️ **Crear notas** con texto e imágenes.\n" +
                        "🗑 **Mover notas a la papelera** y restaurarlas si es necesario.\n" +
                        "🔍 **Buscar notas** fácilmente por título o contenido.\n\n" +
                        "Antes de empezar, necesitamos que concedas los permisos necesarios para acceder a imágenes y la cámara. Esto permitirá que puedas adjuntar fotos a tus notas.\n\n" +
                        "Pulsa 'Continuar' para configurar los permisos."
            )
            .setPositiveButton("Continuar") { _, _ ->
                dismiss()
                (activity as? MainActivity)?.requestPermissionsIfNeeded()
            }
            .setNegativeButton("Cancelar") { _, _ ->
                dismiss()
            }
        return builder.create()
    }
}