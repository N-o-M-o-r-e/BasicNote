package com.sntthanh.notebasic.fragments

import android.view.Menu
import android.view.MenuInflater
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.sntthanh.notebasic.R
import com.sntthanh.notebasic.miscellaneous.add

class Deleted : NotallyFragment() {

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.add(R.string.delete_all, R.drawable.delete_all) { deleteAllNotes() }
    }


    private fun deleteAllNotes() {
        MaterialAlertDialogBuilder(requireContext())
            .setMessage(R.string.delete_all_notes)
            .setPositiveButton(R.string.delete) { _, _ -> model.deleteAllBaseNotes() }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }


    override fun getBackground() = R.drawable.delete

    override fun getObservable() = model.deletedNotes
}