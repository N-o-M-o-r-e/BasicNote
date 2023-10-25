package com.project.tathanhson.basicnote.activities.tutorial

import android.content.Intent
import com.project.tathanhson.basicnote.base.BaseActivityWithoutDataBiding
import com.project.tathanhson.basicnote.databinding.ActivitySplashBinding
import java.util.logging.Handler

class SplashActivity :
    BaseActivityWithoutDataBiding<ActivitySplashBinding>(ActivitySplashBinding::inflate) {
    override fun initData() {

    }

    override fun initView() {

    }

    override fun listenLiveData() {

    }

    override fun listeners() {
        android.os.Handler().postDelayed({
            if (intent.getBooleanExtra("isView",false)){
                finish()
            }else{
                startActivity(Intent(this, LanguageActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
            }
        },1000)
    }

}