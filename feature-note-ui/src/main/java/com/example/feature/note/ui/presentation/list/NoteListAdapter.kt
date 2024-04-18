package com.example.feature.note.ui.presentation.list

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.feature.note.ui.presentation.model.NoteItem
import com.example.feature_note_ui.R
import java.lang.IllegalStateException

class NoteListAdapter(
//    private val actionAdd: (NoteItem) -> Unit,
) : ListAdapter<NoteItem, RecyclerView.ViewHolder>(
    object : DiffUtil.ItemCallback<NoteItem>() {
        override fun areItemsTheSame(
            oldItem: NoteItem,
            newItem: NoteItem,
        ): Boolean = (oldItem as? NoteItem)?.title == (newItem as? NoteItem)?.title

        override fun areContentsTheSame(
            oldItem: NoteItem,
            newItem: NoteItem
        ): Boolean = oldItem == newItem
    }
) {
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
