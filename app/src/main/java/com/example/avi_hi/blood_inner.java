package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class blood_inner extends AppCompatActivity {

    Button blood_data,blood_entry,blood_request,blood_report,blood_stock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_inner);

        blood_data = findViewById(R.id.blood_data_update);
        blood_entry = findViewById(R.id.blood_entry);
        blood_stock = findViewById(R.id.blood_stock);

        blood_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(blood_inner.this,blood_update.class);
                startActivity(intent);
            }
        });


        blood_entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(blood_inner.this,donor_blood.class);
                startActivity(intent);
            }
        });


        blood_stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(blood_inner.this,blood_stock.class);
                startActivity(intent);
            }
        });
    }
}
