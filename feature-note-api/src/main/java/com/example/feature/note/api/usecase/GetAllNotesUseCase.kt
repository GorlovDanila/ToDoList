package com.example.feature.note.api.usecase

import com.example.feature.note.api.entity.Note

interface GetAllNotesUseCase {

    suspend operator fun invoke(): List<Note>
}
