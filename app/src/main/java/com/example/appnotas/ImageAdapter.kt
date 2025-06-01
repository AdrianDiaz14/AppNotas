package com.example.appnotas

import android.graphics.BitmapFactory
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.example.appnotas.databinding.ImageItemBinding

/**
 * Adaptador para mostrar imágenes en un RecyclerView.
 * Soporta clicks normales y largos para mostrar menú contextual.
 *
 * @property imageUris Lista de URIs de imágenes a mostrar
 * @property onImageClicked Callback al hacer click en una imagen
 * @property onImageDeleteRequested Callback al solicitar eliminar una imagen
 *
 * @author Adrian Diaz
 * @since 1.0
 */
class ImageAdapter(
    private val imageUris: List<Uri>,
    private val onImageClicked: (Int) -> Unit,
    private val onImageDeleteRequested: (Int) -> Unit
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    /**
     * ViewHolder para mostrar una imagen individual.
     * @property binding Referencia al binding del layout
     */
    inner class ImageViewHolder(private val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnLongClickListener {
                showContextMenu(it)
                true
            }

            binding.root.setOnClickListener {
                onImageClicked(bindingAdapterPosition)
            }
        }

        /**
         * Muestra el menú contextual para la imagen.
         * @param view Vista ancla para el menú
         */
        private fun showContextMenu(view: View) {
            PopupMenu(view.context, view).apply {
                menuInflater.inflate(R.menu.image_context_menu, menu)
                setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.action_delete_image -> {
                            onImageDeleteRequested(bindingAdapterPosition)
                            true
                        }
                        else -> false
                    }
                }
                show()
            }
        }

        /**
         * Vincula los datos de la imagen a la vista.
         * @param uri URI de la imagen a mostrar
         */
        fun bind(uri: Uri) {
            try {
                val inputStream = binding.root.context.contentResolver.openInputStream(uri)
                val bitmap = BitmapFactory.decodeStream(inputStream)
                binding.imageView.setImageBitmap(bitmap)
                inputStream?.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    /**
     * Crea un nuevo ViewHolder para el RecyclerView.
     * Este método infla el diseño definido en `ImageItemBinding` y
     * lo asocia al ViewHolder que se utilizará para mostrar cada elemento.
     *
     * @param parent Vista padre del RecyclerView.
     * @param viewType Tipo de vista, no usado en este caso.
     * @return Instancia de `ImageViewHolder` con el diseño inflado.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ImageItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ImageViewHolder(binding)
    }

    /**
     * Vincula los datos de una imagen al ViewHolder correspondiente.
     * Este método es llamado por el RecyclerView para actualizar la vista
     * con los datos de la imagen en la posición indicada.
     *
     * @param holder Instancia del ViewHolder.
     * @param position Posición del elemento en la lista.
     */
    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(imageUris[position])
    }

    /**
     * Devuelve el número total de elementos en la lista.
     * Este valor es utilizado por el RecyclerView para determinar
     * cuántas vistas necesitan ser creadas y reutilizadas.
     *
     * @return Número total de imágenes en la lista.
     */
    override fun getItemCount(): Int = imageUris.size
}