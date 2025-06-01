package com.example.appnotas

import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appnotas.database.Notes
import com.example.appnotas.databinding.ItemTrashBinding
import java.text.SimpleDateFormat
import java.util.*

/**
 * Adaptador para mostrar notas eliminadas (en la papelera).
 * Permite restaurar notas eliminadas mediante botón o menú contextual.
 *
 * @property onRestoreClick Callback que se ejecuta al restaurar una nota
 * @constructor Crea un adaptador para la vista de papelera
 * @see TrashFragment Fragmento que utiliza este adaptador
 *
 * @author Adrian Diaz
 * @since 1.1
 */
class TrashAdapter(
    private val onRestoreClick: (Long) -> Unit
) : ListAdapter<Notes, TrashAdapter.TrashViewHolder>(NotesDiffCallback()) {

    /**
     * Posición actualmente seleccionada para el menú contextual.
     * Valor -1 indica que no hay ítem seleccionado.
     */
    private var currentPosition: Int = -1

    /**
     * ViewHolder para notas en la papelera.
     * Maneja la visualización de elementos individuales y eventos de interacción.
     *
     * @property binding Referencia al binding del layout del ítem
     * @constructor Crea un nuevo ViewHolder para notas eliminadas
     */
    inner class TrashViewHolder(private val binding: ItemTrashBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnCreateContextMenuListener {

        init {
            binding.root.setOnCreateContextMenuListener(this)
            binding.root.setOnLongClickListener {
                currentPosition = adapterPosition
                false // Devolver false para permitir que el menú contextual se muestre
            }
        }

        /**
         * Vincula los datos de una nota a las vistas del ViewHolder.
         * @param note Nota a mostrar en este ítem
         */
        fun bind(note: Notes) {
            binding.noteTitle.text = note.title
            binding.noteDescription.text = note.description
            binding.deletionDate.text = formatDeletionDate(note.deletionDate)
            binding.restoreButton.setOnClickListener { onRestoreClick(note.noteId) }
            binding.imageIndicator.visibility =
                if (!note.imageUris.isNullOrEmpty()) View.VISIBLE else View.GONE
        }

        /**
         * Formatea la fecha de eliminación para mostrar en la interfaz.
         * @param timestamp Fecha en milisegundos desde la época Unix
         * @return String con la fecha formateada o cadena vacía si es nula
         */
        private fun formatDeletionDate(timestamp: Long?): String {
            if (timestamp == null) return ""
            val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
            return "Eliminada el ${dateFormat.format(Date(timestamp))}"
        }

        /**
         * Crea el menú contextual al realizar una pulsación larga.
         * @param menu Menú contextual a configurar
         * @param v Vista que originó el menú
         * @param menuInfo Información adicional sobre el menú
         */
        override fun onCreateContextMenu(
            menu: ContextMenu,
            v: View?,
            menuInfo: ContextMenu.ContextMenuInfo?
        ) {
            menu.add(0, 0, 0, "Recuperar").setOnMenuItemClickListener {
                if (currentPosition != -1) {
                    onRestoreClick(getItem(currentPosition).noteId)
                    true
                } else {
                    false
                }
            }
        }
    }

    /**
     * Obtiene la posición actualmente seleccionada para el menú contextual.
     * @return Posición del ítem seleccionado o -1 si no hay selección
     */
    fun getCurrentPosition(): Int = currentPosition

    /**
     * Crea nuevos ViewHolders cuando el RecyclerView los necesita.
     * @param parent Vista padre que contendrá el nuevo ViewHolder
     * @param viewType Tipo de vista (no utilizado en esta implementación)
     * @return Nuevo ViewHolder inicializado
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrashViewHolder {
        val binding = ItemTrashBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TrashViewHolder(binding)
    }

    /**
     * Vincula los datos en la posición especificada al ViewHolder.
     * @param holder ViewHolder a actualizar
     * @param position Posición del dato en el conjunto de datos
     */
    override fun onBindViewHolder(holder: TrashViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}