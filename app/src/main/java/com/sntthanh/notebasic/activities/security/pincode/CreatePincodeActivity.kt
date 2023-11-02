package com.sntthanh.notebasic.activities.security.pincode

import android.util.Log
import com.sntthanh.notebasic.base.BaseActivityWithoutDataBiding
import com.sntthanh.notebasic.databinding.ActivityCreatePinCodeBinding

class CreatePincodeActivity :
    BaseActivityWithoutDataBiding<ActivityCreatePinCodeBinding>(ActivityCreatePinCodeBinding::inflate) {
    private var listPass = ArrayList<Int>()

    override fun initData() {

    }

    override fun initView() {

    }

    override fun listenLiveData() {

    }

    override fun listeners() {
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
        listenersInputPass()
    }

    private fun listenersInputPass() {
        binding.pc0.setOnClickListener {
            listPass.add(0)
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
//            checkList()
        }
        binding.pc1.setOnClickListener {
            listPass.add(1)
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
//            checkList()
        }
        binding.pc2.setOnClickListener {
            listPass.add(2)
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
//            checkList()
        }
        binding.pc3.setOnClickListener {
            listPass.add(3)
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
//            checkList()
        }
        binding.pc4.setOnClickListener {
            listPass.add(4)
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
//            checkList()
        }
        binding.pc5.setOnClickListener {
            listPass.add(5)
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
//            checkList()
        }
        binding.pc6.setOnClickListener {
            listPass.add(6)
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
//            checkList()
        }
        binding.pc7.setOnClickListener {
            listPass.add(7)
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
//            checkList()
        }
        binding.pc8.setOnClickListener {
            listPass.add(8)
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
//            checkList()
        }
        binding.pc9.setOnClickListener {
            listPass.add(9)
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
//            checkList()
        }
        binding.pcClear.setOnClickListener {
            listPass.clear()
            Log.e("AAAAAAAAAAAAAAA", "listeners: ${listPass.size}")
//            checkList()

        }
    }

}