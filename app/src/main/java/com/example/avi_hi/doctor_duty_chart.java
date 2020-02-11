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

public class doctor_duty_chart extends AppCompatActivity {

    EditText doctor_id,doctor_name,doctor_aadhar,doctor_phone,from,to;
    Spinner ward_type;
    Button submit;

    ArrayList<String> ward = new ArrayList<>(Arrays.asList(
            "दन्त रोग विभाग", "ह्रदय रोग विभाग", "ईएनटी विभाग ", "आयुर्वेद  सामान्य  विभाग ", "त्वचा रोग विभाग",
            "नेत्र रोग विभाग", "फॉरेंसिक विभाग", "सामान्य रोग विभाग", "होमियोपैथी विभाग", "प्रसूति रोग विभाग", "अस्थी रोग विभाग",
            "बाल रोग  विभाग", "मनो रोग  विभाग", "भ्रूण  रोग विभाग", "अन्तःस्त्राविक रोग विभाग", "एलर्जी विभाग",
            "मस्तिष्क रोग विभाग", "नभकीय औषधी विभाग", "कैंसर विभाग", "तम्बाकू विभाग", "मूत्र रोग विभाग", "मूत्र पथ संक्रमण विभाग",
            "एक्सरे विभाग", "विक्रति विभाग", "किड्नी विभाग", "ग्रंथि विभाग", "गैस्ट्रॉन्टेरोलॉजी विभाग","उपयुक्त में से कुछ भी नहीं"
    ));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_duty_chart);

        doctor_id = findViewById(R.id.doctor_id_chart);
        doctor_name = findViewById(R.id.doctor_name_chart);
        doctor_phone= findViewById(R.id.doctor_phone_chart);
        doctor_aadhar = findViewById(R.id.driver_aadhar_chart);
        from = findViewById(R.id.driver_time_from);
        to = findViewById(R.id.driver_time_to);

        ward_type = findViewById(R.id.doctor_ward_spinner);


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(doctor_duty_chart.this, android.R.layout.simple_spinner_item, ward);
        ward_type.setAdapter(dataAdapter);
        ward_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                type_item = parent.getItemAtPosition(position).toString();
//                dt = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        submit = findViewById(R.id.submit_chart);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Done man",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
