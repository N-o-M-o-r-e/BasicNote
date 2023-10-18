package com.project.tathanhson.basicnote.widget

import android.app.Application
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews

import com.project.tathanhson.basicnote.R
import com.project.tathanhson.basicnote.activities.ConfigureWidget
import com.project.tathanhson.basicnote.activities.TakeNoteView
import com.project.tathanhson.basicnote.miscellaneous.Constants
import com.project.tathanhson.basicnote.preferences.Preferences

class WidgetProvider : AppWidgetProvider() {

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        if (intent.action == ACTION_NOTES_MODIFIED) {
            val noteIds = intent.getLongArrayExtra(EXTRA_MODIFIED_NOTES)
            if (noteIds != null) {
                val app = context.applicationContext as Application
                val preferences = Preferences.getInstance(app)

                val manager = AppWidgetManager.getInstance(context)
                val updatableWidgets = preferences.getUpdatableWidgets(noteIds)
                updatableWidgets.forEach { pair ->
                    updateWidget(context, manager, pair.first, pair.second)
                }
            }
        }
    }


    override fun onDeleted(context: Context, appWidgetIds: IntArray) {
        val app = context.applicationContext as Application
        val preferences = Preferences.getInstance(app)

        appWidgetIds.forEach { id -> preferences.deleteWidget(id) }
    }

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        val app = context.applicationContext as Application
        val preferences = Preferences.getInstance(app)

        appWidgetIds.forEach { id ->
            val noteId = preferences.getWidgetData(id)
            updateWidget(context, appWidgetManager, id, noteId)
        }
    }

    companion object {

        fun updateWidget(context: Context, manager: AppWidgetManager, id: Int, noteId: Long) {
            // Widgets displaying the same note share the same factory since only the noteId is embedded
            val intent = Intent(context, WidgetService::class.java)
            intent.putExtra(EXTRA_NOTE_ID, noteId)
            embedIntentExtras(intent)

            val view = RemoteViews(context.packageName, R.layout.widget)
            view.setRemoteAdapter(R.id.ListView, intent)
            view.setEmptyView(R.id.ListView, R.id.Empty)

            val selectNote = getSelectNoteIntent(context, id)
            view.setOnClickPendingIntent(R.id.Empty, selectNote)

            val openNote = getOpenNoteIntent(context, noteId)
            view.setPendingIntentTemplate(R.id.ListView, openNote)

            manager.updateAppWidget(id, view)
            manager.notifyAppWidgetViewDataChanged(id, R.id.ListView)
        }

        // Each widget has it's own intent since the widget id is embedded
        private fun getSelectNoteIntent(context: Context, id: Int): PendingIntent {
            val intent = Intent(context, ConfigureWidget::class.java)
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, id)
            embedIntentExtras(intent)
            val flags = PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            return PendingIntent.getActivity(context, 0, intent, flags)
        }

        private fun getOpenNoteIntent(context: Context, noteId: Long): PendingIntent {
            val intent = Intent(context, TakeNoteView::class.java)
            intent.putExtra(Constants.SelectedBaseNote, noteId)
            embedIntentExtras(intent)
            val flags = PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            return PendingIntent.getActivity(context, 0, intent, flags)
        }

        private fun embedIntentExtras(intent: Intent) {
            val string = intent.toUri(Intent.URI_INTENT_SCHEME)
            intent.data = Uri.parse(string)
        }

        const val EXTRA_NOTE_ID = "com.omgodse.notally.EXTRA_NOTE_ID"
        const val EXTRA_MODIFIED_NOTES = "com.omgodse.notally.EXTRA_MODIFIED_NOTES"
        const val ACTION_NOTES_MODIFIED = "com.omgodse.notally.ACTION_NOTE_MODIFIED"
    }
}