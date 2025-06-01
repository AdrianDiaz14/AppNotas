# Manual de Instalación: AppNotas
**Última actualización:** 01/06/2025 12:47

---

## Introducción
Bienvenido a **AppNotas**, una aplicación diseñada para gestionar notas de manera eficiente. Este manual te guiará sobre cómo instalar la aplicación correctamente y configurar su documentación automática.

---

## Requisitos del sistema
**Versión mínima de Android:** `7.0 (SDK 24)`  
**Target SDK:** `34`
**Espacio de almacenamiento mínimo:** `50 MB`

**Permisos requeridos:**  
Para que la aplicación funcione correctamente, se deben conceder los siguientes permisos:

`xml
<uses-permission android:name=android.permission.READ_MEDIA_IMAGES />
<uses-permission android:name=android.permission.READ_MEDIA_VISUAL_USER_SELECTED />
<uses-permission android:name=com.miui.securitycenter.permission.SYSTEM_ALERT_WINDOW />
`

---

## Instalación desde Amazon Appstore
**1️⃣ Abre la Amazon Appstore en tu dispositivo Android.**  
**2️⃣ Busca "AppNotas" en la barra de búsqueda.**  
**3️⃣ Pulsa "Instalar" y espera a que se complete la descarga.**  
**4️⃣ Abre la aplicación y concede los permisos solicitados.**

**Verificación post-instalación:** La aplicación debe iniciarse correctamente con [NotesViewModel](../generated/dokka/markdown/-app-notas/com.example.appnotas.database/-notes-view-model/index.md).

---

## Instalación desde APK
**1️⃣ Descarga el archivo APK desde:**  
[AppNotas - Descarga directa](https://drive.google.com/file/d/1FIs2budCD89GV_7mMUlVLa5PAtJMnOo2/view)  
**2️⃣ Habilita la opción "Fuentes desconocidas" en los ajustes del dispositivo.**  
**3️⃣ Abre el archivo APK y pulsa "Instalar".**  
**4️⃣ Inicia la aplicación.**

---

## Instalación desde Github

### 1️⃣ **Clonar el repositorio**
`bash
git clone https://github.com/AdrianDiaz14/appnotas.git
`

### 2️⃣ **Abrir el proyecto en Android Studio**
**Selecciona "Abrir proyecto"** y busca la carpeta `appnotas/`.

### 3️⃣ **Sincronizar dependencias con Gradle**
`bash
./gradlew build
`

**Verificación:** Revisa [NotesRepository](../generated/dokka/markdown/-app-notas/com.example.appnotas.database/-notes-repository/index.md).

### 4️⃣ **Generar documentación automática con Dokka**
`bash
./gradlew dokkaMarkdown
`

**Documentación generada:**  
[NotesViewModel](../generated/dokka/markdown/-app-notas/com.example.appnotas.database/-notes-view-model/index.md)  
[MainActivity](../generated/dokka/markdown/-app-notas/com.example.appnotas/-main-activity/index.md)  
[EditNoteFragment](../generated/dokka/markdown/-app-notas/com.example.appnotas/-edit-note-fragment/index.md)

---

## Resolución de Problemas

**Error al sincronizar Gradle**  
**Causa:** Fallo en la descarga de dependencias.  
**Solución:** Ejecuta `./gradlew --refresh-dependencies` y revisa [NotesRepository](../generated/dokka/markdown/-app-notas/com.example.appnotas.database/-notes-repository/index.md).

**La aplicación no arranca**  
**Causa:** La pantalla de inicio se queda en blanco.  
**Solución:** Revisa [NotesViewModel](../generated/dokka/markdown/-app-notas/com.example.appnotas.database/-notes-view-model/index.md) y asegúrate de que la base de datos se inicializa correctamente.

---

## Otros manuales disponibles
[Manual de Usuario](../generated/manual/Manual_de_usuario.md)  
[Manual de Configuración](../generated/manual/Manual_de_configuracion_y_administracion.md)

**Este manual se actualiza automáticamente con Dokka al ejecutar:**  
```bash
./gradlew generateManuals
```