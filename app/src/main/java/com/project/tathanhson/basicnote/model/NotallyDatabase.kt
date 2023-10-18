package com.project.tathanhson.basicnote.model

import android.app.Application
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteDatabase
import com.project.tathanhson.basicnote.database.dao.BaseNoteDao
import com.project.tathanhson.basicnote.database.dao.CommonDao
import com.project.tathanhson.basicnote.database.dao.LabelDao


@TypeConverters(Converters::class)
@Database(entities = [BaseNote::class, Label::class], version = 2)
abstract class NotallyDatabase : RoomDatabase() {

    abstract val labelDao: LabelDao
    abstract val commonDao: CommonDao
    abstract val baseNoteDao: BaseNoteDao

    fun checkpoint() {
        baseNoteDao.query(SimpleSQLiteQuery("pragma wal_checkpoint(FULL)"))
    }

    companion object {

        const val DatabaseName = "NotallyDatabase"

        @Volatile
        private var instance: NotallyDatabase? = null

        fun getDatabase(app: Application): NotallyDatabase {
            return instance ?: synchronized(this) {
                val instance = Room.databaseBuilder(app, NotallyDatabase::class.java, DatabaseName)
                    .addMigrations(Migration2)
                    .build()
                Companion.instance = instance
                return instance
            }
        }

        object Migration2 : Migration(1, 2) {

            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE `BaseNote` ADD COLUMN `color` TEXT NOT NULL DEFAULT 'DEFAULT'")
            }
        }
    }
}