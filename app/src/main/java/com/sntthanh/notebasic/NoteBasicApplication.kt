package com.sntthanh.notebasic

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.orhanobut.hawk.Hawk
import com.sntthanh.notebasic.activities.utils.HawkCommon
import com.sntthanh.notebasic.backup.AutoBackupWorker
import com.sntthanh.notebasic.preferences.Preferences
import com.sntthanh.notebasic.preferences.Theme
import java.util.Locale
import java.util.concurrent.TimeUnit

class NoteBasicApplication : Application() , Application.ActivityLifecycleCallbacks{

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

        val request = PeriodicWorkRequest.Builder(AutoBackupWorker::class.java, 6, TimeUnit.HOURS).build()
        WorkManager.getInstance(this).enqueueUniquePeriodicWork("Auto Backup", ExistingPeriodicWorkPolicy.KEEP, request)

        registerActivityLifecycleCallbacks(this)
        Hawk.init(applicationContext).build()
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        val listLang = Common.getLanguageList(activity)
        val position = HawkCommon.getHawkLanguage()
        val langCode = listLang[position].key
        val locale = Locale(langCode)
        Locale.setDefault(locale)
        val resource = activity.resources
        val configuration = resource.configuration
        configuration.setLocale(locale)
        resource.updateConfiguration(configuration, resource.displayMetrics)
    }

    override fun onActivityStarted(activity: Activity) {

    }

    override fun onActivityResumed(activity: Activity) {

    }

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityDestroyed(activity: Activity) {

    }
}