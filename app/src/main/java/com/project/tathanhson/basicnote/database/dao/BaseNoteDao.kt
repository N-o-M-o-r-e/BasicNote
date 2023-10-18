package com.project.tathanhson.basicnote.database.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.project.tathanhson.basicnote.model.BaseNote
import com.project.tathanhson.basicnote.model.Color
import com.project.tathanhson.basicnote.model.Folder
import com.project.tathanhson.basicnote.model.LabelsInBaseNote

@Dao
interface BaseNoteDao {

    @RawQuery
    fun query(query: SupportSQLiteQuery): Int


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(baseNote: BaseNote): Long

    @Insert
    suspend fun insert(baseNotes: List<BaseNote>)

    @Update(entity = BaseNote::class)
    suspend fun update(labelsInBaseNotes: List<LabelsInBaseNote>)


    @Query("DELETE FROM BaseNote WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM BaseNote WHERE folder = :folder")
    suspend fun deleteFrom(folder: Folder)

    @Query("SELECT * FROM BaseNote WHERE folder = :folder ORDER BY pinned DESC, timestamp DESC")
    fun getFrom(folder: Folder): LiveData<List<BaseNote>>

    @Query("SELECT * FROM BaseNote")
    fun getAll(): LiveData<List<BaseNote>>

    @Query("SELECT * FROM BaseNote WHERE id = :id")
    fun get(id: Long): BaseNote


    @Query("SELECT id FROM BaseNote WHERE folder = 'DELETED'")
    suspend fun getDeletedNoteIds(): LongArray


    @Query("SELECT * FROM BaseNote WHERE folder = 'NOTES' AND type = 'NOTE' ORDER BY pinned DESC, timestamp DESC")
    suspend fun getAllNotes(): List<BaseNote>


    @Query("UPDATE BaseNote SET folder = :folder WHERE id = :id")
    suspend fun move(id: Long, folder: Folder)


    @Query("UPDATE BaseNote SET color = :color WHERE id = :id")
    suspend fun updateColor(id: Long, color: Color)

    @Query("UPDATE BaseNote SET pinned = :pinned WHERE id = :id")
    suspend fun updatePinned(id: Long, pinned: Boolean)

    @Query("UPDATE BaseNote SET labels = :labels WHERE id = :id")
    suspend fun updateLabels(id: Long, labels: List<String>)


    fun getBaseNotesByLabel(label: String): LiveData<List<BaseNote>> {
        val result = getBaseNotesByLabel(label, Folder.NOTES)

        val filteredLiveData = MediatorLiveData<List<BaseNote>>()

        filteredLiveData.addSource(result) { list ->
            val filteredList = list.filter { baseNote -> baseNote.labels.contains(label) }
            filteredLiveData.value = filteredList
        }

        return filteredLiveData
    }


    @Query("SELECT * FROM BaseNote WHERE folder = :folder AND labels LIKE '%' || :label || '%' ORDER BY pinned DESC, timestamp DESC")
    fun getBaseNotesByLabel(label: String, folder: Folder): LiveData<List<BaseNote>>


    suspend fun getListOfBaseNotesByLabel(label: String): List<BaseNote> {
        val result = getListOfBaseNotesByLabelImpl(label)
        return result.filter { baseNote -> baseNote.labels.contains(label) }
    }

    @Query("SELECT * FROM BaseNote WHERE labels LIKE '%' || :label || '%'")
    suspend fun getListOfBaseNotesByLabelImpl(label: String): List<BaseNote>


    //    fun getBaseNotesByKeyword(keyword: String, folder: Folder): LiveData<List<BaseNote>> {
//        val result = getBaseNotesByKeywordImpl(keyword, folder)
//        return Transformations.map(result) { list -> list.filter { baseNote -> matchesKeyword(baseNote, keyword) } }
//    }
    fun getBaseNotesByKeyword(keyword: String, folder: Folder): LiveData<List<BaseNote>> {
        val result = getBaseNotesByKeywordImpl(keyword, folder)

        val filteredLiveData = MediatorLiveData<List<BaseNote>>()

        filteredLiveData.addSource(result) { list ->
            val filteredList = list.filter { baseNote -> matchesKeyword(baseNote, keyword) }
            filteredLiveData.value = filteredList
        }

        return filteredLiveData
    }


    @Query("SELECT * FROM BaseNote WHERE folder = :folder AND (title LIKE '%' || :keyword || '%' OR body LIKE '%' || :keyword || '%' OR items LIKE '%' || :keyword || '%' OR labels LIKE '%' || :keyword || '%') ORDER BY pinned DESC, timestamp DESC")
    fun getBaseNotesByKeywordImpl(keyword: String, folder: Folder): LiveData<List<BaseNote>>


    private fun matchesKeyword(baseNote: BaseNote, keyword: String): Boolean {
        if (baseNote.title.contains(keyword, true)) {
            return true
        }
        if (baseNote.body.contains(keyword, true)) {
            return true
        }
        for (label in baseNote.labels) {
            if (label.contains(keyword, true)) {
                return true
            }
        }
        for (item in baseNote.items) {
            if (item.body.contains(keyword, true)) {
                return true
            }
        }
        return false
    }
}