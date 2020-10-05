package com.example.save_switch_state;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Initialize the variables.
    SwitchCompat switchCompat;
    Button btNext;
    Button btExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign the variables.
        switchCompat = findViewById(R.id.switch_compat);
        btNext = findViewById(R.id.bt_next);
        btExit = findViewById(R.id.bt_exit);

        // Save switch state in a shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("save", MODE_PRIVATE);
        switchCompat.setChecked(sharedPreferences.getBoolean("value",true));


        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchCompat.isChecked()){
                    // When the switch is checked.
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("value",true);
                    editor.apply();
                    switchCompat.setChecked(true);
                } else {
                    // When the switch is unchecked.
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    switchCompat.setChecked(false);

                }
            }
        });

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to the next Activity.
                Intent intent = new Intent(
                        MainActivity.this,MainActivity2.class
                );
                startActivity(intent);
            }
        });

        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Closed the Application.
                MainActivity.this.finishAffinity();
            }
        });
    }
}