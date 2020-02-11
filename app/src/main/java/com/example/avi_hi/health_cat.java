package com.example.avi_hi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.avi_hi.Login_Activity.donor_login;
import com.example.avi_hi.Login_Activity.patient_login;

public class health_cat extends AppCompatActivity {
    private Button patient;
    private Button doctor;
    private Button donor;
    private Button hospital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_cat);
        patient = (Button) findViewById(R.id.rogi);
        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent ii = new Intent(health_cat.this, patient_login.class);
                startActivity(ii);
            }
        });
//        doctor = (Button) findViewById(R.id.doctor);
//        doctor.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                Intent i = new Intent(health_cat.this, doctor_login.class);
//        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(i);
//            }
//        });
        donor = (Button) findViewById(R.id.donor);
        donor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(health_cat.this, donor_login.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
        hospital = (Button) findViewById(R.id.hospital);
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(health_cat.this,MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }
}
