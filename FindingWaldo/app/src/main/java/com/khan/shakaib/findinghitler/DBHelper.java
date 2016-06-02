package com.khan.shakaib.findinghitler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "urlLocations.db";
    private static final int DATABASE_VERSION = 1;
    private static final String URL_TABLE_NAME = "parsed_url";
    private static final String URL_COLUMN_ID = "id";
    private static final String URL_LINK_NAME = "urlFound";


    public DBHelper(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+URL_TABLE_NAME+ "(" +URL_COLUMN_ID+" integer primary key autoincrement,"+URL_LINK_NAME+" varchar(350);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+ URL_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertUrl (String url){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(URL_LINK_NAME,url);
        db.insert(URL_TABLE_NAME, null, content);
        return true;
    }

    public String getLastLink(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor link = db.rawQuery("select"+ URL_LINK_NAME +" from "+URL_TABLE_NAME ,null);
        link.moveToLast();
        String lastFoundURL = link.getString(link.getColumnIndex(URL_LINK_NAME));
        return lastFoundURL;
    }
}
