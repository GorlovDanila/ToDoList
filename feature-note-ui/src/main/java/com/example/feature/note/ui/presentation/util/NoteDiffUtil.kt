package com.example.feature.note.ui.presentation.util

import androidx.recyclerview.widget.DiffUtil
import com.example.feature.note.ui.presentation.model.NoteItem

object NoteDiffUtil : DiffUtil.ItemCallback<NoteItem>() {
    override fun areItemsTheSame(
        oldItem: NoteItem,
        newItem: NoteItem,
    ): Boolean = (oldItem as? NoteItem)?.title == (newItem as? NoteItem)?.title

    override fun areContentsTheSame(
        oldItem: NoteItem,
        newItem: NoteItem
    ): Boolean = oldItem == newItem
}