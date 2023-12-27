package com.sntthanh.notebasic.recyclerview.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.sntthanh.notebasic.databinding.RecyclerColorBinding
import com.sntthanh.notebasic.miscellaneous.Operations
import com.sntthanh.notebasic.recyclerview.ItemListener
import com.sntthanh.notebasic.room.model.Color

class ColorVH(private val binding: RecyclerColorBinding, listener: ItemListener) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.CardView.setOnClickListener {
            listener.onClick(adapterPosition)
        }
    }

    fun bind(color: Color) {
        val value = Operations.extractColor(color, binding.root.context)
        binding.CardView.setCardBackgroundColor(value)
    }
}