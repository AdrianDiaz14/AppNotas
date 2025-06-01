//[AppNotas](../../../index.md)/[com.example.appnotas.uso_de_recursos](../index.md)/[StorageUsageTest](index.md)/[testStorageConsumptionWithImages](test-storage-consumption-with-images.md)

# testStorageConsumptionWithImages

[androidJvm]\
fun [testStorageConsumptionWithImages](test-storage-consumption-with-images.md)()

Verifica el consumo de almacenamiento al manejar notas con imágenes.

1. 
   Mide el almacenamiento disponible inicial
2. 
   Crea archivos de imagen de prueba
3. 
   Inserta notas que referencian estas imágenes
4. 
   Verifica que el consumo sea el esperado (±10%)
5. 
   Realiza limpieza final
