package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.avi_hi.Adapter.CheckboxAdapter;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class hospital_detail extends AppCompatActivity {

//    FirebaseAuth mAuth;
    CheckBox btn;
    Button btn1;
    private String lang, text;
    int c, s;
    Spinner type;
    Spinner department;
    Spinner pharmacy;
    String type_name, department_name, pharmacy_name, blood_name;
    Spinner blood_bank;
    FirebaseDatabase database;
    RecyclerView recyclerView;
    Spinner stream;
    int type_1, department_1, pharmacy_1, blood_bank_1;
    CheckboxAdapter adapter;

    String[] list = {
            "दन्त रोग विभाग", "ह्रदय रोग विभाग", "ईएनटी विभाग ", "आयुर्वेद  सामान्य  विभाग ", "त्वचा रोग विभाग",
            "नेत्र रोग विभाग", "फॉरेंसिक विभाग", "सामान्य रोग विभाग", "होमियोपैथी विभाग", "प्रसूति रोग विभाग", "अस्थी रोग विभाग",
            "बाल रोग  विभाग", "मनो रोग  विभाग", "भ्रूण  रोग विभाग", "अन्तःस्त्राविक रोग विभाग", "एलर्जी विभाग",
            "मस्तिष्क रोग विभाग", "नभकीय औषधी विभाग", "कैंसर विभाग", "तम्बाकू विभाग", "मूत्र रोग विभाग", "मूत्र पथ संक्रमण विभाग",
            "एक्सरे विभाग", "विक्रति विभाग", "किड्नी विभाग", "ग्रंथि विभाग", "गैस्ट्रॉन्टेरोलॉजी विभाग","उपयुक्त में से कुछ भी नहीं"
    };

    ArrayList<String> types = new ArrayList<>(Arrays.asList(

            "अस्पताल की श्रेणी", "एलोपैथिक", "आयुर्वेदिक होम्योपैथिक ", "कैंसर ", "यूनानी अस्पताल", "जिला अस्पताल", "शहरी अस्पताल",
            "ग्रामीण अस्पताल", "प्राथमिक स्वास्थ्य सेंटर(PHCs)", "कम्युनिटी स्वास्थ्य सेंटर(CHCs)", "हेल्थ सब सेण्टर (HSCs)",
            "मेडिकल कॉलेज अस्पताल", "जननी अस्पताल ","सॅटॅलाइट हॉस्पिटल"
    ));
    ArrayList<String> departments = new ArrayList<>(Arrays.asList(
            "संगठन ं", "सरकारी", "गैर सरकारी", "ट्रस्ट"
    ));
    ArrayList<String> bloods = new ArrayList<>(Arrays.asList(
            "रक्त सुविधा", "हां", "ना"
    ));
    ArrayList<String> pharmacys = new ArrayList<>(Arrays.asList(
            "दवाई दुकान", "हां", "ना"
    ));


    List<String> checkList = Arrays.asList(list);

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_detail);

//        mAuth = FirebaseAuth.getInstance();
//        final FirebaseDatabase database = FirebaseDatabase.getInstance();
//        final DatabaseReference reff = database.getReference("hospital");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(hospital_detail.this));

        adapter = new CheckboxAdapter(hospital_detail.this, checkList);
        recyclerView.setAdapter(adapter);


        type = (Spinner) findViewById(R.id.spinner1);
        department = (Spinner) findViewById(R.id.spinner2);
        pharmacy = (Spinner) findViewById(R.id.spinner3);
        blood_bank = (Spinner) findViewById(R.id.spinner4);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(hospital_detail.this, android.R.layout.simple_spinner_item, types);
        type.setAdapter(dataAdapter);
        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type_name = parent.getItemAtPosition(position).toString();
                type_1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(hospital_detail.this, android.R.layout.simple_spinner_item, departments);
                department.setAdapter(dataAdapter);
                department_name = parent.getItemAtPosition(position).toString();
                department_1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        department.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(hospital_detail.this, android.R.layout.simple_spinner_item, pharmacys);
                pharmacy.setAdapter(dataAdapter);
                pharmacy_name = parent.getItemAtPosition(position).toString();
                pharmacy_1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        pharmacy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(hospital_detail.this, android.R.layout.simple_spinner_item, bloods);
                blood_bank.setAdapter(dataAdapter);
                blood_name = parent.getItemAtPosition(position).toString();
                blood_bank_1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btn1 = findViewById(R.id.submit_details);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(type_1==0){
                    Toast.makeText(getApplicationContext(),"Please Select Right Option",Toast.LENGTH_SHORT).show();
                }

                else if( department_1==0) {
                    Toast.makeText(getApplicationContext(),"Please Select Right Option",Toast.LENGTH_SHORT).show();
                }

                else if(pharmacy_1==0 ) {
                    Toast.makeText(getApplicationContext(),"Please Select Right Option",Toast.LENGTH_SHORT).show();
                }

                else if(blood_bank_1==0) {
                    Toast.makeText(getApplicationContext(),"Please Select Right Option",Toast.LENGTH_SHORT).show();
                }

                else{

                    Toast.makeText(getApplicationContext(), "Application done", Toast.LENGTH_SHORT).show();
                }

                String hospital_department = department.getSelectedItem().toString();
                String hospital_type = type.getSelectedItem().toString();

                Call<ResponseBody> call= RetrofitClient.getInstance()
                        .getInterface()
                        .hospitalDetails(
                                hospital_department,
                                hospital_type,
                                true,
                                true
                        );

                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        ResponseBody dr=response.body();
                        // Toast.makeText(hospital_reg.this,"User Created Successfully",Toast.LENGTH_LONG).show();
                        try {

                            String s = response.body().string();
                            Toast.makeText(hospital_detail.this,"Value Updated"+s,Toast.LENGTH_LONG).show();
//                            getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                            Intent intent = new Intent(hospital_detail.this,hospital_login.class);
//                            startActivity(intent);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                        Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
