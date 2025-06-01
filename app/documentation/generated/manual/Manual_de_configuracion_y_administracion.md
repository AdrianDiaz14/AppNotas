# Manual de Configuración y Administración - AppNotas
**Última actualización:** 01/06/2025 12:47

---

## Introducción
Este manual describe la configuración y administración de **AppNotas**, incluyendo ajustes avanzados y elementos autoactualizables con Dokka.

**Otros manuales disponibles:**
- [Manual de Usuario](../generated/manual/Manual_de_usuario.md)
- [Manual de Instalación](../generated/manual/Manual_de_instalacion.md)

---

## Configuración General

### 1️⃣ **Preferencias de la aplicación**
**Seguridad de notas:** Protege notas con autenticación **en Ajustes > Seguridad**  
**Papelera de reciclaje:** Las notas eliminadas se almacenan por **7 días antes de ser borradas**

---

## Gestión de Notas

**Notas en papelera:** Restaurar o eliminar definitivamente.  
**Exportación:** Las notas pueden exportarse como archivos `.txt` desde el menú.  
**Adjuntar imágenes:** Habilitar permisos de acceso a galería en ajustes.

**Más detalles en la documentación:**  
[NotesRepository](../generated/dokka/markdown/-app-notas/com.example.appnotas.database/-notes-repository/index.md)

---

## Administración de Datos

### 1️⃣ **Respaldo de base de datos**
**Ubicación:** La base de datos está en `data/data/com.example.appnotas/databases/notes.db`.  
**Exportar:** Usa el menú de configuración para generar una copia de seguridad.  
**Restaurar:** Se puede importar una copia previa desde almacenamiento externo.

**Más detalles en la documentación:**  
[NotesRoomDatabase](../generated/dokka/markdown/-app-notas/com.example.appnotas.database/-notes-room-database/index.md)

---

## Resolución de Problemas

**Error al cargar notas**  
**Causa:** Problema de sincronización con la base de datos.  
**Solución:** Revisa [NotesViewModel](../generated/dokka/markdown/-app-notas/com.example.appnotas.database/-notes-view-model/index.md).

**Fallos de seguridad**  
**Causa:** La protección de notas no está habilitada.  
**Solución:** Activa autenticación en **Ajustes > Seguridad**.

---

## Otros recursos
[Manual de Usuario](../generated/manual/Manual_de_usuario.md)  
[Manual de Instalación](../generated/manual/Manual_de_instalacion.md)

**Este manual se actualiza automáticamente con Dokka al ejecutar:**  
```bash
./gradlew generateManuals
```
