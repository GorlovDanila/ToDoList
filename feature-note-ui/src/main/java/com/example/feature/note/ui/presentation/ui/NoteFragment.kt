package com.example.feature.note.ui.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.feature.note.ui.presentation.list.NoteListAdapter
import com.example.feature.note.ui.presentation.model.NoteItem
import com.example.feature.note.ui.presentation.presenter.NoteViewModel
import com.example.feature.note.ui.presentation.util.DialogResultListener
import com.example.feature_note_ui.R
import com.example.feature_note_ui.databinding.FragmentNoteBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class NoteFragment : Fragment(R.layout.fragment_note), DialogResultListener {

    private var binding: FragmentNoteBinding? = null
    private lateinit var listAdapter: NoteListAdapter
    private val viewModel: NoteViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNoteBinding.bind(view)
           binding?.run {
            fab.setOnClickListener {
                val dialogFragment = AddNoteDialogFragment()
                dialogFragment.listener = this@NoteFragment
                dialogFragment.show(parentFragmentManager, "AddNoteDialogFragment")
            }
        }
        setUpList(binding)
        observeViewModel()
        viewModel.getNotes()
    }

    private fun setUpList(binding: FragmentNoteBinding?) {
        listAdapter = NoteListAdapter()
        val layoutManager = GridLayoutManager(context, 2)
        with(binding?.rvNotes) {
            this?.adapter = listAdapter
            this?.layoutManager = layoutManager
        }
    }

    private fun observeViewModel() {
        with(viewModel) {
            viewLifecycleOwner.lifecycleScope.launch {
                notesList
                    .flowWithLifecycle(
                        viewLifecycleOwner.lifecycle,
                    )
                    .collect {
                        it?.let {
                            listAdapter.submitList(it)
                        } ?: return@collect
                    }
            }
        }
    }

    override fun onDialogResult(noteItem: NoteItem) {
        viewModel.saveNote(noteItem)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
