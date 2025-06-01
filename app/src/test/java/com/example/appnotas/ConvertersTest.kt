package com.example.appnotas

import com.example.appnotas.database.Converters
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import org.junit.Test

// test/ConvertersTest.kt
class ConvertersTest {
    private val converters = Converters()

    @Test
    fun `should convert string list to comma-separated string`() {
        val result = converters.fromStringList(listOf("uri1", "uri2"))
        assertEquals("uri1,uri2", result)
    }

    @Test
    fun `should handle null in string list conversion`() {
        assertNull(converters.fromStringList(null))
    }
}