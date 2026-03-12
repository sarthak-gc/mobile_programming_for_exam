package com.example.list_view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
       super.onCreate(b);
        setContentView(R.layout.activity_main);
        adapter recyclerViewAdapter ;
        RecyclerView recycler_view = findViewById(R.id.recycler_view);

        recyclerViewAdapter =  new adapter();
     recycler_view.setLayoutManager(new LinearLayoutManager(this));
       recycler_view.setAdapter(recyclerViewAdapter);

    }
}