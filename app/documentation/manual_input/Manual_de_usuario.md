# Manual de Usuario - AppNotas
**Última actualización:** {{update_date}}

---

## Índice
1️⃣ [Introducción](#introducción)  
2️⃣ [Creación de Notas](#creación-de-notas)  
3️⃣ [Gestión de Notas](#gestión-de-notas)  
4️⃣ [Restaurar Notas](#restaurar-notas)  
5️⃣ [Ayuda Contextual](#ayuda-contextual)

---

## Introducción
Bienvenido a **AppNotas**, tu aplicación para gestionar notas. Con esta herramienta, podrás escribir, organizar y recuperar notas de forma rápida y sencilla.

**Funcionalidades principales:**
- Creación y edición de notas
- Adjuntar imágenes
- Restaurar notas eliminadas

**Más información en la documentación técnica:**
- [ViewModel de Notas](documentation/generated/dokka/markdown/-app-notas/com.example.appnotas.database/-notes-view-model/index.md)
- [Gestor de Ayuda](documentation/generated/dokka/markdown/-app-notas/com.example.appnotas.helpers/-help-manager/index.md)

---

## Creación de Notas

### 1️⃣ **Abrir el editor de notas**
Pulsa el botón `+` para crear una nueva nota

### 2️⃣ **Escribir y adjuntar contenido**
**Opciones disponibles:**
- Escribe contenido
- Adjunta imágenes

### 3️⃣ **Guardar la nota**
Pulsa el botón **Guardar** para almacenar tu nota.

[Guía completa para crear una nota](tutorial_crear_nota.md)

**Más información técnica:**  
🔍 [ViewModel para guardar notas](documentation/generated/dokka/markdown/-app-notas/com.example.appnotas.database/-note-save-view-model/index.md)

---

## Gestión de Notas

### **Editar una nota existente**
1️⃣ Selecciona la nota en la pantalla principal  
2️⃣ Realiza los cambios necesarios  
3️⃣ Guarda la nota con el botón **Guardar**
4️⃣ Podrás ver la fecha y hora de la última modificación

### **Eliminar una nota**
**Opciones disponibles:**
- Mantén pulsada la nota y selecciona el cubo para **Eliminar**
- Desliza una nota hacia la derecha
- 
La nota se moverá a la Papelera y permanecerá 7 días, a modo de seguridad, hasta que se autoelimine.

[Guía paso a paso para eliminar una nota](tutorial_borrar_nota.md)

**Más detalles técnicos:**  
[Repositorio de notas](documentation/generated/dokka/markdown/-app-notas/com.example.appnotas.database/-notes-repository/index.md)

---

## Restaurar Notas

1️⃣ Accede a la sección **Papelera**  
2️⃣ Mantén pulsada la nota eliminada, o pulsa el botón **Restaurar** directamente

**Eliminación automática:**  
Las notas eliminadas **por más de 7 días** serán **borradas permanentemente**.

[Tutorial para recuperar notas eliminadas](tutorial_recuperar_nota.md)

**Más detalles en la documentación:**  
[Método restoreNote](documentation/generated/dokka/markdown/-app-notas/com.example.appnotas.database/-notes-repository/restore-note.md)

---

## Ayuda Contextual

AppNotas ofrece asistencia contextual según el uso. Si tienes dudas, busca el ícono **!** de Ayuda en la interfaz.

## Otros manuales disponibles
[Manual de Instalación](../generated/manual/Manual_de_instalacion.md)  
[Manual de Configuración y administración](../generated/manual/Manual_de_configuracion_y_administracion.md)

**Este manual se actualiza automáticamente con Dokka al ejecutar:**
```bash
./gradlew generateManuals
```