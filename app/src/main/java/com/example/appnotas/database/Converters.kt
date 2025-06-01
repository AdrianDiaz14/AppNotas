package com.example.appnotas.database

import androidx.room.TypeConverter

/**
 * Convertidores personalizados para Room que permiten almacenar tipos complejos.
 * Convierte entre List<String> y String para almacenar URIs de imágenes.
 *
 * @author Adrian Diaz
 * @since 1.0
 */
class Converters {

    /**
     * Convierte una List<String> a un String separado por comas.
     * @param value Lista de strings a convertir
     * @return String concatenado o null
     */
    @TypeConverter
    fun fromStringList(value: List<String>?): String? {
        return value?.joinToString(",")
    }

    /**
     * Convierte un String separado por comas a List<String>.
     * @param value String a convertir
     * @return Lista de strings o null
     */
    @TypeConverter
    fun toStringList(value: String?): List<String>? {
        return value?.split(",")
    }
}