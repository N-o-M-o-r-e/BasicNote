package com.sntthanh.notebasic.activities.tutorial

import android.content.Intent
import android.util.Log
import com.sntthanh.notebasic.activities.MainActivity
import com.sntthanh.notebasic.activities.security.pincode.EnterPincodeActivity
import com.sntthanh.notebasic.activities.utils.HawkCommon
import com.sntthanh.notebasic.base.BaseActivityWithoutDataBiding
import com.sntthanh.notebasic.databinding.ActivitySplashBinding

class SplashActivity :
    BaseActivityWithoutDataBiding<ActivitySplashBinding>(ActivitySplashBinding::inflate) {
    override fun initData() {
        HawkCommon.putEventLanguage(false)
        HawkCommon.putHawkEventEnterPassCode(false)
    }

    override fun initView() {
        android.os.Handler().postDelayed({
            if (intent.getBooleanExtra("isView",false)){
                finish()
            }else{
                Log.e("AAAAAAAA", "initView Language: "+HawkCommon.getEventFirstApp() )
                if (HawkCommon.getEventFirstApp()){
                    if (HawkCommon.getHawkEventTurnPass()){
                        startActivity(Intent(this, EnterPincodeActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
                    }else{
                        startActivity(Intent(this, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
                    }
                }else{
                    startActivity(Intent(this, LanguageActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
                }
            }
        },3000)
    }

    override fun listenLiveData() {

    }

    override fun listeners() {

    }

}