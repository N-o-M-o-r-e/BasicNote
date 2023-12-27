package com.sntthanh.notebasic.fragment.category

import androidx.lifecycle.LiveData
import com.sntthanh.notebasic.R
import com.sntthanh.notebasic.fragment.NotallyFragment
import com.sntthanh.notebasic.miscellaneous.Constants
import com.sntthanh.notebasic.room.Item

class DisplayLabel : NotallyFragment() {

    override fun getBackground() = R.drawable.label

    override fun getObservable(): LiveData<List<Item>> {
        val label = requireNotNull(requireArguments().getString(Constants.SelectedLabel))
        return model.getNotesByLabel(label)
    }
}