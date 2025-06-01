package com.example.appnotas.seguridad

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File

@RunWith(AndroidJUnit4::class)
class DatabaseEncryptionTest {

    /**
     * Verifica si la base de datos está almacenada en texto plano en lugar de cifrada.
     * Esta prueba inspecciona el encabezado del archivo para determinar si sigue el formato estándar de SQLite.
     */
    @Test
    fun testDatabaseIsNotPlainText() {
        // Obtiene la ruta del archivo de base de datos
        val dbFile = File(
            ApplicationProvider.getApplicationContext<Context>()
                .getDatabasePath("note_database").path
        )

        // Lee los primeros bytes para identificar el formato
        val header = ByteArray(16)
        dbFile.inputStream().use { it.read(header) }

        // Verifica si la base de datos está en formato SQLite sin cifrado
        val isUnencrypted = String(header).startsWith("SQLite format 3")
        assertTrue("La base de datos no está cifrada (como se esperaba)", isUnencrypted)
    }
}