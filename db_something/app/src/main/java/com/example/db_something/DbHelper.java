package com.example.db_something;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "courses";
    private static final int DATABASE_VERSION = 1;
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Courses (id INTEGER PRIMARY KEY, name TEXT, address TEXT);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        var query = "DROP TABLE IF EXISTS USER" ;
        db.execSQL(query);
        onCreate(db);
    }
    public void insertData(name){
       SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("address",address);
        db.insert("Student",null,cv);
        db.close();
    }
    public Cursor selectData(String id ){
       SQLiteDatabase db= this.getReadableDatabase();
       String query = "SELECT * from USER;";
       return db.rawQuery(query,null);
    }

    public void updateData(String id,String name, String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("address",address);
        db.update("Student",cv,"id=?",new String[]{id});
    }

    public void deleteData(String id,String name, String address){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Student","id=?",new String[]{id});
    }

}