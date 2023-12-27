package com.sntthanh.notebasic.activities.create_note

import com.sntthanh.notebasic.R
import com.sntthanh.notebasic.miscellaneous.setOnNextAction
import com.sntthanh.notebasic.recyclerview.ListItemListener
import com.sntthanh.notebasic.recyclerview.adapters.MakeListAdapter
import com.sntthanh.notebasic.recyclerview.viewholders.MakeListVH
import com.sntthanh.notebasic.room.ListItem
import com.sntthanh.notebasic.room.model.Type

class MakeList : NotallyActivity(Type.LIST) {

    private lateinit var adapter: MakeListAdapter

    override fun configureUI() {
        binding.EnterTitle.setOnNextAction {
            moveToNext(-1)
        }

        setupRecyclerView()

        if (model.isNewNote) {
            if (model.items.isEmpty()) {
                addListItem()
            }
        }
    }


    override fun setupListeners() {
        super.setupListeners()
        binding.AddItem.setOnClickListener {
            addListItem()
        }
    }


    private fun addListItem() {
        val position = model.items.size
        val listItem = ListItem(String(), false)
        model.items.add(listItem)
        adapter.notifyItemInserted(position)
        binding.RecyclerView.post {
            val viewHolder =
                binding.RecyclerView.findViewHolderForAdapterPosition(position) as MakeListVH?
            viewHolder?.binding?.EditText?.requestFocus()
        }
    }


    private fun setupRecyclerView() {
        val unit = resources.getDimension(R.dimen.unit)
        val elevation = unit * 2

        adapter = MakeListAdapter(model.textSize, elevation, model.items, object :
            ListItemListener {

            override fun delete(position: Int) {
                model.items.removeAt(position)
                adapter.notifyItemRemoved(position)
            }

            override fun moveToNext(position: Int) {
                this@MakeList.moveToNext(position)
            }

            override fun textChanged(position: Int, text: String) {
                model.items[position].body = text
            }

            override fun checkedChanged(position: Int, checked: Boolean) {
                model.items[position].checked = checked
            }
        })

        binding.RecyclerView.adapter = adapter
    }

    private fun moveToNext(currentPosition: Int) {
        val viewHolder =
            binding.RecyclerView.findViewHolderForAdapterPosition(currentPosition + 1) as MakeListVH?
        if (viewHolder != null) {
            if (viewHolder.binding.CheckBox.isChecked) {
                moveToNext(currentPosition + 1)
            } else viewHolder.binding.EditText.requestFocus()
        } else addListItem()
    }
}