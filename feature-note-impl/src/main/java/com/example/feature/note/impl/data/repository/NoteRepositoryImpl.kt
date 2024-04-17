package com.example.feature.note.impl.data.repository

import com.example.feature.note.api.entity.Note
import com.example.feature.note.impl.data.db.dao.NoteDao
import com.example.feature.note.impl.data.mapper.NoteEntityDbToNoteMapper
import com.example.feature.note.impl.domain.repository.NoteRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class NoteRepositoryImpl(
    private val noteDao: NoteDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val noteEntityDbToNoteMapper: NoteEntityDbToNoteMapper,
) : NoteRepository {

    override suspend fun getNotes(): List<Note> =
        withContext(dispatcher) { noteDao.getAll().map { noteEntityDbToNoteMapper.toDomain(it) } }

    override suspend fun addNote(note: Note) =
        withContext(dispatcher) { noteDao.save(noteEntityDbToNoteMapper.toDb(note)) }
}
