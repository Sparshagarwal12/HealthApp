package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class take_blood extends AppCompatActivity{

    ArrayList<String> blood_types= new ArrayList<>(Arrays.asList(
            "रक्त समूह","A+","A-","B+","B-","AB+","AB-","O+","O-"
    ));
    ArrayList<String> blood_component= new ArrayList<>(Arrays.asList(
            "रक्त समूह","लाल रक्त कोशिकाएँ","प्लाज़्मा ","प्लटेलेटस","कृायो पृसीटीपीटेट","गृनुलोसाइट्स","श्वेत रक्त कोशिकाएँ "
    ));
    Button submit;
    Spinner blood_type,component;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_blood);

        blood_type = findViewById(R.id.blood_type_take);
        component = findViewById(R.id.blood_component_take);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(take_blood.this, android.R.layout.simple_spinner_item, blood_types);
        blood_type.setAdapter(dataAdapter);
        blood_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//
//                ltitem = parent.getItemAtPosition(position).toString();
//                lt = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_component = new ArrayAdapter<>(take_blood.this, android.R.layout.simple_spinner_item, blood_component);
        component.setAdapter(dataAdapter_component);
        component.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//
//                ltitem = parent.getItemAtPosition(position).toString();
//                lt = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
