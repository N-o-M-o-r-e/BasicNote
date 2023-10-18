package com.project.tathanhson.basicnote.viewmodels.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.project.tathanhson.basicnote.database.dao.BaseNoteDao
import com.project.tathanhson.basicnote.model.BaseNote
import com.project.tathanhson.basicnote.model.Folder
import com.project.tathanhson.basicnote.model.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SearchResult(
    private val scope: CoroutineScope,
    private val baseNoteDao: BaseNoteDao,
    transform: (List<BaseNote>) -> List<Item>
) : LiveData<List<Item>>() {

    private var job: Job? = null
    private var liveData: LiveData<List<BaseNote>>? = null
    private val observer = Observer<List<BaseNote>> { list -> value = transform(list) }

    init {
        value = emptyList()
    }

    fun fetch(keyword: String, folder: Folder) {
        job?.cancel()
        liveData?.removeObserver(observer)
        job = scope.launch {
            if (keyword.isNotEmpty()) {
                liveData = baseNoteDao.getBaseNotesByKeyword(keyword, folder)
                liveData?.observeForever(observer)
            } else value = emptyList()
        }
    }
}