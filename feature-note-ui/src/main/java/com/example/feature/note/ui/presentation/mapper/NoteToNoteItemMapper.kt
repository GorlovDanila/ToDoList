package com.example.feature.note.ui.presentation.mapper

import com.example.feature.note.api.entity.Note
import com.example.feature.note.ui.presentation.model.NoteItem

internal class NoteToNoteItemMapper {

    fun toPresentation(note: Note) = with(note) {
        NoteItem(
            title = title,
            description = description,
        )
    }

    fun toDomain(noteItem: NoteItem) = with(noteItem) {
        Note(
            title = title,
            description = description,
        )
    }
}