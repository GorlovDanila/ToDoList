package com.example.feature.note.ui.presentation.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.feature.note.ui.presentation.model.NoteItem
import com.example.feature.note.ui.presentation.util.DialogResultListener
import com.example.feature_note_ui.R
import com.example.feature_note_ui.databinding.FragmentDialogBinding

internal class AddNoteDialogFragment : DialogFragment() {

    internal lateinit var listener: DialogResultListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)

        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.fragment_dialog, null)
        val binding: FragmentDialogBinding = FragmentDialogBinding.bind(view)
        builder.setView(view)
            .setTitle("New note")
            .setPositiveButton("OK") { dialog, _ ->
                with(binding) {
                    listener.onDialogResult(NoteItem(etTitle.text.toString(), etDescription.text.toString()))
                }
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }

        return builder.create()
    }
}