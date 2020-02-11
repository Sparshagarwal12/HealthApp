package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class medicine_form extends AppCompatActivity {

    ArrayList<String> med_type = new ArrayList<>(Arrays.asList(

            "Pills(Tablets,Capsule,etc..","MilliLiters(Drops,Syrup,DRS,etc...)","Inhalers","Injections","Tubes(Cream,Oinment,Lotion,etc...)"
    ));
    ArrayList<String> pack = new ArrayList<>(Arrays.asList(
            "Seal Pack","Yes","No"
    ));

//    int med;
//    String med_name;
    Button submit;

    EditText d_name,diease_name,drug_expire,drug_batch;
    Spinner drug_name,packing,drug_name_layout,packing_layout;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_form);

        d_name = findViewById(R.id.drug_name);
        diease_name = findViewById(R.id.medicine_diease);
        drug_expire = findViewById(R.id.medicine_expire);
        drug_batch = findViewById(R.id.medicine_batch);

        drug_name = findViewById(R.id.drug_type);
        packing = findViewById(R.id.drug_pack);
        submit = findViewById(R.id.submit_medicine_form);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(medicine_form.this, android.R.layout.simple_spinner_item,med_type);
        drug_name.setAdapter(dataAdapter);
        drug_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_pack = new ArrayAdapter<>(medicine_form.this, android.R.layout.simple_spinner_item,pack);
        packing.setAdapter(dataAdapter_pack);
        packing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d_name.setText("");
                diease_name.setText("");
                drug_expire.setText("");
                drug_batch.setText("");
            }
        });
    }
}
