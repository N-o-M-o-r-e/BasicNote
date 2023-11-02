package com.sntthanh.notebasic.activities.utils

import com.orhanobut.hawk.Hawk

object HawkCommon {
    fun putEventLanguage(event: Boolean) = Hawk.put("EVENT_LANGUAGE", event)
    fun getEventLanguage(): Boolean = Hawk.get("EVENT_LANGUAGE", false)
    fun putHawkLanguage(position: Int) { Hawk.put("LANGUAGE_CHOOSE", position)}
    fun getHawkLanguage(): Int = Hawk.get("LANGUAGE_CHOOSE", 0)
    fun putEventAppOpen(openEvent: Boolean) = Hawk.put("EVENT_OPEN", openEvent)
    fun getEventAppOpen() : Boolean = Hawk.get("EVENT_OPEN", false)
}