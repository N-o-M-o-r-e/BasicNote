package com.sntthanh.notebasic.room;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.sntthanh.notebasic.room.dao.BaseNoteDao;
import com.sntthanh.notebasic.room.dao.BaseNoteDao_Impl;
import com.sntthanh.notebasic.room.dao.CommonDao;
import com.sntthanh.notebasic.room.dao.CommonDao_Impl;
import com.sntthanh.notebasic.room.dao.LabelDao;
import com.sntthanh.notebasic.room.dao.LabelDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NotallyDatabase_Impl extends NotallyDatabase {
  private volatile LabelDao _labelDao;

  private volatile CommonDao _commonDao;

  private volatile BaseNoteDao _baseNoteDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `BaseNote` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `type` TEXT NOT NULL, `folder` TEXT NOT NULL, `color` TEXT NOT NULL, `title` TEXT NOT NULL, `pinned` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `labels` TEXT NOT NULL, `body` TEXT NOT NULL, `spans` TEXT NOT NULL, `items` TEXT NOT NULL)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_BaseNote_id_folder_pinned_timestamp_labels` ON `BaseNote` (`id`, `folder`, `pinned`, `timestamp`, `labels`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Label` (`value` TEXT NOT NULL, PRIMARY KEY(`value`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '4b4b549bcedcae938a5da7fd5433af4f')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `BaseNote`");
        _db.execSQL("DROP TABLE IF EXISTS `Label`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsBaseNote = new HashMap<String, TableInfo.Column>(11);
        _columnsBaseNote.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBaseNote.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBaseNote.put("folder", new TableInfo.Column("folder", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBaseNote.put("color", new TableInfo.Column("color", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBaseNote.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBaseNote.put("pinned", new TableInfo.Column("pinned", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBaseNote.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBaseNote.put("labels", new TableInfo.Column("labels", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBaseNote.put("body", new TableInfo.Column("body", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBaseNote.put("spans", new TableInfo.Column("spans", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBaseNote.put("items", new TableInfo.Column("items", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBaseNote = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBaseNote = new HashSet<TableInfo.Index>(1);
        _indicesBaseNote.add(new TableInfo.Index("index_BaseNote_id_folder_pinned_timestamp_labels", false, Arrays.asList("id","folder","pinned","timestamp","labels"), Arrays.asList("ASC","ASC","ASC","ASC","ASC")));
        final TableInfo _infoBaseNote = new TableInfo("BaseNote", _columnsBaseNote, _foreignKeysBaseNote, _indicesBaseNote);
        final TableInfo _existingBaseNote = TableInfo.read(_db, "BaseNote");
        if (! _infoBaseNote.equals(_existingBaseNote)) {
          return new RoomOpenHelper.ValidationResult(false, "BaseNote(com.sntthanh.notebasic.room.BaseNote).\n"
                  + " Expected:\n" + _infoBaseNote + "\n"
                  + " Found:\n" + _existingBaseNote);
        }
        final HashMap<String, TableInfo.Column> _columnsLabel = new HashMap<String, TableInfo.Column>(1);
        _columnsLabel.put("value", new TableInfo.Column("value", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLabel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLabel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLabel = new TableInfo("Label", _columnsLabel, _foreignKeysLabel, _indicesLabel);
        final TableInfo _existingLabel = TableInfo.read(_db, "Label");
        if (! _infoLabel.equals(_existingLabel)) {
          return new RoomOpenHelper.ValidationResult(false, "Label(com.sntthanh.notebasic.room.Label).\n"
                  + " Expected:\n" + _infoLabel + "\n"
                  + " Found:\n" + _existingLabel);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "4b4b549bcedcae938a5da7fd5433af4f", "009eb9d96c4db9497d7adf17c5b30ca5");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "BaseNote","Label");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `BaseNote`");
      _db.execSQL("DELETE FROM `Label`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(LabelDao.class, LabelDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CommonDao.class, CommonDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(BaseNoteDao.class, BaseNoteDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public LabelDao getLabelDao() {
    if (_labelDao != null) {
      return _labelDao;
    } else {
      synchronized(this) {
        if(_labelDao == null) {
          _labelDao = new LabelDao_Impl(this);
        }
        return _labelDao;
      }
    }
  }

  @Override
  public CommonDao getCommonDao() {
    if (_commonDao != null) {
      return _commonDao;
    } else {
      synchronized(this) {
        if(_commonDao == null) {
          _commonDao = new CommonDao_Impl(this);
        }
        return _commonDao;
      }
    }
  }

  @Override
  public BaseNoteDao getBaseNoteDao() {
    if (_baseNoteDao != null) {
      return _baseNoteDao;
    } else {
      synchronized(this) {
        if(_baseNoteDao == null) {
          _baseNoteDao = new BaseNoteDao_Impl(this);
        }
        return _baseNoteDao;
      }
    }
  }
}
