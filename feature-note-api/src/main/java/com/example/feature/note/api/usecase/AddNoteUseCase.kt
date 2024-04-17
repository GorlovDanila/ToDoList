package com.example.feature.note.api.usecase

import com.example.feature.note.api.entity.Note

interface AddNoteUseCase {

    suspend operator fun invoke(note: Note)
}