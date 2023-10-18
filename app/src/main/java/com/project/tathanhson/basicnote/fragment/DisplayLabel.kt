package com.project.tathanhson.basicnote.fragment

import androidx.lifecycle.LiveData
import com.project.tathanhson.basicnote.R
import com.project.tathanhson.basicnote.miscellaneous.Constants
import com.project.tathanhson.basicnote.model.Item

class DisplayLabel : NoteViewFragment() {

    override fun getBackground() = R.drawable.label

    override fun getObservable(): LiveData<List<Item>> {
        val label = requireNotNull(requireArguments().getString(Constants.SelectedLabel))
        return model.getNotesByLabel(label)
    }
}