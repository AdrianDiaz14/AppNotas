# ProGuard rules file for AppNotas

# Mantener clases de Room Database y ViewModels
-keep class androidx.room.RoomDatabase { *; }
-keep interface androidx.room.* { *; }
-keep class androidx.lifecycle.ViewModel { *; }

# Evitar que ProGuard elimine las anotaciones de Room
-keepattributes *Annotation*

# Mantener clases usadas en DataBinding
-keep class **.databinding.** { *; }

# Mantener clases de Retrofit y Gson para llamadas a API
-keep class com.google.gson.** { *; }
-keep class com.squareup.retrofit2.** { *; }

# Mantener clases relacionadas con WebView y configuración de JavaScript
-keep class android.webkit.WebView { *; }
-keepclassmembers class android.webkit.WebSettings { *; }

# Si tienes una interfaz para comunicación entre JavaScript y Kotlin, añade esta línea:
# -keepclassmembers class com.example.appnotas.MyJSInterface { public *; }

# Mantener clases usadas en modelos de datos serializables
-keep class **.model.** { *; }

# Mantener métodos públicos en clases utilizadas por la app
-keep class com.example.appnotas.** { *; }

# Configuración específica para evitar problemas con la serialización de Kotlin
-keepclassmembers class * {
    @kotlin.Metadata *;
}

# No eliminar métodos y clases de AndroidX que puedan ser usados en reflexión
-keep class androidx.** { *; }

# Mantener clases relacionadas con la gestión de fragments
-keep class android.app.Fragment { *; }
-keep class androidx.fragment.app.Fragment { *; }
-keep class androidx.fragment.app.FragmentManager { *; }

# Evitar ofuscación de recursos R para prevenir errores en la app
-keep class com.example.appnotas.R { *; }

# Preservar atributos de código fuente para facilitar depuración
-keepattributes SourceFile,LineNumberTable

# Ocultar el nombre del archivo original en la salida de ProGuard
-renamesourcefileattribute SourceFile
