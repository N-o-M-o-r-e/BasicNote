package com.sntthanh.notebasic.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Label(@PrimaryKey val value: String)