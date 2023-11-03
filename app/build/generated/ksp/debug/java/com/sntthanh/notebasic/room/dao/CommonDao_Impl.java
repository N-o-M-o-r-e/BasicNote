package com.sntthanh.notebasic.room.dao;

import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import com.sntthanh.notebasic.room.BaseNote;
import com.sntthanh.notebasic.room.Label;
import com.sntthanh.notebasic.room.NotallyDatabase;
import java.lang.Class;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CommonDao_Impl extends CommonDao {
  private final RoomDatabase __db;

  public CommonDao_Impl(NotallyDatabase __db) {
    super(__db);
    this.__db = __db;
  }

  @Override
  public Object deleteLabel(final String value, final Continuation<? super Unit> continuation) {
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> CommonDao_Impl.super.deleteLabel(value, __cont), continuation);
  }

  @Override
  public Object updateLabel(final String oldValue, final String newValue,
      final Continuation<? super Unit> continuation) {
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> CommonDao_Impl.super.updateLabel(oldValue, newValue, __cont), continuation);
  }

  @Override
  public Object importBackup(final List<BaseNote> baseNotes, final List<Label> labels,
      final Continuation<? super Unit> continuation) {
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> CommonDao_Impl.super.importBackup(baseNotes, labels, __cont), continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
