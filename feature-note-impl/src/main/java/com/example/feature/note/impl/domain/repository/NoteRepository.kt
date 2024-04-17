package com.example.feature.note.impl.domain.repository

import com.example.feature.note.api.entity.Note

interface NoteRepository {

    suspend fun getNotes(): List<Note>

    suspend fun addNote(note: Note)
}
