package com.project.tathanhson.basicnote.recyclerview

interface ListItemListener {

    fun delete(position: Int)

    fun moveToNext(position: Int)

    fun textChanged(position: Int, text: String)

    fun checkedChanged(position: Int, checked: Boolean)
}