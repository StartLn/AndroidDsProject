package com.example.ln20181119.helpSql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelps extends SQLiteOpenHelper {
    public MyHelps(Context context) {
        super(context, "mySql", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table mynews(id Integer primary key autoincrement,title text,context text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
