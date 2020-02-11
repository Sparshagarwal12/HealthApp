package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.avi_hi.Doctor_Get_Activity.doctordetailshow;
import com.example.avi_hi.Hospital_Get_Activity.hospital_show_main;

public class patient_inner_choices extends AppCompatActivity {

    Button choice1,choice2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_inner_choices);

        choice1 = findViewById(R.id.choose_Doctor);
        choice2 = findViewById(R.id.choose_hospital);
        
        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(patient_inner_choices.this, doctordetailshow.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(patient_inner_choices.this, hospital_show_main.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
