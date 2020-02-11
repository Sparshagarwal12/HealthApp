package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class regular_update extends AppCompatActivity {

    EditText doctor_name,patient_name,patient_mobile,patient_aadhar,nurse_name,helper_name,helper_mobile,diease_name,treatment_name,today,admit,discharge;
    CheckBox yes,no;
    Button submit_regular;
    RelativeLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regular_update);

        doctor_name = findViewById(R.id.doctor_name_regular);
        patient_name = findViewById(R.id.patient_name_regular);
        patient_mobile = findViewById(R.id.Mob_number_regular);
        patient_aadhar = findViewById(R.id.aadhar_number_regular);
        nurse_name = findViewById(R.id.nurse_name_regular);
        helper_name = findViewById(R.id.parigen_name_regular);
        helper_mobile = findViewById(R.id.parigen_phone_regular);
        diease_name = findViewById(R.id.diease_regular);
        treatment_name = findViewById(R.id.treatment_regular);
        yes = findViewById(R.id.regular_yes);
        no = findViewById(R.id.regular_no);
        today = findViewById(R.id.today_date);
        discharge = findViewById(R.id.discharge_date_regular);
        submit_regular = findViewById(R.id.regular_submit);


        if(yes.isChecked()){
            submit_regular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            submit_regular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"Not Done",Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
