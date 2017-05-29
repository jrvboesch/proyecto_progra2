package com.example.juan.proyecto;

import android.database.sqlite.*;
import android.content.*;
/**
 * Created by juan on 5/28/17.
 */

public class appDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Users.db";

    public appDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);

    }
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + appContract.Users.TABLE_NAME + " (" +
                    appContract.Users._ID + " INTEGER PRIMARY KEY," +
                    appContract.Users.COLUMN_NAME_USER + " TEXT," +
                    appContract.Users.COLUMN_NAME_NAME + " TEXT," +
                    appContract.Users.COLUMN_NAME_PASSWORD + " TEXT," +
                    appContract.Users.COLUMN_NAME_AGE + " INTEGER," +
                    appContract.Users.COLUMN_NAME_EMAIL + " TEXT," +
                    appContract.Users.COLUMN_NAME_ACTIVE + " INTEGER," +
                    appContract.Users.COLUMN_NAME_ROLL + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + appContract.Users.TABLE_NAME;
}
