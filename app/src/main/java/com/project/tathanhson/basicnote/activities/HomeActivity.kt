package com.project.tathanhson.basicnote.activities

import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.project.tathanhson.basicnote.R
import com.project.tathanhson.basicnote.base.BaseActivityWithoutDataBiding
import com.project.tathanhson.basicnote.databinding.ActivityHomeBinding
import com.project.tathanhson.basicnote.fragment.Archived
import com.project.tathanhson.basicnote.fragment.Deleted
import com.project.tathanhson.basicnote.fragment.Labels
import com.project.tathanhson.basicnote.fragment.NoteViewFragment
import com.project.tathanhson.basicnote.fragment.Notes
import com.project.tathanhson.basicnote.fragment.Search
import com.project.tathanhson.basicnote.fragment.Settings

class HomeActivity :
    BaseActivityWithoutDataBiding<ActivityHomeBinding>(ActivityHomeBinding::inflate) {
    var fragmentIdToLoad: Int = 1
    var i = 0
    override fun initData() {

    }

    override fun initView() {

    }

    override fun listenLiveData() {
        setupNavigation()
    }

    private fun setupNavigation() {
        binding.Notes.setOnClickListener {
//            replaceFragment(NoteViewFragment())
        }
        binding.Labels.setOnClickListener {
            replaceFragment(Labels())
        }
        binding.Archived.setOnClickListener {
            replaceFragment(Archived())
        }
        binding.Settings.setOnClickListener {
            replaceFragment(Settings())
        }

    }

    override fun listeners() {
        binding.btnSearching.setOnClickListener {
            i++
            if (i % 2 == 0) {
                binding.titleName.visibility = View.GONE
                binding.EnterSearchKeyword.visibility = View.VISIBLE
            } else {
                binding.titleName.visibility = View.VISIBLE
                binding.EnterSearchKeyword.visibility = View.GONE
            }

        }
    }

    private fun replaceFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
        supportActionBar?.title = title
        return true
    }

}