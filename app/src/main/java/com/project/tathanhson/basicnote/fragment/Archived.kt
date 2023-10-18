package com.project.tathanhson.basicnote.fragment

import com.project.tathanhson.basicnote.R

class Archived : NoteViewFragment() {

    override fun getBackground() = R.drawable.archive

    override fun getObservable() = model.archivedNotes
}