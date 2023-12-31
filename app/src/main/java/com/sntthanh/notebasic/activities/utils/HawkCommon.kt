package com.sntthanh.notebasic.activities.utils

import com.orhanobut.hawk.Hawk

object HawkCommon {
    fun putEventFirstApp(event: Boolean) = Hawk.put("EVENT", event)
    fun getEventFirstApp(): Boolean = Hawk.get("EVENT", false)
    fun putEventLanguage(event: Boolean) = Hawk.put("EVENT_LANGUAGE", event)
    fun getEventLanguage(): Boolean = Hawk.get("EVENT_LANGUAGE", false)
    fun putHawkLanguage(position: Int) { Hawk.put("LANGUAGE_CHOOSE", position)}
    fun getHawkLanguage(): Int = Hawk.get("LANGUAGE_CHOOSE", 0)
    fun putEventAppOpen(openEvent: Boolean) = Hawk.put("EVENT_OPEN", openEvent)
    fun getEventAppOpen() : Boolean = Hawk.get("EVENT_OPEN", false)
    fun putHawkListPinCode(listPass: List<Int>){ Hawk.put("PASS_LIST", listPass) }
    fun getHawkListPinCode() : List<Int> = Hawk.get("PASS_LIST", listOf() )
    fun putHawkQuestion(question: String){ Hawk.put("QUESTION_CHOOSE", question)}
    fun getHawkQuestion(): String = Hawk.get("QUESTION_CHOOSE","")
    fun putHawkAnswer(answer: String) { Hawk.put("ANSWER", answer)}
    fun getHawkAnswer() : String = Hawk.get("ANSWER", "")
    fun putHawkName(name: String) { Hawk.put("NAME", name)}
    fun getHawkName() : String = Hawk.get("NAME", "")
    fun putHawkEventEnterPassCode(event :Boolean) {Hawk.put("ENTER_CODE", event)}
    fun getHawkEventEnterPassCode() :Boolean = Hawk.get("ENTER_CODE", false)
    fun putHawkEventTurnPass(event: Boolean) {Hawk.put("EVENT_TURN_PASS", event)}
    fun getHawkEventTurnPass(): Boolean = Hawk.get("EVENT_TURN_PASS", true)

}