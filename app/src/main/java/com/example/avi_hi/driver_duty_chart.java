package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class driver_duty_chart extends AppCompatActivity {

    EditText driver_id,driver_name,driver_aadhar,ambulance_number,from,to;
    Spinner ambulance_type;
    Button submit;

    ArrayList<String> ambulance_types = new ArrayList<>(Arrays.asList(
            "बेसिक लाइफ सपोर्ट एम्बुलेंस","एडवांस लाइफ सपोर्ट एम्बुलेंस ", "पेशेंट ट्रांसफर  सपोर्ट एम्बुलेंस ",  "मुर्दाघर एम्बुलेंस","सामान्य एम्बुलेंस"
    ));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_duty_chart);
        driver_id = findViewById(R.id.driver_id_chart);
        driver_name = findViewById(R.id.driver_name_chart);
        ambulance_number = findViewById(R.id.driver_ambulance_chart);
        driver_aadhar = findViewById(R.id.driver_aadhar_chart);
        from = findViewById(R.id.driver_time_from);
        to = findViewById(R.id.driver_time_to);

        ambulance_type = findViewById(R.id.driver_ambulance_type);


        ArrayAdapter<String> dataAdapter_t = new ArrayAdapter<>(driver_duty_chart.this, android.R.layout.simple_spinner_item, ambulance_types);
        ambulance_type.setAdapter(dataAdapter_t);
        ambulance_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                type_item = parent.getItemAtPosition(position).toString();
//                dt = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        submit = findViewById(R.id.submit_driver_chart);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Done man",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
