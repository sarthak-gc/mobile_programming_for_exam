package com.example.todoapp;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {

        List<String> tasks = new ArrayList<>();
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        ListView listview = findViewById(R.id.list);
        Button addTaskBtn = findViewById(R.id.addTask);
        EditText task = findViewById(R.id.task);
        addTaskBtn.setOnClickListener(v->{
            String t = task.getText().toString();
            if (t.isEmpty()){
                Toast.makeText(this, "Task cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }
            tasks.add(t);
            ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tasks);
            listview.setAdapter(ad);
            task.setText("");
        });
    }
}