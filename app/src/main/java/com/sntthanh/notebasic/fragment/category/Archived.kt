package com.sntthanh.notebasic.fragment.category

import com.sntthanh.notebasic.R
import com.sntthanh.notebasic.fragment.NotallyFragment

class Archived : NotallyFragment() {

    override fun getBackground() = R.drawable.archive

    override fun getObservable() = model.archivedNotes
}