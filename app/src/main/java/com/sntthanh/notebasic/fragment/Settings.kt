package com.sntthanh.notebasic.fragment

import android.app.Activity
import android.app.Application
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.documentfile.provider.DocumentFile
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.sntthanh.notebasic.MenuDialog
import com.sntthanh.notebasic.R
import com.sntthanh.notebasic.activities.info.InfoUserActivity
import com.sntthanh.notebasic.activities.security.pincode.CreatePincodeActivity
import com.sntthanh.notebasic.activities.security.pincode.EnterPincodeActivity
import com.sntthanh.notebasic.activities.tutorial.LanguageActivity
import com.sntthanh.notebasic.activities.utils.HawkCommon
import com.sntthanh.notebasic.databinding.FragmentSettingsBinding
import com.sntthanh.notebasic.databinding.PreferenceBinding
import com.sntthanh.notebasic.databinding.PreferenceSeekbarBinding
import com.sntthanh.notebasic.miscellaneous.Operations
import com.sntthanh.notebasic.preferences.AutoBackup
import com.sntthanh.notebasic.preferences.DateFormat
import com.sntthanh.notebasic.preferences.ListInfo
import com.sntthanh.notebasic.preferences.MaxItems
import com.sntthanh.notebasic.preferences.MaxLines
import com.sntthanh.notebasic.preferences.SeekbarInfo
import com.sntthanh.notebasic.preferences.TextSize
import com.sntthanh.notebasic.preferences.Theme
import com.sntthanh.notebasic.viewmodels.BaseNoteModel

private const val REQUEST_IMPORT_BACKUP = 20
private const val REQUEST_EXPORT_BACKUP = 21
private const val REQUEST_CHOOSE_FOLDER = 22

class Settings : Fragment() {

    private val model: BaseNoteModel by activityViewModels()

    private fun setupBinding(binding: FragmentSettingsBinding) {
        model.preferences.view.observe(viewLifecycleOwner) { value ->
            binding.View.setup(com.sntthanh.notebasic.preferences.View, value)
        }

        model.preferences.theme.observe(viewLifecycleOwner) { value ->
            binding.Theme.setup(Theme, value)
        }

        model.preferences.dateFormat.observe(viewLifecycleOwner) { value ->
            binding.DateFormat.setup(DateFormat, value)
        }

        model.preferences.textSize.observe(viewLifecycleOwner) { value ->
            binding.TextSize.setup(TextSize, value)
        }


        binding.MaxItems.setup(MaxItems, model.preferences.maxItems)

        binding.MaxLines.setup(MaxLines, model.preferences.maxLines)


        model.preferences.autoBackup.observe(viewLifecycleOwner) { value ->
            binding.AutoBackup.setup(AutoBackup, value)
        }

        binding.ImportBackup.setOnClickListener {
            importBackup()
        }

        binding.ExportBackup.setOnClickListener {
            exportBackup()
        }

        Log.e("AAAAAAAAAA", "checkSwitch: " + HawkCommon.getHawkEventTurnPass())

        if (HawkCommon.getHawkEventTurnPass()){
            binding.switchTurnPass.isChecked =true
            binding.ChangePasscode.setTextColor(
                ContextCompat.getColor(
                    requireActivity(),
                    R.color.text_color
                )
            )
            binding.ChangePasscode.isEnabled = true
//            binding.Info.setTextColor(ContextCompat.getColor(requireActivity(), R.color.text_color))
//            binding.Info.isEnabled = true
        }else{
            binding.switchTurnPass.isChecked =false
            binding.ChangePasscode.setTextColor(
                ContextCompat.getColor(
                    requireActivity(),
                    R.color.colorGray
                )
            )
            binding.ChangePasscode.isEnabled = false
//            binding.Info.setTextColor(ContextCompat.getColor(requireActivity(), R.color.colorGray))
//            binding.Info.isEnabled = false
        }

        binding.switchTurnPass.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.ChangePasscode.setTextColor(
                    ContextCompat.getColor(
                        requireActivity(),
                        R.color.text_color
                    )
                )
                binding.ChangePasscode.isEnabled = true
//                binding.Info.setTextColor(ContextCompat.getColor(requireActivity(), R.color.text_color))
//                binding.Info.isEnabled = true
                HawkCommon.putHawkEventTurnPass(true)
                if (HawkCommon.getHawkListPinCode().isEmpty()){
                    val intent = Intent(requireActivity(), CreatePincodeActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }
            } else {
                HawkCommon.putHawkEventTurnPass(false)
                binding.ChangePasscode.setTextColor(
                    ContextCompat.getColor(
                        requireActivity(),
                        R.color.colorGray
                    )
                )
                binding.ChangePasscode.isEnabled = false
//                binding.Info.setTextColor(ContextCompat.getColor(requireActivity(), R.color.colorGray))
//                binding.Info.isEnabled = false
            }
            Log.e("AAAAAAAAA", "binding.switchTurnPass: " + HawkCommon.getHawkEventTurnPass(),)
        }


        binding.ChangePasscode.setOnClickListener {
            HawkCommon.putHawkEventEnterPassCode(true)
            val intent = Intent(activity, EnterPincodeActivity::class.java)
            intent.putExtra("SETTING", true)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

        binding.Info.setOnClickListener {
            val intent = Intent(activity, InfoUserActivity::class.java)
            intent.putExtra("SETTING_INFO", true)
            startActivity(intent)
        }

        binding.tvLanguage.setOnClickListener {
            val intent = Intent(activity, LanguageActivity::class.java)
            HawkCommon.putEventLanguage(true)
            startActivity(intent)
        }

        binding.GitHub.setOnClickListener {
            openLink("")
        }

        binding.Libraries.setOnClickListener {
            displayLibraries()
        }

        binding.Rate.setOnClickListener {
            openLink("")
        }

        binding.SendFeedback.setOnClickListener {
            sendEmailWithLog()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSettingsBinding.inflate(inflater)
        setupBinding(binding)
        return binding.root
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            intent?.data?.let { uri ->
                when (requestCode) {
                    REQUEST_IMPORT_BACKUP -> model.importBackup(uri)
                    REQUEST_EXPORT_BACKUP -> model.exportBackup(uri)
                    REQUEST_CHOOSE_FOLDER -> model.setAutoBackupPath(uri)
                }
            }
        }
    }


    private fun exportBackup() {
        val intent = Intent(Intent.ACTION_CREATE_DOCUMENT)
        intent.type = "application/zip"
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.putExtra(Intent.EXTRA_TITLE, "NoteBasic Backup")
        startActivityForResult(intent, REQUEST_EXPORT_BACKUP)
    }

    private fun importBackup() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.type = "*/*"
        intent.putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("application/zip", "text/xml"))
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(intent, REQUEST_IMPORT_BACKUP)
    }


    private fun sendEmailWithLog() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.selector = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"))

        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(""))
        intent.putExtra(Intent.EXTRA_SUBJECT, "")

        val app = requireContext().applicationContext as Application
        val log = Operations.getLog(app)
        if (log.exists()) {
            val uri = FileProvider.getUriForFile(app, "${app.packageName}.provider", log)
            intent.putExtra(Intent.EXTRA_STREAM, uri)
        }

        try {
            startActivity(intent)
        } catch (exception: ActivityNotFoundException) {
            Toast.makeText(requireContext(), R.string.install_an_email, Toast.LENGTH_LONG).show()
        }
    }

    private fun displayLibraries() {
        val libraries = arrayOf(
            "Pretty Time",
            "Swipe Layout",
            "Work Manager",
            "Material Components for Android"
        )
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.libraries)
            .setItems(libraries) { _, which ->
                when (which) {
                    0 -> openLink("")
                    1 -> openLink("")
                    2 -> openLink("")
                    3 -> openLink("")
                }
            }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }

    private fun displayChooseFolderDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setMessage(R.string.notes_will_be)
            .setPositiveButton(R.string.choose_folder) { _, _ ->
                val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
                startActivityForResult(intent, REQUEST_CHOOSE_FOLDER)
            }
            .show()
    }


    private fun PreferenceBinding.setup(info: ListInfo, value: String) {
        Title.setText(info.title)

        val entries = info.getEntries(requireContext())
        val entryValues = info.getEntryValues()

        val checked = entryValues.indexOf(value)
        val displayValue = entries[checked]

        Value.text = displayValue

        root.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(info.title)
                .setSingleChoiceItems(entries, checked) { dialog, which ->
                    dialog.cancel()
                    val newValue = entryValues[which]
                    model.savePreference(info, newValue)
                }
                .setNegativeButton(R.string.cancel, null)
                .show()
        }
    }

    private fun PreferenceBinding.setup(info: AutoBackup, value: String) {
        Title.setText(AutoBackup.title)

        if (value == AutoBackup.emptyPath) {
            Value.setText(R.string.tap_to_set_up)

            root.setOnClickListener { displayChooseFolderDialog() }
        } else {
            val uri = Uri.parse(value)
            val folder = requireNotNull(DocumentFile.fromTreeUri(requireContext(), uri))
            if (folder.exists()) {
                Value.text = folder.name
            } else Value.setText(R.string.cant_find_folder)

            root.setOnClickListener {
                MenuDialog(requireContext())
                    .add(R.string.disable_auto_backup) { model.disableAutoBackup() }
                    .add(R.string.choose_another_folder) { displayChooseFolderDialog() }
                    .show()
            }
        }
    }

    private fun PreferenceSeekbarBinding.setup(info: SeekbarInfo, initialValue: Int) {
        Title.setText(info.title)

        Slider.valueTo = info.max.toFloat()
        Slider.valueFrom = info.min.toFloat()

        Slider.value = initialValue.toFloat()

        Slider.addOnChangeListener { _, value, _ ->
            model.savePreference(info, value.toInt())
        }
    }


    private fun openLink(link: String) {
        val uri = Uri.parse(link)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        try {
            startActivity(intent)
        } catch (exception: ActivityNotFoundException) {
            Toast.makeText(requireContext(), R.string.install_a_browser, Toast.LENGTH_LONG).show()
        }
    }
}