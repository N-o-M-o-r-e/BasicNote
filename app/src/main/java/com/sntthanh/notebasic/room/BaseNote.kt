package com.sntthanh.notebasic.room

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.sntthanh.notebasic.room.model.Color
import com.sntthanh.notebasic.room.model.Folder
import com.sntthanh.notebasic.room.model.Type

@Entity(indices = [Index(value = ["id", "folder", "pinned", "timestamp", "labels"])])
data class BaseNote(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val type: Type,
    val folder: Folder,
    val color: Color,
    val title: String,
    val pinned: Boolean,
    val timestamp: Long,
    val labels: List<String>,
    val body: String,
    val spans: List<SpanRepresentation>,
    val items: List<ListItem>,
) : Item