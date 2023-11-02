package com.sntthanh.notebasic.recyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.sntthanh.notebasic.databinding.RecyclerListItemBinding
import com.sntthanh.notebasic.recyclerview.DragCallback
import com.sntthanh.notebasic.recyclerview.ListItemListener
import com.sntthanh.notebasic.recyclerview.viewholders.MakeListVH
import com.sntthanh.notebasic.room.ListItem

class MakeListAdapter(
    private val textSize: String,
    elevation: Float,
    val list: ArrayList<ListItem>,
    private val listener: ListItemListener
) : RecyclerView.Adapter<MakeListVH>() {

    private val callback = DragCallback(elevation, this)
    private val touchHelper = ItemTouchHelper(callback)

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        touchHelper.attachToRecyclerView(recyclerView)
    }


    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MakeListVH, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeListVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerListItemBinding.inflate(inflater, parent, false)
        binding.root.background = parent.background
        return MakeListVH(binding, listener, touchHelper, textSize)
    }
}