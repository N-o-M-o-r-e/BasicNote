package com.project.tathanhson.basicnote.utils

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.project.tathanhson.basicnote.preferences.Preferences
import com.project.tathanhson.basicnote.preferences.Theme
import java.util.concurrent.TimeUnit

class NotallyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val preferences = Preferences.getInstance(this)
        preferences.theme.observeForever { theme ->
            when (theme) {
                Theme.dark -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                Theme.light -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                Theme.followSystem -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
        }

        val request =
            PeriodicWorkRequest.Builder(AutoBackupWorker::class.java, 12, TimeUnit.HOURS).build()
        WorkManager.getInstance(this)
            .enqueueUniquePeriodicWork("Auto Backup", ExistingPeriodicWorkPolicy.KEEP, request)
    }
}