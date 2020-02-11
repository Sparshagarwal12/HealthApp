package com.example.avi_hi.Hospital_Get_Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.avi_hi.Adapter.HospitalGetAdapter;
import com.example.avi_hi.PojoClasses.hospital_show_pojo;
import com.example.avi_hi.R;
import com.example.avi_hi.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class hospital_show_main extends AppCompatActivity implements HospitalGetAdapter.OnItemClickListener{


    public static final String region_1 = "dfsd";
    public static final String district_data_1 = "asdfas";
    public static final String mobile_1 = "asdfas";
    public static final String name_1 = "hblkhnm";
    public static final String address_1 = "asdfasasdasd";
    public static final String state_1 = "asdad";
    public static final String tahsil_1 = "dsfas";
    public static final String url_1 = "dasds";


    ArrayList<hospital_show_pojo> hospital_pojo = new ArrayList<>();
    private HospitalGetAdapter hospitalGetAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_show_main);

        recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getHospitalResponse();

    }
    private void getHospitalResponse(){

        Call<List<hospital_show_pojo>> call = RetrofitClient.getInstance()
                .getInterface().getHospitalJson();
        call.enqueue(new Callback<List<hospital_show_pojo>>() {
            @Override
            public void onResponse(Call<List<hospital_show_pojo>> call, Response<List<hospital_show_pojo>> response) {

                hospital_pojo = new ArrayList<>(response.body());
                hospitalGetAdapter = new HospitalGetAdapter(hospital_show_main.this, hospital_pojo);
                recyclerView.setAdapter(hospitalGetAdapter);
                hospitalGetAdapter.setOnItemClickListener(hospital_show_main.this);

               }
            @Override
            public void onFailure(Call<List<hospital_show_pojo>> call, Throwable t) {

                Toast.makeText(hospital_show_main.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public void onItemClick(int position) {
        Toast.makeText(getApplicationContext(),"You Just Clicked",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Hospital_show_detail.class);
        hospital_show_pojo clickedItem = hospital_pojo.get(position);


        intent.putExtra(name_1,clickedItem.getName());
        intent.putExtra(address_1,clickedItem.getAddress());
        intent.putExtra(tahsil_1,clickedItem.getTahsil());
        intent.putExtra(district_data_1,clickedItem.getDistrict());
        intent.putExtra(state_1,clickedItem.getState());
        intent.putExtra(mobile_1,clickedItem.getMobile_number());
        intent.putExtra(region_1,clickedItem.getRegion());
        startActivity(intent);
    }
}
