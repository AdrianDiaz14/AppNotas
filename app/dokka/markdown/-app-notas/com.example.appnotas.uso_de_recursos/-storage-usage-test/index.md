//[AppNotas](../../../index.md)/[com.example.appnotas.uso_de_recursos](../index.md)/[StorageUsageTest](index.md)

# StorageUsageTest

[androidJvm]\
class [StorageUsageTest](index.md)

Pruebas para medir y verificar el uso de almacenamiento de la aplicación.

Estas pruebas verifican que:

- 
   El consumo de almacenamiento es el esperado al manejar notas con imágenes
- 
   Los archivos se gestionan correctamente

## Constructors

| | |
|---|---|
| [StorageUsageTest](-storage-usage-test.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [cleanUpTestFiles](clean-up-test-files.md) | [androidJvm]<br>private fun [cleanUpTestFiles](clean-up-test-files.md)()<br>Elimina archivos de prueba creados durante las pruebas. |
| [createTestImageFiles](create-test-image-files.md) | [androidJvm]<br>private fun [createTestImageFiles](create-test-image-files.md)(count: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[File](https://developer.android.com/reference/kotlin/java/io/File.html)&gt;<br>Crea archivos de imagen de prueba del tamaño especificado. |
| [getAvailableStorage](get-available-storage.md) | [androidJvm]<br>private fun [getAvailableStorage](get-available-storage.md)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-long/index.html)<br>Obtiene el espacio disponible en el almacenamiento interno. |
| [insertTestNotesWithImages](insert-test-notes-with-images.md) | [androidJvm]<br>private suspend fun [insertTestNotesWithImages](insert-test-notes-with-images.md)(files: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[File](https://developer.android.com/reference/kotlin/java/io/File.html)&gt;)<br>Inserta notas de prueba que referencian los archivos proporcionados. |
| [setup](setup.md) | [androidJvm]<br>fun [setup](setup.md)()<br>Configura el entorno de prueba: |
| [testStorageConsumptionWithImages](test-storage-consumption-with-images.md) | [androidJvm]<br>fun [testStorageConsumptionWithImages](test-storage-consumption-with-images.md)()<br>Verifica el consumo de almacenamiento al manejar notas con imágenes. |

## Properties

| Name | Summary |
|---|---|
| [context](context.md) | [androidJvm]<br>private lateinit var [context](context.md): [Context](https://developer.android.com/reference/kotlin/android/content/Context.html) |
| [fakeNotesDao](fake-notes-dao.md) | [androidJvm]<br>private lateinit var [fakeNotesDao](fake-notes-dao.md): [FakeNotesDao](../../com.example.appnotas.testHelpers/-fake-notes-dao/index.md) |
