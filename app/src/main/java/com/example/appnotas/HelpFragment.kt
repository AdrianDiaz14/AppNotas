package com.example.appnotas

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.appnotas.databinding.FragmentHelpBinding

/**
 * Fragmento que muestra la sección de ayuda de la aplicación.
 * Carga contenido HTML desde assets para mostrar documentación.
 *
 * @author Adrian Diaz
 * @since 1.0
 */
class HelpFragment : Fragment() {
    private var _binding: FragmentHelpBinding? = null
    private val binding get() = _binding!!

    /**
     * Infla la vista asociada al fragmento.
     *
     * Este método se utiliza para inicializar el binding de la vista, que permite acceder
     * fácilmente a los elementos de la interfaz definidos en `FragmentHelpBinding`.
     *
     * @param inflater Inflador usado para crear la vista del fragmento.
     * @param container Contenedor que alojará la vista del fragmento.
     * @param savedInstanceState Estado previamente guardado del fragmento, si aplica.
     * @return Vista raíz del fragmento generada a partir del layout.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHelpBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Configura el contenido mostrado en el `WebView` al inicializar la vista del fragmento.
     *
     * Este método carga contenido HTML desde los assets y habilita JavaScript para
     * garantizar que las características interactivas del contenido funcionen correctamente.
     * En caso de errores al cargar el contenido, se muestra un contenido alternativo.
     *
     * @param view Vista raíz del fragmento generada por `onCreateView`.
     * @param savedInstanceState Estado previamente guardado del fragmento, si aplica.
     * @throws Exception Si ocurre un error mientras se carga el contenido HTML.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        try {
            binding.webView.apply {
                settings.javaScriptEnabled = true
                loadUrl("file:///android_asset/help.html")
            }
        } catch (e: Exception) {
            Log.e("HelpFragment", "Error cargando ayuda", e)
            showFallbackContent()
        }
    }

    /**
     * Muestra contenido alternativo en el `WebView` cuando no se puede cargar el archivo HTML.
     *
     * Este método utiliza HTML en línea para informar al usuario que la sección de ayuda
     * no está disponible temporalmente.
     */
    private fun showFallbackContent() {
        binding.webView.loadData(
            "<h3>Ayuda no disponible</h3><p>Disculpa las molestias</p>",
            "text/html",
            "UTF-8"
        )
    }

    /**
     * Limpia el binding al destruir la vista del fragmento.
     *
     * Este método se utiliza para liberar recursos y evitar fugas de memoria al
     * establecer `_binding` en `null` cuando el fragmento deja de estar asociado
     * a una vista.
     *
     * @see Fragment.onDestroyView
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}