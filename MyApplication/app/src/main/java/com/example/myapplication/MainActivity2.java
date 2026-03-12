package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
       super.onCreate(b);
       setContentView(R.layout.activity_main2);
        Intent intent= getIntent();
        int sum  = intent.getIntExtra("sum",0);

        TextView tv = findViewById(R.id.sub_result);
        tv.setText(Integer.toString(sum));
    }
}