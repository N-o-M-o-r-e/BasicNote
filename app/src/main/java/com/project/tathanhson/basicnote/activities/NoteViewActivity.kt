package com.project.tathanhson.basicnote.activities

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.TypedValue
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.lifecycleScope
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.project.tathanhson.basicnote.R
import com.project.tathanhson.basicnote.databinding.ActivityNoteBinding
import com.project.tathanhson.basicnote.miscellaneous.Constants
import com.project.tathanhson.basicnote.miscellaneous.Operations
import com.project.tathanhson.basicnote.model.Folder
import com.project.tathanhson.basicnote.model.Type
import com.project.tathanhson.basicnote.preferences.TextSize
import com.project.tathanhson.basicnote.viewmodels.BaseNoteModel
import com.project.tathanhson.basicnote.viewmodels.NotallyModel
import com.project.tathanhson.basicnote.widget.WidgetProvider
import kotlinx.coroutines.launch

abstract class NoteViewActivity(private val type: Type) : AppCompatActivity() {

    internal lateinit var binding: ActivityNoteBinding
    internal val model: NotallyModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        when (type) {
            Type.NOTE -> {
                binding.AddItem.visibility = View.GONE
                binding.RecyclerView.visibility = View.GONE
            }

            Type.LIST -> {
                binding.EnterBody.visibility = View.GONE
            }
        }

        val title = TextSize.getEditTitleSize(model.textSize)
        val date = TextSize.getDisplayBodySize(model.textSize)
        val body = TextSize.getEditBodySize(model.textSize)

        binding.EnterTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, title)
        binding.DateCreated.setTextSize(TypedValue.COMPLEX_UNIT_SP, date)
        binding.EnterBody.setTextSize(TypedValue.COMPLEX_UNIT_SP, body)

        binding.root.isSaveFromParentEnabled = false

        setContentView(binding.root)

        lifecycleScope.launch {
            if (model.isFirstInstance) {
                val persistedId = savedInstanceState?.getLong("id")
                val selectedId = intent.getLongExtra(Constants.SelectedBaseNote, 0L)
                val id = persistedId ?: selectedId
                if (id != 0L) {
                    model.isNewNote = false
                    model.setState(id)
                } else {
                    model.isNewNote = true
                    model.createBaseNote()

                    if (intent.action == Intent.ACTION_SEND) {
                        handleSharedNote()
                    }
                }
                model.isFirstInstance = false
            }

            setupToolbar()
            setupListeners()
            setStateFromModel()

            configureUI()
            binding.ScrollView.visibility = View.VISIBLE
        }

    }

    override fun finish() {
        lifecycleScope.launch {
            model.saveNote()
            sendModificationBroadcast()
            super.finish()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("id", model.id)
        lifecycleScope.launch {
            model.saveNote()
            sendModificationBroadcast()
        }
    }

    abstract fun configureUI()

    open fun setupListeners() {
        binding.EnterTitle.doAfterTextChanged { text ->
            model.title = requireNotNull(text).trim().toString()
        }
    }

    open fun setStateFromModel() {
        val formatter = BaseNoteModel.getDateFormatter(this)
        binding.DateCreated.text = formatter.format(model.timestamp)

        binding.EnterTitle.setText(model.title)
        Operations.bindLabels(binding.LabelGroup, model.labels, model.textSize)

        setupColor()
    }


    private fun sendModificationBroadcast() {
        val intent = Intent(this, WidgetProvider::class.java)
        intent.action = WidgetProvider.ACTION_NOTES_MODIFIED
        intent.putExtra(WidgetProvider.EXTRA_MODIFIED_NOTES, longArrayOf(model.id))
        sendBroadcast(intent)
    }


    private fun handleSharedNote() {
        val title = intent.getStringExtra(Intent.EXTRA_SUBJECT)

        val string = intent.getStringExtra(Intent.EXTRA_TEXT)
        val charSequence = intent.getCharSequenceExtra(Operations.extraCharSequence)
        val body = charSequence ?: string

        if (body != null) {
            model.body = Editable.Factory.getInstance().newEditable(body)
        }
        if (title != null) {
            model.title = title
        }
    }


    private fun share() {
        val body = when (type) {
            Type.NOTE -> model.body
            Type.LIST -> Operations.getBody(model.items)
        }
        Operations.shareNote(this, model.title, body)
    }

    private fun label() {
        lifecycleScope.launch {
            val labels = model.getAllLabels()
            val onUpdated = { new: List<String> ->
                model.setLabels(new)
                Operations.bindLabels(binding.LabelGroup, model.labels, model.textSize)
            }
            val add = { Operations.displayAddLabelDialog(this@NoteViewActivity, model::insertLabel) { label() } }
            Operations.labelNote(this@NoteViewActivity, labels, model.labels, onUpdated, add)
        }
    }


    private fun delete() {
        model.folder = Folder.DELETED
        finish()
    }

    private fun restore() {
        model.folder = Folder.NOTES
        finish()
    }

    private fun archive() {
        model.folder = Folder.ARCHIVED
        finish()
    }

    private fun deleteForever() {
        MaterialAlertDialogBuilder(this)
            .setMessage(R.string.delete_note_forever)
            .setPositiveButton(R.string.delete) { _, _ ->
                lifecycleScope.launch {
                    model.delete()
                    sendModificationBroadcast()
                    super.finish()
                }
            }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }

    private fun pin(item: MenuItem) {
        model.pinned = !model.pinned
        bindPinned(item)
    }


    private fun setupColor() {
        val color = Operations.extractColor(model.color, this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = color
        }
        binding.root.setBackgroundColor(color)
        binding.RecyclerView.setBackgroundColor(color)
        binding.Toolbar.backgroundTintList = ColorStateList.valueOf(color)
    }

    private fun setupToolbar() {
        binding.Toolbar.setNavigationOnClickListener { finish() }

        val menu = binding.Toolbar.menu
        val pin = menu.add(R.string.pin, R.drawable.pin) { item -> pin(item) }
        bindPinned(pin)

        menu.add(R.string.share, R.drawable.share) { share() }
        menu.add(R.string.labels, R.drawable.label) { label() }

        when (model.folder) {
            Folder.NOTES -> {
                menu.add(R.string.delete, R.drawable.delete) { delete() }
                menu.add(R.string.archive, R.drawable.archive) { archive() }
            }

            Folder.DELETED -> {
                menu.add(R.string.restore, R.drawable.restore) { restore() }
                menu.add(R.string.delete_forever, R.drawable.delete) { deleteForever() }
            }

            Folder.ARCHIVED -> {
                menu.add(R.string.delete, R.drawable.delete) { delete() }
                menu.add(R.string.unarchive, R.drawable.unarchive) { restore() }
            }
        }
    }

    fun Menu.add(title: Int, drawable: Int, onClick: (item: MenuItem) -> Unit): MenuItem {
        val menuItem = add(title)
        menuItem.setIcon(drawable)
        menuItem.setOnMenuItemClickListener { item ->
            onClick(item)
            return@setOnMenuItemClickListener false
        }
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
        return menuItem
    }

    private fun initialiseBinding() {
        binding = ActivityNoteBinding.inflate(layoutInflater)
        when (type) {
            Type.NOTE -> {
                binding.AddItem.visibility = View.GONE
                binding.RecyclerView.visibility = View.GONE
            }

            Type.LIST -> {
                binding.EnterBody.visibility = View.GONE
            }
        }

        val title = TextSize.getEditTitleSize(model.textSize)
        val date = TextSize.getDisplayBodySize(model.textSize)
        val body = TextSize.getEditBodySize(model.textSize)

        binding.EnterTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, title)
        binding.DateCreated.setTextSize(TypedValue.COMPLEX_UNIT_SP, date)
        binding.EnterBody.setTextSize(TypedValue.COMPLEX_UNIT_SP, body)

        binding.root.isSaveFromParentEnabled = false
    }

    private fun bindPinned(item: MenuItem) {
        val icon: Int
        val title: Int
        if (model.pinned) {
            icon = R.drawable.unpin
            title = R.string.unpin
        } else {
            icon = R.drawable.pin
            title = R.string.pin
        }
        item.setTitle(title)
        item.setIcon(icon)
    }

}