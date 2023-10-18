package com.project.tathanhson.basicnote.viewmodels.livedata

import androidx.lifecycle.LiveData
import com.project.tathanhson.basicnote.model.BaseNote
import com.project.tathanhson.basicnote.model.Item

class Content(liveData: LiveData<List<BaseNote>>, transform: (List<BaseNote>) -> List<Item>) :
    LiveData<List<Item>>() {

    init {
        liveData.observeForever { list -> value = transform(list) }
    }
}