package com.sntthanh.notebasic.activities.info

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.sntthanh.notebasic.activities.MainActivity
import com.sntthanh.notebasic.activities.security.pincode.CreatePincodeActivity
import com.sntthanh.notebasic.activities.utils.HawkCommon
import com.sntthanh.notebasic.base.BaseActivityWithoutDataBiding
import com.sntthanh.notebasic.databinding.ActivityInfoUserBinding
import com.sntthanh.notebasic.databinding.DialogDoYouWantSetPasscodeBinding

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
            } else {
                HawkCommon.putHawkName(binding.edtName.text.toString())
                if (!intent.getBooleanExtra("SETTING_INFO", true) || !HawkCommon.getEventFirstApp()) {
                    showDialogSetPasscode()
                } else {
                    goToNewActivity(MainActivity::class.java, true)
                }
            }

        }
    }

    private fun showDialogSetPasscode() {
        val mBinding: DialogDoYouWantSetPasscodeBinding =
            DialogDoYouWantSetPasscodeBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(this).create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        mBinding.btnSkip.setOnClickListener {
            HawkCommon.putHawkEventTurnPass(false)
            goToNewActivity(MainActivity::class.java, true)
            dialog.dismiss()
        }
        mBinding.btnOk.setOnClickListener {
            HawkCommon.putHawkEventTurnPass(true)

            Log.e("AAAAAAA", "listeners: " + HawkCommon.getHawkName())
            goToNewActivity(CreatePincodeActivity::class.java)
            dialog.dismiss()
        }
        dialog.setView(mBinding.root)
        dialog.show()
    }

}