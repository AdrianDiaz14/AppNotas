# **Estructura de la Información Persistente - AppNotas**

La aplicación AppNotas gestiona las notas utilizando **Room Database**, lo que permite almacenar datos de forma segura y eficiente.

## **Componentes principales**

**NotesRoomDatabase** → Implementa la base de datos en Room. [Documentación técnica](../dokka/markdown/-notes%20-app/com.sba.notes/[android-jvm]-notes-room-database.md)  
**NotesDao** → Define operaciones CRUD sobre las notas. [Documentación técnica](../dokka/markdown/-notes%20-app/com.sba.notes/[android-jvm]-notes-dao.md)  
**NotesRepository** → Abstrae la interacción con la base de datos y gestiona actualizaciones automáticas. [Documentación técnica](../dokka/markdown/-notes%20-app/com.sba.notes/[android-jvm]-notes-repository.md)  
**Eliminación automática de notas** → Las notas en la papelera se borran tras 7 días mediante `cleanOldDeletedNotes()`. [Documentación técnica](../dokka/markdown/-notes%20-app/com.sba.notes/[android-jvm]-notes-repository/clean-old-deleted-notes.md)

## **Gestión de la Información Persistente**
La información persistente en AppNotas garantiza la continuidad de los datos a lo largo del tiempo. Se ha diseñado el sistema para:
- **Evitar pérdida de información**, asegurando que las notas se mantengan almacenadas en la base de datos.
- **Optimizar el acceso a los datos** mediante consultas eficientes en `NotesDao`.
- **Gestionar la papelera de reciclaje**, eliminando automáticamente notas tras un período de 7 días.

### **Eliminación automática en la papelera**
La app implementa un mecanismo que borra las notas que han permanecido más de **7 días** en la papelera. Este sistema se gestiona mediante el método `cleanOldDeletedNotes()`, garantizando que la papelera se mantenga libre de notas innecesarias.

```kotlin
suspend fun cleanOldDeletedNotes() {
    val sevenDaysAgo = System.currentTimeMillis() - (7 * 24 * 60 * 60 * 1000)
    noteDao.permanentlyDeleteOldNotes(sevenDaysAgo)
}
```

> **Flujo completo:**  
> `TrashFragment` → `NotesViewModel` → `NotesRepository` → `NotesDao`.  
> [Ver implementación](../dokka/markdown/com.example.appnotas/-trash-fragment/index.md)