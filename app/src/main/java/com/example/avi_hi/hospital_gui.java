package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class hospital_gui extends AppCompatActivity {

    Button btn_action1,btn_action2,btn_action3,btn_action4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_gui);

        btn_action1 = findViewById(R.id.hospital_detail_ward);
        btn_action2 = findViewById(R.id.hospital_tika);
        btn_action3 = findViewById(R.id.hospital_test);
        btn_action4 = findViewById(R.id.hospital_ward);

        btn_action1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(hospital_gui.this,hospital_detail.class);
                startActivity(i);
            }
        });
        btn_action2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(hospital_gui.this,hospital_tika.class);
                startActivity(i);
            }
        });
        btn_action3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(hospital_gui.this,hospital_test.class);
                startActivity(i);
            }
        });
        btn_action4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(hospital_gui.this,hospital_ward.class);
                startActivity(i);
            }
        });
    }
}
