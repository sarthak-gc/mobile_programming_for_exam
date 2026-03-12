package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button addBtn ;
    Button subBtn ;
    EditText number1Et;
    EditText number2Et;
    EditText number3Et;
    TextView result;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        addBtn = findViewById(R.id.sum);
        subBtn = findViewById(R.id.subtract);
        number1Et = findViewById(R.id.number1);
        number2Et = findViewById(R.id.number2);
        number3Et = findViewById(R.id.number3);
        result = findViewById(R.id.result);
           addBtn.setOnClickListener(v->{

                   String n1 = number1Et.getText().toString();
                   String n2 = number2Et.getText().toString();
                   String n3 = number3Et.getText().toString();

                   if(n1.isEmpty() || n2.isEmpty() || n3.isEmpty()){
                       result.setText("Please enter all numbers");
                       return;
                   }

                   int number1 = Integer.parseInt(n1);
                   int number2 = Integer.parseInt(n2);
                   int number3 = Integer.parseInt(n3);
                   int sum = number1 + number2 + number3;
                   result.setText(String.valueOf(sum));
        });
        subBtn.setOnClickListener(v -> {
            String n1 = number1Et.getText().toString();
            String n2 = number2Et.getText().toString();
            String n3 = number3Et.getText().toString();

            if(n1.isEmpty() || n2.isEmpty() || n3.isEmpty()){
                result.setText("Please enter all numbers");
                return;
            }

            int number1 = Integer.parseInt(n1);
            int number2 = Integer.parseInt(n2);
            int number3 = Integer.parseInt(n3);
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            int sum = number1 - number2 - number3;
            intent.putExtra("sum", sum);
            startActivity(intent);
        });
    }

}