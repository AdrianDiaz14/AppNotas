package com.example.appnotas

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.appnotas.database.NoteSaveViewModel
import com.example.appnotas.database.Notes
import com.example.appnotas.databinding.FragmentEditNoteBinding
import com.example.appnotas.notes.EditNoteFragmentArgs
import java.text.SimpleDateFormat
import java.util.*

/**
 * Fragmento para crear o editar notas.
 * Maneja:
 * - Edición de título y contenido
 * - Adjuntar imágenes
 * - Guardar cambios
 *
 * @property notesSaveViewModel ViewModel para guardar notas
 * @property fbind Binding obsoleto (debería eliminarse)
 * @property note Nota actual siendo editada (null para nueva nota)
 * @property imageAdapter Adaptador para imágenes adjuntas
 * @property imageList Lista de URIs de imágenes adjuntas
 *
 * @author Adrian Diaz
 * @since 1.0
 */
class EditNoteFragment : Fragment() {
    private lateinit var notesSaveViewModel: NoteSaveViewModel
    private var fbind: FragmentEditNoteBinding? = null
    private var note: Notes? = null
    private lateinit var imageAdapter: ImageAdapter
    private val imageList = mutableListOf<Uri>()

    companion object {
        /**
         * Código de solicitud para la selección de imágenes desde la galería.
         */
        private const val IMAGE_PICK_CODE = 1001
    }

    /**
     * Registro para solicitar permisos y manejar el resultado de la solicitud.
     *
     * Este launcher se usa para solicitar acceso a los archivos multimedia o almacenamiento
     * según la versión del sistema operativo, permitiendo adjuntar imágenes en las notas.
     *
     * - **Si el usuario concede el permiso**, se ejecuta `pickImage()`, permitiendo la selección de imágenes.
     * - **Si el usuario lo deniega**, se muestra un `Toast` informando que el permiso ha sido rechazado.
     * - **Si el usuario marca "No volver a preguntar"**, se muestra un diálogo guiando al usuario a los ajustes
     *   de la aplicación para habilitar manualmente el permiso.
     *
     * Android 13 o superior: Usa `READ_MEDIA_IMAGES` en lugar de `READ_EXTERNAL_STORAGE`.
     *
     * ## Ejemplo de uso:
     * ```kotlin
     * requestPermissionLauncher.launch(android.Manifest.permission.READ_MEDIA_IMAGES)
     * ```
     */
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Toast.makeText(context, "Permiso concedido. Ahora puedes añadir imágenes.", Toast.LENGTH_SHORT).show()
        } else {
            if (!shouldShowRequestPermissionRationale(android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
                // 🔹 Si el usuario marcó "No volver a preguntar", mostrar un diálogo para ir a ajustes
                AlertDialog.Builder(requireContext())
                    .setTitle("Permiso requerido")
                    .setMessage("Debes habilitar el permiso de almacenamiento en los ajustes para adjuntar imágenes.")
                    .setPositiveButton("Abrir ajustes") { _, _ ->
                        val intent = Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                        intent.data = Uri.parse("package:${requireContext().packageName}")
                        startActivity(intent)
                    }
                    .setNegativeButton("Cancelar", null)
                    .show()
            } else {
                Toast.makeText(context, "Permiso denegado", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * Infla el diseño del fragmento.
     *
     * @param inflater Objeto usado para inflar el diseño.
     * @param container Vista padre que contendrá este fragmento.
     * @param savedInstanceState Estado previamente guardado del fragmento, si aplica.
     * @return Vista inflada del diseño.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_note, container, false)
    }

    /**
     * Configura el fragmento una vez que la vista ha sido creada.
     * Inicializa el binding, ViewModel y otras configuraciones iniciales.
     *
     * @param view Vista raíz del fragmento.
     * @param savedInstanceState Estado previamente guardado del fragmento, si aplica.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Activar FLAG_SECURE para proteger la privacidad, evitando capturas de pantalla
        activity?.window?.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )


        fbind = FragmentEditNoteBinding.bind(view)
        notesSaveViewModel = ViewModelProvider(this).get(NoteSaveViewModel::class.java)

        setupImageAdapter()
        setupRecyclerView()
        loadNoteData()
        setupClickListeners()

        // Verificar permisos al abrir la pantalla
        checkAndRequestPermission()
    }

    /**
     * Configura el adaptador para gestionar la lista de imágenes adjuntas.
     * Proporciona funciones de clic y eliminación para cada imagen.
     */
    private fun setupImageAdapter() {
        imageAdapter = ImageAdapter(
            imageList,
            onImageClicked = { position ->
                showImageDialog(position)
            },
            onImageDeleteRequested = { position ->
                imageList.removeAt(position)
                imageAdapter.notifyDataSetChanged()
                updateImageRecyclerVisibility()
            }
        )
    }

    /**
     * Actualiza la visibilidad del RecyclerView que muestra las imágenes.
     * Oculta la vista si no hay imágenes en la lista.
     */
    private fun updateImageRecyclerVisibility() {
        fbind?.imageRecyclerView?.visibility = if (imageList.isEmpty()) View.GONE else View.VISIBLE
    }

    /**
     * Configura el RecyclerView que contiene las imágenes adjuntas a la nota.
     */
    private fun setupRecyclerView() {
        fbind?.imageRecyclerView?.apply {
            adapter = imageAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
            updateImageRecyclerVisibility()
        }
    }

    /**
     * Carga los datos de una nota existente o prepara la interfaz para crear una nueva nota.
     *
     * Este método utiliza los argumentos proporcionados al fragmento para determinar si se debe editar
     * una nota existente o crear una nueva. Si se proporciona una nota existente:
     * - Carga el título, descripción y última fecha de edición en los campos correspondientes.
     * - Carga las imágenes adjuntas y las muestra en el RecyclerView asociado.
     *
     * Si no hay datos, la interfaz se prepara para crear una nueva nota sin contenido preestablecido.
     *
     * Flujo del método:
     * - Recupera los datos de los argumentos del fragmento.
     * - Si se proporciona una nota, actualiza los campos de texto y las imágenes.
     * - Si no se proporciona una nota, la interfaz permanece vacía.
     *
     * @throws IllegalArgumentException Si los argumentos del fragmento no son válidos.
     */
    private fun loadNoteData() {
        arguments?.let { bundle ->
            note = EditNoteFragmentArgs.fromBundle(bundle).updateNote
            fbind?.apply {
                titleEdittext.setText(note?.title)
                descEditText.setText(note?.description)

                note?.let { existingNote ->
                    lastEditText.text = setDate(existingNote.date)
                    existingNote.imageUris?.map { Uri.parse(it) }?.let { uris ->
                        imageList.addAll(uris)
                        imageAdapter.notifyDataSetChanged()
                        updateImageRecyclerVisibility()
                    }
                }
            }
        }
    }

    /**
     * Configura los listeners de clic en los botones de la vista del fragmento.
     *
     * Este método se encarga de vincular las acciones correspondientes a cada botón de la interfaz del usuario:
     * - **Botón "Añadir Imagen":** Llama al método `addImage()` para iniciar el proceso de selección de imágenes desde el almacenamiento.
     * - **Botón "Guardar Nota":** Llama al método `saveNote()` para validar y guardar los datos de la nota actual.
     *
     * Flujo de trabajo del método:
     * - Accede al binding de la vista actual (`fbind`) para identificar los botones interactivos.
     * - Establece un listener para cada botón, asociándolo con la función correspondiente.
     *
     * Este método garantiza que las interacciones de los usuarios con los botones sean procesadas de manera adecuada,
     * manteniendo la funcionalidad esperada en la pantalla de edición de notas.
     *
     * @throws IllegalStateException Si el binding de la vista (`fbind`) no ha sido inicializado.
     */
    private fun setupClickListeners() {
        fbind?.apply {
            addImageButton.setOnClickListener { addImage() }
            saveFAB.setOnClickListener { saveNote() }
        }
    }

    /**
     * Muestra el diálogo para ver una imagen en tamaño completo.
     * @param position Posición de la imagen en la lista
     */
    private fun showImageDialog(position: Int) {
        ImageDialogFragment.newInstance(ArrayList(imageList), position)
            .show(parentFragmentManager, "ImageDialog")
    }

    /**
     * Solicita los permisos necesarios y permite al usuario añadir una imagen desde el almacenamiento del dispositivo.
     *
     * Este método verifica si el permiso correspondiente al acceso a los archivos multimedia
     * o almacenamiento externo ha sido otorgado. Si el permiso es válido:
     * - Lanza el proceso para que el usuario pueda seleccionar una imagen.
     *
     * Si no se ha otorgado el permiso:
     * - Solicita al usuario que lo conceda.
     *
     * @throws SecurityException Si el usuario rechaza el permiso requerido.
     */
    private fun addImage() {
        val permission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            android.Manifest.permission.READ_MEDIA_IMAGES
        } else {
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        }

        if (requireContext().checkSelfPermission(permission) == android.content.pm.PackageManager.PERMISSION_GRANTED) {
            pickImage()
        } else {
            requestPermissionLauncher.launch(permission)
        }
    }

    /**
     * Registro para manejar la selección de imágenes desde el sistema.
     * Utiliza `ActivityResultContracts.OpenDocument` para abrir un selector de documentos
     * y permite la persistencia del URI seleccionado.
     *
     * Al seleccionar una imagen:
     * - El URI se agrega a la lista de imágenes de la nota.
     * - La visibilidad del RecyclerView se actualiza automáticamente.
     * - La lista de imágenes se notifica al adaptador para que se redibuje.
     *
     * @throws SecurityException Si no se pueden otorgar permisos persistentes para el URI.
     */
    @SuppressLint("NotifyDataSetChanged")
    private val pickImageLauncher = registerForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
        uri?.let {
            // Permitir persistencia del URI
            context?.contentResolver?.takePersistableUriPermission(
                it,
                Intent.FLAG_GRANT_READ_URI_PERMISSION
            )
            // Añadir a la lista de imágenes
            imageList.add(it)
            imageAdapter.notifyDataSetChanged()
            updateImageRecyclerVisibility()
        }
    }


    /**
     * Abre el selector de archivos del sistema para que el usuario pueda elegir una imagen.
     *
     * Este método utiliza el contrato `ActivityResultContracts.OpenDocument` para lanzar un diálogo
     * que permite al usuario seleccionar una imagen desde el almacenamiento. Una vez seleccionada:
     * - La imagen es añadida a la lista `imageList`.
     * - El adaptador del RecyclerView se actualiza para reflejar los cambios.
     * - Se verifica y ajusta la visibilidad del RecyclerView.
     *
     * @throws IllegalArgumentException Si el tipo de archivo seleccionado no es compatible.
     */
    private fun pickImage() {
        pickImageLauncher.launch(arrayOf("image/*"))
    }

    /**
     * Guarda la nota actual en la base de datos.
     *
     * Este método valida los datos introducidos por el usuario, guarda una nueva nota o actualiza la existente,
     * y luego navega de regreso a la lista de notas. También actualiza el estado de las imágenes adjuntas.
     *
     * Flujo del método:
     * - Si el título y la descripción están vacíos, muestra un mensaje y no guarda la nota.
     * - Si la nota es nueva, la crea en la base de datos.
     * - Si la nota ya existe, actualiza sus datos en la base de datos.
     * - Al completar la acción, se oculta el teclado y se navega de regreso.
     *
     * @throws IllegalArgumentException Si los datos proporcionados son inválidos.
     */
    private fun saveNote() {
        val title = fbind?.titleEdittext?.text.toString()
        val desc = fbind?.descEditText?.text.toString()

        if (title.isBlank() && desc.isBlank()) {
            Toast.makeText(activity, "Título y nota están vacíos", Toast.LENGTH_SHORT).show()
            return
        }

        val mNote = Notes(
            title = title,
            description = desc,
            imageUris = if (imageList.isNotEmpty()) imageList.map { it.toString() } else null
        )

        if (note == null) {
            notesSaveViewModel.insertNote(mNote)
            Toast.makeText(activity, "Nota guardada!", Toast.LENGTH_SHORT).show()
        } else {
            mNote.noteId = note!!.noteId
            mNote.date = System.currentTimeMillis()
            notesSaveViewModel.updateNote(mNote)
            Toast.makeText(activity, "Nota actualizada!", Toast.LENGTH_SHORT).show()
        }

        hideKeyboard(requireActivity())
        view?.let { Navigation.findNavController(it).navigateUp() }
    }

    /**
     * Formatea la fecha para mostrar.
     * @param timeInMillis Tiempo en milisegundos desde la época Unix.
     * @return Fecha formateada como cadena (ej. "20 abr. 2025")
     */
    private fun setDate(date: Long): String {
        val sdf = if (SimpleDateFormat("MMM dd").format(Date(date)) ==
            SimpleDateFormat("MMM dd").format(Date())) {
            SimpleDateFormat("hh:mm a")
        } else {
            SimpleDateFormat("MMM dd")
        }
        return "Editado ${sdf.format(Date(date))}"
    }

    /**
     * Oculta el teclado virtual.
     * @param activity Actividad actual
     */
    private fun hideKeyboard(activity: Activity) {
        (activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as? InputMethodManager)?.apply {
            hideSoftInputFromWindow(activity.currentFocus?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    /**
     * Comprueba si los permisos están concedidos y los solicita si es necesario.
     */
    private fun checkAndRequestPermission() {
        val permission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            android.Manifest.permission.READ_MEDIA_IMAGES
        } else {
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        }

        if (requireContext().checkSelfPermission(permission) != android.content.pm.PackageManager.PERMISSION_GRANTED) {
            requestPermissionLauncher.launch(permission)
        }
    }

    /**
     * Limpia el binding al destruir la vista para liberar recursos.
     */
    override fun onDestroyView() {
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_SECURE)
        super.onDestroyView()
        fbind = null
    }
}