package com.sntthanh.notebasic.recyclerview.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.sntthanh.notebasic.databinding.RecyclerLabelBinding
import com.sntthanh.notebasic.recyclerview.ItemListener

class LabelVH(private val binding: RecyclerLabelBinding, listener: ItemListener) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            listener.onClick(adapterPosition)
        }

        binding.root.setOnLongClickListener {
            listener.onLongClick(adapterPosition)
            return@setOnLongClickListener true
        }
    }

    fun bind(value: String) {
        binding.root.text = value
    }
}