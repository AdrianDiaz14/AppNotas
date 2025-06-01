package com.example.appnotas.uso_de_recursos

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.appnotas.database.Notes
import com.example.appnotas.testHelpers.FakeNotesDao
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File

/**
 * Pruebas para medir y verificar el uso de almacenamiento de la aplicación.
 *
 * Estas pruebas verifican que:
 * - El consumo de almacenamiento es el esperado al manejar notas con imágenes
 * - Los archivos se gestionan correctamente
 */
@RunWith(AndroidJUnit4::class)
class StorageUsageTest {

    private lateinit var fakeNotesDao: FakeNotesDao
    private lateinit var context: Context

    /**
     * Configura el entorno de prueba:
     * - Inicializa un DAO falso
     * - Obtiene el contexto de la aplicación
     * - Limpia archivos de pruebas anteriores
     */
    @Before
    fun setup() {
        fakeNotesDao = FakeNotesDao()
        context = InstrumentationRegistry.getInstrumentation().targetContext

        // Limpiar archivos de pruebas anteriores
        cleanUpTestFiles()
    }

    /**
     * Verifica el consumo de almacenamiento al manejar notas con imágenes.
     *
     * 1. Mide el almacenamiento disponible inicial
     * 2. Crea archivos de imagen de prueba
     * 3. Inserta notas que referencian estas imágenes
     * 4. Verifica que el consumo sea el esperado (±10%)
     * 5. Realiza limpieza final
     */
    @Test
    fun testStorageConsumptionWithImages() = runBlocking {
        // 1. Medir almacenamiento inicial
        val initialStorage = getAvailableStorage()

        // 2. Crear archivos de imagen reales para la prueba
        val testFiles = createTestImageFiles(5) // 5 archivos de 1MB cada uno

        // 3. Insertar notas con referencias a estos archivos
        insertTestNotesWithImages(testFiles)

        // 4. Verificar consumo de almacenamiento
        val storageAfterInsert = getAvailableStorage()
        val storageUsed = initialStorage - storageAfterInsert
        val expectedUsage = testFiles.sumOf { it.length() }

        assertTrue(
            "El almacenamiento usado ($storageUsed bytes) debería ser ≈ $expectedUsage bytes",
            storageUsed in (expectedUsage * 0.9).toLong()..(expectedUsage * 1.1).toLong()
        )

        // 5. Limpieza después de la prueba
        cleanUpTestFiles()
    }

    /**
     * Obtiene el espacio disponible en el almacenamiento interno.
     * @return Bytes disponibles en el almacenamiento
     */
    private fun getAvailableStorage(): Long {
        return File(context.filesDir.path).freeSpace
    }

    /**
     * Crea archivos de imagen de prueba del tamaño especificado.
     * @param count Número de archivos a crear
     * @return Lista de archivos creados (1MB cada uno)
     */
    private fun createTestImageFiles(count: Int): List<File> {
        return (1..count).map { i ->
            File(context.filesDir, "test_image_$i.jpg").apply {
                writeBytes(ByteArray(1024 * 1024)) // 1MB por archivo
            }
        }
    }

    /**
     * Inserta notas de prueba que referencian los archivos proporcionados.
     * @param files Lista de archivos de imagen a referenciar en las notas
     */
    private suspend fun insertTestNotesWithImages(files: List<File>) {
        files.forEachIndexed { index, file ->
            fakeNotesDao.insertNote(
                Notes(
                    title = "Nota Test ${index + 1}",
                    description = "Contenido de prueba",
                    imageUris = listOf(file.absolutePath)
                )
            )
        }
    }

    /**
     * Elimina archivos de prueba creados durante las pruebas.
     */
    private fun cleanUpTestFiles() {
        context.filesDir.listFiles()?.forEach { file ->
            if (file.name.startsWith("test_image_")) {
                file.delete()
            }
        }
    }
}