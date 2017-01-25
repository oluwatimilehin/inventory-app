package com.oluwatimilehin.myinventory.data;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by timad on 25/01/2017.
 */

public class StoreContract {

    private StoreContract(){};
    public static final String CONTENT_AUTHORITY = "com.oluwatimilehin.myinventory";
    public static final String PATH_INVENTORY = "inventory";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY );

    public static class StoreEntry implements BaseColumns{
        public static final Uri INVENTORY_URI = Uri.withAppendedPath(BASE_CONTENT_URI,
                PATH_INVENTORY);
        public static final String TABLE_NAME = "inventory";
        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_SUPPLIER = "supplier";
        public static final String COLUMN_IMAGE = "image";
    }
}
