package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class blood_stock extends AppCompatActivity{


    ArrayList<String> blood_type= new ArrayList<>(Arrays.asList(
           "रक्त समूह","A+","A-","B+","B-","AB+","AB-","O+","O-"
    ));
    ArrayList<String> units= new ArrayList<>(Arrays.asList(
           "mL","यूनिट"
    ));

    Spinner type1,type2,type3,type4,type5,type6,type7,unit1,unit2,unit3,unit4,unit5,unit6,unit7;
    String type_t,unit_u;
    Button btn;
    int tp,ut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_stock);

        type1 = findViewById(R.id.blood_type1);
        type2 = findViewById(R.id.blood_type2);
        type3 = findViewById(R.id.blood_type3);
        type4 = findViewById(R.id.blood_type4);
        type5 = findViewById(R.id.blood_type5);
        type6 = findViewById(R.id.blood_type6);
        type7 = findViewById(R.id.blood_type7);
        btn = findViewById(R.id.stock_submit);

        ArrayAdapter<String> dataAdapter_1 = new ArrayAdapter<>(blood_stock.this, android.R.layout.simple_spinner_item, blood_type);
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
        ArrayAdapter<String> dataAdapter_2 = new ArrayAdapter<>(blood_stock.this, android.R.layout.simple_spinner_item, blood_type);
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
        ArrayAdapter<String> dataAdapter_3 = new ArrayAdapter<>(blood_stock.this, android.R.layout.simple_spinner_item, blood_type);
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
        ArrayAdapter<String> dataAdapter_4 = new ArrayAdapter<>(blood_stock.this, android.R.layout.simple_spinner_item, blood_type);
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
        ArrayAdapter<String> dataAdapter_5 = new ArrayAdapter<>(blood_stock.this, android.R.layout.simple_spinner_item, blood_type);
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
        ArrayAdapter<String> dataAdapter_6 = new ArrayAdapter<>(blood_stock.this, android.R.layout.simple_spinner_item, blood_type);
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
        ArrayAdapter<String> dataAdapter_7 = new ArrayAdapter<>(blood_stock.this, android.R.layout.simple_spinner_item, blood_type);
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

        unit1 = findViewById(R.id.blood_unit1);
        unit2 = findViewById(R.id.blood_unit2);
        unit3 = findViewById(R.id.blood_unit3);
        unit4 = findViewById(R.id.blood_unit4);
        unit5 = findViewById(R.id.blood_unit5);
        unit6 = findViewById(R.id.blood_unit6);
        unit7 = findViewById(R.id.blood_unit7);


        ArrayAdapter<String> dataAdapter_8 = new ArrayAdapter<>(blood_stock.this, android.R.layout.simple_spinner_item, units);
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
        ArrayAdapter<String> dataAdapter_9 = new ArrayAdapter<>(blood_stock.this, android.R.layout.simple_spinner_item, units);
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
        ArrayAdapter<String> dataAdapter_10 = new ArrayAdapter<>(blood_stock.this, android.R.layout.simple_spinner_item, units);
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
        ArrayAdapter<String> dataAdapter_11 = new ArrayAdapter<>(blood_stock.this, android.R.layout.simple_spinner_item, units);
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
        ArrayAdapter<String> dataAdapter_12 = new ArrayAdapter<>(blood_stock.this, android.R.layout.simple_spinner_item, units);
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
        ArrayAdapter<String> dataAdapter_13 = new ArrayAdapter<>(blood_stock.this, android.R.layout.simple_spinner_item, units);
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
        ArrayAdapter<String> dataAdapter_14 = new ArrayAdapter<>(blood_stock.this, android.R.layout.simple_spinner_item, units);
        unit7.setAdapter(dataAdapter_14);
        unit7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                stitem = parent.getItemAtPosition(position).toString();
//                st = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stock_type1 = type1.getSelectedItem().toString();
                String stock_type2 = type2.getSelectedItem().toString();
                String stock_type3 = type3.getSelectedItem().toString();
                String stock_type4 = type4.getSelectedItem().toString();
                String stock_type5 = type5.getSelectedItem().toString();
                String stock_type6 = type6.getSelectedItem().toString();
                String stock_type7 = type7.getSelectedItem().toString();
                String stock_unit1 = unit1.getSelectedItem().toString();
                String stock_unit2 = unit2.getSelectedItem().toString();
                String stock_unit3 = unit3.getSelectedItem().toString();
                String stock_unit4 = unit4.getSelectedItem().toString();
                String stock_unit5 = unit5.getSelectedItem().toString();
                String stock_unit6 = unit6.getSelectedItem().toString();
                String stock_unit7 = unit7.getSelectedItem().toString();

//                Call<ResponseBody> call= RetrofitClient.getInstance()
//                        .getInterface()
//                        .bloodStock(
//
//                        );
//
//                call.enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        ResponseBody dr=response.body();
//                        // Toast.makeText(hospital_reg.this,"User Created Successfully",Toast.LENGTH_LONG).show();
//                        try {
//
//                            String s = response.body().string();
//                            Toast.makeText(hospital_detail.this,"Value Updated"+s,Toast.LENGTH_LONG).show();
////                            getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////                            Intent intent = new Intent(hospital_detail.this,hospital_login.class);
////                            startActivity(intent);
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//                        Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
//                    }
//                });
            }
        });
    }



}
