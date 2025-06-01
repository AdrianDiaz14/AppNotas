package com.example.appnotas.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Clase abstracta que representa la base de datos de Room para las notas.
 *
 * Esta clase utiliza Room como ORM para conectar las entidades con los DAOs.
 *
 * @see Notes Para las entidades gestionadas por la base de datos.
 * @see NotesDao Para los métodos de acceso a datos.
 *
 * @property notesDao Método abstracto para obtener el DAO de notas
 *
 * @author Adrian Diaz
 * @since 1.0
 */
@Database(entities = [Notes::class], version = 3, exportSchema = false)
abstract class NotesRoomDatabase : RoomDatabase() {

    /**
     * Proporciona acceso al DAO de notas.
     *
     * @return DAO para interactuar con notas en la base de datos.
     */
    abstract fun notesDao(): NotesDao

    companion object {
        @Volatile
        private var INSTANCE: NotesRoomDatabase? = null

        /**
         * Obtiene la instancia de la base de datos.
         * @param context Contexto de la aplicación
         * @param scope CoroutineScope para operaciones asíncronas
         * @return Instancia singleton de la base de datos
         * @throws IllegalStateException Si la base de datos no puede ser inicializada.
         */
        fun getDatabase(context: Context, scope: CoroutineScope): NotesRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesRoomDatabase::class.java,
                    "note_database"
                )
                    .addCallback(NoteDatabaseCallback(scope))
                    .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                    .build()
                INSTANCE = instance
                instance
            }
        }

        /**
         * Migración de la versión 1 a la versión 2 de la base de datos.
         * En esta migración, se añade el campo `imageUris` a la tabla `Notes`.
         */        private val MIGRATION_1_2 = object : Migration(1, 2) {
            /**
             * Ejecuta las instrucciones SQL necesarias para realizar la migración.
             *
             * @param database Base de datos SQLite sobre la que se ejecuta la migración.
             */
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Notes ADD COLUMN imageUris TEXT")
            }
        }

        /**
         * Migración de la versión 2 a la versión 3 de la base de datos.
         * En esta migración, se añaden los campos `isDeleted` y `deletionDate` a la tabla `Notes`.
         */        private val MIGRATION_2_3 = object : Migration(2, 3) {
            /**
             * Ejecuta las instrucciones SQL necesarias para realizar la migración.
             *
             * @param database Base de datos SQLite sobre la que se ejecuta la migración.
             */
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Notes ADD COLUMN isDeleted INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE Notes ADD COLUMN deletionDate INTEGER")
            }
        }
    }

    /**
     * Callback para poblar la base de datos al crearse.
     * @property scope CoroutineScope para operaciones asíncronas
     */
    private class NoteDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        /**
         * Callback que se ejecuta al crear la base de datos.
         * Este método permite inicializar la base de datos con datos predeterminados
         * al momento de su creación.
         *
         * @param db Base de datos SQLite recién creada.
         */
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.notesDao())
                }
            }
        }

        /**
         * Inserta datos iniciales en la base de datos.
         * @param notesDao DAO para operaciones con notas
         */
        suspend fun populateDatabase(notesDao: NotesDao) {
            notesDao.insertNote(
                Notes(
                    title = "Consejo #1",
                    description = "Mantén pulsado una nota para seleccionarla",
                    isDeleted = false
                )
            )
            notesDao.insertNote(
                Notes(
                    title = "Consejo #2",
                    description = "Desliza para eliminar notas",
                    isDeleted = false
                )
            )
            notesDao.insertNote(
                Notes(
                    title = "Consejo #3",
                    description = "Ve a la papelera para recuperar notas eliminadas",
                    isDeleted = false
                )
            )
        }
    }
}