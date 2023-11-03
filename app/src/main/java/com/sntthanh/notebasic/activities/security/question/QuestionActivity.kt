package com.sntthanh.notebasic.activities.security.question

import android.annotation.SuppressLint
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import com.sntthanh.notebasic.activities.MainActivity
import com.sntthanh.notebasic.activities.utils.HawkCommon
import com.sntthanh.notebasic.base.BaseActivityWithoutDataBiding
import com.sntthanh.notebasic.databinding.ActivityQuestionBinding

class QuestionActivity :
    BaseActivityWithoutDataBiding<ActivityQuestionBinding>(ActivityQuestionBinding::inflate) {
    private lateinit var answer: String
    override fun initData() {

    }

    override fun initView() {

    }

    @SuppressLint("ClickableViewAccessibility")
    override fun listenLiveData() {
        binding.spinnerView.apply {
            setOnSpinnerItemSelectedListener<String> { _, _, _, item ->

                HawkCommon.putHawkQuestion(item)
            }

            setOnSpinnerDismissListener {

            }
            setOnTouchListener { _, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        binding.spinnerView.show()
                    }
                }
                return@setOnTouchListener true
            }
        }
    }

    override fun listeners() {
        binding.imageButton.setOnClickListener {

        }


        binding.btnOk.setOnClickListener {

            answer = binding.edtAnswer.text.toString().trim()
            if (HawkCommon.getHawkQuestion().isEmpty()) {
                Toast.makeText(this, "Please enter your question", Toast.LENGTH_SHORT).show()
            } else {
                if (answer == "") {
                    Toast.makeText(
                        this,
                        "Please enter your answer",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    HawkCommon.putHawkAnswer(answer)
                    Toast.makeText(
                        this,
                        "The answer has been saved!",
                        Toast.LENGTH_SHORT
                    ).show()
                    goToNewActivity(MainActivity::class.java, true)
                    Log.e("AAAAAAAAA", "listeners: ${HawkCommon.getHawkAnswer()}")
                }
            }
            Log.e("AAAAAAAAAAAAAA", "qs "+HawkCommon.getHawkQuestion() )
            Log.e("AAAAAAAAAAAAAA", "as "+HawkCommon.getHawkAnswer() )
        }
    }
}