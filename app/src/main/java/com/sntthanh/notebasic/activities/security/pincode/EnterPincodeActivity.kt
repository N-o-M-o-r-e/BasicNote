package com.sntthanh.notebasic.activities.security.pincode

import android.content.Intent
import android.util.Log
import android.view.View
import com.sntthanh.notebasic.R
import com.sntthanh.notebasic.activities.MainActivity
import com.sntthanh.notebasic.activities.utils.HawkCommon
import com.sntthanh.notebasic.base.BaseActivityWithoutDataBiding
import com.sntthanh.notebasic.databinding.ActivityEnterPincodeBinding

class EnterPincodeActivity :
    BaseActivityWithoutDataBiding<ActivityEnterPincodeBinding>(ActivityEnterPincodeBinding::inflate) {
    private var listPass = ArrayList<Int>()
    override fun initData() {

    }

    override fun initView() {

    }

    override fun listenLiveData() {

    }

    override fun listeners() {
        listenersInputPass()
    }

    private fun listenersInputPass() {
        binding.pc0.setOnClickListener {
            listPass.add(0)
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
            checkList()
        }
        binding.pc1.setOnClickListener {
            listPass.add(1)
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
            checkList()
        }
        binding.pc2.setOnClickListener {
            listPass.add(2)
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
            checkList()
        }
        binding.pc3.setOnClickListener {
            listPass.add(3)
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
            checkList()
        }
        binding.pc4.setOnClickListener {
            listPass.add(4)
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
            checkList()
        }
        binding.pc5.setOnClickListener {
            listPass.add(5)
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
            checkList()
        }
        binding.pc6.setOnClickListener {
            listPass.add(6)
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
            checkList()
        }
        binding.pc7.setOnClickListener {
            listPass.add(7)
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
            checkList()
        }
        binding.pc8.setOnClickListener {
            listPass.add(8)
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
            checkList()
        }
        binding.pc9.setOnClickListener {
            listPass.add(9)
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
            checkList()
        }
        binding.pcClear.setOnClickListener {
            listPass.clear()
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
            checkList()

        }
    }
    private fun checkList() {
        when(listPass.size){
            0-> {
                binding.dot01.setBackgroundResource(R.drawable.background_view_dot)
                binding.dot02.setBackgroundResource(R.drawable.background_view_dot)
                binding.dot03.setBackgroundResource(R.drawable.background_view_dot)
                binding.dot04.setBackgroundResource(R.drawable.background_view_dot)
            }
            1-> binding.dot01.setBackgroundResource(R.drawable.background_view_dot_select)
            2-> binding.dot02.setBackgroundResource(R.drawable.background_view_dot_select)
            3-> binding.dot03.setBackgroundResource(R.drawable.background_view_dot_select)
            4-> {
                binding.dot04.setBackgroundResource(R.drawable.background_view_dot_select)
                if (listPass == HawkCommon.getHawkListPinCode()){
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }else{
                    binding.tvDes.visibility = View.INVISIBLE
                    binding.tvError.visibility = View.VISIBLE

                    listPass.clear()

                    binding.dot01.setBackgroundResource(R.drawable.background_view_dot)
                    binding.dot02.setBackgroundResource(R.drawable.background_view_dot)
                    binding.dot03.setBackgroundResource(R.drawable.background_view_dot)
                    binding.dot04.setBackgroundResource(R.drawable.background_view_dot)

                }
            }
        }
    }
}