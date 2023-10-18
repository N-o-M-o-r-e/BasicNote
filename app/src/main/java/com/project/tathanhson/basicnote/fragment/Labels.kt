package com.project.tathanhson.basicnote.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.project.tathanhson.basicnote.R
import com.project.tathanhson.basicnote.databinding.DialogInputBinding
import com.project.tathanhson.basicnote.databinding.FragmentNotesBinding
import com.project.tathanhson.basicnote.miscellaneous.Constants
import com.project.tathanhson.basicnote.miscellaneous.Operations
import com.project.tathanhson.basicnote.miscellaneous.add

import com.project.tathanhson.basicnote.recyclerview.ItemListener
import com.project.tathanhson.basicnote.recyclerview.adapters.LabelAdapter
import com.project.tathanhson.basicnote.utils.MenuDialog
import com.project.tathanhson.basicnote.viewmodels.BaseNoteModel

class Labels : Fragment(), ItemListener {

    private var adapter: LabelAdapter? = null
    private var binding: FragmentNotesBinding? = null

    private val model: BaseNoteModel by activityViewModels()

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        adapter = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = LabelAdapter(this)

        binding?.RecyclerView?.setHasFixedSize(true)
        binding?.RecyclerView?.adapter = adapter
        binding?.RecyclerView?.layoutManager = LinearLayoutManager(requireContext())
        val itemDecoration = DividerItemDecoration(requireContext(), RecyclerView.VERTICAL)
        binding?.RecyclerView?.addItemDecoration(itemDecoration)

        binding?.RecyclerView?.setPadding(0, 0, 0, 0)
        binding?.ImageView?.setImageResource(R.drawable.label)

        setupObserver()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        binding = FragmentNotesBinding.inflate(inflater)
        return binding?.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.add(R.string.add_label, R.drawable.add) { displayAddLabelDialog() }
    }


    override fun onClick(position: Int) {
        adapter?.currentList?.get(position)?.let { value ->
            val bundle = Bundle()
            bundle.putString(Constants.SelectedLabel, value)
            findNavController().navigate(R.id.LabelsToDisplayLabel, bundle)
        }
    }

    override fun onLongClick(position: Int) {
        adapter?.currentList?.get(position)?.let { value ->
            MenuDialog(requireContext())
                .add(R.string.edit) { displayEditLabelDialog(value) }
                .add(R.string.delete) { confirmDeletion(value) }
                .show()
        }
    }


    private fun setupObserver() {
        model.labels.observe(viewLifecycleOwner) { labels ->
            adapter?.submitList(labels)
            binding?.ImageView?.isVisible = labels.isEmpty()
        }
    }


    private fun displayAddLabelDialog() {
        Operations.displayAddLabelDialog(requireContext(), model::insertLabel) {}
    }

    private fun confirmDeletion(value: String) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.delete_label)
            .setMessage(R.string.your_notes_associated)
            .setPositiveButton(R.string.delete) { _, _ -> model.deleteLabel(value) }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }

    private fun displayEditLabelDialog(oldValue: String) {
        val dialogBinding = DialogInputBinding.inflate(layoutInflater)

        dialogBinding.EditText.setText(oldValue)

        MaterialAlertDialogBuilder(requireContext())
            .setView(dialogBinding.root)
            .setTitle(R.string.edit_label)
            .setNegativeButton(R.string.cancel, null)
            .setPositiveButton(R.string.save) { dialog, _ ->
                val value = dialogBinding.EditText.text.toString().trim()
                if (value.isNotEmpty()) {
                    model.updateLabel(oldValue, value) { success ->
                        if (success) {
                            dialog.dismiss()
                        } else Toast.makeText(requireContext(), R.string.label_exists, Toast.LENGTH_LONG).show()
                    }
                }
            }
            .show()

        dialogBinding.EditText.requestFocus()
    }
}