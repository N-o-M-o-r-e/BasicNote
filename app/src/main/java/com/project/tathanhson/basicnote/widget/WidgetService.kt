package com.project.tathanhson.basicnote.widget

import android.content.Intent
import android.widget.RemoteViewsService
import com.project.tathanhson.basicnote.widget.WidgetFactory

class WidgetService : RemoteViewsService() {

    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory {
        return WidgetFactory(applicationContext, intent)
    }
}