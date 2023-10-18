package com.project.tathanhson.basicnote.activities

import android.appwidget.AppWidgetManager
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.project.tathanhson.basicnote.base.BaseActivityWithoutDataBiding
import com.project.tathanhson.basicnote.recyclerview.ItemListener
import com.project.tathanhson.basicnote.databinding.ActivityConfigureWidgetBinding
import com.project.tathanhson.basicnote.model.BaseNote
import com.project.tathanhson.basicnote.preferences.Preferences
import com.project.tathanhson.basicnote.preferences.View
import com.project.tathanhson.basicnote.recyclerview.adapters.BaseNoteAdapter
import com.project.tathanhson.basicnote.viewmodels.BaseNoteModel
import com.project.tathanhson.basicnote.widget.WidgetProvider

class ConfigureWidget : BaseActivityWithoutDataBiding<ActivityConfigureWidgetBinding>(ActivityConfigureWidgetBinding::inflate), ItemListener {

    private lateinit var adapter: BaseNoteAdapter
    private val id by lazy {
        intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID)
    }
    override fun initData() {
        val result = Intent()
        result.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, id)
        setResult(RESULT_CANCELED, result)
    }

    override fun initView() {
        val preferences = Preferences.getInstance(application)

        val maxItems = preferences.maxItems
        val maxLines = preferences.maxLines
        val textSize = preferences.textSize.value
        val dateFormat = preferences.dateFormat.value

        val formatter = BaseNoteModel.getDateFormatter(this)

        adapter = BaseNoteAdapter(dateFormat, textSize, maxItems, maxLines, formatter, this)

        binding.RecyclerView.adapter = adapter
        binding.RecyclerView.setHasFixedSize(true)

        binding.RecyclerView.layoutManager = if (preferences.view.value == View.grid) {
            StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        } else LinearLayoutManager(this)
    }

    override fun listenLiveData() {
        
    }

    override fun listeners() {
        
    }

    override fun onClick(position: Int) {
        if (position != -1) {
            val preferences = Preferences.getInstance(application)
            val noteId = (adapter.currentList[position] as BaseNote).id
            preferences.updateWidget(id, noteId)

            val manager = AppWidgetManager.getInstance(this)
            WidgetProvider.updateWidget(this, manager, id, noteId)

            val success = Intent()
            success.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, id)
            setResult(RESULT_OK, success)
            finish()
        }
    }

    override fun onLongClick(position: Int) {
        
    }

}