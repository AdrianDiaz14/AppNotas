package com.example.appnotas

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 * Adaptador simple para mostrar imágenes en un ViewPager2.
 * Más ligero que el usado en ImageDialogFragment pero con menos funcionalidades.
 *
 * @property images Lista de URIs de imágenes a mostrar
 *
 * @author Adrian Diaz
 * @since 1.0
 */
class ImagePagerAdapter(
    private val images: List<Uri>
) : RecyclerView.Adapter<ImagePagerAdapter.ViewHolder>() {

    /**
     * ViewHolder para gestionar la visualización de imágenes individuales.
     *
     * @property imageView Vista en la que se mostrará la imagen.
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.fullImageView)
    }

    /**
     * Crea un nuevo ViewHolder para el RecyclerView.
     * Este método se encarga de inflar el diseño de los elementos individuales y asociarlo al ViewHolder.
     *
     * @param parent Vista padre que contendrá los elementos del RecyclerView.
     * @param viewType Tipo de vista, no usado en este adaptador.
     * @return Instancia de ViewHolder para gestionar cada elemento.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_full_image, parent, false)
        return ViewHolder(view)
    }

    /**
     * Vincula los datos de las imágenes al ViewHolder correspondiente.
     * Este método utiliza Glide para cargar la imagen desde un URI y mostrarla en el `imageView`.
     *
     * @param holder Instancia del ViewHolder que gestionará el elemento actual.
     * @param position Posición del elemento en la lista de imágenes.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(images[position])
            .into(holder.imageView)
    }

    /**
     * Devuelve el número total de elementos en la lista de imágenes.
     * Este valor es utilizado por el RecyclerView para determinar cuántos elementos deben ser creados y gestionados.
     *
     * @return Número de imágenes en la lista proporcionada.
     */
    override fun getItemCount() = images.size
}