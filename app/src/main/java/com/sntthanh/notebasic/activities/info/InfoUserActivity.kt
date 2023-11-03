package com.sntthanh.notebasic.activities.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sntthanh.notebasic.R
import com.sntthanh.notebasic.activities.security.pincode.CreatePincodeActivity
import com.sntthanh.notebasic.base.BaseActivityWithoutDataBiding
import com.sntthanh.notebasic.databinding.ActivityInfoUserBinding

class InfoUserActivity : BaseActivityWithoutDataBiding<ActivityInfoUserBinding>(ActivityInfoUserBinding::inflate) {
    override fun initData() {
        
    }

    override fun initView() {
        
    }

    override fun listenLiveData() {
        
    }

    override fun listeners() {
        binding.btnContinue.setOnClickListener {
            goToNewActivity(CreatePincodeActivity::class.java, true)
        }
    }

}