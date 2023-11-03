package com.sntthanh.notebasic.activities.security.question

import android.util.Log
import android.widget.Toast
import com.sntthanh.notebasic.R
import com.sntthanh.notebasic.activities.security.pincode.CreatePincodeActivity
import com.sntthanh.notebasic.activities.utils.HawkCommon
import com.sntthanh.notebasic.base.BaseActivityWithoutDataBiding
import com.sntthanh.notebasic.databinding.ActivityAnswerBinding

class AnswerActivity :
    BaseActivityWithoutDataBiding<ActivityAnswerBinding>(ActivityAnswerBinding::inflate) {

    override fun initData() {

    }

    override fun initView() {
        binding.spinnerView.text = HawkCommon.getHawkQuestion()
    }

    override fun listenLiveData() {

    }

    override fun listeners() {
        binding.btnOk.setOnClickListener {
            val answer = binding.edtAnswer.text.trim()
            val answerCheck = HawkCommon.getHawkAnswer().trim()
            if (answer.toString() == answerCheck.toString()) {
                goToNewActivity(CreatePincodeActivity::class.java, true)
                Toast.makeText(this, R.string.success, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, R.string.wrong_answer_please_reply_again, Toast.LENGTH_SHORT)
                    .show()
                Log.e("AAAAAAAAAA", "edtAnswer = $answer  hawkAnswer = $answerCheck")
            }
        }
    }
}