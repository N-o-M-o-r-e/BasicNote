package com.project.tathanhson.basicnote.fragment

import android.os.Bundle
import android.view.View
import com.project.tathanhson.basicnote.R
import com.project.tathanhson.basicnote.model.Folder


class Search : NoteViewFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.ChipGroup?.visibility = View.VISIBLE
        binding?.RecyclerView?.scrollIndicators = View.SCROLL_INDICATOR_TOP
        super.onViewCreated(view, savedInstanceState)

        val checked = when (model.folder) {
            Folder.NOTES -> R.id.Notes
            Folder.DELETED -> R.id.Deleted
            Folder.ARCHIVED -> R.id.Archived
        }

        binding?.ChipGroup?.check(checked)

        binding?.ChipGroup?.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.Notes -> model.folder = Folder.NOTES
                R.id.Deleted -> model.folder = Folder.DELETED
                R.id.Archived -> model.folder = Folder.ARCHIVED
            }
        }
    }


    override fun getBackground() = R.drawable.search

    override fun getObservable() = model.searchResults
}