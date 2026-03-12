package com.example.alerts;


import android.app.*;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        Button toast = findViewById(R.id.toast);
        Button snack = findViewById(R.id.snack);
        Button notification = findViewById(R.id.notification);
        Button alert = findViewById(R.id.alert_dialog);
        Button progress = findViewById(R.id.progress_dialog);
        Button timePicker = findViewById(R.id.timepicker_dialog);
        Button single = findViewById(R.id.single_choice);
        Button multi = findViewById(R.id.multi_choice);
        Button custom = findViewById(R.id.custom_dialog);

        alert.setOnClickListener(v->{
            new AlertDialog.Builder(this)
                    .setTitle("Delete")
                    .setMessage("Are you sure?")
                    .setPositiveButton("Yes",null)
                    .setNegativeButton("No", null)
                    .show();
        });

        progress.setOnClickListener(v->{
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        });

        single.setOnClickListener(v->{
            String[] colors = {"Red", "Blue", "Green"};
            new AlertDialog.Builder(this)
                    .setTitle("Choose a color")
                    .setSingleChoiceItems(colors, -1, (dialog, which) ->{
                        Toast.makeText(this,"done",Toast.LENGTH_SHORT).show();
                    })
                    .show();
        });

        multi.setOnClickListener(v->{
            String[] items = {"Music", "Movies", "Books"};
            boolean[] checkedItems = {false, true, false};
            new AlertDialog.Builder(this)
                    .setTitle("Select interests")
                    .setMultiChoiceItems(items, checkedItems, (dialog, which, isChecked) ->{
                        Toast.makeText(this,"done",Toast.LENGTH_SHORT).show();
                    })
                    .setPositiveButton("OK", null)
                    .show();
        });
        custom.setOnClickListener(v->{
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.custom_dialog);
            dialog.findViewById(R.id.btnSubmit).setOnClickListener(a -> dialog.dismiss());
            dialog.show();
        });

       toast.setOnClickListener(v->{
           Toast.makeText(this, "This is a toast message", Toast.LENGTH_SHORT).show();
       });

       snack.setOnClickListener(v->{
           Snackbar.make(v, "Item deleted", Snackbar.LENGTH_LONG).show();

       });
    }

}
