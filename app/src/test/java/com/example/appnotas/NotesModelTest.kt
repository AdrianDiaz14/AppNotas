package com.example.appnotas

import com.example.appnotas.database.Notes
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Test

class NotesModelTest {
    @Test
    fun `should create note with current timestamp`() {
        val note = Notes(title = "Test", description = "Content")
        assertTrue(note.date > 0) // Verifica que la fecha se establezca
    }

    @Test
    fun `should mark note as deleted`() {
        val note = Notes(title = "Test", description = "Content").apply {
            isDeleted = true
            deletionDate = System.currentTimeMillis()
        }
        assertTrue(note.isDeleted)
        assertNotNull(note.deletionDate)
    }
}