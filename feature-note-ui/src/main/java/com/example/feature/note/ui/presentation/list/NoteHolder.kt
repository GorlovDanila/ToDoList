package com.example.feature.note.ui.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.feature.note.ui.presentation.model.NoteItem
import com.example.feature_note_ui.databinding.ItemNoteBinding

class NoteHolder(
    private val binding: ItemNoteBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(noteItem: NoteItem) {
        with(binding) {
            tvTitle.text = noteItem.title
            tvDescription.text = noteItem.description
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
        ): NoteHolder = NoteHolder(
            binding = ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
        )
    }
}