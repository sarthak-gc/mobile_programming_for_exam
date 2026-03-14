package com.example.a2025_11;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
//    Provided that a SQLite database named "BookStore" with a table
//    named Book with the following columns (book_id as Integer, name as
//    Text and author as Text).
//    Develop an android application to connect to
//    the database and insert three book records and display the book information.



   public DbHelper(Context ctx){
        super(ctx, "BookStore", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
       db.execSQL("CREATE TABLE Book (book_id integer, name Text, author Text);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int o,int n){
    }

    public void insertBook(Integer id, String name, String author){
       SQLiteDatabase db = this.getWritableDatabase();

       var cv = new ContentValues();
       cv.put("book_id",id);
       cv.put("name",name);
       cv.put("author",author);

       db.insert("Book",null,cv);
    }
    public Cursor displayInformation(Integer id){
       SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * from Books WHERE id = ?";
       return db.rawQuery(query,new String[]{id.toString()});
    }

}