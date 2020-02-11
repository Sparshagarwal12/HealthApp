package com.example.avi_hi.Login_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.avi_hi.R;
import com.example.avi_hi.Registration_Activity.patient_reg;
import com.example.avi_hi.patient_choice1;

public class patient_login extends AppCompatActivity {
    private Button patient;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);
        patient = (Button) findViewById(R.id.patient_reg);
        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(patient_login.this, patient_reg.class);
                startActivity(i);
            }
        });
        login = (Button) findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(patient_login.this, patient_choice1.class);
                startActivity(i);
            }
        });
    }
}
