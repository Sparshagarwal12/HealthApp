package com.example.avi_hi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class donor_selcet extends AppCompatActivity {
    private Button medicine;
    private Button blood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_selcet);

        medicine = (Button) findViewById(R.id.button_health);
        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(donor_selcet.this,medicine_form.class);
                startActivity(i);
            }
        });
        blood = (Button) findViewById(R.id.button_blood);
        blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(donor_selcet.this,blood_page.class);
                startActivity(i);
            }
        });
    }
}
