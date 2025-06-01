package com.example.appnotas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appnotas.database.NotesViewModel
import com.example.appnotas.databinding.FragmentTrashBinding

/**
 * Fragmento que muestra la papelera con notas eliminadas.
 * Permite restaurar notas o eliminarlas permanentemente.
 *
 * @property _binding Backing property para el view binding
 * @property binding Acceso seguro al view binding
 * @property notesViewModel ViewModel que gestiona los datos de las notas
 * @property adapter Adaptador para la lista de notas eliminadas
 *
 * @see NotesViewModel ViewModel que proporciona los datos
 * @see TrashAdapter Adaptador para la lista de notas
 *
 * @author Adrian Diaz
 * @since 1.1
 */
class TrashFragment : Fragment() {
    private var _binding: FragmentTrashBinding? = null
    private val binding get() = _binding!!
    private lateinit var notesViewModel: NotesViewModel
    private lateinit var adapter: TrashAdapter

    /**
     * Infla la vista del fragmento.
     * @param inflater Objeto usado para inflar la vista
     * @param container Contenedor padre de la vista
     * @param savedInstanceState Estado previamente guardado
     * @return Vista inflada del fragmento
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrashBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Configura la vista después de su creación.
     * @param view Vista raíz del fragmento
     * @param savedInstanceState Estado previamente guardado
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesViewModel = ViewModelProvider(requireActivity()).get(NotesViewModel::class.java)

        setupRecyclerView()
        setupObservers()
        cleanOldNotes()
    }

    /**
     * Configura el RecyclerView y su adaptador.
     * Inicializa el layout manager y añade decoraciones.
     */
    private fun setupRecyclerView() {
        adapter = TrashAdapter { noteId ->
            notesViewModel.restoreNote(noteId)
            showRestoreMessage()
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@TrashFragment.adapter
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    /**
     * Muestra un mensaje toast cuando se recupera una nota.
     */
    private fun showRestoreMessage() {
        Toast.makeText(requireContext(), "Nota recuperada", Toast.LENGTH_SHORT).show()
    }

    /**
     * Configura los observadores para los datos del ViewModel.
     * Actualiza la lista cuando cambian las notas eliminadas.
     */
    private fun setupObservers() {
        notesViewModel.deletedNotes.observe(viewLifecycleOwner) { notes ->
            adapter.submitList(notes)
            binding.emptyView.visibility = if (notes.isEmpty()) View.VISIBLE else View.GONE
        }
    }

    /**
     * Limpia automáticamente las notas antiguas de la papelera.
     */
    private fun cleanOldNotes() {
        notesViewModel.cleanOldDeletedNotes()
    }

    /**
     * Limpia el binding al destruir la vista.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}