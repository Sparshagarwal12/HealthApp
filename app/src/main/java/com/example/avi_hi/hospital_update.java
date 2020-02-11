package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class hospital_update extends AppCompatActivity {

   Button ward,doctor_detail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_update);

        ward = findViewById(R.id.ward_update);
        doctor_detail = findViewById(R.id.doctor_duty_chart);

        ward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(hospital_update.this,ward_update.class);
                startActivity(intent);
            }
        });

        doctor_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(hospital_update.this,doctor_duty_chart.class);
                startActivity(intent);
            }
        });
    }
}
