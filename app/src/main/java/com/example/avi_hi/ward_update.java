package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ward_update extends AppCompatActivity {

    Button normal,regular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ward_update);

        normal = findViewById(R.id.normal_update);
        regular = findViewById(R.id.regular_update);

        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ward_update.this,normal_update.class);
                startActivity(intent);
            }
        });

        regular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ward_update.this,regular_update.class);
                startActivity(intent);
            }
        });
    }
}
