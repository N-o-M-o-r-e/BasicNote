package com.sntthanh.notebasic.fragment.category

import android.view.Menu
import android.view.MenuInflater
import androidx.navigation.fragment.findNavController
import com.sntthanh.notebasic.R
import com.sntthanh.notebasic.fragment.NotallyFragment
import com.sntthanh.notebasic.miscellaneous.add

class Notes : NotallyFragment() {

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.add(
            R.string.search,
            R.drawable.search
        ) { findNavController().navigate(R.id.NotesToSearch) }
    }


    override fun getObservable() = model.baseNotes

    override fun getBackground() = R.drawable.notebook
}