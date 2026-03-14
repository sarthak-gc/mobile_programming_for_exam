package com.example.fragments;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        Button b1 = findViewById(R.id.btn1);
        Button b2 = findViewById(R.id.btn2);
        b1.setOnClickListener(v->{
            BlankFragment f1  =new BlankFragment();
            FragmentTransaction txn = getSupportFragmentManager().beginTransaction();
            txn.replace(R.id.fgm,f1);
            txn.commit();
        });

        b2.setOnClickListener(v->{
            BlankFragment2 f2  =new BlankFragment2();
            FragmentTransaction txn = getSupportFragmentManager().beginTransaction();
            txn.replace(R.id.fgm,f2);
            txn.commit();
        });


    }
}