package com.sntthanh.notebasic.fragments

import com.sntthanh.notebasic.R

class Archived : NotallyFragment() {

    override fun getBackground() = R.drawable.archive

    override fun getObservable() = model.archivedNotes
}