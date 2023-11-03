package com.sntthanh.notebasic.activities.tutorial

import android.content.Intent
import androidx.viewpager2.widget.ViewPager2
import com.sntthanh.notebasic.activities.MainActivity
import com.sntthanh.notebasic.activities.info.InfoUserActivity
import com.sntthanh.notebasic.base.BaseActivityWithoutDataBiding
import com.sntthanh.notebasic.databinding.ActivityIntroBinding
import com.sntthanh.notebasic.recyclerview.adapters.IntroPagerAdapter
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class IntroActivity :
    BaseActivityWithoutDataBiding<ActivityIntroBinding>(ActivityIntroBinding::inflate) {
    private lateinit var viewPager: ViewPager2
    private lateinit var dotsIndicator: DotsIndicator
    override fun initData() {
        viewPager = binding.viewPager2
        dotsIndicator = binding.dotsIndicator


        val adapter = IntroPagerAdapter(this)
        viewPager.adapter = adapter

        binding.btnContinue.setOnClickListener {
            val currentItem = viewPager.currentItem
            if (currentItem < adapter.itemCount - 1) {
                viewPager.currentItem = currentItem + 1
            } else {
                val intent = Intent(this, InfoUserActivity::class.java)
                startActivity(intent)
            }
        }
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                // Đây bạn có thể thực hiện xử lý khi trang được chọn
            }
        })

        dotsIndicator.setViewPager2(viewPager)
    }

    override fun initView() {

    }

    override fun listenLiveData() {

    }

    override fun listeners() {

    }

}