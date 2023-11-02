package com.sntthanh.notebasic.recyclerview.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sntthanh.notebasic.fragments.Intro_01_Fragment
import com.sntthanh.notebasic.fragments.Intro_02_Fragment
import com.sntthanh.notebasic.fragments.Intro_03_Fragment


class IntroPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> Intro_01_Fragment()
            1 -> Intro_02_Fragment()
            2 -> Intro_03_Fragment()
            else -> Intro_01_Fragment()
        }
    }

    override fun getItemCount(): Int {

        return 3
    }
}
