package com.example.middlecourseproject.data.local.roomDB.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.paging.PagingSource;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.paging.LimitOffsetPagingSource;
import androidx.room.util.CursorUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.middlecourseproject.data.local.roomDB.entity.RecipeEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class FoodDao_Impl implements FoodDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<RecipeEntity> __insertionAdapterOfRecipeEntity;

  private final SharedSQLiteStatement __preparedStmtOfClearRecipes;

  public FoodDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRecipeEntity = new EntityInsertionAdapter<RecipeEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `recipes` (`recipeId`,`query`,`publisher`,`title`,`sourceUrl`,`imageUrl`,`socialRank`,`publisherUrl`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final RecipeEntity entity) {
        statement.bindString(1, entity.getRecipeId());
        statement.bindString(2, entity.getQuery());
        statement.bindString(3, entity.getPublisher());
        statement.bindString(4, entity.getTitle());
        statement.bindString(5, entity.getSourceUrl());
        statement.bindString(6, entity.getImageUrl());
        statement.bindLong(7, entity.getSocialRank());
        statement.bindString(8, entity.getPublisherUrl());
      }
    };
    this.__preparedStmtOfClearRecipes = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM recipes WHERE query = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertAll(final List<RecipeEntity> recipes,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfRecipeEntity.insert(recipes);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object clearRecipes(final String query, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearRecipes.acquire();
        int _argIndex = 1;
        _stmt.bindString(_argIndex, query);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfClearRecipes.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public PagingSource<Integer, RecipeEntity> getRecipesPagingSource(final String query) {
    final String _sql = "SELECT * FROM recipes WHERE query = LOWER(?) ORDER BY socialRank DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, query);
    return new LimitOffsetPagingSource<RecipeEntity>(_statement, __db, "recipes") {
      @Override
      @NonNull
      protected List<RecipeEntity> convertRows(@NonNull final Cursor cursor) {
        final int _cursorIndexOfRecipeId = CursorUtil.getColumnIndexOrThrow(cursor, "recipeId");
        final int _cursorIndexOfQuery = CursorUtil.getColumnIndexOrThrow(cursor, "query");
        final int _cursorIndexOfPublisher = CursorUtil.getColumnIndexOrThrow(cursor, "publisher");
        final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
        final int _cursorIndexOfSourceUrl = CursorUtil.getColumnIndexOrThrow(cursor, "sourceUrl");
        final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(cursor, "imageUrl");
        final int _cursorIndexOfSocialRank = CursorUtil.getColumnIndexOrThrow(cursor, "socialRank");
        final int _cursorIndexOfPublisherUrl = CursorUtil.getColumnIndexOrThrow(cursor, "publisherUrl");
        final List<RecipeEntity> _result = new ArrayList<RecipeEntity>(cursor.getCount());
        while (cursor.moveToNext()) {
          final RecipeEntity _item;
          final String _tmpRecipeId;
          _tmpRecipeId = cursor.getString(_cursorIndexOfRecipeId);
          final String _tmpQuery;
          _tmpQuery = cursor.getString(_cursorIndexOfQuery);
          final String _tmpPublisher;
          _tmpPublisher = cursor.getString(_cursorIndexOfPublisher);
          final String _tmpTitle;
          _tmpTitle = cursor.getString(_cursorIndexOfTitle);
          final String _tmpSourceUrl;
          _tmpSourceUrl = cursor.getString(_cursorIndexOfSourceUrl);
          final String _tmpImageUrl;
          _tmpImageUrl = cursor.getString(_cursorIndexOfImageUrl);
          final int _tmpSocialRank;
          _tmpSocialRank = cursor.getInt(_cursorIndexOfSocialRank);
          final String _tmpPublisherUrl;
          _tmpPublisherUrl = cursor.getString(_cursorIndexOfPublisherUrl);
          _item = new RecipeEntity(_tmpRecipeId,_tmpQuery,_tmpPublisher,_tmpTitle,_tmpSourceUrl,_tmpImageUrl,_tmpSocialRank,_tmpPublisherUrl);
          _result.add(_item);
        }
        return _result;
      }
    };
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
