package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.avi_hi.Login_Activity.ambulance_login;
import com.example.avi_hi.Login_Activity.blood_login;
import com.example.avi_hi.Login_Activity.hospital_login;

public class MainActivity extends AppCompatActivity {

    Button hospital_activity,blood_bank_activity,ambulance_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hospital_activity = (Button)findViewById(R.id.hospital);
        blood_bank_activity = (Button)findViewById(R.id.blood_bank);
        ambulance_activity = (Button)findViewById(R.id.ambulance);

        hospital_activity.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, hospital_login.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
            });

        blood_bank_activity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, blood_login.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        ambulance_activity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ambulance_login.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }
}
