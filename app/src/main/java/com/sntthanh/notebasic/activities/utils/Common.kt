package com.sntthanh.notebasic.activities.utils

import android.content.Context
import com.sntthanh.notebasic.R


object Common {

    fun setLanguagePosition(context: Context, position: Int) {
        val preferences =
            context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
        preferences.edit().putInt("KEY_LANGUAGE_POSITION", position).apply()
    }


    fun getLanguageList(context: Context): ArrayList<Language> {
        val languageList = ArrayList<Language>()
        languageList.add(
            Language(
                R.drawable.ic_vietnam,
                context.getString(R.string.vietnamese),
                "vi"
            )
        )
        languageList.add(Language(R.drawable.ic_english, context.getString(R.string.english), "en"))
        languageList.add(Language(R.drawable.ic_china, context.getString(R.string.chinese), "zh"))
        languageList.add(Language(R.drawable.ic_russian, context.getString(R.string.russian), "ru"))
        languageList.add(Language(R.drawable.ic_thailand, context.getString(R.string.thai), "th"))
        languageList.add(Language(R.drawable.ic_hindi, context.getString(R.string.hindi), "hi"))

        return languageList
    }


}

data class Language(
    val img: Int,
    val name: String,
    val key: String
)