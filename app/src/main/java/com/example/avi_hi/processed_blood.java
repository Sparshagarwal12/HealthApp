package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class processed_blood extends AppCompatActivity{


    ArrayList<String> process_type= new ArrayList<>(Arrays.asList(
            "रक्त समूह","A+","A-","B+","B-","AB+","AB-","O+","O-"
    ));
    ArrayList<String> process_units= new ArrayList<>(Arrays.asList(
            "mL","यूनिट"
    ));
    Spinner type1,type2,type3,type4,type5,type6,type7,unit1,unit2,unit3,unit4,unit5,unit6,unit7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processed_blood);

        type1 = findViewById(R.id.processed_type1);
        type2 = findViewById(R.id.processed_type2);
        type3 = findViewById(R.id.processed_type3);
        type4 = findViewById(R.id.processed_type4);
        type5 = findViewById(R.id.processed_type5);
        type6 = findViewById(R.id.processed_type6);
        type7 = findViewById(R.id.processed_type7);

        ArrayAdapter<String> dataAdapter_1 = new ArrayAdapter<>(processed_blood.this, android.R.layout.simple_spinner_item, process_type);
        type1.setAdapter(dataAdapter_1);
        type1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                stitem = parent.getItemAtPosition(position).toString();
//                st = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_2 = new ArrayAdapter<>(processed_blood.this, android.R.layout.simple_spinner_item, process_type);
        type2.setAdapter(dataAdapter_2);
        type2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                stitem = parent.getItemAtPosition(position).toString();
//                st = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_3 = new ArrayAdapter<>(processed_blood.this, android.R.layout.simple_spinner_item, process_type);
        type3.setAdapter(dataAdapter_3);
        type3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                stitem = parent.getItemAtPosition(position).toString();
//                st = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_4 = new ArrayAdapter<>(processed_blood.this, android.R.layout.simple_spinner_item, process_type);
        type4.setAdapter(dataAdapter_4);
        type4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                stitem = parent.getItemAtPosition(position).toString();
//                st = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_5 = new ArrayAdapter<>(processed_blood.this, android.R.layout.simple_spinner_item, process_type);
        type5.setAdapter(dataAdapter_5);
        type5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                stitem = parent.getItemAtPosition(position).toString();
//                st = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_6 = new ArrayAdapter<>(processed_blood.this, android.R.layout.simple_spinner_item, process_type);
        type6.setAdapter(dataAdapter_6);
        type6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                stitem = parent.getItemAtPosition(position).toString();
//                st = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_7 = new ArrayAdapter<>(processed_blood.this, android.R.layout.simple_spinner_item, process_type);
        type7.setAdapter(dataAdapter_7);
        type7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                stitem = parent.getItemAtPosition(position).toString();
//                st = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        unit1 = findViewById(R.id.processed_unit1);
        unit2 = findViewById(R.id.processed_unit2);
        unit3 = findViewById(R.id.processed_unit3);
        unit4 = findViewById(R.id.processed_unit4);
        unit5 = findViewById(R.id.processed_unit5);
        unit6 = findViewById(R.id.processed_unit6);
        unit7 = findViewById(R.id.processed_unit7);

        ArrayAdapter<String> dataAdapter_8 = new ArrayAdapter<>(processed_blood.this, android.R.layout.simple_spinner_item, process_units);
        unit1.setAdapter(dataAdapter_8);
        unit1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                stitem = parent.getItemAtPosition(position).toString();
//                st = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_9 = new ArrayAdapter<>(processed_blood.this, android.R.layout.simple_spinner_item, process_units);
        unit2.setAdapter(dataAdapter_9);
        unit2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                stitem = parent.getItemAtPosition(position).toString();
//                st = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_10 = new ArrayAdapter<>(processed_blood.this, android.R.layout.simple_spinner_item, process_units);
        unit3.setAdapter(dataAdapter_10);
        unit3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                stitem = parent.getItemAtPosition(position).toString();
//                st = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_11 = new ArrayAdapter<>(processed_blood.this, android.R.layout.simple_spinner_item, process_units);
        unit4.setAdapter(dataAdapter_11);
        unit4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                stitem = parent.getItemAtPosition(position).toString();
//                st = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_12 = new ArrayAdapter<>(processed_blood.this, android.R.layout.simple_spinner_item, process_units);
        unit5.setAdapter(dataAdapter_12);
        unit5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                stitem = parent.getItemAtPosition(position).toString();
//                st = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_13 = new ArrayAdapter<>(processed_blood.this, android.R.layout.simple_spinner_item, process_units);
        unit6.setAdapter(dataAdapter_13);
        unit6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                stitem = parent.getItemAtPosition(position).toString();
//                st = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_14 = new ArrayAdapter<>(processed_blood.this, android.R.layout.simple_spinner_item, process_units);
        unit7.setAdapter(dataAdapter_14);
        unit7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
