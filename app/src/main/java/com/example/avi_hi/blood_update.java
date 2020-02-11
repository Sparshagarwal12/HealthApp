package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class blood_update extends AppCompatActivity {

    Button btn_processed,btn_take,btn_donate,btn_total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_update);

        btn_processed = findViewById(R.id.btn_processed_blood);
        btn_take = findViewById(R.id.take_blood);
        btn_donate = findViewById(R.id.donate_blood);
        btn_total = findViewById(R.id.total_update);

        btn_processed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(blood_update.this,processed_blood.class);
                startActivity(intent);
            }
        });

        btn_take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(blood_update.this,take_blood.class);
                startActivity(intent);
            }
        });

        btn_donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(blood_update.this,blood_donate.class);
                startActivity(intent);
            }
        });

        btn_total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(blood_update.this,blood_total_update.class);
                startActivity(intent);
            }
        });
    }
}
