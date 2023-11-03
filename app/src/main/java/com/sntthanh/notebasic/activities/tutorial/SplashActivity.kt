package com.sntthanh.notebasic.activities.tutorial

import android.content.Intent
import com.sntthanh.notebasic.base.BaseActivityWithoutDataBiding
import com.sntthanh.notebasic.databinding.ActivitySplashBinding

class SplashActivity :
    BaseActivityWithoutDataBiding<ActivitySplashBinding>(ActivitySplashBinding::inflate) {
    override fun initData() {

    }

    override fun initView() {
        android.os.Handler().postDelayed({
            if (intent.getBooleanExtra("isView",false)){
                finish()
            }else{
                startActivity(Intent(this, LanguageActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
            }
        },10000)
    }

    override fun listenLiveData() {

    }

    override fun listeners() {

    }

}