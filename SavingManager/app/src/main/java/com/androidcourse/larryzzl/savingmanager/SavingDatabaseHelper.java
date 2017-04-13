package com.androidcourse.larryzzl.savingmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zzhang on 13/04/2017.
 */

public class SavingDatabaseHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_ENTRIES =    "CREATE TABLE" +
                                                        SavingItemEntry.TABLE_NAME + " (" +
                                                        SavingItemEntry._ID + " INTEGER PRIMARY KEY," +
                                                        SavingItemEntry.COLUMN_NAME_BANK_NAME + " TEXT," +
                                                        SavingItemEntry.COLUMN_NAME_START_DATE + " TIMESTAMP," +
                                                        SavingItemEntry.COLUMN_NAME_END_DATE + " TIMESTAMP," +
                                                        SavingItemEntry.COLUMN_NAME_AMOUNT + " FLOAT," +
                                                        SavingItemEntry.COLUMN_NAME_YIELD + " FLOAT," +
                                                        SavingItemEntry.COLUMN_NAME_INTEREST + " FLOAT)";

    private static final  String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + SavingItemEntry.TABLE_NAME;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Saving.db";

    public SavingDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}
