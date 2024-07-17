package com.example.feature.note.impl.di

import com.example.feature.note.api.usecase.AddNoteUseCase
import com.example.feature.note.api.usecase.GetAllNotesUseCase
import com.example.feature.note.impl.data.db.dao.NoteDao
import com.example.feature.note.impl.data.mapper.NoteEntityDbToNoteMapper
import com.example.feature.note.impl.data.repository.NoteRepositoryImpl
import com.example.feature.note.impl.domain.repository.NoteRepository
import com.example.feature.note.impl.domain.usecase.AddNoteUseCaseImpl
import com.example.feature.note.impl.domain.usecase.GetAllNotesUseCaseImpl
import org.koin.dsl.module

val noteImplModule = module {
    single {
        provideNoteEntityDbToNoteMapper()
    }
    single {
        provideNoteRepository(
            noteDao = get(),
            noteEntityDbToNoteMapper = get()
        )
    }
    single {
        provideAddNoteUseCase(
            noteRepository = get()
        )
    }
    single {
        provideGetAllNotesUseCase(
            noteRepository = get()
        )
    }
}

private fun provideNoteEntityDbToNoteMapper(): NoteEntityDbToNoteMapper = NoteEntityDbToNoteMapper()

private fun provideNoteRepository(
    noteDao: NoteDao,
    noteEntityDbToNoteMapper: NoteEntityDbToNoteMapper,
): NoteRepository =
    NoteRepositoryImpl(noteDao = noteDao, noteEntityDbToNoteMapper = noteEntityDbToNoteMapper)

private fun provideAddNoteUseCase(
    noteRepository: NoteRepository,
): AddNoteUseCase = AddNoteUseCaseImpl(noteRepository)

private fun provideGetAllNotesUseCase(
    noteRepository: NoteRepository,
): GetAllNotesUseCase = GetAllNotesUseCaseImpl(noteRepository)