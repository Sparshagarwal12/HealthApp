package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class normal_update extends AppCompatActivity{

    EditText pnm,dt,mob,adno,nnm,dnm,dinm,trt,help_name,help_no;
    Button btn_action;
    int day,year,month;
    nupdate nupdate;
    Spinner bed_nos,ward,complex;
    String  bed_num,ward_num,complicated;
    int bed_pos,ward_pos,ct;


    ArrayList<String> bed_no = new ArrayList<>(Arrays.asList(
            "1","2","3","4","5","6","7","8","9","10",
            "11","12","13","14","15","16","17","18","19","20",
            "21","22","23","24","25","26","27","28","29","30",
            "31","32","33","34","35","36","37","38","39","40",
            "41","42","43","44","45","46","47","48","49","50",
            "61","62","63","64","65","66","67","68","69","70",
            "81","82","83","84","85","86","87","88","89","90",
            "91","92","93","94","95","96","97","98","99","100"
    ));
    ArrayList<String> complication = new ArrayList<>(Arrays.asList(
            "जटिलता","गंभीर स्थिति","सामान्य स्थिति","अत्यधिक गंभीर स्थिति"
    ));

    ArrayList<String> ward_name = new ArrayList<>(Arrays.asList(
            "जनरल वार्ड ( महिला )",
            "जनरल वार्ड ( पुरुष )",
            "मेजर ऑपरेशन थिएटर वार्ड",
            "माइनर ऑपरेशन थिएटर वार्ड ",
            "आई सी यू",
            "मनोरोग वार्ड",
            "ट्रॉमा सेंटर वार्ड",
            "नवजात गहन देखभाल इकाई (NICU)",
            "बाल गहन चिकित्सा इकाई (PICU)",
            "कोरोनरी देखभाल इकाई (CCU)",
            "कार्डियोथोरेसिक  इकाई ( CTU)",
            "सर्जिकल गहन देखभाल इकाई (SICU)",
            "चिकित्सा गहन देखभाल इकाई",
            "दीर्घकालिक गहन देखभाल इकाई ",
            "नवजात इकाई",
            "बाल चिकित्सा इकाई",
            "ऑन्कोलॉजी इकाई",
            "सर्जिकल इकाई",
            "पुनर्वास इकाई",
            "बर्न इकाई",
            "प्रसूति इकाई"
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_update);

        bed_nos = (Spinner) findViewById(R.id.bed_no);
        ward = (Spinner) findViewById(R.id.ward_name);
        complex = findViewById(R.id.jatilta);

        ArrayAdapter<String> dataAdapter_bed = new ArrayAdapter<>(normal_update.this, android.R.layout.simple_spinner_item, bed_no);
        bed_nos.setAdapter(dataAdapter_bed);
        bed_nos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bed_num = parent.getItemAtPosition(position).toString();
                bed_pos = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_ward = new ArrayAdapter<>(normal_update.this, android.R.layout.simple_spinner_item, ward_name);
        ward.setAdapter(dataAdapter_ward);
        ward.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ward_num = parent.getItemAtPosition(position).toString();
                ward_pos = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_complication = new ArrayAdapter<>(normal_update.this, android.R.layout.simple_spinner_item, complication);
        complex.setAdapter(dataAdapter_complication);
        complex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                complicated = parent.getItemAtPosition(position).toString();
                ct = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        pnm = findViewById(R.id.patient_name);
        dt = findViewById(R.id.admit_date);
        mob = findViewById(R.id.Mob_number);
        adno = findViewById(R.id.aadhar_number);
        nnm = findViewById(R.id.nurse_name);
        dnm = findViewById(R.id.doctor_name);
        dinm = findViewById(R.id.diease);
        trt = findViewById(R.id.treatment);
        btn_action = findViewById(R.id.normal_submit);
        help_name = findViewById(R.id.parigen_name);
        help_no = findViewById(R.id.parigen_phone);


        btn_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                nupdate = new nupdate();

                String patient_nm = pnm.getText().toString().trim();
                String date = dt.getText().toString().trim();
                String mobile = mob.getText().toString().trim();
                String aadhar_no = adno.getText().toString().trim();
                String nurse_nm = nnm.getText().toString().trim();
                String doctor_nm = dnm.getText().toString().trim();
                String diease = dinm.getText().toString().trim();
                String treat = trt.getText().toString().trim();
                String helper_name = help_name.getText().toString().trim();
                String helper_no = help_no.getText().toString().trim();

//                nupdate.setBnm(bed_nos.getSelectedItem().toString());
//                nupdate.setWard_name(ward.getSelectedItem().toString());
//                nupdate.setComlex(complex.getSelectedItem().toString());
//                nupdate.setDnm(dnm.getText().toString().trim());
//                nupdate.setPnm(pnm.getText().toString().trim());
//                nupdate.setMob(mob.getText().toString().trim());
//                nupdate.setAdno(adno.getText().toString().trim());
//                nupdate.setDt(dt.getText().toString().trim());
//                nupdate.setNnm(nnm.getText().toString().trim());
//                nupdate.setHelp_name(help_name.getText().toString().trim());
//                nupdate.setHelp_no(help_no.getText().toString().trim());
//                nupdate.setDinm(dinm.getText().toString().trim());
//                nupdate.setTreat(trt.getText().toString().trim());


                if (patient_nm.isEmpty()) {
                    pnm.setError("Patient Name is Required");
                    pnm.requestFocus();
                    return;
                }
                if (date.isEmpty()) {
                    dt.setError("Date is Required");
                    dt.requestFocus();
                    return;
                }
                if (mobile.isEmpty()) {
                    mob.setError("Mobile is Required");
                    mob.requestFocus();
                    return;
                }
                if (aadhar_no.isEmpty()) {
                    adno.setError("Aadhar Number is Required");
                    adno.requestFocus();
                    return;
                }
                if (nurse_nm.isEmpty()) {
                    nnm.setError("Nurse Name is Required");
                    nnm.requestFocus();
                    return;
                }
                if (helper_name.isEmpty()) {
                    help_name.setError("Helper Name is Required");
                    help_name.requestFocus();
                    return;
                }
                if (helper_no.isEmpty()) {
                    help_no.setError("Helper Number is Required");
                    help_no.requestFocus();
                    return;
                }

                if (doctor_nm.isEmpty()) {
                    dnm.setError("Doctor Name is Required");
                    dnm.requestFocus();
                    return;
                }
                if (diease.isEmpty()) {
                    dnm.setError("Diease Name is Required");
                    dnm.requestFocus();
                    return;
                }
                if (treat.isEmpty()) {
                    trt.setError("Treatment is Required");
                    trt.requestFocus();
                    return;
                }
            }
        });
    }
}
