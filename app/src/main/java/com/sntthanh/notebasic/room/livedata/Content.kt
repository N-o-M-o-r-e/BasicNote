package com.sntthanh.notebasic.room.livedata

import androidx.lifecycle.LiveData
import com.sntthanh.notebasic.room.BaseNote
import com.sntthanh.notebasic.room.Item

class Content(liveData: LiveData<List<BaseNote>>, transform: (List<BaseNote>) -> List<Item>) : LiveData<List<Item>>() {

    init {
        liveData.observeForever { list -> value = transform(list) }
    }
}