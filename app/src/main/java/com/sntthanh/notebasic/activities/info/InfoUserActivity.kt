package com.sntthanh.notebasic.activities.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.sntthanh.notebasic.R
import com.sntthanh.notebasic.activities.security.pincode.CreatePincodeActivity
import com.sntthanh.notebasic.activities.utils.HawkCommon
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
            if (binding.edtName.text.isEmpty()){
                Toast.makeText(this, "Please input your name.", Toast.LENGTH_SHORT).show()
            }else{
                HawkCommon.putHawkName(binding.edtName.text.toString())
                Log.e("AAAAAAA", "listeners: "+HawkCommon.getHawkName(), )
                goToNewActivity(CreatePincodeActivity::class.java)
            }

        }
    }

}