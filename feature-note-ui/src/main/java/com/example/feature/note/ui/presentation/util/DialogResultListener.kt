package com.example.feature.note.ui.presentation.util

import com.example.feature.note.ui.presentation.model.NoteItem

internal fun interface DialogResultListener {

    fun onDialogResult(noteItem: NoteItem)
}