package com.example.ln20181119.helpSql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.ViewGroup;

import com.example.ln20181119.bean.MyData;

import java.util.ArrayList;

public class MyDao {

    private SQLiteDatabase db;
    private final MyHelps myHelps;

    public MyDao(Context context) {
        myHelps = new MyHelps(context);
        db = myHelps.getWritableDatabase();
    }


    public long insert(ArrayList<MyData.DataBean> mData) {
        long num=0;
        for(int i=0;i<mData.size();i++){
            MyData.DataBean dataBean = mData.get(i);
            ContentValues contentValues = new ContentValues();
            contentValues.put("title",dataBean.getNews_title());
            contentValues.put("context",dataBean.getNews_summary());
            db.insert("mynews",null,contentValues);
            num++;
        }
        return num;
    }

    public String select() {
        StringBuffer sb = new StringBuffer();
        Cursor cursor = db.query("mynews", null, null, null, null, null, null, null);
        while (cursor.moveToNext()){
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String context = cursor.getString(cursor.getColumnIndex("context"));
            sb.append(title).append(context);
        }
        return sb.toString();
    }
}
