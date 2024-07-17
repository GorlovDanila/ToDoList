package com.example.feature.note.impl.domain.usecase

import com.example.feature.note.api.entity.Note
import com.example.feature.note.api.usecase.GetAllNotesUseCase
import com.example.feature.note.impl.domain.repository.NoteRepository

internal class GetAllNotesUseCaseImpl(
    private val noteRepository: NoteRepository,
) : GetAllNotesUseCase {

    override suspend fun invoke(): List<Note> = noteRepository.getNotes()
}