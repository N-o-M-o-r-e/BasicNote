package com.sntthanh.notebasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sntthanh.notebasic.databinding.ActivityRealTimeBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Timer
import java.util.TimerTask


class RealTimeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRealTimeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRealTimeBinding.inflate(layoutInflater)

        setContentView(binding.root)
        updateTime()
    }

    private fun updateTime() {
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                updateClock()
            }
        }, 0, 1000)
    }

    private fun updateClock() {
        runOnUiThread {
            val sdf = SimpleDateFormat("hh:mm:ss a  MMM dd, yyyy")
            val currentTime: String = sdf.format(Calendar.getInstance().time)
            binding.tvRealtime.text = currentTime
        }
    }
}