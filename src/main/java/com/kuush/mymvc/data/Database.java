package com.kuush.mymvc.data;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by K4K on 6/11/2017.
 */

public final class Database {
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://com.kuush.mymvc");//you can add the table here!
    public static final String PATH_PHONEBOOK = "phoneNumber";

    public static final String CONTENT_AUTHORITY = "com.kuush.mymvc";
    public Database(){};
    public static abstract class PhoneBookDatabase implements BaseColumns {
        public static final String TABLE_NAME = "theUsers";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_ABRIVATION = "abrivation";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_NUMBER = "phonenumber";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PHONEBOOK);
    }
}