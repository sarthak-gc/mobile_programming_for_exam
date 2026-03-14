package com.example.db_something;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);



        Button addBtn = findViewById(R.id.add_btn);
        ListView courseList = findViewById(R.id.existing_users);

        EditText emailArea = findViewById(R.id.textarea_email);
        EditText nameArea = findViewById(R.id.textarea_name);

       DbHelper dbHelper= new DbHelper(this) ;
        addBtn.setOnClickListener(v->{
            var email = emailArea.getText().toString();
            var name = nameArea.getText().toString();

            if(email.isEmpty() || name.isEmpty()){
                Toast.makeText(this,"Email and Username required",Toast.LENGTH_SHORT).show();
            }
            dbHelper.insertData();
        });

        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,userList);
        courseList.setAdapter(ad);

    }
}