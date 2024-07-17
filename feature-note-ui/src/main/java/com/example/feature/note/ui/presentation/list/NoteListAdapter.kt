package com.example.feature.note.ui.presentation.list

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.feature.note.ui.presentation.model.NoteItem
import com.example.feature.note.ui.presentation.util.NoteDiffUtil
import com.example.feature_note_ui.R
import java.lang.IllegalStateException

class NoteListAdapter : ListAdapter<NoteItem, RecyclerView.ViewHolder>(NoteDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            R.layout.item_note -> NoteHolder.create(parent)
            else -> throw IllegalStateException("Unknown item type!")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = currentList[position]
        when (holder) {
            is NoteHolder -> holder.onBind(currentItem as NoteItem)
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (currentList[position]) {
            is NoteItem -> R.layout.item_note
            else -> throw IllegalArgumentException("Unknown item type!")
        }
}
