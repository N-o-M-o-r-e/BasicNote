package com.sntthanh.notebasic.recyclerview

interface ItemListener {

    fun onClick(position: Int)

    fun onLongClick(position: Int)
}