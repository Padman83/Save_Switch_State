package com.example.save_switch_state;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    // Initialize the variables.
    Button btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Assign the variables.
        btBack = findViewById(R.id.bt_back);

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Going back.
                Intent intent = new Intent(
                        MainActivity2.this,MainActivity.class
                );
                startActivity(intent);
            }
        });
    }
}