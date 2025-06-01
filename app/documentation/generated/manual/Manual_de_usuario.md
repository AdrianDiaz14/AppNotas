# Manual de Usuario - AppNotas
**Última actualización:** 01/06/2025 12:47

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
Para crear una nueva nota:  
Pulsa el botón `+` en la pantalla principal

### 2️⃣ **Escribir y adjuntar contenido**
**Opciones disponibles:**
- Escribe un título y descripción
- Añade imágenes tocando **Añadir imagen**

### 3️⃣ **Guardar la nota**
Pulsa el botón **Guardar** para almacenar tu nota.

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
Mantén pulsada la nota y selecciona **Eliminar**  
La nota se moverá a la Papelera  
La nota permanecerá 7 días en la papelera, a modo de seguridad, hasta que se autoelimine.

**Más detalles técnicos:**  
[Repositorio de notas](documentation/generated/dokka/markdown/-app-notas/com.example.appnotas.database/-notes-repository/index.md)

---

## Restaurar Notas

1️⃣ Accede a la sección **Papelera**  
2️⃣ Selecciona la nota eliminada, o pulsa el botón correspondiente
3️⃣ Pulsa en **Recuperar**

**Restauración automática:**  
Las notas eliminadas **por más de 7 días** serán **borradas permanentemente**.

**Más detalles en la documentación:**  
[Método restoreNote](documentation/generated/dokka/markdown/-app-notas/com.example.appnotas.database/-notes-repository/restore-note.md)

---

## (!) Ayuda Contextual

AppNotas ofrece asistencia contextual según el uso. Si tienes dudas, busca el ícono **!** de Ayuda en la interfaz.

## Otros manuales disponibles
[Manual de Instalación](../generated/manual/Manual_de_instalacion.md)  
[Manual de Configuración](../generated/manual/Manual_de_configuracion_y_administracion.md)

**Este manual se actualiza automáticamente con Dokka al ejecutar:**
```bash
./gradlew generateManuals
```