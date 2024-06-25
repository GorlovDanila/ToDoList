package com.example.feature.note.ui.presentation.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature.note.api.usecase.AddNoteUseCase
import com.example.feature.note.api.usecase.GetAllNotesUseCase
import com.example.feature.note.ui.presentation.mapper.NoteToNoteItemMapper
import com.example.feature.note.ui.presentation.model.NoteItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class NoteViewModel(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val addNoteUseCase: AddNoteUseCase,
    private val noteToNoteItemMapper: NoteToNoteItemMapper,
) : ViewModel() {

    private val _notesList = MutableStateFlow<List<NoteItem>?>(null)
    val notesList: StateFlow<List<NoteItem>?>
        get() = _notesList.asStateFlow()

    fun getNotes() {
        viewModelScope.launch {
            _notesList.emit(
                value = getAllNotesUseCase().map { noteToNoteItemMapper.toPresentation(it) }
            )
        }
    }

    fun saveNote(noteItem: NoteItem) {
        viewModelScope.launch {
            addNoteUseCase(noteToNoteItemMapper.toDomain(noteItem))
            getNotes()
        }
    }
}