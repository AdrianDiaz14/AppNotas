package com.example.appnotas

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.Manifest
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.example.appnotas.helpers.HelpManager

/**
 * Actividad principal que sirve como contenedor para los fragmentos.
 * Maneja:
 * - Navegación entre pantallas
 * - Configuración del drawer navigation
 * - Mostrar ayuda contextual
 *
 *  @property appBarConfiguration Configuración de la barra de acción y navegación.
 *  @property navController Controlador de navegación utilizado para manejar cambios de fragmentos.
 *  @property drawerLayout Layout del tipo drawer para el menú lateral.
 *  @property navView Vista de navegación que contiene el menú lateral.
 *
 * @author Adrian Diaz
 * @since 1.0
 */
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    private val sharedPreferences by lazy {
        getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
    }

    /**
     * Método inicial llamado al crear la actividad.
     * Configura los componentes esenciales: toolbar, navegación, spinner del menú y listener de los ítems del menú.
     *
     * @param savedInstanceState Estado previamente guardado de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupToolbar()
        setupNavigation()
        setupHeaderSpinner()
        setupMenuClickListener()
        checkFirstLaunch()
    }

    private fun checkFirstLaunch() {
        val firstLaunch = sharedPreferences.getBoolean("firstLaunch", true)
        if (firstLaunch) {
            WelcomeDialogFragment().show(supportFragmentManager, "WelcomeDialog")
            sharedPreferences.edit().putBoolean("firstLaunch", false).apply()
        }
    }

    fun requestPermissionsIfNeeded() {
        val permissions = arrayOf(
            Manifest.permission.READ_MEDIA_IMAGES,
            Manifest.permission.CAMERA
        )

        if (permissions.any { ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED }) {
            ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE_PERMISSIONS)
        }
    }

    companion object {
        private const val REQUEST_CODE_PERMISSIONS = 101
    }

    /**
     * Configura la barra de herramientas (toolbar) para la actividad.
     * Esta toolbar sirve como contenedor principal para las opciones de menú y la navegación.
     */
    private fun setupToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    /**
     * Configura el sistema de navegación principal para manejar los fragmentos y el menú lateral.
     * Integra el `DrawerLayout` con el controlador de navegación (`NavController`).
     */
    private fun setupNavigation() {
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_home, R.id.nav_trash, R.id.nav_help),
            drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    /**
     * Configura el spinner en el header del menú lateral.
     * El spinner muestra una lista de opciones y escucha selecciones del usuario.
     */
    private fun setupHeaderSpinner() {
        val headerView = navView.getHeaderView(0)
        val spinner = headerView.findViewById<Spinner>(R.id.spinner)

        val spinnerItems = listOf("Listado Notas 1")
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            spinnerItems
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // TODO: Implementar acciones para cada opción
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    /**
     * Configura los listeners para los ítems del menú lateral.
     * Maneja acciones específicas para cada ítem seleccionado.
     */
    private fun setupMenuClickListener() {
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_help -> {
                    handleHelpMenuItem()
                    true
                }
                else -> {
                    handleDefaultMenuItem(menuItem)
                    true
                }
            }
        }
    }

    /**
     * Maneja la selección del ítem de ayuda en el menú lateral.
     * Cierra el drawer y navega a la pantalla de ayuda si no está abierta.
     */
    private fun handleHelpMenuItem() {
        drawerLayout.closeDrawer(GravityCompat.START)
        if (navController.currentDestination?.id != R.id.nav_help) {
            navController.navigate(R.id.nav_help)
        }
    }

    /**
     * Maneja la selección de un ítem de menú regular.
     * Navega a la pantalla correspondiente y muestra el mensaje de ayuda contextual.
     *
     * @param menuItem Ítem seleccionado del menú.
     *
     * ## Ejemplo de uso:
     * ```kotlin
     * handleDefaultMenuItem(navView.menu.findItem(R.id.nav_home))
     * ```
     */
    private fun handleDefaultMenuItem(menuItem: MenuItem) {
        if (navController.currentDestination?.id != menuItem.itemId) {
            navController.navigate(menuItem.itemId)
            HelpManager.showContextHelp(
                this,
                HelpManager.getHelpForScreen(menuItem.itemId)
            )
        }
        drawerLayout.closeDrawer(GravityCompat.START)
    }

    /**
     * Configura la acción de navegación al presionar el botón "arriba" en la barra de acciones.
     *
     * @return `true` si la navegación se completa correctamente, de lo contrario, el comportamiento por defecto.
     */
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    /**
     * Maneja la acción de retroceso (back) en la actividad.
     * Si el drawer está abierto, lo cierra; de lo contrario, ejecuta el comportamiento por defecto.
     */
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun checkPermissionAndShowToast() {
        try {
            // Simular permiso denegado
            Toast.makeText(this, "Permiso denegado", Toast.LENGTH_LONG).apply {
                show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}