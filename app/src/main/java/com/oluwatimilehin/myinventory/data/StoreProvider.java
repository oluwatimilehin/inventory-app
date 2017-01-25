package com.oluwatimilehin.myinventory.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import com.oluwatimilehin.myinventory.data.StoreContract.StoreEntry;
/**
 * Created by timad on 25/01/2017.
 */

public class StoreProvider extends ContentProvider {

    private static final int ITEMS = 100;
    private static final int ITEMS_ID = 101;

    StoreDbHelper mStoreDbHelper;
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(StoreContract.CONTENT_AUTHORITY, StoreContract.PATH_INVENTORY, ITEMS);
        sUriMatcher.addURI(StoreContract.CONTENT_AUTHORITY, StoreContract.PATH_INVENTORY+"/#",
                ITEMS_ID);
    }
    @Override
    public boolean onCreate() {
        mStoreDbHelper = new StoreDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder) {
        SQLiteDatabase db = mStoreDbHelper.getReadableDatabase();

        Cursor cursor = null;

        switch (sUriMatcher.match(uri)){
            case ITEMS:
                cursor = db.query(StoreEntry.TABLE_NAME, projection, null, null, null, null,null );
                break;
            case ITEMS_ID:
                selection = StoreEntry.COLUMN_ID + "=?";
                selectionArgs = new String[]{
                        String.valueOf(ContentUris.parseId(uri))
                };
                cursor = db.query(StoreEntry.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, null, null );
        }

        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
