package com.example.appnotas

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.*
import com.google.android.material.snackbar.Snackbar
import com.example.appnotas.database.NotesViewModel
import com.example.appnotas.databinding.FragmentAllNotesBinding
import com.example.appnotas.helpers.HelpManager
import kotlin.properties.Delegates

/**
 * Fragmento principal que muestra la lista de notas en un diseño de cuadrícula.
 *
 * Responsabilidades:
 * - Mostrar todas las notas activas en un diseño staggered grid
 * - Manejar gestos de deslizar para mover notas a la papelera
 * - Proporcionar acceso a la creación/edición de notas
 * - Gestionar la selección múltiple de notas
 * - Mostrar ayuda contextual (solo primera vez o al pulsar FAB)
 * - Mantener la configuración del tema visual
 *
 * @property notesViewModel ViewModel que gestiona los datos de las notas
 * @property sharedPrefKey Clave para las preferencias compartidas
 * @property firstTimeKey Clave para controlar la primera visualización
 * @property appPref Referencia a las preferencias compartidas
 * @property nightModeStatus Estado actual del modo nocturno
 * @property _binding Backing property para el view binding
 * @property binding Acceso seguro al view binding
 *
 * @author Adrian Diaz
 * @since 1.0
 */
class AllNotesFragment : Fragment() {

    private lateinit var notesViewModel: NotesViewModel
    private val sharedPrefKey = "appSettings"
    private val firstTimeKey = "firstTimeHomeV2"
    private lateinit var appPref: SharedPreferences
    private var nightModeStatus by Delegates.notNull<Int>()
    private var _binding: FragmentAllNotesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    /**
     * Infla la vista del fragmento.
     *
     * @param inflater LayoutInflater usado para inflar la vista
     * @param container Contenedor padre de la vista
     * @param savedInstanceState Estado previamente guardado
     * @return La vista inflada
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Configura la vista después de que se haya creado.
     * - Inicializa las preferencias compartidas
     * - Configura el botón de ayuda
     * - Muestra ayuda inicial solo la primera vez
     * - Configura ViewModel y RecyclerView
     *
     * @param view La vista devuelta por onCreateView
     * @param savedInstanceState Estado previamente guardado
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.window?.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )

        appPref = requireActivity().getSharedPreferences(sharedPrefKey, Context.MODE_PRIVATE)

        setupHelpButton()
        setupViewModelAndRecycler(view)
        setHasOptionsMenu(true)

        /**
         * Muestra un mensaje de ayuda contextual la primera vez que se accede al fragmento.
         * Utiliza preferencias compartidas para recordar si ya se mostró.
         *
         * @param savedInstanceState Estado previamente guardado para verificar la primera entrada.
         */
        if (savedInstanceState == null && appPref.getBoolean(firstTimeKey, true)) {
            HelpManager.showContextHelp(requireContext(), R.string.help_home)
            appPref.edit().putBoolean(firstTimeKey, false).apply()
        }
    }

    /**
     * Configura el botón flotante de ayuda (FAB) para mostrar
     * mensajes contextuales relevantes al fragmento actual.
     * Proporciona retroalimentación háptica al pulsar.
     */
    private fun setupHelpButton() {
        binding.helpFab.setOnClickListener {
            Log.d("HelpFab", "FAB pulsado")
            it.performHapticFeedback(HapticFeedbackConstants.CONFIRM)
            HelpManager.showContextHelp(requireContext(), R.string.help_home)
        }
    }

    /**
     * Configura el ViewModel y el RecyclerView para mostrar las notas.
     * - Inicializa el ViewModel
     * - Configura el tema según preferencias
     * - Prepara el adaptador y layout manager
     * - Configura el botón de nueva nota
     * - Establece el gesto de deslizar
     *
     * @param view La vista raíz del fragmento
     */
    private fun setupViewModelAndRecycler(view: View) {
        notesViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)
        appPref = activity?.getSharedPreferences(sharedPrefKey, 0)!!
        nightModeStatus = appPref.getInt("NightMode", 3)

        val adapter = NotesAdapter().apply {
            setViewModel(notesViewModel)
            setActivity(requireActivity() as AppCompatActivity)
        }

        binding.noteRecycler.apply {
            this.adapter = adapter
            setHasFixedSize(true)
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }

        // Observador para actualizar la lista de notas
        notesViewModel.allNotes.observe(viewLifecycleOwner) { notes ->
            adapter.submitList(notes)
        }

        // Configurar el botón de nueva nota
        binding.newNoteFAB.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_allNotesFragment_to_editNoteFragment)
        }

        setupSwipeToDelete(adapter)
    }

    /**
     * Configura el gesto de deslizar para eliminar notas.
     * - Permite deslizar izquierda/derecha para mover a papelera
     * - Muestra Snackbar con opción de deshacer
     *
     * @param adapter Adaptador del RecyclerView
     */
    private fun setupSwipeToDelete(adapter: NotesAdapter) {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.bindingAdapterPosition
                val note = adapter.currentList[position]
                notesViewModel.softDeleteNote(note)

                Snackbar.make(requireView(), "Note moved to trash", Snackbar.LENGTH_LONG)
                    .setAction("Undo") {
                        notesViewModel.restoreNote(note.noteId)
                    }.show()
            }
        }

        ItemTouchHelper(callback).attachToRecyclerView(binding.noteRecycler)
    }


    /**
     * Método llamado cuando la vista asociada al fragmento se destruye.
     *
     * Este método se utiliza para limpiar el binding y evitar fugas de memoria.
     * Establece `_binding` en `null` para liberar los recursos asociados a la vista.
     *
     * @see Fragment.onDestroyView
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.delete_all_menu -> {
                notesViewModel.allNotes.value?.forEach { note ->
                    notesViewModel.softDeleteNote(note)
                }
                setupSwipeToDelete(binding.noteRecycler.adapter as NotesAdapter)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}