# INFORME DE PRUEBAS

![Logo de AppNotas](https://i.imgur.com/SRHLNK9.png)  

## PRUEBAS DE ACCESIBILIDAD

En un mundo donde la tecnología nos acompaña día a día y se ha convertido en una herramienta esencial en la vida cotidiana, excluir a ciertas personas por barreras de accesibilidad es una limitación que debemos eliminar como desarrolladores de software. La accesibilidad no es solo una característica opcional, sino un principio fundamental del diseño inclusivo que permite que todas las personas, sin importar sus capacidades físicas, sensoriales o cognitivas, puedan utilizar la aplicación de manera efectiva y sin restricciones.

Las pruebas de accesibilidad no solo garantizan que la app cumpla con las normativas internacionales como las WCAG. Millones de personas en todo el mundo tienen dificultades para acceder a la tecnología por diversos motivos: discapacidad visual, cognitiva, motora, etc. Por lo general, se tiende a pensar que la accesibilidad solo afecta a estas minorías, pero en realidad mejora la experiencia de todos los usuarios.

En cualquier app es básico llevar a cabo diversos aspectos de accesibilidad como puede ser la combinación de colores adecuados, la utilización de mensajes informativos relevantes o textos suficientemente grandes para mejorar su accesibilidad. A continuación, se presentan los diferentes aspectos de accesibilidad que se han considerado durante el desarrollo de la aplicación.

### 1. Descripción de contenido

Uno de los aspectos básicos de la usabilidad, es el uso de la etiqueta descriptiva (contentDescription) en los distintos elementos de la app. Esto permite dar un significado a los elementos gráficos, de modo que los programas de accesibilidad mediante lectura de pantalla conozcan el significado de los elementos en pantalla y puedan transmitirlos al usuario.

![](https://i.imgur.com/wGXJKwv.png)

### 2. Tamaño de los elementos táctiles

> Otro de los elementos tenidos en cuenta para favorecer la accesibilidad del usuario, es la inclusión de elementos táctiles de interacción con un tamaño mínimo de 48dp. Con esto conseguimos favorecer el área de interacción del usuario.

![](https://i.imgur.com/102yCcM.png)

### 3. Contraste de colores

> Otro de los principales aspectos que deben considerarse en accesibilidad es la elección de colores de la App. En el desarrollo de AppNotas se ha tenido en cuenta este aspecto desde el primer momento, y se ha escogido una paleta de colores (colors.xml) que cumpla con los estándares mínimos de contraste (3.0:1). De este modo, se facilita una correcta lectura y visualización de los distintos elementos, ya no solo en las personas con visión reducida, sino en cualquier usuario.

![](https://i.imgur.com/GjMDFpR.png)

![](https://i.imgur.com/Zr6X4lW.png)
Para poder detectar posibles deficiencias en la accesibilidad, ha resultado importante hacer uso de la herramienta de **Test de accesibilidad**, que permite analizar la aplicación y obtener un diagnóstico de posibles elementos mal configurados desde el punto de vista accesible. De este modo se han podido detectar y corregir, durante el proceso de creación de la aplicación, distintos tamaños inadecuados o colores con un contraste inferior a lo esperado.

![](https://i.imgur.com/o512dq6.png)

Seguidamente también se han llevado a cabo dos pruebas de accesibilidad sobre la propia aplicación AppNotas, que pueden verse en los correspondientes vídeos, a continuación.

#### 1. Talkback

> Se trata de un lector de pantalla integrado en Android que permite a los usuarios con discapacidad visual navegar y usar aplicaciones mediante gestos o síntesis de voz. Los *contentDescription* implantados anteriormente, resultan imprescindibles para un correcto uso de esta herramienta.

[Accesibilidad - Talkback](https://youtu.be/4t0WuspAfeE)

#### 2. Accesibilidad con interruptores

> Evalúa si la aplicación puede ser usada mediante accesibilidad con interruptores, con la función de Android que permite controlar el dispositivo con uno o varios interruptores físicos en lugar de toques en la pantalla, que permitiría a personas con discapacidad poder hacer uso del gestor de notas.

[Accesibilidad con interruptores](https://youtube.com/shorts/OUV0vN01W_8)

## PRUEBAS DE INTEGRACIÓN

Este tipo de pruebas evalúan la interacción entre distintos elementos de la App para asegurar que todas las partes individuales, cuando se combinan, trabajen como se espera y se comuniquen adecuadamente. En el caso de AppNotas, estas pruebas son fundamentales para garantizar el correcto funcionamiento en conjunto de las capas de base de datos (Room), repositorio, ViewModel o UI de la aplicación. 

Estas pruebas de integración combinan JUnit 4, AndroidJUnit4, Room Database en memoria, LiveData, coroutines y FakeNotesRepository para verificar que la interacción entre NotesDao, NotesRepository y NotesViewModel opera correctamente en conjunto dentro del sistema, incluso tras modificaciones en la lógica de la aplicación.

A continuación, se describen las pruebas de integración más relevantes llevadas a cabo en el desarrollo de la aplicación:

### 1. Prueba de actualización de notas en la base de datos

- **Clase de testeo:** NotesDaoIntegrationTest
- **Elementos probados:** NotesDao, NotesRoomDatabase
- **Descripción:** Se inserta una nota, se actualiza su título y se verifica que el cambio persiste en la base de datos
- **Resultado obtenido:** La base de datos refleja correctamente los cambios (Assert.assertEquals confirma que el título se actualizó)

### 2. Prueba de eliminación temporal y restauración

- **Clase de testeo:** NotesRepositoryTest
- **Elementos probados:** NotesRepository, NotesDao
- **Descripción:**  
  i. Una nota se marca como eliminada (softDeleteNote) y debe aparecer en la papelera (deletedNotes)  
  ii. Luego se restaura (restoreNote) y debe volver a la lista principal (allNotes)
- **Resultado obtenido:** La nota cambia de estado correctamente y las listas (LiveData) se actualizan

### 3. Prueba de rendimiento con 500 notas

- **Clase de testeo:** TrashIntegrationTest
- **Elementos probados:** NotesRepository, base de datos Room
- **Descripción:** Se simula la restauración masiva de 500 notas desde la papelera, midiendo el tiempo de ejecución
- **Resultado obtenido:** Todas las notas se restauran sin errores (Assert.assertEquals confirma el conteo). El tiempo de ejecución se registra para optimización

### 4. Prueba de error al restaurar nota inexistente

- **Clase de testeo:** TrashIntegrationTest
- **Elementos probados:** NotesRepository, manejo de excepciones
- **Descripción:** Se intenta restaurar una nota con ID inválido (99999)
- **Resultado obtenido:** El sistema lanza una excepción controlada (IllegalStateException) con un mensaje claro

### 5. Integración ViewModel con LiveData

- **Clase de testeo:** NotesViewModelTest
- **Elementos probados:** NotesViewModel, LiveData
- **Descripción:** Se inserta una nota y se verifica que el LiveData del ViewModel se actualice con los nuevos datos
- **Resultado obtenido:** El LiveData emite la lista actualizada (Assert.assertNotNull confirma la presencia de la nota)

## PRUEBAS DE REGRESIÓN

Los tests de regresión verifican que las funcionalidades existentes de la aplicación siguen funcionando correctamente después de introducir cambios, actualizaciones o nuevas características. Su objetivo es detectar posibles errores que puedan surgir debido a modificaciones en el código, asegurando que el comportamiento esperado no se vea afectado. Por ello, es importante ejecutar estas pruebas siempre que se hagan cambios en el código de la aplicación, para asegurar su correcto funcionamiento tras cada modificación relevante.

En el contexto de la aplicación AppNotas, este tipo de prueba es crucial para garantizar que las operaciones básicas con notas continúen funcionando como se espera, incluso después de actualizaciones futuras. Por lo tanto, las funcionalidades básicas que interesa probar para asegurar el funcionamiento de la app, con; inserción de notas, eliminación a la papelera, eliminación tras 7 días y recuperación de notas desde la papelera.

Estas pruebas combinan **JUnit 4, Room Database en memoria, LiveData, coroutines y AndroidJUnit4** para verificar que las funciones de **NotesDao** operan correctamente incluso después de modificaciones en la lógica de la aplicación.

### 1. Validación de inserción de notas

**Clase de testeo:** insertNote_shouldStillWork  
**Elementos probados:**
- NotesDao (método insertNote)
- NotesRoomDatabase (configuración de la base de datos)
- LiveData (para observar cambios en getAllNotes)

**Descripción:**  
Se verifica que la función insertNote() persiste correctamente una nueva nota en la base de datos. El test inserta una nota con título y descripción específicos, luego recupera todas las notas activas para confirmar que la inserción fue exitosa.

**Resultado obtenido:**  
La nota insertada aparece en la lista de notas activas, confirmando que el mecanismo de persistencia sigue funcionando como se esperaba.

### 2. Validación de eliminación a papelera

**Clase de testeo:** deleteNote_shouldMoveToTrash  
**Elementos probados:**
- NotesDao (métodos insertNote, updateNote, getDeletedNotes)
- Lógica de "soft delete" (campos isDeleted y deletionDate)

**Descripción:**  
Se prueba el flujo de eliminación no permanente (papelera):
1. Se inserta una nota
2. Se marca como eliminada actualizando sus campos (isDeleted = true y deletionDate)
3. Se verifica que la nota aparece en la consulta de notas eliminadas (getDeletedNotes)

**Resultado obtenido:**  
La nota eliminada aparece en la papelera, confirmando que la lógica de "soft delete" y las consultas filtradas por isDeleted funcionan correctamente.

### 3. Validación de eliminación permanente

**Clase de testeo:** permanentlyDeleteOldNotes_shouldRemoveFromTrash  
**Elementos probados:**
- NotesDao (método permanentlyDeleteOldNotes)
- Lógica de limpieza automática (notas con más de 7 días en papelera)

**Descripción:**  
Se simula una nota eliminada hace 8 días y se ejecuta la limpieza de notas antiguas. El test verifica que la nota no aparece en la papelera después de llamar a permanentlyDeleteOldNotes().

**Resultado obtenido:**  
La nota antigua es eliminada permanentemente, demostrando que el sistema de limpieza automática opera correctamente.

### 4. Validación de restauración de notas

**Clase de testeo:** restoreNote_shouldStillWork  
**Elementos probados:**
- NotesDao (método restoreNote)
- Consultas condicionales (isDeleted = 0 en getAllNotes)

**Descripción:**  
Se inserta una nota, se restaura mediante restoreNote() (que actualiza isDeleted a false), y se confirma que la nota vuelve a la lista de notas activas.

**Resultado obtenido:**  
La nota restaurada reaparece en la lista de notas activas, confirmando que la reversión de eliminaciones funciona como se diseñó.

## PRUEBAS DE VOLUMEN Y ESTRÉS

Las pruebas de volumen y estrés tienen como objetivo evaluar el comportamiento de la aplicación ante una carga elevada de datos y operaciones concurrentes, asegurando su estabilidad y rendimiento en situaciones extremas.

En el caso de AppNotas, se prueban situaciones con distintos niveles de carga. Las pruebas se centran en la gestión de un gran número de notas, de imágenes o del contenido de texto. Así se evalúa el comportamiento de la App en situaciones extremas que pudieran ocurrir.

Estas pruebas de volumen y estrés combinan JUnit 4, AndroidJUnit4, Room Database en memoria, LiveData, coroutines, CountDownLatch y AtomicInteger para verificar que la aplicación mantiene rendimiento, estabilidad y eficiencia bajo condiciones de alta carga y múltiples operaciones simultáneas.

### 1. Pruebas de Volumen

**Objetivo:** Evaluar el rendimiento al manejar grandes cantidades de datos (notas, imágenes) y contenido extenso.

#### testVolumeNoteInsertion

| Volumen | Notas insertadas | Recursos consumidos | Tiempo  |
|---------|------------------|---------------------|---------|
| Bajo    | 100              | 3.015 Kb            | 1,087s  |
| Medio   | 500              | 15.825 Kb           | 4,499s  |
| Alto    | 2000             | 108 Kb              | 33,282s |

![](https://i.imgur.com/kBqtzGG.png)

**Cálculos:**
- **Bajo (100 notas, 1,087 s):**  
  `1,087 / 100 = 0,01087 s/nota`
- **Medio (500 notas, 4,499 s):**  
  `4,499 / 500 = 0,008998 s/nota`
- **Alto (2000 notas, 33,282 s):**  
  `33,282 / 2000 = 0,016641 s/nota`

#### testNoteContent

| Volumen | Peso del contenido | Recursos consumidos | Tiempo |
|---------|--------------------|---------------------|--------|
| Bajo    | 10 Kb              | 248 Kb              | 7ms    |
| Medio   | 100 Kb             | 128 Kb              | 6ms    |
| Alto    | 1000 Kb            | 144 Kb              | 6ms    |

![](https://i.imgur.com/bax8GoP.png)

**Cálculos:**
- **Bajo (10 KB):**  
  `248 KB / 10 KB = 24,8 KB/KB`
- **Medio (100 KB):**  
  `128 KB / 100 KB = 1,28 KB/KB`
- **Alto (1000 KB):**  
  `144 KB / 1000 KB = 0,144 KB/KB`

#### testNotesWithImages

| Volumen | Notas con imágenes | Recursos consumidos | Tiempo |
|---------|--------------------|---------------------|--------|
| Bajo    | 20                 | 353 Kb              | 14ms   |
| Medio   | 100                | 1.237 Kb            | 53ms   |
| Alto    | 500                | 2.132 Kb            | 119ms  |

![](https://i.imgur.com/bsn9Knm.png)

**Cálculos por nota:**
- **Tiempo:**
    - Bajo: `14 ms / 20 notas = 0,7 ms/nota`
    - Medio: `53 ms / 100 notas = 0,53 ms/nota`
    - Alto: `119000 ms / 500 notas = 238 ms/nota`
- **Recursos:**
    - Bajo: `353 KB / 20 notas = 17,65 KB/nota`
    - Medio: `1237 KB / 100 notas = 12,37 KB/nota`
    - Alto: `2132 KB / 500 notas = 4,264 KB/nota`

#### testImageConverterLimits

| Volumen | URIs de imágenes | Recursos consumidos | Tiempo |
|---------|------------------|---------------------|--------|
| Bajo    | 50               | 32 Kb               | 6ms    |
| Medio   | 250              | 48 Kb               | 7ms    |
| Alto    | 1000             | 32 Kb               | 6ms    |

![](https://i.imgur.com/VanS4SB.png)

**Cálculos por URI:**
- **Recursos:**
    - Bajo: `32 KB / 50 URIs = 0,64 KB/URI`
    - Medio: `48 KB / 250 URIs = 0,192 KB/URI`
    - Alto: `32 KB / 1000 URIs = 0,032 KB/URI`
- **Tiempo:**
    - Bajo: `6 ms / 50 URIs = 0,12 ms/URI`
    - Medio: `7 ms / 250 URIs = 0,028 ms/URI`
    - Alto: `6 ms / 1000 URIs = 0,006 ms/URI`

### 2. Pruebas de Estrés

**Objetivo:** Validar estabilidad bajo operaciones concurrentes y alta frecuencia de actualizaciones.

#### testMixedConcurrentOperations

| Volumen | Nº Operaciones | Recursos consumidos | Tiempo |
|---------|----------------|---------------------|--------|
| Bajo    | 20             | 2.381 Kb            | 6,117s |
| Medio   | 50             | 4.948 Kb            | 7,843s |
| Alto    | 75             | 10.130 Kb           | 4,491s |

![](https://i.imgur.com/VanS4SB.png)

**Cálculos por operación:**
- **Tiempo:**
    - Bajo: `6,117 s / 20 ops = 0,306 s/op`
    - Medio: `7,843 s / 50 ops = 0,157 s/op`
    - Alto: `4,491 s / 75 ops = 0,060 s/op`
- **Recursos:**
    - Bajo: `2381 KB / 20 ops = 119,05 KB/op`
    - Medio: `4948 KB / 50 ops = 98,96 KB/op`
    - Alto: `10130 KB / 75 ops = 135,07 KB/op`

#### testFrequencyUpdatesWithRecovery

| Volumen | Nº Actualizaciones | Recursos consumidos | Tiempo |
|---------|--------------------|---------------------|--------|
| Bajo    | 20                 | 1.115 Kb            | 2,075s |
| Medio   | 50                 | 1.387 Kb            | 3,118s |
| Alto    | 100                | 1.666 Kb            | 1,720s |

![](https://i.imgur.com/tChXKU6.png)

**Cálculos por actualización:**
- **Tiempo:**
    - Bajo: `2.075 s / 20 actualizaciones = 0,104 s/actualización`
    - Medio: `3.118 s / 50 actualizaciones = 0,062 s/actualización`
    - Alto: `1.720 s / 100 actualizaciones = 0,017 s/actualización`
- **Recursos:**
    - Bajo: `1115 KB / 20 actualizaciones = 55,75 KB/actualización`
    - Medio: `1387 KB / 50 actualizaciones = 27,74 KB/actualización`
    - Alto: `1666 KB / 100 actualizaciones = 16,66 KB/actualización`

#### testNotesWithManyImages

| Volumen | Nº Imágenes adjuntas | Recursos consumidos | Tiempo |
|---------|----------------------|---------------------|--------|
| Bajo    | 10                   | 10 Kb               | 5ms    |
| Medio   | 50                   | 33 Kb               | 4ms    |
| Alto    | 500                  | 32 Kb               | 5ms    |

![](https://i.imgur.com/GrhyTMK.png)

**Cálculos por imagen:**
- **Recursos:**
    - Bajo: `10 KB / 10 imágenes = 1 KB/imagen`
    - Medio: `33 KB / 50 imágenes = 0,66 KB/imagen`
    - Alto: `32 KB / 500 imágenes = 0,064 KB/imagen`
- **Tiempo:**
    - Bajo: `5 ms / 10 imágenes = 0,5 ms/imagen`
    - Medio: `4 ms / 50 imágenes = 0,08 ms/imagen`
    - Alto: `5 ms / 500 imágenes = 0,01 ms/imagen`

### Conclusiones

**1. Volumen:**
- La inserción masiva de notas escala linealmente hasta 500 notas (4,5s), pero sufre un cuello de botella con 2000 notas (33s)
- El manejo de imágenes es eficiente incluso con 500 URIs (5ms)

**2. Estrés:**
- Las operaciones concurrentes muestran buen rendimiento en niveles altos (150 ops en 4,5s)
- Las actualizaciones frecuentes son estables, aunque se recomienda optimizar la memoria

## PRUEBAS DE SEGURIDAD

Las pruebas de seguridad tienen como objetivo garantizar la protección de los datos almacenados en la aplicación, la prevención de ataques y la implementación de medidas que eviten accesos no autorizados.

En el caso de AppNotas, se han realizado pruebas enfocadas en evaluar la resistencia de la aplicación ante ataques de inyección de código, la protección de la interfaz frente a capturas no autorizadas y la correcta manipulación de datos en la UI. Además, se ha complementado el análisis con un estudio de seguridad estático utilizando MobSF (Mobile Security Framework), lo que ha permitido detectar riesgos en la configuración de permisos, la estructura del código y el almacenamiento de información.

Estas pruebas de seguridad combinan JUnit 4, AndroidJUnit4, Room Database en memoria, LiveData, coroutines, ActivityScenario, Espresso y CountDownLatch para verificar que la aplicación implementa protecciones contra capturas de pantalla, prevención de inyección SQL y correcto manejo de datos sensibles.

### Pruebas implementadas

1. **Protección contra inyección SQL** (SQLInjectionTest)  
   Se evalúa la seguridad de la base de datos frente a posibles ataques de inyección SQL.

2. **Uso del FLAG_SECURE** en la UI (SecureFlagTest)  
   Se comprueba si la aplicación impide la captura de pantalla y la grabación de contenido en vistas sensibles.

3. **Validación de LiveData** (LiveDataTestUtil)  
   Se asegura que los valores emitidos por LiveData son gestionados de manera segura.

### Análisis de seguridad estático con MobSF

Principales hallazgos:
- Uso de permisos sensibles (READ_MEDIA_IMAGES, READ_MEDIA_VISUAL_USER_SELECTED)
- Exportación de componentes (android:exported=true)
- Depuración activada (android:debuggable=true)
- Riesgo de almacenamiento inseguro

[VER INFORME MOBSF](https://drive.google.com/file/d/1SRvGmil0J6nnjrIQHFtU5aSXnfQbTuYS/view?usp=sharing)
![](blob:https://imgur.com/40f48d18-36b2-40d7-8ac3-bb49a74808bb)

## PRUEBAS DE USO DE RECURSOS

Las pruebas de uso de recursos miden cómo la aplicación consume componentes críticos del dispositivo como batería, almacenamiento y memoria.

En estas pruebas se ha combinado JUnit 4, AndroidJUnit4, Room Database en memoria, LiveData, coroutines, BatteryManager, PowerManager, InstrumentationRegistry y FakeNotesDao para verificar que la aplicación optimiza consumo de batería, gestiona almacenamiento de manera eficiente y previene un uso excesivo de recursos del dispositivo.

### 1. Validación de consumo eficiente de batería

**Clase de testeo:** BatteryUsageTest  
**Elementos probados:**
- PowerManager (gestión de WakeLocks)
- BatteryManager (medición de consumo energético)
- NotesViewModel (operaciones con Room Database)

**Resultado obtenido:**
- Consumo de batería ≤5% en la operación crítica
- Ausencia de WakeLocks residuales
- Estabilidad demostrada al manejar 1.000 operaciones de DB consecutivas

### 2. Gestión óptima de almacenamiento

**Clase de testeo:** StorageUsageTest  
**Elementos probados:**
- Almacenamiento interno del dispositivo
- FakeNotesDao (simulación de inserción de notas con imágenes)
- Gestión de archivos temporales

**Resultado obtenido:**
- El consumo medido coincidió con el esperado (5MB ±10%)
- Limpieza efectiva de archivos temporales post-prueba
- Integridad de datos (las URIs de imágenes se asociaron correctamente a las notas)


### 3. Análisis de recursos con Android Profiler  

Además de los tests automatizados, se ha utilizado **Android Profiler** para monitorear el consumo de recursos en tiempo real mientras la aplicación está en ejecución.  

**Elementos analizados:**  

**Capture System Activities:** Registro detallado de eventos del sistema durante la ejecución de la aplicación.  
![Capture System](https://i.imgur.com/6lSkuuG.jpeg)  

**CPU Hotspots:** Identificación de las funciones más demandantes en términos de procesamiento.  
![CPU Hotspots](https://i.imgur.com/KFrub4f.jpeg)  

**Memory Usage:** Monitorización del consumo de memoria, incluyendo el impacto de las operaciones con Room Database.  
![Memory Usage](https://i.imgur.com/vxpVdCL.jpeg)  

**Track Memory:** Seguimiento de asignaciones de memoria para detectar posibles fugas.  
![Track Memory](https://i.imgur.com/4YEdybg.jpeg)  

**View Live Telemetry:** Visualización en tiempo real del comportamiento de la aplicación bajo diferentes condiciones.  
![View Live Telemetry](https://i.imgur.com/Tu7mxbc.jpeg)  

Con esta herramienta de Android Studio, se pueden identificar **puntos de optimización** en la gestión de memoria y procesos en segundo plano, asegurando que la aplicación se mantenga fluida y eficiente.  


### Resultados generales

**Batería:**
- Operaciones masivas consumen menos del 5% de carga
- No se detectaron WakeLocks mal gestionadas

**Almacenamiento:**
- El uso de espacio es proporcional a los datos almacenados
- Los recursos temporales se liberan adecuadamente

