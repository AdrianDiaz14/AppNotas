//[AppNotas](index.md)

# AppNotas

[androidJvm]\
##  Descripción General

AppNotas es una aplicación para gestionar notas de manera intuitiva, con funciones avanzadas como adjuntar imágenes y restaurar notas eliminadas.

📌 **Para documentación técnica autoactualizable**, consulta ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-notes-repository.md y ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-notes-view-model.md.

##  Requisitos Técnicos

📌 **Especificaciones:**

| Requisito | Versión |
|---|---|
| **Android SDK Mínimo** | 24 |
| **Versión de Kotlin** | 1.8.10 |
| **Base de datos** | Room Database |
| **Interfaz gráfica** | Material Design con ViewModel y LiveData |

📌 **Dependencias principales:**

```kotlin
dependencies {
implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
implementation ("androidx.room:room-runtime:2.5.0")
kapt ("androidx.room:room-compiler:2.5.0")
}
```

📌 **Clase de configuración:**../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-settings-manager.md.

##  Estructura de paquetes

📌 **Distribución del código:**

### **1. database**

- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-notes-room-database.md: Implementación de Room Database.
- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-notes-dao.md: Manejo de operaciones CRUD.
- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-notes-repository.md: Acceso a los datos desde los ViewModels.

### **2. ui**

- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-main-activity.md: Pantalla principal de gestión de notas.
- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-all-notes-fragment.md: Vista con todas las notas activas.
- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-edit-note-fragment.md: Edición y creación de notas.
- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-trash-fragment.md: Manejo de la papelera y restauración de notas.

### **3. seguridad**

- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-database-encryption-test.md: Prueba para verificar el cifrado de la base de datos.
- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-sql-injection-test.md: Prueba de seguridad para detectar inyección SQL.

##  Diagrama de Clases

📌 **Relación entre los elementos principales:**

```plantuml
@startuml
class Notes {
  +Long noteId
  +String title
  +String description
  +List<String> imageUris
  +Boolean isDeleted
}

class NotesDao {
  +insertNote()
  +getAllNotes()
  +updateNote()
  +deleteNote()
}

class NotesRepository {
  -NotesDao
  +allNotes: LiveData
  +insertNote()
  +deleteNote()
  +restoreNote()
}

class NotesViewModel {
  -NotesRepository
  +createNote()
  +deleteNote()
  +restoreNote()
}

class MainActivity {
  +initUI()
  +navigate()
}

class EditNoteFragment {
  +saveNote()
}

class TrashFragment {
  +listDeletedNotes()
  +restoreNote()
}

NotesDao "1" --> "1" Notes
NotesRepository "1" --> "1" NotesDao
NotesViewModel "1" --> "1" NotesRepository
EditNoteFragment "1" --> "1" NotesViewModel
TrashFragment "1" --> "1" NotesViewModel
MainActivity "1" --> "1" NotesViewModel
@enduml
```

📌 Documentación del modelo de datos: Notes. 🚀 Este módulo se documenta automáticamente con Dokka al ejecutar: 

```bash 
./gradlew dokkaMarkdown 
```
<!-- End of Module Documentation -->

##  Descripción General

AppNotas es una aplicación para gestionar notas de manera intuitiva, con funciones avanzadas como adjuntar imágenes y restaurar notas eliminadas.

📌 **Para documentación técnica autoactualizable**, consulta ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-notes-repository.md y ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-notes-view-model.md.

##  Requisitos Técnicos

📌 **Especificaciones:**

| Requisito | Versión |
|---|---|
| **Android SDK Mínimo** | 24 |
| **Versión de Kotlin** | 1.8.10 |
| **Base de datos** | Room Database |
| **Interfaz gráfica** | Material Design con ViewModel y LiveData |

📌 **Dependencias principales:**

```kotlin
dependencies {
implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
implementation ("androidx.room:room-runtime:2.5.0")
kapt ("androidx.room:room-compiler:2.5.0")
}
```

📌 **Clase de configuración:**../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-settings-manager.md.

##  Estructura de paquetes

📌 **Distribución del código:**

### **1. database**

- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-notes-room-database.md: Implementación de Room Database.
- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-notes-dao.md: Manejo de operaciones CRUD.
- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-notes-repository.md: Acceso a los datos desde los ViewModels.

### **2. ui**

- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-main-activity.md: Pantalla principal de gestión de notas.
- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-all-notes-fragment.md: Vista con todas las notas activas.
- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-edit-note-fragment.md: Edición y creación de notas.
- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-trash-fragment.md: Manejo de la papelera y restauración de notas.

### **3. seguridad**

- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-database-encryption-test.md: Prueba para verificar el cifrado de la base de datos.
- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-sql-injection-test.md: Prueba de seguridad para detectar inyección SQL.

##  Diagrama de Clases

📌 **Relación entre los elementos principales:**

```plantuml
@startuml
class Notes {
  +Long noteId
  +String title
  +String description
  +List<String> imageUris
  +Boolean isDeleted
}

class NotesDao {
  +insertNote()
  +getAllNotes()
  +updateNote()
  +deleteNote()
}

class NotesRepository {
  -NotesDao
  +allNotes: LiveData
  +insertNote()
  +deleteNote()
  +restoreNote()
}

class NotesViewModel {
  -NotesRepository
  +createNote()
  +deleteNote()
  +restoreNote()
}

class MainActivity {
  +initUI()
  +navigate()
}

class EditNoteFragment {
  +saveNote()
}

class TrashFragment {
  +listDeletedNotes()
  +restoreNote()
}

NotesDao "1" --> "1" Notes
NotesRepository "1" --> "1" NotesDao
NotesViewModel "1" --> "1" NotesRepository
EditNoteFragment "1" --> "1" NotesViewModel
TrashFragment "1" --> "1" NotesViewModel
MainActivity "1" --> "1" NotesViewModel
@enduml
```

📌 Documentación del modelo de datos: Notes. 🚀 Este módulo se documenta automáticamente con Dokka al ejecutar: 

```bash 
./gradlew dokkaMarkdown 
```
<!-- End of Module Documentation -->

##  Descripción General

AppNotas es una aplicación para gestionar notas de manera intuitiva, con funciones avanzadas como adjuntar imágenes y restaurar notas eliminadas.

📌 **Para documentación técnica autoactualizable**, consulta ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-notes-repository.md y ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-notes-view-model.md.

##  Requisitos Técnicos

📌 **Especificaciones:**

| Requisito | Versión |
|---|---|
| **Android SDK Mínimo** | 24 |
| **Versión de Kotlin** | 1.8.10 |
| **Base de datos** | Room Database |
| **Interfaz gráfica** | Material Design con ViewModel y LiveData |

📌 **Dependencias principales:**

```kotlin
dependencies {
implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
implementation ("androidx.room:room-runtime:2.5.0")
kapt ("androidx.room:room-compiler:2.5.0")
}
```

📌 **Clase de configuración:**../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-settings-manager.md.

##  Estructura de paquetes

📌 **Distribución del código:**

### **1. database**

- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-notes-room-database.md: Implementación de Room Database.
- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-notes-dao.md: Manejo de operaciones CRUD.
- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-notes-repository.md: Acceso a los datos desde los ViewModels.

### **2. ui**

- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-main-activity.md: Pantalla principal de gestión de notas.
- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-all-notes-fragment.md: Vista con todas las notas activas.
- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-edit-note-fragment.md: Edición y creación de notas.
- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-trash-fragment.md: Manejo de la papelera y restauración de notas.

### **3. seguridad**

- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-database-encryption-test.md: Prueba para verificar el cifrado de la base de datos.
- 
   ../dokka/markdown/-app-notas/com.example.appnotas/[android-jvm]-sql-injection-test.md: Prueba de seguridad para detectar inyección SQL.

##  Diagrama de Clases

📌 **Relación entre los elementos principales:**

```plantuml
@startuml
class Notes {
  +Long noteId
  +String title
  +String description
  +List<String> imageUris
  +Boolean isDeleted
}

class NotesDao {
  +insertNote()
  +getAllNotes()
  +updateNote()
  +deleteNote()
}

class NotesRepository {
  -NotesDao
  +allNotes: LiveData
  +insertNote()
  +deleteNote()
  +restoreNote()
}

class NotesViewModel {
  -NotesRepository
  +createNote()
  +deleteNote()
  +restoreNote()
}

class MainActivity {
  +initUI()
  +navigate()
}

class EditNoteFragment {
  +saveNote()
}

class TrashFragment {
  +listDeletedNotes()
  +restoreNote()
}

NotesDao "1" --> "1" Notes
NotesRepository "1" --> "1" NotesDao
NotesViewModel "1" --> "1" NotesRepository
EditNoteFragment "1" --> "1" NotesViewModel
TrashFragment "1" --> "1" NotesViewModel
MainActivity "1" --> "1" NotesViewModel
@enduml
```

📌 Documentación del modelo de datos: Notes. 🚀 Este módulo se documenta automáticamente con Dokka al ejecutar: 

```bash 
./gradlew dokkaMarkdown 
```
<!-- End of Module Documentation -->

## Packages

| Name |
|---|
| [com.example.appnotas](-app-notas/com.example.appnotas/index.md) |
| [com.example.appnotas.database](-app-notas/com.example.appnotas.database/index.md) |
| [com.example.appnotas.helpers](-app-notas/com.example.appnotas.helpers/index.md) |
| [com.example.appnotas.integracion](-app-notas/com.example.appnotas.integracion/index.md) |
| [com.example.appnotas.notes](-app-notas/com.example.appnotas.notes/index.md) |
| [com.example.appnotas.regresion](-app-notas/com.example.appnotas.regresion/index.md) |
| [com.example.appnotas.seguridad](-app-notas/com.example.appnotas.seguridad/index.md) |
| [com.example.appnotas.testHelpers](-app-notas/com.example.appnotas.testHelpers/index.md) |
| [com.example.appnotas.unitaria](-app-notas/com.example.appnotas.unitaria/index.md) |
| [com.example.appnotas.uso_de_recursos](-app-notas/com.example.appnotas.uso_de_recursos/index.md) |
| [com.example.appnotas.volumenestres.alto](-app-notas/com.example.appnotas.volumenestres.alto/index.md) |
| [com.example.appnotas.volumenestres.bajo](-app-notas/com.example.appnotas.volumenestres.bajo/index.md) |
| [com.example.appnotas.volumenestres.medio](-app-notas/com.example.appnotas.volumenestres.medio/index.md) |
