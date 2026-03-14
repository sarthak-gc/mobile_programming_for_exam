package com.example.a2025_11;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b){
       super.onCreate(b);
       setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.add_book);
        EditText nameET = findViewById(R.id.book_name);
        EditText authorEt = findViewById(R.id.book_author);
        EditText idEt = findViewById(R.id.book_id);
        ListView bookLV = findViewById(R.id.book_list_view);

        DbHelper db = new DbHelper(this);

        List<String> books = new ArrayList<>();

        btn.setOnClickListener(v->{
            var bookName = nameET.getText().toString();
            var authorName = authorEt.getText().toString();
           var bookId = idEt.getText().toString() ;

            if(bookId.isEmpty()|| bookName.isEmpty() || authorName.isEmpty()){
                Toast.makeText(this,"ALL FIELDS ARE REQUIRED", Toast.LENGTH_SHORT).show();
                return;
            }

            ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,books);

            books.add(bookName + " by " + authorName);
            Integer bookIdInt = Integer.parseInt(bookId) ;

            db.insertBook(bookIdInt,bookName,authorName);

            bookLV.setAdapter(ad);
            nameET.setText("");
            authorEt.setText("");
            idEt.setText("");
        });
    }
}