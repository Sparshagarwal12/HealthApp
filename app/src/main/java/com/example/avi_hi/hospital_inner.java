package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class hospital_inner extends AppCompatActivity {

    Button btn_action1, btn_action2, btn_action3, btn_action4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_inner);


        btn_action1 = (Button)findViewById(R.id.hospital_detail);
        btn_action2 = (Button)findViewById(R.id.doctor_detail);
        btn_action3 = (Button)findViewById(R.id.hospital_update);
//        btn_action4 = (Button)findViewById(R.id.hospital_patient_report);

        btn_action1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(hospital_inner.this,hospital_gui.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        btn_action2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(hospital_inner.this,doctor_detail.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        btn_action3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(hospital_inner.this,hospital_update.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

//        btn_action4.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(hospital_inner.this,ambulance_login.class);
//                startActivity(i);
//            }
//        });

    }
}
