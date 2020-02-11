package com.example.avi_hi.Doctor_Get_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.avi_hi.R;

import static com.example.avi_hi.Doctor_Get_Activity.doctordetailshow.aadhar_1;
import static com.example.avi_hi.Doctor_Get_Activity.doctordetailshow.address_1;
import static com.example.avi_hi.Doctor_Get_Activity.doctordetailshow.district_1;
import static com.example.avi_hi.Doctor_Get_Activity.doctordetailshow.doctor_1;
import static com.example.avi_hi.Doctor_Get_Activity.doctordetailshow.name_1;
import static com.example.avi_hi.Doctor_Get_Activity.doctordetailshow.org_1;
import static com.example.avi_hi.Doctor_Get_Activity.doctordetailshow.pincode_1;
import static com.example.avi_hi.Doctor_Get_Activity.doctordetailshow.spec_1;
import static com.example.avi_hi.Doctor_Get_Activity.doctordetailshow.state_1;
import static com.example.avi_hi.Doctor_Get_Activity.doctordetailshow.type_1;

public class Doctor_show_detail extends AppCompatActivity {

    TextView name,org,doctor,aadhar,type,spec,address,state,district,pincode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_show_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String name_data = intent.getStringExtra(name_1);
        String org_data = intent.getStringExtra(org_1);
        String doctor_data= intent.getStringExtra(doctor_1);
        String aadhar_data= intent.getStringExtra(aadhar_1);
        String type_data= intent.getStringExtra(type_1);
        String spec_data= intent.getStringExtra(spec_1);
        String address_data= intent.getStringExtra(address_1);
        String state_data = intent.getStringExtra(state_1);
        String district_data = intent.getStringExtra(district_1);
        String pincode_data = intent.getStringExtra(pincode_1);


        name = findViewById(R.id.hospital_get1);
        org = findViewById(R.id.hospital_get2);
        doctor = findViewById(R.id.hospital_get3);
        aadhar = findViewById(R.id.hospital_get4);
        type = findViewById(R.id.hospital_get5);
        spec = findViewById(R.id.hospital_get6);
        address = findViewById(R.id.hospital_get7);
        state = findViewById(R.id.hospital_get8);
        district = findViewById(R.id.hospital_get9);
        pincode = findViewById(R.id.hospital_get10);

        name.setText("Hospital Name: "+name_data);
        org.setText("Organisation "+org_data);
        doctor.setText("Doctor Name: "+doctor_data);
        aadhar.setText("Aadhar: "+aadhar_data);
        type.setText("Type: "+type_data);
        spec.setText("Specialisation: "+spec_data);
        address.setText("Address :"+address_data);
        district.setText("District Name: "+district_data);
        state.setText("State Name: "+state_data);
        pincode.setText("Pincode: "+pincode_data);
    }
}
