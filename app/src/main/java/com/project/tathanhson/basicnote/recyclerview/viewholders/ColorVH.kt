package com.project.tathanhson.basicnote.recyclerview.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.project.tathanhson.basicnote.databinding.RecyclerColorBinding
import com.project.tathanhson.basicnote.miscellaneous.Operations
import com.project.tathanhson.basicnote.model.Color
import com.project.tathanhson.basicnote.recyclerview.ItemListener

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