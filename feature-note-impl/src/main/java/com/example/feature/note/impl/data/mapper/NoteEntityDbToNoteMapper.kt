package com.example.feature.note.impl.data.mapper

import com.example.feature.note.api.entity.Note
import com.example.feature.note.impl.data.db.entity.NoteEntityDb

internal class NoteEntityDbToNoteMapper {

    fun toDb(note: Note): NoteEntityDb = with(note) {
        return NoteEntityDb(
            title = title,
            description = description,
        )
    }

    fun toDomain(noteEntityDb: NoteEntityDb): Note = with(noteEntityDb) {
        return Note(
            title = title,
            description = description,
        )
    }
}