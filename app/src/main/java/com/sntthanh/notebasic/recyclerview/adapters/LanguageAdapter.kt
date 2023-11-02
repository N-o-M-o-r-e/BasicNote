package com.sntthanh.notebasic.recyclerview.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.sntthanh.notebasic.R
import com.sntthanh.notebasic.activities.utils.Common
import com.sntthanh.notebasic.databinding.ItemLanguageBinding

class LanguageAdapter(private val context: Context) :
    RecyclerView.Adapter<LanguageAdapter.ViewHolder>() {

    private var selectedPosition = 0
    private var styleTheme = 1

    @SuppressLint("NotifyDataSetChanged")
    fun updateSelected(selectedPosition: Int) {
        this.selectedPosition = selectedPosition
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemLanguageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemLanguageBinding.inflate(inflater, parent, false)
        )
    }

    @SuppressLint("ResourceAsColor", "NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {

        val language = Common.getLanguageList(context)[position]

        Log.e("AAAAAAAAA", "onBindViewHolder: $selectedPosition")
        if (selectedPosition == position) {
            holder.binding.layoutRoot.setBackgroundResource(R.drawable.background_button_02)
            holder.binding.languageName.setTextColor(ContextCompat.getColor(context, R.color.Black))
        } else {
            if (styleTheme == 1) {
                holder.binding.languageName.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.Black
                    )
                )
                holder.binding.layoutRoot.setBackgroundResource(R.drawable.background_language_uncheck)
                ViewCompat.setElevation(holder.binding.layoutRoot, 4f) // Đặt độ nổi lên là 4dp
            } else {
                holder.binding.languageName.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.White
                    )
                )
                holder.binding.layoutRoot.setBackgroundResource(R.drawable.background_language_uncheck)
                ViewCompat.setElevation(holder.binding.layoutRoot, 4f) // Đặt độ nổi lên là 4dp
            }
        }

        holder.binding.languageIcon.setImageResource(language.img)
        holder.binding.languageName.text = language.name
        holder.binding.languageName.setHorizontallyScrolling(true)
        holder.binding.languageName.isSelected = true
        holder.itemView.setOnClickListener {
            //hawk
//            HawkCommon.putHawkLanguage(position)
            selectedPosition = position
            notifyDataSetChanged()
        }
    }

    fun getSelectedPositionLanguage(): Int {
        return selectedPosition
    }


    override fun getItemCount(): Int {
        return Common.getLanguageList(context).size
    }
}