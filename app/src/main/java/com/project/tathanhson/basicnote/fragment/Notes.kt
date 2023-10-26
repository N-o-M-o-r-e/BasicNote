package com.project.tathanhson.basicnote.fragment

import android.view.Menu
import android.view.MenuInflater
import androidx.navigation.fragment.findNavController
import com.project.tathanhson.basicnote.R
import com.project.tathanhson.basicnote.miscellaneous.add

class Notes : NoteViewFragment() {

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.add(R.string.search,R.drawable.search) {
            findNavController().navigate(R.id.NotesToSearch)
        }
    }


    override fun getObservable() = model.baseNotes

    override fun getBackground() = R.drawable.notebook
}