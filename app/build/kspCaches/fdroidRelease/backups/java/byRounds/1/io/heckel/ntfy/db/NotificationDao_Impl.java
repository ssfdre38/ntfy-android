package io.heckel.ntfy.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class NotificationDao_Impl implements NotificationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Notification> __insertionAdapterOfNotification;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<Notification> __updateAdapterOfNotification;

  private final SharedSQLiteStatement __preparedStmtOfClearIconUri;

  private final SharedSQLiteStatement __preparedStmtOfClearAllNotificationIds;

  private final SharedSQLiteStatement __preparedStmtOfMarkAsDeleted;

  private final SharedSQLiteStatement __preparedStmtOfMarkAllAsDeleted;

  private final SharedSQLiteStatement __preparedStmtOfMarkAsDeletedIfOlderThan;

  private final SharedSQLiteStatement __preparedStmtOfUndelete;

  private final SharedSQLiteStatement __preparedStmtOfRemoveIfOlderThan;

  private final SharedSQLiteStatement __preparedStmtOfRemoveAll;

  public NotificationDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNotification = new EntityInsertionAdapter<Notification>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR IGNORE INTO `Notification` (`id`,`subscriptionId`,`timestamp`,`title`,`message`,`contentType`,`encoding`,`notificationId`,`priority`,`tags`,`click`,`actions`,`deleted`,`icon_url`,`icon_contentUri`,`attachment_name`,`attachment_type`,`attachment_size`,`attachment_expires`,`attachment_url`,`attachment_contentUri`,`attachment_progress`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Notification entity) {
        statement.bindString(1, entity.getId());
        statement.bindLong(2, entity.getSubscriptionId());
        statement.bindLong(3, entity.getTimestamp());
        statement.bindString(4, entity.getTitle());
        statement.bindString(5, entity.getMessage());
        statement.bindString(6, entity.getContentType());
        statement.bindString(7, entity.getEncoding());
        statement.bindLong(8, entity.getNotificationId());
        statement.bindLong(9, entity.getPriority());
        statement.bindString(10, entity.getTags());
        statement.bindString(11, entity.getClick());
        final String _tmp = __converters.fromActionList(entity.getActions());
        if (_tmp == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, _tmp);
        }
        final int _tmp_1 = entity.getDeleted() ? 1 : 0;
        statement.bindLong(13, _tmp_1);
        final Icon _tmpIcon = entity.getIcon();
        if (_tmpIcon != null) {
          statement.bindString(14, _tmpIcon.getUrl());
          if (_tmpIcon.getContentUri() == null) {
            statement.bindNull(15);
          } else {
            statement.bindString(15, _tmpIcon.getContentUri());
          }
        } else {
          statement.bindNull(14);
          statement.bindNull(15);
        }
        final Attachment _tmpAttachment = entity.getAttachment();
        if (_tmpAttachment != null) {
          statement.bindString(16, _tmpAttachment.getName());
          if (_tmpAttachment.getType() == null) {
            statement.bindNull(17);
          } else {
            statement.bindString(17, _tmpAttachment.getType());
          }
          if (_tmpAttachment.getSize() == null) {
            statement.bindNull(18);
          } else {
            statement.bindLong(18, _tmpAttachment.getSize());
          }
          if (_tmpAttachment.getExpires() == null) {
            statement.bindNull(19);
          } else {
            statement.bindLong(19, _tmpAttachment.getExpires());
          }
          statement.bindString(20, _tmpAttachment.getUrl());
          if (_tmpAttachment.getContentUri() == null) {
            statement.bindNull(21);
          } else {
            statement.bindString(21, _tmpAttachment.getContentUri());
          }
          statement.bindLong(22, _tmpAttachment.getProgress());
        } else {
          statement.bindNull(16);
          statement.bindNull(17);
          statement.bindNull(18);
          statement.bindNull(19);
          statement.bindNull(20);
          statement.bindNull(21);
          statement.bindNull(22);
        }
      }
    };
    this.__updateAdapterOfNotification = new EntityDeletionOrUpdateAdapter<Notification>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR IGNORE `Notification` SET `id` = ?,`subscriptionId` = ?,`timestamp` = ?,`title` = ?,`message` = ?,`contentType` = ?,`encoding` = ?,`notificationId` = ?,`priority` = ?,`tags` = ?,`click` = ?,`actions` = ?,`deleted` = ?,`icon_url` = ?,`icon_contentUri` = ?,`attachment_name` = ?,`attachment_type` = ?,`attachment_size` = ?,`attachment_expires` = ?,`attachment_url` = ?,`attachment_contentUri` = ?,`attachment_progress` = ? WHERE `id` = ? AND `subscriptionId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Notification entity) {
        statement.bindString(1, entity.getId());
        statement.bindLong(2, entity.getSubscriptionId());
        statement.bindLong(3, entity.getTimestamp());
        statement.bindString(4, entity.getTitle());
        statement.bindString(5, entity.getMessage());
        statement.bindString(6, entity.getContentType());
        statement.bindString(7, entity.getEncoding());
        statement.bindLong(8, entity.getNotificationId());
        statement.bindLong(9, entity.getPriority());
        statement.bindString(10, entity.getTags());
        statement.bindString(11, entity.getClick());
        final String _tmp = __converters.fromActionList(entity.getActions());
        if (_tmp == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, _tmp);
        }
        final int _tmp_1 = entity.getDeleted() ? 1 : 0;
        statement.bindLong(13, _tmp_1);
        final Icon _tmpIcon = entity.getIcon();
        if (_tmpIcon != null) {
          statement.bindString(14, _tmpIcon.getUrl());
          if (_tmpIcon.getContentUri() == null) {
            statement.bindNull(15);
          } else {
            statement.bindString(15, _tmpIcon.getContentUri());
          }
        } else {
          statement.bindNull(14);
          statement.bindNull(15);
        }
        final Attachment _tmpAttachment = entity.getAttachment();
        if (_tmpAttachment != null) {
          statement.bindString(16, _tmpAttachment.getName());
          if (_tmpAttachment.getType() == null) {
            statement.bindNull(17);
          } else {
            statement.bindString(17, _tmpAttachment.getType());
          }
          if (_tmpAttachment.getSize() == null) {
            statement.bindNull(18);
          } else {
            statement.bindLong(18, _tmpAttachment.getSize());
          }
          if (_tmpAttachment.getExpires() == null) {
            statement.bindNull(19);
          } else {
            statement.bindLong(19, _tmpAttachment.getExpires());
          }
          statement.bindString(20, _tmpAttachment.getUrl());
          if (_tmpAttachment.getContentUri() == null) {
            statement.bindNull(21);
          } else {
            statement.bindString(21, _tmpAttachment.getContentUri());
          }
          statement.bindLong(22, _tmpAttachment.getProgress());
        } else {
          statement.bindNull(16);
          statement.bindNull(17);
          statement.bindNull(18);
          statement.bindNull(19);
          statement.bindNull(20);
          statement.bindNull(21);
          statement.bindNull(22);
        }
        statement.bindString(23, entity.getId());
        statement.bindLong(24, entity.getSubscriptionId());
      }
    };
    this.__preparedStmtOfClearIconUri = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE notification SET icon_contentUri = null WHERE icon_contentUri = ?";
        return _query;
      }
    };
    this.__preparedStmtOfClearAllNotificationIds = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE notification SET notificationId = 0 WHERE subscriptionId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfMarkAsDeleted = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE notification SET deleted = 1 WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfMarkAllAsDeleted = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE notification SET deleted = 1 WHERE subscriptionId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfMarkAsDeletedIfOlderThan = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE notification SET deleted = 1 WHERE subscriptionId = ? AND timestamp < ?";
        return _query;
      }
    };
    this.__preparedStmtOfUndelete = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE notification SET deleted = 0 WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveIfOlderThan = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM notification WHERE subscriptionId = ? AND timestamp < ?";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM notification WHERE subscriptionId = ?";
        return _query;
      }
    };
  }

  @Override
  public void add(final Notification notification) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfNotification.insert(notification);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Notification notification) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfNotification.handle(notification);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void clearIconUri(final String uri) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearIconUri.acquire();
    int _argIndex = 1;
    _stmt.bindString(_argIndex, uri);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfClearIconUri.release(_stmt);
    }
  }

  @Override
  public void clearAllNotificationIds(final long subscriptionId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearAllNotificationIds.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, subscriptionId);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfClearAllNotificationIds.release(_stmt);
    }
  }

  @Override
  public void markAsDeleted(final String notificationId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfMarkAsDeleted.acquire();
    int _argIndex = 1;
    _stmt.bindString(_argIndex, notificationId);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfMarkAsDeleted.release(_stmt);
    }
  }

  @Override
  public void markAllAsDeleted(final long subscriptionId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfMarkAllAsDeleted.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, subscriptionId);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfMarkAllAsDeleted.release(_stmt);
    }
  }

  @Override
  public void markAsDeletedIfOlderThan(final long subscriptionId, final long olderThanTimestamp) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfMarkAsDeletedIfOlderThan.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, subscriptionId);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, olderThanTimestamp);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfMarkAsDeletedIfOlderThan.release(_stmt);
    }
  }

  @Override
  public void undelete(final String notificationId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUndelete.acquire();
    int _argIndex = 1;
    _stmt.bindString(_argIndex, notificationId);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfUndelete.release(_stmt);
    }
  }

  @Override
  public void removeIfOlderThan(final long subscriptionId, final long olderThanTimestamp) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveIfOlderThan.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, subscriptionId);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, olderThanTimestamp);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfRemoveIfOlderThan.release(_stmt);
    }
  }

  @Override
  public void removeAll(final long subscriptionId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveAll.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, subscriptionId);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfRemoveAll.release(_stmt);
    }
  }

  @Override
  public Object list(final Continuation<? super List<Notification>> $completion) {
    final String _sql = "SELECT * FROM notification";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Notification>>() {
      @Override
      @NonNull
      public List<Notification> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSubscriptionId = CursorUtil.getColumnIndexOrThrow(_cursor, "subscriptionId");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "contentType");
          final int _cursorIndexOfEncoding = CursorUtil.getColumnIndexOrThrow(_cursor, "encoding");
          final int _cursorIndexOfNotificationId = CursorUtil.getColumnIndexOrThrow(_cursor, "notificationId");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfClick = CursorUtil.getColumnIndexOrThrow(_cursor, "click");
          final int _cursorIndexOfActions = CursorUtil.getColumnIndexOrThrow(_cursor, "actions");
          final int _cursorIndexOfDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "deleted");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "icon_url");
          final int _cursorIndexOfContentUri = CursorUtil.getColumnIndexOrThrow(_cursor, "icon_contentUri");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_name");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_type");
          final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_size");
          final int _cursorIndexOfExpires = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_expires");
          final int _cursorIndexOfUrl_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_url");
          final int _cursorIndexOfContentUri_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_contentUri");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_progress");
          final List<Notification> _result = new ArrayList<Notification>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Notification _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final long _tmpSubscriptionId;
            _tmpSubscriptionId = _cursor.getLong(_cursorIndexOfSubscriptionId);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpMessage;
            _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            final String _tmpContentType;
            _tmpContentType = _cursor.getString(_cursorIndexOfContentType);
            final String _tmpEncoding;
            _tmpEncoding = _cursor.getString(_cursorIndexOfEncoding);
            final int _tmpNotificationId;
            _tmpNotificationId = _cursor.getInt(_cursorIndexOfNotificationId);
            final int _tmpPriority;
            _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
            final String _tmpTags;
            _tmpTags = _cursor.getString(_cursorIndexOfTags);
            final String _tmpClick;
            _tmpClick = _cursor.getString(_cursorIndexOfClick);
            final List<Action> _tmpActions;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfActions)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfActions);
            }
            _tmpActions = __converters.toActionList(_tmp);
            final boolean _tmpDeleted;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfDeleted);
            _tmpDeleted = _tmp_1 != 0;
            final Icon _tmpIcon;
            if (!(_cursor.isNull(_cursorIndexOfUrl) && _cursor.isNull(_cursorIndexOfContentUri))) {
              final String _tmpUrl;
              _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
              final String _tmpContentUri;
              if (_cursor.isNull(_cursorIndexOfContentUri)) {
                _tmpContentUri = null;
              } else {
                _tmpContentUri = _cursor.getString(_cursorIndexOfContentUri);
              }
              _tmpIcon = new Icon(_tmpUrl,_tmpContentUri);
            } else {
              _tmpIcon = null;
            }
            final Attachment _tmpAttachment;
            if (!(_cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfSize) && _cursor.isNull(_cursorIndexOfExpires) && _cursor.isNull(_cursorIndexOfUrl_1) && _cursor.isNull(_cursorIndexOfContentUri_1) && _cursor.isNull(_cursorIndexOfProgress))) {
              final String _tmpName;
              _tmpName = _cursor.getString(_cursorIndexOfName);
              final String _tmpType;
              if (_cursor.isNull(_cursorIndexOfType)) {
                _tmpType = null;
              } else {
                _tmpType = _cursor.getString(_cursorIndexOfType);
              }
              final Long _tmpSize;
              if (_cursor.isNull(_cursorIndexOfSize)) {
                _tmpSize = null;
              } else {
                _tmpSize = _cursor.getLong(_cursorIndexOfSize);
              }
              final Long _tmpExpires;
              if (_cursor.isNull(_cursorIndexOfExpires)) {
                _tmpExpires = null;
              } else {
                _tmpExpires = _cursor.getLong(_cursorIndexOfExpires);
              }
              final String _tmpUrl_1;
              _tmpUrl_1 = _cursor.getString(_cursorIndexOfUrl_1);
              final String _tmpContentUri_1;
              if (_cursor.isNull(_cursorIndexOfContentUri_1)) {
                _tmpContentUri_1 = null;
              } else {
                _tmpContentUri_1 = _cursor.getString(_cursorIndexOfContentUri_1);
              }
              final int _tmpProgress;
              _tmpProgress = _cursor.getInt(_cursorIndexOfProgress);
              _tmpAttachment = new Attachment(_tmpName,_tmpType,_tmpSize,_tmpExpires,_tmpUrl_1,_tmpContentUri_1,_tmpProgress);
            } else {
              _tmpAttachment = null;
            }
            _item = new Notification(_tmpId,_tmpSubscriptionId,_tmpTimestamp,_tmpTitle,_tmpMessage,_tmpContentType,_tmpEncoding,_tmpNotificationId,_tmpPriority,_tmpTags,_tmpClick,_tmpIcon,_tmpActions,_tmpAttachment,_tmpDeleted);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Notification>> listFlow(final long subscriptionId) {
    final String _sql = "SELECT * FROM notification WHERE subscriptionId = ? AND deleted != 1 ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, subscriptionId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"notification"}, new Callable<List<Notification>>() {
      @Override
      @NonNull
      public List<Notification> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSubscriptionId = CursorUtil.getColumnIndexOrThrow(_cursor, "subscriptionId");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "contentType");
          final int _cursorIndexOfEncoding = CursorUtil.getColumnIndexOrThrow(_cursor, "encoding");
          final int _cursorIndexOfNotificationId = CursorUtil.getColumnIndexOrThrow(_cursor, "notificationId");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfClick = CursorUtil.getColumnIndexOrThrow(_cursor, "click");
          final int _cursorIndexOfActions = CursorUtil.getColumnIndexOrThrow(_cursor, "actions");
          final int _cursorIndexOfDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "deleted");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "icon_url");
          final int _cursorIndexOfContentUri = CursorUtil.getColumnIndexOrThrow(_cursor, "icon_contentUri");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_name");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_type");
          final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_size");
          final int _cursorIndexOfExpires = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_expires");
          final int _cursorIndexOfUrl_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_url");
          final int _cursorIndexOfContentUri_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_contentUri");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_progress");
          final List<Notification> _result = new ArrayList<Notification>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Notification _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final long _tmpSubscriptionId;
            _tmpSubscriptionId = _cursor.getLong(_cursorIndexOfSubscriptionId);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpMessage;
            _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            final String _tmpContentType;
            _tmpContentType = _cursor.getString(_cursorIndexOfContentType);
            final String _tmpEncoding;
            _tmpEncoding = _cursor.getString(_cursorIndexOfEncoding);
            final int _tmpNotificationId;
            _tmpNotificationId = _cursor.getInt(_cursorIndexOfNotificationId);
            final int _tmpPriority;
            _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
            final String _tmpTags;
            _tmpTags = _cursor.getString(_cursorIndexOfTags);
            final String _tmpClick;
            _tmpClick = _cursor.getString(_cursorIndexOfClick);
            final List<Action> _tmpActions;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfActions)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfActions);
            }
            _tmpActions = __converters.toActionList(_tmp);
            final boolean _tmpDeleted;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfDeleted);
            _tmpDeleted = _tmp_1 != 0;
            final Icon _tmpIcon;
            if (!(_cursor.isNull(_cursorIndexOfUrl) && _cursor.isNull(_cursorIndexOfContentUri))) {
              final String _tmpUrl;
              _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
              final String _tmpContentUri;
              if (_cursor.isNull(_cursorIndexOfContentUri)) {
                _tmpContentUri = null;
              } else {
                _tmpContentUri = _cursor.getString(_cursorIndexOfContentUri);
              }
              _tmpIcon = new Icon(_tmpUrl,_tmpContentUri);
            } else {
              _tmpIcon = null;
            }
            final Attachment _tmpAttachment;
            if (!(_cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfSize) && _cursor.isNull(_cursorIndexOfExpires) && _cursor.isNull(_cursorIndexOfUrl_1) && _cursor.isNull(_cursorIndexOfContentUri_1) && _cursor.isNull(_cursorIndexOfProgress))) {
              final String _tmpName;
              _tmpName = _cursor.getString(_cursorIndexOfName);
              final String _tmpType;
              if (_cursor.isNull(_cursorIndexOfType)) {
                _tmpType = null;
              } else {
                _tmpType = _cursor.getString(_cursorIndexOfType);
              }
              final Long _tmpSize;
              if (_cursor.isNull(_cursorIndexOfSize)) {
                _tmpSize = null;
              } else {
                _tmpSize = _cursor.getLong(_cursorIndexOfSize);
              }
              final Long _tmpExpires;
              if (_cursor.isNull(_cursorIndexOfExpires)) {
                _tmpExpires = null;
              } else {
                _tmpExpires = _cursor.getLong(_cursorIndexOfExpires);
              }
              final String _tmpUrl_1;
              _tmpUrl_1 = _cursor.getString(_cursorIndexOfUrl_1);
              final String _tmpContentUri_1;
              if (_cursor.isNull(_cursorIndexOfContentUri_1)) {
                _tmpContentUri_1 = null;
              } else {
                _tmpContentUri_1 = _cursor.getString(_cursorIndexOfContentUri_1);
              }
              final int _tmpProgress;
              _tmpProgress = _cursor.getInt(_cursorIndexOfProgress);
              _tmpAttachment = new Attachment(_tmpName,_tmpType,_tmpSize,_tmpExpires,_tmpUrl_1,_tmpContentUri_1,_tmpProgress);
            } else {
              _tmpAttachment = null;
            }
            _item = new Notification(_tmpId,_tmpSubscriptionId,_tmpTimestamp,_tmpTitle,_tmpMessage,_tmpContentType,_tmpEncoding,_tmpNotificationId,_tmpPriority,_tmpTags,_tmpClick,_tmpIcon,_tmpActions,_tmpAttachment,_tmpDeleted);
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
  public List<String> listIds(final long subscriptionId) {
    final String _sql = "SELECT id FROM notification WHERE subscriptionId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, subscriptionId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final String _item;
        _item = _cursor.getString(0);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Notification> listDeletedWithAttachments() {
    final String _sql = "SELECT * FROM notification WHERE deleted = 1 AND attachment_contentUri <> ''";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSubscriptionId = CursorUtil.getColumnIndexOrThrow(_cursor, "subscriptionId");
      final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "contentType");
      final int _cursorIndexOfEncoding = CursorUtil.getColumnIndexOrThrow(_cursor, "encoding");
      final int _cursorIndexOfNotificationId = CursorUtil.getColumnIndexOrThrow(_cursor, "notificationId");
      final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
      final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
      final int _cursorIndexOfClick = CursorUtil.getColumnIndexOrThrow(_cursor, "click");
      final int _cursorIndexOfActions = CursorUtil.getColumnIndexOrThrow(_cursor, "actions");
      final int _cursorIndexOfDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "deleted");
      final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "icon_url");
      final int _cursorIndexOfContentUri = CursorUtil.getColumnIndexOrThrow(_cursor, "icon_contentUri");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_name");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_type");
      final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_size");
      final int _cursorIndexOfExpires = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_expires");
      final int _cursorIndexOfUrl_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_url");
      final int _cursorIndexOfContentUri_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_contentUri");
      final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_progress");
      final List<Notification> _result = new ArrayList<Notification>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Notification _item;
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        final long _tmpSubscriptionId;
        _tmpSubscriptionId = _cursor.getLong(_cursorIndexOfSubscriptionId);
        final long _tmpTimestamp;
        _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpMessage;
        _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
        final String _tmpContentType;
        _tmpContentType = _cursor.getString(_cursorIndexOfContentType);
        final String _tmpEncoding;
        _tmpEncoding = _cursor.getString(_cursorIndexOfEncoding);
        final int _tmpNotificationId;
        _tmpNotificationId = _cursor.getInt(_cursorIndexOfNotificationId);
        final int _tmpPriority;
        _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
        final String _tmpTags;
        _tmpTags = _cursor.getString(_cursorIndexOfTags);
        final String _tmpClick;
        _tmpClick = _cursor.getString(_cursorIndexOfClick);
        final List<Action> _tmpActions;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfActions)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfActions);
        }
        _tmpActions = __converters.toActionList(_tmp);
        final boolean _tmpDeleted;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfDeleted);
        _tmpDeleted = _tmp_1 != 0;
        final Icon _tmpIcon;
        if (!(_cursor.isNull(_cursorIndexOfUrl) && _cursor.isNull(_cursorIndexOfContentUri))) {
          final String _tmpUrl;
          _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
          final String _tmpContentUri;
          if (_cursor.isNull(_cursorIndexOfContentUri)) {
            _tmpContentUri = null;
          } else {
            _tmpContentUri = _cursor.getString(_cursorIndexOfContentUri);
          }
          _tmpIcon = new Icon(_tmpUrl,_tmpContentUri);
        } else {
          _tmpIcon = null;
        }
        final Attachment _tmpAttachment;
        if (!(_cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfSize) && _cursor.isNull(_cursorIndexOfExpires) && _cursor.isNull(_cursorIndexOfUrl_1) && _cursor.isNull(_cursorIndexOfContentUri_1) && _cursor.isNull(_cursorIndexOfProgress))) {
          final String _tmpName;
          _tmpName = _cursor.getString(_cursorIndexOfName);
          final String _tmpType;
          if (_cursor.isNull(_cursorIndexOfType)) {
            _tmpType = null;
          } else {
            _tmpType = _cursor.getString(_cursorIndexOfType);
          }
          final Long _tmpSize;
          if (_cursor.isNull(_cursorIndexOfSize)) {
            _tmpSize = null;
          } else {
            _tmpSize = _cursor.getLong(_cursorIndexOfSize);
          }
          final Long _tmpExpires;
          if (_cursor.isNull(_cursorIndexOfExpires)) {
            _tmpExpires = null;
          } else {
            _tmpExpires = _cursor.getLong(_cursorIndexOfExpires);
          }
          final String _tmpUrl_1;
          _tmpUrl_1 = _cursor.getString(_cursorIndexOfUrl_1);
          final String _tmpContentUri_1;
          if (_cursor.isNull(_cursorIndexOfContentUri_1)) {
            _tmpContentUri_1 = null;
          } else {
            _tmpContentUri_1 = _cursor.getString(_cursorIndexOfContentUri_1);
          }
          final int _tmpProgress;
          _tmpProgress = _cursor.getInt(_cursorIndexOfProgress);
          _tmpAttachment = new Attachment(_tmpName,_tmpType,_tmpSize,_tmpExpires,_tmpUrl_1,_tmpContentUri_1,_tmpProgress);
        } else {
          _tmpAttachment = null;
        }
        _item = new Notification(_tmpId,_tmpSubscriptionId,_tmpTimestamp,_tmpTitle,_tmpMessage,_tmpContentType,_tmpEncoding,_tmpNotificationId,_tmpPriority,_tmpTags,_tmpClick,_tmpIcon,_tmpActions,_tmpAttachment,_tmpDeleted);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<String> listActiveIconUris() {
    final String _sql = "SELECT DISTINCT icon_contentUri FROM notification WHERE deleted != 1 AND icon_contentUri <> ''";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final String _item;
        _item = _cursor.getString(0);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Notification get(final String notificationId) {
    final String _sql = "SELECT * FROM notification WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, notificationId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSubscriptionId = CursorUtil.getColumnIndexOrThrow(_cursor, "subscriptionId");
      final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "contentType");
      final int _cursorIndexOfEncoding = CursorUtil.getColumnIndexOrThrow(_cursor, "encoding");
      final int _cursorIndexOfNotificationId = CursorUtil.getColumnIndexOrThrow(_cursor, "notificationId");
      final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
      final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
      final int _cursorIndexOfClick = CursorUtil.getColumnIndexOrThrow(_cursor, "click");
      final int _cursorIndexOfActions = CursorUtil.getColumnIndexOrThrow(_cursor, "actions");
      final int _cursorIndexOfDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "deleted");
      final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "icon_url");
      final int _cursorIndexOfContentUri = CursorUtil.getColumnIndexOrThrow(_cursor, "icon_contentUri");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_name");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_type");
      final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_size");
      final int _cursorIndexOfExpires = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_expires");
      final int _cursorIndexOfUrl_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_url");
      final int _cursorIndexOfContentUri_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_contentUri");
      final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "attachment_progress");
      final Notification _result;
      if (_cursor.moveToFirst()) {
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        final long _tmpSubscriptionId;
        _tmpSubscriptionId = _cursor.getLong(_cursorIndexOfSubscriptionId);
        final long _tmpTimestamp;
        _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpMessage;
        _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
        final String _tmpContentType;
        _tmpContentType = _cursor.getString(_cursorIndexOfContentType);
        final String _tmpEncoding;
        _tmpEncoding = _cursor.getString(_cursorIndexOfEncoding);
        final int _tmpNotificationId;
        _tmpNotificationId = _cursor.getInt(_cursorIndexOfNotificationId);
        final int _tmpPriority;
        _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
        final String _tmpTags;
        _tmpTags = _cursor.getString(_cursorIndexOfTags);
        final String _tmpClick;
        _tmpClick = _cursor.getString(_cursorIndexOfClick);
        final List<Action> _tmpActions;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfActions)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfActions);
        }
        _tmpActions = __converters.toActionList(_tmp);
        final boolean _tmpDeleted;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfDeleted);
        _tmpDeleted = _tmp_1 != 0;
        final Icon _tmpIcon;
        if (!(_cursor.isNull(_cursorIndexOfUrl) && _cursor.isNull(_cursorIndexOfContentUri))) {
          final String _tmpUrl;
          _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
          final String _tmpContentUri;
          if (_cursor.isNull(_cursorIndexOfContentUri)) {
            _tmpContentUri = null;
          } else {
            _tmpContentUri = _cursor.getString(_cursorIndexOfContentUri);
          }
          _tmpIcon = new Icon(_tmpUrl,_tmpContentUri);
        } else {
          _tmpIcon = null;
        }
        final Attachment _tmpAttachment;
        if (!(_cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfSize) && _cursor.isNull(_cursorIndexOfExpires) && _cursor.isNull(_cursorIndexOfUrl_1) && _cursor.isNull(_cursorIndexOfContentUri_1) && _cursor.isNull(_cursorIndexOfProgress))) {
          final String _tmpName;
          _tmpName = _cursor.getString(_cursorIndexOfName);
          final String _tmpType;
          if (_cursor.isNull(_cursorIndexOfType)) {
            _tmpType = null;
          } else {
            _tmpType = _cursor.getString(_cursorIndexOfType);
          }
          final Long _tmpSize;
          if (_cursor.isNull(_cursorIndexOfSize)) {
            _tmpSize = null;
          } else {
            _tmpSize = _cursor.getLong(_cursorIndexOfSize);
          }
          final Long _tmpExpires;
          if (_cursor.isNull(_cursorIndexOfExpires)) {
            _tmpExpires = null;
          } else {
            _tmpExpires = _cursor.getLong(_cursorIndexOfExpires);
          }
          final String _tmpUrl_1;
          _tmpUrl_1 = _cursor.getString(_cursorIndexOfUrl_1);
          final String _tmpContentUri_1;
          if (_cursor.isNull(_cursorIndexOfContentUri_1)) {
            _tmpContentUri_1 = null;
          } else {
            _tmpContentUri_1 = _cursor.getString(_cursorIndexOfContentUri_1);
          }
          final int _tmpProgress;
          _tmpProgress = _cursor.getInt(_cursorIndexOfProgress);
          _tmpAttachment = new Attachment(_tmpName,_tmpType,_tmpSize,_tmpExpires,_tmpUrl_1,_tmpContentUri_1,_tmpProgress);
        } else {
          _tmpAttachment = null;
        }
        _result = new Notification(_tmpId,_tmpSubscriptionId,_tmpTimestamp,_tmpTitle,_tmpMessage,_tmpContentType,_tmpEncoding,_tmpNotificationId,_tmpPriority,_tmpTags,_tmpClick,_tmpIcon,_tmpActions,_tmpAttachment,_tmpDeleted);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
