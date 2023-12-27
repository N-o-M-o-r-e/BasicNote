package com.sntthanh.notebasic.room.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sntthanh.notebasic.room.BaseNote;
import com.sntthanh.notebasic.room.Converters;
import com.sntthanh.notebasic.room.LabelsInBaseNote;
import com.sntthanh.notebasic.room.ListItem;
import com.sntthanh.notebasic.room.SpanRepresentation;
import com.sntthanh.notebasic.room.model.Color;
import com.sntthanh.notebasic.room.model.Folder;
import com.sntthanh.notebasic.room.model.Type;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class BaseNoteDao_Impl implements BaseNoteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BaseNote> __insertionAdapterOfBaseNote;

  private final EntityInsertionAdapter<BaseNote> __insertionAdapterOfBaseNote_1;

  private final EntityDeletionOrUpdateAdapter<LabelsInBaseNote> __updateAdapterOfLabelsInBaseNoteAsBaseNote;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  private final SharedSQLiteStatement __preparedStmtOfDeleteFrom;

  private final SharedSQLiteStatement __preparedStmtOfMove;

  private final SharedSQLiteStatement __preparedStmtOfUpdateColor;

  private final SharedSQLiteStatement __preparedStmtOfUpdatePinned;

  private final SharedSQLiteStatement __preparedStmtOfUpdateLabels;

  private final SharedSQLiteStatement __preparedStmtOfUpdateItems;

  public BaseNoteDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBaseNote = new EntityInsertionAdapter<BaseNote>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `BaseNote` (`id`,`type`,`folder`,`color`,`title`,`pinned`,`timestamp`,`labels`,`body`,`spans`,`items`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BaseNote value) {
        stmt.bindLong(1, value.getId());
        if (value.getType() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, __Type_enumToString(value.getType()));
        }
        if (value.getFolder() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, __Folder_enumToString(value.getFolder()));
        }
        if (value.getColor() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, __Color_enumToString(value.getColor()));
        }
        if (value.getTitle() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getTitle());
        }
        final int _tmp = value.getPinned() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        stmt.bindLong(7, value.getTimestamp());
        final String _tmp_1 = Converters.INSTANCE.labelsToJson(value.getLabels());
        if (_tmp_1 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp_1);
        }
        if (value.getBody() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getBody());
        }
        final String _tmp_2 = Converters.INSTANCE.spansToJson(value.getSpans());
        if (_tmp_2 == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, _tmp_2);
        }
        final String _tmp_3 = Converters.INSTANCE.itemsToJson(value.getItems());
        if (_tmp_3 == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, _tmp_3);
        }
      }
    };
    this.__insertionAdapterOfBaseNote_1 = new EntityInsertionAdapter<BaseNote>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `BaseNote` (`id`,`type`,`folder`,`color`,`title`,`pinned`,`timestamp`,`labels`,`body`,`spans`,`items`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BaseNote value) {
        stmt.bindLong(1, value.getId());
        if (value.getType() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, __Type_enumToString(value.getType()));
        }
        if (value.getFolder() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, __Folder_enumToString(value.getFolder()));
        }
        if (value.getColor() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, __Color_enumToString(value.getColor()));
        }
        if (value.getTitle() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getTitle());
        }
        final int _tmp = value.getPinned() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        stmt.bindLong(7, value.getTimestamp());
        final String _tmp_1 = Converters.INSTANCE.labelsToJson(value.getLabels());
        if (_tmp_1 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp_1);
        }
        if (value.getBody() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getBody());
        }
        final String _tmp_2 = Converters.INSTANCE.spansToJson(value.getSpans());
        if (_tmp_2 == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, _tmp_2);
        }
        final String _tmp_3 = Converters.INSTANCE.itemsToJson(value.getItems());
        if (_tmp_3 == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, _tmp_3);
        }
      }
    };
    this.__updateAdapterOfLabelsInBaseNoteAsBaseNote = new EntityDeletionOrUpdateAdapter<LabelsInBaseNote>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `BaseNote` SET `id` = ?,`labels` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LabelsInBaseNote value) {
        stmt.bindLong(1, value.getId());
        final String _tmp = Converters.INSTANCE.labelsToJson(value.getLabels());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
        stmt.bindLong(3, value.getId());
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM BaseNote WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteFrom = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM BaseNote WHERE folder = ?";
        return _query;
      }
    };
    this.__preparedStmtOfMove = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE BaseNote SET folder = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateColor = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE BaseNote SET color = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdatePinned = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE BaseNote SET pinned = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateLabels = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE BaseNote SET labels = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateItems = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE BaseNote SET items = ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final BaseNote baseNote, final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfBaseNote.insertAndReturnId(baseNote);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object insert(final List<BaseNote> baseNotes,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfBaseNote_1.insert(baseNotes);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final List<LabelsInBaseNote> labelsInBaseNotes,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfLabelsInBaseNoteAsBaseNote.handleMultiple(labelsInBaseNotes);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final long id, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDelete.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteFrom(final Folder folder, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteFrom.acquire();
        int _argIndex = 1;
        if (folder == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, __Folder_enumToString(folder));
        }
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteFrom.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object move(final long id, final Folder folder,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfMove.acquire();
        int _argIndex = 1;
        if (folder == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, __Folder_enumToString(folder));
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfMove.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object updateColor(final long id, final Color color,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateColor.acquire();
        int _argIndex = 1;
        if (color == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, __Color_enumToString(color));
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfUpdateColor.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object updatePinned(final long id, final boolean pinned,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatePinned.acquire();
        int _argIndex = 1;
        final int _tmp = pinned ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfUpdatePinned.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object updateLabels(final long id, final List<String> labels,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateLabels.acquire();
        int _argIndex = 1;
        final String _tmp = Converters.INSTANCE.labelsToJson(labels);
        if (_tmp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, _tmp);
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfUpdateLabels.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object updateItems(final long id, final List<ListItem> items,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateItems.acquire();
        int _argIndex = 1;
        final String _tmp = Converters.INSTANCE.itemsToJson(items);
        if (_tmp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, _tmp);
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfUpdateItems.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<BaseNote>> getFrom(final Folder folder) {
    final String _sql = "SELECT * FROM BaseNote WHERE folder = ? ORDER BY pinned DESC, timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (folder == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, __Folder_enumToString(folder));
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"BaseNote"}, false, new Callable<List<BaseNote>>() {
      @Override
      public List<BaseNote> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfFolder = CursorUtil.getColumnIndexOrThrow(_cursor, "folder");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "pinned");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfLabels = CursorUtil.getColumnIndexOrThrow(_cursor, "labels");
          final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "body");
          final int _cursorIndexOfSpans = CursorUtil.getColumnIndexOrThrow(_cursor, "spans");
          final int _cursorIndexOfItems = CursorUtil.getColumnIndexOrThrow(_cursor, "items");
          final List<BaseNote> _result = new ArrayList<BaseNote>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final BaseNote _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final Type _tmpType;
            _tmpType = __Type_stringToEnum(_cursor.getString(_cursorIndexOfType));
            final Folder _tmpFolder;
            _tmpFolder = __Folder_stringToEnum(_cursor.getString(_cursorIndexOfFolder));
            final Color _tmpColor;
            _tmpColor = __Color_stringToEnum(_cursor.getString(_cursorIndexOfColor));
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final boolean _tmpPinned;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfPinned);
            _tmpPinned = _tmp != 0;
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final List<String> _tmpLabels;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfLabels)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfLabels);
            }
            _tmpLabels = Converters.INSTANCE.jsonToLabels(_tmp_1);
            final String _tmpBody;
            if (_cursor.isNull(_cursorIndexOfBody)) {
              _tmpBody = null;
            } else {
              _tmpBody = _cursor.getString(_cursorIndexOfBody);
            }
            final List<SpanRepresentation> _tmpSpans;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfSpans)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfSpans);
            }
            _tmpSpans = Converters.INSTANCE.jsonToSpans(_tmp_2);
            final List<ListItem> _tmpItems;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfItems)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfItems);
            }
            _tmpItems = Converters.INSTANCE.jsonToItems(_tmp_3);
            _item = new BaseNote(_tmpId,_tmpType,_tmpFolder,_tmpColor,_tmpTitle,_tmpPinned,_tmpTimestamp,_tmpLabels,_tmpBody,_tmpSpans,_tmpItems);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<BaseNote>> getAll() {
    final String _sql = "SELECT * FROM BaseNote";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"BaseNote"}, false, new Callable<List<BaseNote>>() {
      @Override
      public List<BaseNote> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfFolder = CursorUtil.getColumnIndexOrThrow(_cursor, "folder");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "pinned");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfLabels = CursorUtil.getColumnIndexOrThrow(_cursor, "labels");
          final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "body");
          final int _cursorIndexOfSpans = CursorUtil.getColumnIndexOrThrow(_cursor, "spans");
          final int _cursorIndexOfItems = CursorUtil.getColumnIndexOrThrow(_cursor, "items");
          final List<BaseNote> _result = new ArrayList<BaseNote>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final BaseNote _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final Type _tmpType;
            _tmpType = __Type_stringToEnum(_cursor.getString(_cursorIndexOfType));
            final Folder _tmpFolder;
            _tmpFolder = __Folder_stringToEnum(_cursor.getString(_cursorIndexOfFolder));
            final Color _tmpColor;
            _tmpColor = __Color_stringToEnum(_cursor.getString(_cursorIndexOfColor));
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final boolean _tmpPinned;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfPinned);
            _tmpPinned = _tmp != 0;
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final List<String> _tmpLabels;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfLabels)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfLabels);
            }
            _tmpLabels = Converters.INSTANCE.jsonToLabels(_tmp_1);
            final String _tmpBody;
            if (_cursor.isNull(_cursorIndexOfBody)) {
              _tmpBody = null;
            } else {
              _tmpBody = _cursor.getString(_cursorIndexOfBody);
            }
            final List<SpanRepresentation> _tmpSpans;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfSpans)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfSpans);
            }
            _tmpSpans = Converters.INSTANCE.jsonToSpans(_tmp_2);
            final List<ListItem> _tmpItems;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfItems)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfItems);
            }
            _tmpItems = Converters.INSTANCE.jsonToItems(_tmp_3);
            _item = new BaseNote(_tmpId,_tmpType,_tmpFolder,_tmpColor,_tmpTitle,_tmpPinned,_tmpTimestamp,_tmpLabels,_tmpBody,_tmpSpans,_tmpItems);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public BaseNote get(final long id) {
    final String _sql = "SELECT * FROM BaseNote WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfFolder = CursorUtil.getColumnIndexOrThrow(_cursor, "folder");
      final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "pinned");
      final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
      final int _cursorIndexOfLabels = CursorUtil.getColumnIndexOrThrow(_cursor, "labels");
      final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "body");
      final int _cursorIndexOfSpans = CursorUtil.getColumnIndexOrThrow(_cursor, "spans");
      final int _cursorIndexOfItems = CursorUtil.getColumnIndexOrThrow(_cursor, "items");
      final BaseNote _result;
      if(_cursor.moveToFirst()) {
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final Type _tmpType;
        _tmpType = __Type_stringToEnum(_cursor.getString(_cursorIndexOfType));
        final Folder _tmpFolder;
        _tmpFolder = __Folder_stringToEnum(_cursor.getString(_cursorIndexOfFolder));
        final Color _tmpColor;
        _tmpColor = __Color_stringToEnum(_cursor.getString(_cursorIndexOfColor));
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        final boolean _tmpPinned;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfPinned);
        _tmpPinned = _tmp != 0;
        final long _tmpTimestamp;
        _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
        final List<String> _tmpLabels;
        final String _tmp_1;
        if (_cursor.isNull(_cursorIndexOfLabels)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getString(_cursorIndexOfLabels);
        }
        _tmpLabels = Converters.INSTANCE.jsonToLabels(_tmp_1);
        final String _tmpBody;
        if (_cursor.isNull(_cursorIndexOfBody)) {
          _tmpBody = null;
        } else {
          _tmpBody = _cursor.getString(_cursorIndexOfBody);
        }
        final List<SpanRepresentation> _tmpSpans;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfSpans)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfSpans);
        }
        _tmpSpans = Converters.INSTANCE.jsonToSpans(_tmp_2);
        final List<ListItem> _tmpItems;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfItems)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfItems);
        }
        _tmpItems = Converters.INSTANCE.jsonToItems(_tmp_3);
        _result = new BaseNote(_tmpId,_tmpType,_tmpFolder,_tmpColor,_tmpTitle,_tmpPinned,_tmpTimestamp,_tmpLabels,_tmpBody,_tmpSpans,_tmpItems);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Object getDeletedNoteIds(final Continuation<? super long[]> continuation) {
    final String _sql = "SELECT id FROM BaseNote WHERE folder = 'DELETED'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<long[]>() {
      @Override
      public long[] call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final long[] _result = new long[_cursor.getCount()];
          int _index = 0;
          while(_cursor.moveToNext()) {
            final long _item;
            _item = _cursor.getLong(0);
            _result[_index] = _item;
            _index ++;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAllNotes(final Continuation<? super List<BaseNote>> continuation) {
    final String _sql = "SELECT * FROM BaseNote WHERE folder = 'NOTES' ORDER BY pinned DESC, timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<BaseNote>>() {
      @Override
      public List<BaseNote> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfFolder = CursorUtil.getColumnIndexOrThrow(_cursor, "folder");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "pinned");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfLabels = CursorUtil.getColumnIndexOrThrow(_cursor, "labels");
          final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "body");
          final int _cursorIndexOfSpans = CursorUtil.getColumnIndexOrThrow(_cursor, "spans");
          final int _cursorIndexOfItems = CursorUtil.getColumnIndexOrThrow(_cursor, "items");
          final List<BaseNote> _result = new ArrayList<BaseNote>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final BaseNote _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final Type _tmpType;
            _tmpType = __Type_stringToEnum(_cursor.getString(_cursorIndexOfType));
            final Folder _tmpFolder;
            _tmpFolder = __Folder_stringToEnum(_cursor.getString(_cursorIndexOfFolder));
            final Color _tmpColor;
            _tmpColor = __Color_stringToEnum(_cursor.getString(_cursorIndexOfColor));
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final boolean _tmpPinned;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfPinned);
            _tmpPinned = _tmp != 0;
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final List<String> _tmpLabels;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfLabels)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfLabels);
            }
            _tmpLabels = Converters.INSTANCE.jsonToLabels(_tmp_1);
            final String _tmpBody;
            if (_cursor.isNull(_cursorIndexOfBody)) {
              _tmpBody = null;
            } else {
              _tmpBody = _cursor.getString(_cursorIndexOfBody);
            }
            final List<SpanRepresentation> _tmpSpans;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfSpans)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfSpans);
            }
            _tmpSpans = Converters.INSTANCE.jsonToSpans(_tmp_2);
            final List<ListItem> _tmpItems;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfItems)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfItems);
            }
            _tmpItems = Converters.INSTANCE.jsonToItems(_tmp_3);
            _item = new BaseNote(_tmpId,_tmpType,_tmpFolder,_tmpColor,_tmpTitle,_tmpPinned,_tmpTimestamp,_tmpLabels,_tmpBody,_tmpSpans,_tmpItems);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<BaseNote>> getBaseNotesByLabel(final String label, final Folder folder) {
    final String _sql = "SELECT * FROM BaseNote WHERE folder = ? AND labels LIKE '%' || ? || '%' ORDER BY pinned DESC, timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (folder == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, __Folder_enumToString(folder));
    }
    _argIndex = 2;
    if (label == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, label);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"BaseNote"}, false, new Callable<List<BaseNote>>() {
      @Override
      public List<BaseNote> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfFolder = CursorUtil.getColumnIndexOrThrow(_cursor, "folder");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "pinned");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfLabels = CursorUtil.getColumnIndexOrThrow(_cursor, "labels");
          final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "body");
          final int _cursorIndexOfSpans = CursorUtil.getColumnIndexOrThrow(_cursor, "spans");
          final int _cursorIndexOfItems = CursorUtil.getColumnIndexOrThrow(_cursor, "items");
          final List<BaseNote> _result = new ArrayList<BaseNote>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final BaseNote _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final Type _tmpType;
            _tmpType = __Type_stringToEnum(_cursor.getString(_cursorIndexOfType));
            final Folder _tmpFolder;
            _tmpFolder = __Folder_stringToEnum(_cursor.getString(_cursorIndexOfFolder));
            final Color _tmpColor;
            _tmpColor = __Color_stringToEnum(_cursor.getString(_cursorIndexOfColor));
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final boolean _tmpPinned;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfPinned);
            _tmpPinned = _tmp != 0;
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final List<String> _tmpLabels;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfLabels)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfLabels);
            }
            _tmpLabels = Converters.INSTANCE.jsonToLabels(_tmp_1);
            final String _tmpBody;
            if (_cursor.isNull(_cursorIndexOfBody)) {
              _tmpBody = null;
            } else {
              _tmpBody = _cursor.getString(_cursorIndexOfBody);
            }
            final List<SpanRepresentation> _tmpSpans;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfSpans)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfSpans);
            }
            _tmpSpans = Converters.INSTANCE.jsonToSpans(_tmp_2);
            final List<ListItem> _tmpItems;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfItems)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfItems);
            }
            _tmpItems = Converters.INSTANCE.jsonToItems(_tmp_3);
            _item = new BaseNote(_tmpId,_tmpType,_tmpFolder,_tmpColor,_tmpTitle,_tmpPinned,_tmpTimestamp,_tmpLabels,_tmpBody,_tmpSpans,_tmpItems);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getListOfBaseNotesByLabelImpl(final String label,
      final Continuation<? super List<BaseNote>> continuation) {
    final String _sql = "SELECT * FROM BaseNote WHERE labels LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (label == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, label);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<BaseNote>>() {
      @Override
      public List<BaseNote> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfFolder = CursorUtil.getColumnIndexOrThrow(_cursor, "folder");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "pinned");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfLabels = CursorUtil.getColumnIndexOrThrow(_cursor, "labels");
          final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "body");
          final int _cursorIndexOfSpans = CursorUtil.getColumnIndexOrThrow(_cursor, "spans");
          final int _cursorIndexOfItems = CursorUtil.getColumnIndexOrThrow(_cursor, "items");
          final List<BaseNote> _result = new ArrayList<BaseNote>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final BaseNote _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final Type _tmpType;
            _tmpType = __Type_stringToEnum(_cursor.getString(_cursorIndexOfType));
            final Folder _tmpFolder;
            _tmpFolder = __Folder_stringToEnum(_cursor.getString(_cursorIndexOfFolder));
            final Color _tmpColor;
            _tmpColor = __Color_stringToEnum(_cursor.getString(_cursorIndexOfColor));
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final boolean _tmpPinned;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfPinned);
            _tmpPinned = _tmp != 0;
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final List<String> _tmpLabels;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfLabels)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfLabels);
            }
            _tmpLabels = Converters.INSTANCE.jsonToLabels(_tmp_1);
            final String _tmpBody;
            if (_cursor.isNull(_cursorIndexOfBody)) {
              _tmpBody = null;
            } else {
              _tmpBody = _cursor.getString(_cursorIndexOfBody);
            }
            final List<SpanRepresentation> _tmpSpans;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfSpans)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfSpans);
            }
            _tmpSpans = Converters.INSTANCE.jsonToSpans(_tmp_2);
            final List<ListItem> _tmpItems;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfItems)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfItems);
            }
            _tmpItems = Converters.INSTANCE.jsonToItems(_tmp_3);
            _item = new BaseNote(_tmpId,_tmpType,_tmpFolder,_tmpColor,_tmpTitle,_tmpPinned,_tmpTimestamp,_tmpLabels,_tmpBody,_tmpSpans,_tmpItems);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<BaseNote>> getBaseNotesByKeywordImpl(final String keyword,
      final Folder folder) {
    final String _sql = "SELECT * FROM BaseNote WHERE folder = ? AND (title LIKE '%' || ? || '%' OR body LIKE '%' || ? || '%' OR items LIKE '%' || ? || '%' OR labels LIKE '%' || ? || '%') ORDER BY pinned DESC, timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 5);
    int _argIndex = 1;
    if (folder == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, __Folder_enumToString(folder));
    }
    _argIndex = 2;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"BaseNote"}, false, new Callable<List<BaseNote>>() {
      @Override
      public List<BaseNote> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfFolder = CursorUtil.getColumnIndexOrThrow(_cursor, "folder");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "pinned");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfLabels = CursorUtil.getColumnIndexOrThrow(_cursor, "labels");
          final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "body");
          final int _cursorIndexOfSpans = CursorUtil.getColumnIndexOrThrow(_cursor, "spans");
          final int _cursorIndexOfItems = CursorUtil.getColumnIndexOrThrow(_cursor, "items");
          final List<BaseNote> _result = new ArrayList<BaseNote>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final BaseNote _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final Type _tmpType;
            _tmpType = __Type_stringToEnum(_cursor.getString(_cursorIndexOfType));
            final Folder _tmpFolder;
            _tmpFolder = __Folder_stringToEnum(_cursor.getString(_cursorIndexOfFolder));
            final Color _tmpColor;
            _tmpColor = __Color_stringToEnum(_cursor.getString(_cursorIndexOfColor));
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final boolean _tmpPinned;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfPinned);
            _tmpPinned = _tmp != 0;
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final List<String> _tmpLabels;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfLabels)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfLabels);
            }
            _tmpLabels = Converters.INSTANCE.jsonToLabels(_tmp_1);
            final String _tmpBody;
            if (_cursor.isNull(_cursorIndexOfBody)) {
              _tmpBody = null;
            } else {
              _tmpBody = _cursor.getString(_cursorIndexOfBody);
            }
            final List<SpanRepresentation> _tmpSpans;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfSpans)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfSpans);
            }
            _tmpSpans = Converters.INSTANCE.jsonToSpans(_tmp_2);
            final List<ListItem> _tmpItems;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfItems)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfItems);
            }
            _tmpItems = Converters.INSTANCE.jsonToItems(_tmp_3);
            _item = new BaseNote(_tmpId,_tmpType,_tmpFolder,_tmpColor,_tmpTitle,_tmpPinned,_tmpTimestamp,_tmpLabels,_tmpBody,_tmpSpans,_tmpItems);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public int query(final SupportSQLiteQuery query) {
    final SupportSQLiteQuery _internalQuery = query;
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _internalQuery, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
    }
  }

  @Override
  public Object updateChecked(final long id, final int position, final boolean checked,
      final Continuation<? super Unit> continuation) {
    return BaseNoteDao.DefaultImpls.updateChecked(BaseNoteDao_Impl.this, id, position, checked, continuation);
  }

  @Override
  public LiveData<List<BaseNote>> getBaseNotesByLabel(final String label) {
    return BaseNoteDao.DefaultImpls.getBaseNotesByLabel(BaseNoteDao_Impl.this, label);
  }

  @Override
  public Object getListOfBaseNotesByLabel(final String label,
      final Continuation<? super List<BaseNote>> continuation) {
    return BaseNoteDao.DefaultImpls.getListOfBaseNotesByLabel(BaseNoteDao_Impl.this, label, continuation);
  }

  @Override
  public LiveData<List<BaseNote>> getBaseNotesByKeyword(final String keyword, final Folder folder) {
    return BaseNoteDao.DefaultImpls.getBaseNotesByKeyword(BaseNoteDao_Impl.this, keyword, folder);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __Type_enumToString(final Type _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case NOTE: return "NOTE";
      case LIST: return "LIST";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private String __Folder_enumToString(final Folder _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case NOTES: return "NOTES";
      case DELETED: return "DELETED";
      case ARCHIVED: return "ARCHIVED";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private String __Color_enumToString(final Color _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case DEFAULT: return "DEFAULT";
      case CORAL: return "CORAL";
      case ORANGE: return "ORANGE";
      case SAND: return "SAND";
      case STORM: return "STORM";
      case FOG: return "FOG";
      case SAGE: return "SAGE";
      case MINT: return "MINT";
      case DUSK: return "DUSK";
      case FLOWER: return "FLOWER";
      case BLOSSOM: return "BLOSSOM";
      case CLAY: return "CLAY";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private Type __Type_stringToEnum(final String _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case "NOTE": return Type.NOTE;
      case "LIST": return Type.LIST;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private Folder __Folder_stringToEnum(final String _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case "NOTES": return Folder.NOTES;
      case "DELETED": return Folder.DELETED;
      case "ARCHIVED": return Folder.ARCHIVED;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private Color __Color_stringToEnum(final String _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case "DEFAULT": return Color.DEFAULT;
      case "CORAL": return Color.CORAL;
      case "ORANGE": return Color.ORANGE;
      case "SAND": return Color.SAND;
      case "STORM": return Color.STORM;
      case "FOG": return Color.FOG;
      case "SAGE": return Color.SAGE;
      case "MINT": return Color.MINT;
      case "DUSK": return Color.DUSK;
      case "FLOWER": return Color.FLOWER;
      case "BLOSSOM": return Color.BLOSSOM;
      case "CLAY": return Color.CLAY;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
