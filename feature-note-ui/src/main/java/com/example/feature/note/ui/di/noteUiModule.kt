package com.example.feature.note.ui.di

import com.example.feature.note.ui.presentation.mapper.NoteToNoteItemMapper
import com.example.feature.note.ui.presentation.presenter.NoteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val noteUiModule = module {
    single {
        provideNoteToNoteItemMapper()
    }
    viewModel { NoteViewModel(get(), get(), get()) }

}

private fun provideNoteToNoteItemMapper() = NoteToNoteItemMapper()