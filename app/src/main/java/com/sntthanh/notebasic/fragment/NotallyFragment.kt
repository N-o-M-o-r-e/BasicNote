package com.sntthanh.notebasic.fragment

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.print.PostPDFGenerator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.sntthanh.notebasic.MenuDialog
import com.sntthanh.notebasic.R
import com.sntthanh.notebasic.activities.create_note.MakeList
import com.sntthanh.notebasic.activities.create_note.TakeNote
import com.sntthanh.notebasic.databinding.DialogColorBinding
import com.sntthanh.notebasic.databinding.FragmentNotesBinding
import com.sntthanh.notebasic.miscellaneous.Constants
import com.sntthanh.notebasic.miscellaneous.Operations
import com.sntthanh.notebasic.miscellaneous.applySpans
import com.sntthanh.notebasic.recyclerview.ItemListener
import com.sntthanh.notebasic.recyclerview.adapters.BaseNoteAdapter
import com.sntthanh.notebasic.recyclerview.adapters.ColorAdapter
import com.sntthanh.notebasic.room.BaseNote
import com.sntthanh.notebasic.room.model.Color
import com.sntthanh.notebasic.room.model.Folder
import com.sntthanh.notebasic.room.Item
import com.sntthanh.notebasic.room.model.Type
import com.sntthanh.notebasic.viewmodels.BaseNoteModel
import kotlinx.coroutines.launch
import java.io.File

private const val REQUEST_EXPORT_FILE = 10

abstract class NotallyFragment : Fragment(), ItemListener {

    private var adapter: BaseNoteAdapter? = null
    internal var binding: FragmentNotesBinding? = null

    internal val model: BaseNoteModel by activityViewModels()

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        adapter = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.ImageView?.setImageResource(getBackground())
        setupAdapter()
        setupRecyclerView()
        setupObserver()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        binding = FragmentNotesBinding.inflate(inflater)
        return binding?.root
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        if (requestCode == REQUEST_EXPORT_FILE && resultCode == Activity.RESULT_OK) {
            intent?.data?.let { uri ->
                model.writeCurrentFileToUri(uri)
            }
        }
    }


    // See [RecyclerView.ViewHolder.getAdapterPosition]
    override fun onClick(position: Int) {
        if (position != -1) {
            adapter?.currentList?.get(position)?.let { item ->
                if (item is BaseNote) {
                    when (item.type) {
                        Type.NOTE -> goToActivity(TakeNote::class.java, item)
                        Type.LIST -> goToActivity(MakeList::class.java, item)
                    }
                }
            }
        }
    }

    override fun onLongClick(position: Int) {
        if (position != -1) {
            adapter?.currentList?.get(position)?.let { item ->
                if (item is BaseNote) {
                    showOperations(item)
                }
            }
        }
    }


    private fun setupAdapter() {
        val textSize = model.preferences.textSize.value
        val maxItems = model.preferences.maxItems
        val maxLines = model.preferences.maxLines
        val dateFormat = model.preferences.dateFormat.value

        adapter = BaseNoteAdapter(dateFormat, textSize, maxItems, maxLines, model.formatter, this)
        adapter?.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {

            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                if (itemCount > 0) {
                    binding?.RecyclerView?.scrollToPosition(positionStart)
                }
            }
        })
        binding?.RecyclerView?.adapter = adapter
        binding?.RecyclerView?.setHasFixedSize(true)
    }

    private fun setupObserver() {
        getObservable().observe(viewLifecycleOwner) { list ->
            adapter?.submitList(list)
            binding?.ImageView?.isVisible = list.isEmpty()
        }
    }

    private fun setupRecyclerView() {
        binding?.RecyclerView?.layoutManager = if (model.preferences.view.value == com.sntthanh.notebasic.preferences.View.grid) {
            StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        } else LinearLayoutManager(requireContext())
    }


    private fun showOperations(baseNote: BaseNote) {
        val dialog = MenuDialog(requireContext())
        when (baseNote.folder) {
            Folder.NOTES -> {
                if (baseNote.pinned) {
                    dialog.add(R.string.unpin) { model.unpinBaseNote(baseNote.id) }
                } else dialog.add(R.string.pin) { model.pinBaseNote(baseNote.id) }
                dialog.add(R.string.share) { share(baseNote) }
                dialog.add(R.string.labels) { label(baseNote) }
                dialog.add(R.string.export) { export(baseNote) }
                dialog.add(R.string.delete) { model.moveBaseNoteToDeleted(baseNote.id) }
                dialog.add(R.string.archive) { model.moveBaseNoteToArchive(baseNote.id) }
                dialog.add(R.string.change_color) { color(baseNote.id) }
            }

            Folder.DELETED -> {
                dialog.add(R.string.restore) { model.restoreBaseNote(baseNote.id) }
                dialog.add(R.string.delete_forever) { delete(baseNote.id) }
            }

            Folder.ARCHIVED -> {
                dialog.add(R.string.delete) { model.moveBaseNoteToDeleted(baseNote.id) }
                dialog.add(R.string.unarchive) { model.restoreBaseNote(baseNote.id) }
            }
        }
        dialog.show()
    }

    private fun goToActivity(activity: Class<*>, baseNote: BaseNote) {
        val intent = Intent(requireContext(), activity)
        intent.putExtra(Constants.SelectedBaseNote, baseNote.id)
        startActivity(intent)
    }


    private fun share(baseNote: BaseNote) {
        val body = when (baseNote.type) {
            Type.NOTE -> baseNote.body.applySpans(baseNote.spans)
            Type.LIST -> Operations.getBody(baseNote.items)
        }
        Operations.shareNote(requireContext(), baseNote.title, body)
    }

    private fun label(baseNote: BaseNote) {
        lifecycleScope.launch {
            val labels = model.getAllLabels()
            val onUpdated = { new: List<String> -> model.updateBaseNoteLabels(new, baseNote.id) }
            val add = {
                Operations.displayAddLabelDialog(requireContext(), model::insertLabel) {
                    label(baseNote)
                }
            }
            Operations.labelNote(requireContext(), labels, baseNote.labels, onUpdated, add)
        }
    }

    private fun export(baseNote: BaseNote) {
        MenuDialog(requireContext())
            .add("PDF") { exportToPDF(baseNote) }
            .add("TXT") { exportToTXT(baseNote) }
            .add("JSON") { exportToJSON(baseNote) }
            .add("HTML") { exportToHTML(baseNote) }
            .show()
    }

    private fun delete(id: Long) {
        MaterialAlertDialogBuilder(requireContext())
            .setMessage(R.string.delete_note_forever)
            .setPositiveButton(R.string.delete) { _, _ ->
                model.deleteBaseNoteForever(id)
            }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }

    private fun color(id: Long) {
        val dialog = MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.change_color)
            .create()

        val colorAdapter = ColorAdapter(object : ItemListener {
            override fun onClick(position: Int) {
                dialog.dismiss()
                val color = Color.values()[position]
                model.colorBaseNote(id, color)
            }

            override fun onLongClick(position: Int) {}
        })

        val dialogBinding = DialogColorBinding.inflate(layoutInflater)
        dialogBinding.RecyclerView.adapter = colorAdapter

        dialog.setView(dialogBinding.root)
        dialog.show()
    }


    private fun exportToPDF(baseNote: BaseNote) {
        model.getPDFFile(baseNote, object : PostPDFGenerator.OnResult {

            override fun onSuccess(file: File) {
                showFileOptionsDialog(file, "application/pdf")
            }

            override fun onFailure(message: CharSequence?) {
                Toast.makeText(requireContext(), R.string.something_went_wrong, Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    private fun exportToTXT(baseNote: BaseNote) {
        lifecycleScope.launch {
            val file = model.getTXTFile(baseNote)
            showFileOptionsDialog(file, "text/plain")
        }
    }

    private fun exportToJSON(baseNote: BaseNote) {
        lifecycleScope.launch {
            val file = model.getJSONFile(baseNote)
            showFileOptionsDialog(file, "application/json")
        }
    }

    private fun exportToHTML(baseNote: BaseNote) {
        lifecycleScope.launch {
            val file = model.getHTMLFile(baseNote)
            showFileOptionsDialog(file, "text/html")
        }
    }

    private fun showFileOptionsDialog(file: File, mimeType: String) {
        val uri = FileProvider.getUriForFile(
            requireContext(),
            "${requireContext().packageName}.provider",
            file
        )

        MenuDialog(requireContext())
            .add(R.string.share) { shareFile(uri, mimeType) }
            .add(R.string.view_file) { viewFile(uri, mimeType) }
            .add(R.string.save_to_device) { saveFileToDevice(file, mimeType) }
            .show()
    }


    private fun viewFile(uri: Uri, mimeType: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(uri, mimeType)
        intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION

        val chooser = Intent.createChooser(intent, getString(R.string.view_note))
        startActivity(chooser)
    }

    private fun shareFile(uri: Uri, mimeType: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = mimeType
        intent.putExtra(Intent.EXTRA_STREAM, uri)

        val chooser = Intent.createChooser(intent, null)
        startActivity(chooser)
    }

    private fun saveFileToDevice(file: File, mimeType: String) {
        val intent = Intent(Intent.ACTION_CREATE_DOCUMENT)
        intent.type = mimeType
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.putExtra(Intent.EXTRA_TITLE, file.nameWithoutExtension)

        model.currentFile = file
        startActivityForResult(intent, REQUEST_EXPORT_FILE)
    }


    abstract fun getBackground(): Int

    abstract fun getObservable(): LiveData<List<Item>>
}