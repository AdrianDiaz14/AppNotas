# Manual de Instalación: AppNotas
**Última actualización:** 02/06/2025 23:34

---

## Introducción
Este manual es una ayuda para la instalación de **AppNotas** desde los distintos canales disponibles.

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

[AppNotas en Amazon](https://www.amazon.es/AppNotes-AppNotas/dp/B0F9QMKSHG/ref=sr_1_1?__mk_es_ES=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2008V7IXXV5DM&dib=eyJ2IjoiMSJ9.Ns3OdA29wYzRoifJSCAXxNLfX8zDxHRUY0iRXGbxRtDGjHj071QN20LucGBJIEps.9f6fYnRohlxv1eIR9hDwatfo9csAf5xyr6nQ7PhR6z0&dib_tag=se&keywords=appnotas&qid=1748877137&s=mobile-apps&sprefix=appnotas%2Cmobile-apps%2C107&sr=1-1)

---

## Instalación desde APK/AAB
**1️⃣ Descarga el archivo APK o AAB desde:**  
**2️⃣ Habilita la opción "Fuentes desconocidas" en los ajustes del dispositivo.**  
**3️⃣ Abre el archivo APK/AAB y pulsa "Instalar".**  
**4️⃣ Inicia la aplicación.**

[AppNotas APK- Descarga directa](https://drive.google.com/file/d/1FIs2budCD89GV_7mMUlVLa5PAtJMnOo2/view?usp=drive_link)  
[AppNotas AAB- Descarga directa](https://drive.google.com/file/d/1lHdOMEU_g1_AFNf4GYY1k0HPwxJ9z92o/view?usp=sharing) 
 
---

## Instalación desde Github (para desarrolladores)

### 1️⃣ **Clonar el repositorio**
`bash
git clone https://github.com/AdrianDiaz14/AppNotas.git
`

### 2️⃣ **Abrir el proyecto en Android Studio**
**Selecciona "Abrir proyecto"** y busca la carpeta `appnotas/`.

### 3️⃣ **Sincronizar dependencias con Gradle**
`bash
./gradlew build
`

**Revisar:** [NotesRepository](../dokka/markdown/-app-notas/com.example.appnotas.database/-notes-repository/index.md).

### 4️⃣ **Generar documentación automática con Dokka**
`bash
./gradlew generateManuals
`

---

## Resolución de Problemas

**Error en la descarga del APK**  
**Causa:** Fallo en la red.  
**Solución:** Comprueba el estado de la conexión WI-FI

**La aplicación no arranca**  
**Causa:** La pantalla de inicio se queda en blanco.  
**Solución:** Reinstala la app nuevamente y comprueba que el dispositivo cumple con los requisitos necesarios.

---

## Otros manuales disponibles
[Manual de Usuario](../manual/Manual_de_usuario.md)  
[Manual de Configuración y Administración](../manual/Manual_de_configuracion_y_administracion.md)

**Más información técnica:**
- La aplicación debe iniciarse correctamente con [NotesViewModel](../dokka/markdown/-app-notas/com.example.appnotas.database/-notes-view-model/index.md).
- [Actividad principal](..dokka/markdown/-app-notas/com.example.appnotas/-main-activity/index.md)  

**Este manual se actualiza automáticamente con Dokka al ejecutar:**  
```bash
./gradlew generateManuals
```
