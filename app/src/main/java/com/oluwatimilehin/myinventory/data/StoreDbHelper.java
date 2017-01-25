package com.oluwatimilehin.myinventory.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.oluwatimilehin.myinventory.data.StoreContract.StoreEntry;

/**
 * Created by timad on 25/01/2017.
 */

public class StoreDbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "items.db";
    public static final int DB_VERSION = 1;

    public StoreDbHelper(Context context){

        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLITE_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQLITE_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    public static final String SQLITE_CREATE_ENTRIES  = "CREATE TABLE " + StoreEntry.TABLE_NAME +
            "( " + StoreEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + StoreEntry
            .COLUMN_NAME + " TEXT UNIQUE NOT NULL, " + StoreEntry.COLUMN_PRICE + " INTEGER NOT " +
            "NULL, " +
            StoreEntry.COLUMN_QUANTITY + "INTEGER NOT NULL, " + StoreEntry.COLUMN_SUPPLIER +
            "TEXT NOT NULL, "+ StoreEntry.COLUMN_IMAGE + " BLOB)" ;

    public static final String SQLITE_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + StoreEntry
            .TABLE_NAME;
}
