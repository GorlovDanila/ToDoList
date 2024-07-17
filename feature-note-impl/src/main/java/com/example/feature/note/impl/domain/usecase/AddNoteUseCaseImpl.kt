package com.example.feature.note.impl.domain.usecase

import com.example.feature.note.api.entity.Note
import com.example.feature.note.api.usecase.AddNoteUseCase
import com.example.feature.note.impl.domain.repository.NoteRepository

internal class AddNoteUseCaseImpl(
    private val noteRepository: NoteRepository,
) : AddNoteUseCase {

    override suspend fun invoke(note: Note) = noteRepository.addNote(note)
}