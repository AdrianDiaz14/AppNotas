package com.example.appnotas

import android.net.Uri
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appnotas.database.Notes
import com.example.appnotas.database.NotesViewModel
import com.example.appnotas.databinding.NoteLayoutBinding

/**
 * Adaptador para mostrar notas en un RecyclerView.
 * Soporta:
 * - Selección múltiple con ActionMode
 * - Visualización de imágenes adjuntas
 * - Navegación a edición
 * - Gestos personalizados
 *
 * @author Adrian Diaz
 * @since 1.0
 */
class NotesAdapter : ListAdapter<Notes, NotesAdapter.NotesViewHolder>(NotesDiffCallback()) {

    private var notesViewModel: NotesViewModel? = null
    private var activity: AppCompatActivity? = null
    private var actionMode: ActionMode? = null
    private val selectedItems = mutableSetOf<Int>()


    /**
     * Establece el ViewModel para operaciones con notas.
     * @param viewModel ViewModel a utilizar
     */
    fun setViewModel(viewModel: NotesViewModel) {
        this.notesViewModel = viewModel
    }

    /**
     * Establece la actividad para el ActionMode.
     * @param activity Actividad contenedora
     */
    fun setActivity(activity: AppCompatActivity) {
        this.activity = activity
    }

    /**
     * Callback para el modo de selección múltiple.
     */
    private val actionModeCallback = object : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            mode.menuInflater.inflate(R.menu.contextual_action_mode, menu)
            mode.title = "${selectedItems.size} seleccionadas"
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean = false

        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.action_delete -> {
                    deleteSelectedNotes()
                    mode.finish()
                    true
                }
                R.id.action_copy -> {
                    copySelectedNotes()
                    mode.finish()
                    true
                }
                else -> false
            }
        }

        override fun onDestroyActionMode(mode: ActionMode) {
            selectedItems.clear()
            notifyDataSetChanged()
            actionMode = null
        }
    }

    /**
     * Elimina las notas seleccionadas.
     */
    private fun deleteSelectedNotes() {
        selectedItems.sortedDescending().forEach { position ->
            notesViewModel?.softDeleteNote(getItem(position))
        }
    }

    /**
     * Copia las notas seleccionadas.
     */
    private fun copySelectedNotes() {
        selectedItems.sorted().forEach { position ->
            val originalNote = getItem(position)
            val newNote = originalNote.copy(
                noteId = 0L,
                date = System.currentTimeMillis()
            )
            notesViewModel?.insertNote(newNote)
        }
    }

    /**
     * ViewHolder para mostrar notas individuales.
     */
    inner class NotesViewHolder(private val binding: NoteLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            setupLongClickListener()
            setupClickListener()
        }

        /**
         * Configura el listener para selección larga.
         */
        private fun setupLongClickListener() {
            binding.noteConstrainLayout.setOnLongClickListener {
                if (actionMode == null) {
                    actionMode = activity?.startSupportActionMode(actionModeCallback)
                }
                toggleSelection(bindingAdapterPosition)
                true
            }
        }

        /**
         * Configura el listener para clicks simples.
         */
        private fun setupClickListener() {
            binding.noteConstrainLayout.setOnClickListener {
                if (actionMode != null) {
                    toggleSelection(bindingAdapterPosition)
                } else {
                    navigateToEditNote()
                }
            }
        }

        /**
         * Navega al fragmento de edición de nota.
         */
        private fun navigateToEditNote() {
            val note = getItem(bindingAdapterPosition)
            val action = com.example.appnotas.notes.AllNotesFragmentDirections.actionAllNotesFragmentToEditNoteFragment()
            action.updateNote = note
            Navigation.findNavController(binding.root).navigate(action)
        }

        /**
         * Vincula los datos de la nota a las vistas.
         * @param note Nota a mostrar
         */
        fun bind(note: Notes) {
            binding.noteTitle.text = note.title
            binding.noteDesc.text = note.description
            binding.noteTitle.visibility = if (note.title.isBlank()) View.GONE else View.VISIBLE

            // Mantener el color original del fondo
            binding.noteConstrainLayout.setCardBackgroundColor(
                ContextCompat.getColor(binding.root.context, R.color.primaryLight)
            )

            // Modificar solo el color del borde si está seleccionado
            if (selectedItems.contains(bindingAdapterPosition)) {
                binding.noteConstrainLayout.strokeColor =
                    ContextCompat.getColor(binding.root.context, R.color.green)
                binding.noteConstrainLayout.strokeWidth = 3
            } else {
                binding.noteConstrainLayout.strokeColor =
                    ContextCompat.getColor(binding.root.context, R.color.indigo)
                binding.noteConstrainLayout.strokeWidth = 1
            }

            bindNoteImages(note)
        }


        /**
         * Configura las imágenes adjuntas a la nota.
         * @param note Nota con imágenes a mostrar
         */
        private fun bindNoteImages(note: Notes) {
            val imageUris = note.imageUris?.mapNotNull { Uri.parse(it) } ?: emptyList()

            binding.imageIndicator.visibility = if (imageUris.isNotEmpty()) View.VISIBLE else View.GONE
            if (imageUris.isNotEmpty()) {
                binding.imageIndicator.setImageDrawable(
                    ContextCompat.getDrawable(binding.root.context, R.drawable.gallery_icon))
            }

            if (imageUris.isNotEmpty()) {
                binding.imageRecyclerView.visibility = View.VISIBLE
                setupImageAdapter(imageUris)
            } else {
                binding.imageRecyclerView.visibility = View.GONE
            }
        }

        /**
         * Configura el adaptador para imágenes adjuntas.
         * @param imageUris Lista de URIs de imágenes
         */
        private fun setupImageAdapter(imageUris: List<Uri>) {
            binding.imageRecyclerView.adapter = ImageAdapter(
                imageUris,
                onImageClicked = { position ->
                    (binding.root.context as? FragmentActivity)?.supportFragmentManager?.let { fm ->
                        ImageDialogFragment.newInstance(ArrayList(imageUris), position)
                            .show(fm, "image_dialog")
                    }
                },
                onImageDeleteRequested = { position ->
                    val currentNote = getItem(bindingAdapterPosition)
                    val updatedUris = currentNote.imageUris?.toMutableList()?.apply {
                        removeAt(position)
                    }
                    notesViewModel?.updateNote(currentNote.copy(imageUris = updatedUris))
                }
            )
        }
    }

    /**
     * Alterna la selección de un ítem.
     * @param position Posición del ítem
     */
    private fun toggleSelection(position: Int) {
        if (selectedItems.contains(position)) {
            selectedItems.remove(position)
            if (selectedItems.isEmpty()) {
                actionMode?.finish()
            }
        } else {
            selectedItems.add(position)
            if (actionMode == null) {
                actionMode = activity?.startSupportActionMode(actionModeCallback)
            }
        }
        notifyItemChanged(position)
        actionMode?.title = "${selectedItems.size} seleccionadas"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(NoteLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

/**
 * Callback para comparar notas y optimizar actualizaciones del RecyclerView.
 */
class NotesDiffCallback : DiffUtil.ItemCallback<Notes>() {
    override fun areItemsTheSame(oldItem: Notes, newItem: Notes): Boolean {
        return oldItem.noteId == newItem.noteId
    }

    override fun areContentsTheSame(oldItem: Notes, newItem: Notes): Boolean {
        return oldItem == newItem
    }
}