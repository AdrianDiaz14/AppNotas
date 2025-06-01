package com.example.appnotas

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.appnotas.databinding.DialogImageViewerBinding

/**
 * Diálogo que muestra imágenes en un viewpager con funcionalidad de zoom.
 * Permite navegar entre múltiples imágenes con gestos.
 *
 * @author Adrian Diaz
 * @since 1.0
 */
class ImageDialogFragment : DialogFragment() {

    private var _binding: DialogImageViewerBinding? = null
    private val binding get() = _binding!!
    private lateinit var images: List<Uri>
    private var position = 0

    companion object {
        private const val ARG_IMAGES = "images"
        private const val ARG_POSITION = "position"

        /**
         * Crea una nueva instancia del diálogo.
         * @param images Lista de URIs de imágenes a mostrar
         * @param position Posición inicial a mostrar
         * @return Nueva instancia de ImageDialogFragment
         */
        fun newInstance(images: ArrayList<Uri>, position: Int) = ImageDialogFragment().apply {
            arguments = Bundle().apply {
                putParcelableArrayList(ARG_IMAGES, images)
                putInt(ARG_POSITION, position)
            }
        }
    }

    /**
     * Infla la vista asociada al diálogo.
     * Este método inicializa el binding del diseño del fragmento utilizando `DialogImageViewerBinding`.
     *
     * @param inflater Inflador utilizado para crear la vista.
     * @param container Contenedor padre que alojará la vista del fragmento.
     * @param savedInstanceState Estado previamente guardado, si aplica.
     * @return La vista inflada como raíz del fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogImageViewerBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Configura los elementos del diálogo después de que la vista ha sido creada.
     * Carga los argumentos para configurar la lista de imágenes y la posición inicial,
     * y establece el ViewPager y el botón de cierre.
     *
     * @param view Vista raíz del fragmento generada por `onCreateView`.
     * @param savedInstanceState Estado previamente guardado, si aplica.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            images = it.getParcelableArrayList(ARG_IMAGES) ?: emptyList()
            position = it.getInt(ARG_POSITION, 0)
        }

        setupViewPager()
        setupCloseButton()
    }

    /**
     * Configura el ViewPager para mostrar las imágenes utilizando un adaptador personalizado.
     * Permite desplazarse entre las imágenes y muestra un indicador de carga mientras
     * se están descargando las imágenes con Glide.
     */
    private fun setupViewPager() {
        binding.viewPager.adapter = object : RecyclerView.Adapter<ImageViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_full_image, parent, false)
                return ImageViewHolder(view)
            }

            override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
                holder.progressBar.visibility = View.VISIBLE

                Glide.with(holder.itemView)
                    .load(images[position])
                    .listener(object : RequestListener<Drawable> {
                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable>,
                            isFirstResource: Boolean
                        ): Boolean {
                            holder.progressBar.visibility = View.GONE
                            return false
                        }

                        override fun onResourceReady(
                            resource: Drawable,
                            model: Any,
                            target: Target<Drawable>,
                            dataSource: DataSource,
                            isFirstResource: Boolean
                        ): Boolean {
                            holder.progressBar.visibility = View.GONE
                            return false
                        }
                    })
                    .into(holder.imageView)
            }

            override fun getItemCount() = images.size
        }

        binding.viewPager.setCurrentItem(position, false)
    }

    /**
     * Configura el botón de cierre del diálogo y los gestos para navegar entre imágenes.
     * Registra un callback para detectar cambios de página en el ViewPager y permite cerrar el diálogo al hacer clic.
     */
    private fun setupCloseButton() {
        binding.closeButton.setOnClickListener { dismiss() }

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.viewPager.setOnClickListener { dismiss() }
            }
        })
    }

    /**
     * Configura el estilo del diálogo al iniciarse.
     * Aplica configuraciones como fondo transparente, dimensiones del diálogo y comportamiento
     * para ocultar las barras del sistema en dispositivos con Android R o superior.
     */
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onStart() {
        super.onStart()
        dialog?.window?.apply {
            setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
            )
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setDimAmount(0.8f)

            // Reemplazo de systemUiVisibility con WindowInsetsController
            insetsController?.apply {
                hide(WindowInsets.Type.systemBars()) // Oculta barras de navegación y estado
                systemBarsBehavior = WindowInsetsController.BEHAVIOR_DEFAULT // Muestra al deslizar
            }
        }
    }

    /**
     * Limpia el binding al destruir la vista del diálogo.
     * Esto asegura que no haya fugas de memoria estableciendo `_binding` como `null`.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * ViewHolder personalizado para las imágenes mostradas en el ViewPager.
     *
     * @property imageView Vista para mostrar la imagen.
     * @property progressBar Indicador de carga mientras se descarga la imagen.
     */
    private inner class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.fullImageView)
        val progressBar: ProgressBar = view.findViewById(R.id.progressBar)
    }
}