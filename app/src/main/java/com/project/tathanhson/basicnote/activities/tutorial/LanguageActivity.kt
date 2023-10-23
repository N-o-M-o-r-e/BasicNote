package com.project.tathanhson.basicnote.activities.tutorial

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.project.tathanhson.basicnote.activities.MainActivity
import com.project.tathanhson.basicnote.base.BaseActivityWithoutDataBiding
import com.project.tathanhson.basicnote.databinding.ActivityLanguageBinding
import com.project.tathanhson.basicnote.recyclerview.adapters.LanguageAdapter
import com.project.tathanhson.basicnote.utils.Common
import com.project.tathanhson.basicnote.utils.HawkCommon

class LanguageActivity :
    BaseActivityWithoutDataBiding<ActivityLanguageBinding>(ActivityLanguageBinding::inflate) {

    var screen = false
    var adapter: LanguageAdapter? = null


    override fun initData() {
        screen = intent.getBooleanExtra(Constant.KEY_SCREEN, false)

    }

    override fun initView() {

        if (!HawkCommon.getEventLanguage()) {
            binding.btnBack.visibility = View.GONE

        } else {
            binding.btnBack.visibility = View.VISIBLE
        }
    }

    override fun listenLiveData() {

    }

    override fun listeners() {
        doneLanguage()
        loadDataLanguage()
        btnBackListener()
    }

    private fun btnBackListener() {
        binding.btnBack.setOnClickListener {
            finish()
        }

    }

    private fun loadDataLanguage() {
        adapter = LanguageAdapter(this)
        adapter!!.updateSelected(HawkCommon.getHawkLanguage())
        binding.scrollView.apply {
            layoutManager = GridLayoutManager(context, 1)
        }
        binding.scrollView.adapter = adapter
    }

    private fun doneLanguage() {


        binding.btnDone.setOnClickListener {
            Common.setLanguagePosition(this, adapter!!.getSelectedPositionLanguage())
            HawkCommon.putHawkLanguage(adapter!!.getSelectedPositionLanguage())

            if (!HawkCommon.getEventLanguage()) {
                if (!HawkCommon.getEventAppOpen()) {
                    startActivity(
                        Intent(this@LanguageActivity, IntroActivity::class.java).addFlags(
                            Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        )
                    )
                } else {
                    startActivity(
                        Intent(this@LanguageActivity, IntroActivity::class.java).addFlags(
                            Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        )
                    )
                }
            } else {
                startActivity(
                    Intent(this@LanguageActivity, IntroActivity::class.java).addFlags(
                        Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    )
                )
            }

        }
    }

}

object Constant {
    const val KEY_SCREEN = "key_screen"
}