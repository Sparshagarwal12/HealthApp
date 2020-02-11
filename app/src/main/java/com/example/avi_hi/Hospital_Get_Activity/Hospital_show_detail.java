package com.example.avi_hi.Hospital_Get_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.avi_hi.R;

import static com.example.avi_hi.Hospital_Get_Activity.hospital_show_main.address_1;
import static com.example.avi_hi.Hospital_Get_Activity.hospital_show_main.district_data_1;
import static com.example.avi_hi.Hospital_Get_Activity.hospital_show_main.mobile_1;
import static com.example.avi_hi.Hospital_Get_Activity.hospital_show_main.name_1;
import static com.example.avi_hi.Hospital_Get_Activity.hospital_show_main.region_1;
import static com.example.avi_hi.Hospital_Get_Activity.hospital_show_main.state_1;
import static com.example.avi_hi.Hospital_Get_Activity.hospital_show_main.tahsil_1;
import static com.example.avi_hi.Hospital_Get_Activity.hospital_show_main.url_1;

public class Hospital_show_detail extends AppCompatActivity {

    TextView tahsil,district,state,mobile,region,name,address,url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_show_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            Intent intent = getIntent();
            String names = intent.getStringExtra(name_1);
            String address_data = intent.getStringExtra(address_1);
            String tahsil_data= intent.getStringExtra(tahsil_1);
            String state_data= intent.getStringExtra(state_1);
            String district_data= intent.getStringExtra(district_data_1);
            String mobile_data= intent.getStringExtra(mobile_1);
            String region_data= intent.getStringExtra(region_1);
            String url_data = intent.getStringExtra(url_1);


        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        tahsil = findViewById(R.id.tahsil);
        district = findViewById(R.id.district);
        state = findViewById(R.id.state);
        mobile =findViewById(R.id.mobile);
        region = findViewById(R.id.region);
        url = findViewById(R.id.url);

        name.setText("Name: "+names);
        address.setText("Address :"+address_data);
        tahsil.setText("Tahsil Name: "+tahsil_data);
        district.setText("District Name: "+district_data);
        state.setText("State Name: "+state_data);
        mobile.setText("Mobile Number: "+mobile_data);
        region.setText("Block: "+region_data);
        url.setText("URL: "+url_data);
    }
}
