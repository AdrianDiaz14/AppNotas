# Manual de Configuración y Administración - AppNotas
**Última actualización:** 02/06/2025 23:34

---

## Introducción
Este manual describe la configuración y administración de **AppNotas**, incluyendo ajustes avanzados y elementos autoactualizables con Dokka.

---

## Configuración General

### 1️⃣ **Preferencias de la aplicación**
**Papelera de reciclaje:** Las notas eliminadas se almacenan por **7 días antes de ser borradas** a modo de copia de seguridad recuperable

### 2️⃣ **Seguridad del contenido de las notas**
**FLAGS:** Se ha inhabilitado la captura de pantalla mediante foto o vídeo de los contenidos de las notas mediante los correspondientes **FLAGS**.

[Clase contenedora de los FLAGS](../dokka/markdown/-app-notas/com.example.appnotas/-edit-note-fragment/on-view-created.md)

---

## Gestión de Notas

**Notas en papelera:** Restaurar o eliminar definitivamente a los 7 días.  
**Adjuntar imágenes:** Habilitar permisos de acceso a galería durante el primer acceso a la app, o en ajustes del dispositivo.

---

## Resolución de Problemas

**Error al cargar notas**  
**Causa:** Problema de sincronización con la base de datos.  
**Solución:** Revisa [NotesViewModel](../dokka/markdown/-app-notas/com.example.appnotas.database/-notes-view-model/index.md).

**Fallos de seguridad**  
**Causa:** La protección de notas no está habilitada.  
**Solución:** Activa los FLAGS en el código.

---

## Otros manuales disponibles
[Manual de Usuario](../manual/Manual_de_usuario.md)  
[Manual de Instalación](../manual/Manual_de_instalacion.md)


**Más información técnica:**  
[NotesRepository](../dokka/markdown/-app-notas/com.example.appnotas.database/-notes-repository/index.md)  
[NotesRoomDatabase](../dokka/markdown/-app-notas/com.example.appnotas.database/-notes-room-database/index.md)


**Este manual se actualiza automáticamente con Dokka al ejecutar:**  
```bash
./gradlew generateManuals
```
