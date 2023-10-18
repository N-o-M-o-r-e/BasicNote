package com.project.tathanhson.basicnote.database.dao

import androidx.room.Dao
import androidx.room.Transaction
import com.project.tathanhson.basicnote.model.BaseNote
import com.project.tathanhson.basicnote.model.Label
import com.project.tathanhson.basicnote.model.LabelsInBaseNote
import com.project.tathanhson.basicnote.model.NotallyDatabase

@Dao
abstract class CommonDao(private val database: NotallyDatabase) {

    @Transaction
    open suspend fun deleteLabel(value: String) {
        val labelsInBaseNotes = database.baseNoteDao.getListOfBaseNotesByLabel(value).map { baseNote ->
            val labels = ArrayList(baseNote.labels)
            labels.remove(value)
            LabelsInBaseNote(baseNote.id, labels)
        }
        database.baseNoteDao.update(labelsInBaseNotes)
        database.labelDao.delete(value)
    }

    @Transaction
    open suspend fun updateLabel(oldValue: String, newValue: String) {
        val labelsInBaseNotes = database.baseNoteDao.getListOfBaseNotesByLabel(oldValue).map { baseNote ->
            val labels = ArrayList(baseNote.labels)
            labels.remove(oldValue)
            labels.add(newValue)
            LabelsInBaseNote(baseNote.id, labels)
        }
        database.baseNoteDao.update(labelsInBaseNotes)
        database.labelDao.update(oldValue, newValue)
    }

    @Transaction
    open suspend fun importBackup(baseNotes: List<BaseNote>, labels: List<Label>) {
        database.baseNoteDao.insert(baseNotes)
        database.labelDao.insert(labels)
    }
}