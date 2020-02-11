package com.example.avi_hi.Login_Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.avi_hi.Log.ambulance_log;
import com.example.avi_hi.Log.blood_log;
import com.example.avi_hi.Log.community_log;
import com.example.avi_hi.Log.hospital_log;
import com.example.avi_hi.Log.lab_log;
import com.example.avi_hi.Log.tika_log;
import com.example.avi_hi.R;
import com.example.avi_hi.Registration_Activity.community_reg;
import com.example.avi_hi.Registration_Activity.blood_reg;
import com.example.avi_hi.Registration_Activity.donor_reg;
import com.example.avi_hi.Registration_Activity.hospital_reg;
import com.example.avi_hi.Registration_Activity.lab_operator_reg;
import com.example.avi_hi.Registration_Activity.operator_reg;
import com.example.avi_hi.Registration_Activity.patient_reg;
import com.example.avi_hi.Registration_Activity.test_register;
import com.example.avi_hi.RetrofitClient;
import com.example.avi_hi.ambulance_inner;
import com.example.avi_hi.blood_inner;
import com.example.avi_hi.donor_inner;
import com.example.avi_hi.hospital_inner;
import com.example.avi_hi.hospital_test;
import com.example.avi_hi.hospital_tika;
import com.example.avi_hi.patient_choice1;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainLogin extends AppCompatActivity implements View.OnClickListener{

    EditText aadhar,password;
    String user_item;
    Spinner user;

    community_log communityLog;
    blood_log bloodLog;
    hospital_log hospitalLog;
    lab_log labLog;
    tika_log tikaLog;
    ambulance_log ambulanceLog;

    int u;
    int flag =0;

    SharedPreferences sp;

    final CharSequence[] items = {"Patient","Donor","Driver","Hospital Operator","Lab Operator","Tika Operator","Blood Bank","Organisation","Doctor"};
    ArrayList<String> login_user= new ArrayList<>(Arrays.asList(
            "Choose Option","Patient","Donor","Driver","Hospital Operator","Lab Operator","Tika Operator","Blood Bank","Organisation","Doctor"
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        aadhar= findViewById(R.id.main_aadhar_login);
        password = findViewById(R.id.main_login_password);
        findViewById(R.id.main_register_button).setOnClickListener(this);
        findViewById(R.id.main_login_button).setOnClickListener(this);

        user = findViewById(R.id.main_login_users);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(MainLogin.this, android.R.layout.simple_spinner_item, login_user);
        user.setAdapter(dataAdapter);
        user.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                user_item = parent.getItemAtPosition(position).toString();
                u = position;
                if(u==0){
                   flag=-1;
                }

                if(u==1){
                    flag=1;
                }

                if(u==2){
                    flag =2;
                }

                if(u==3){
                    flag = 3;
                }

                if(u==4){
                    flag=4;
                }

                if(u==5){
                    flag =5;
                }

                if(u==6){
                    flag = 6;
                }

                if(u==7){
                    flag=7;
                }

                if(u==8){
                    flag =8;
                }
                if(u==9){
                    flag = 9;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    //for Login Activity
    private void hospital_login()
    {

        if(flag == -1){
            Toast.makeText(getApplicationContext(),"Sahi Vikalp Chune",Toast.LENGTH_SHORT).show();
        }

        // For Patient Login
        else if(flag == 1) {
            String aadhar1 = aadhar.getText().toString().trim();
            String pass1 = password.getText().toString().trim();

            //aadhar
            if (aadhar1.isEmpty()) {
                aadhar.setError("Email is Required");
                aadhar.requestFocus();
                return;
            }

            if (aadhar1.length()!=12) {
                aadhar.setError("Enter Valid Length");
                aadhar.requestFocus();
                return;
            }

            //for Password
            if (pass1.isEmpty()) {
                password.setError("Password Required");
                password.requestFocus();
                return;
            }
            if (pass1.length() < 6) {
                password.setError("Minimum length of Password is 6");
                password.requestFocus();
                return;
            }

            Toast.makeText(MainLogin.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainLogin.this, patient_choice1.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

            Call<hospital_log> call = RetrofitClient.getInstance()
                    .getInterface().hospitalLogin(aadhar1, pass1);

            call.enqueue(new Callback<hospital_log>() {
                @Override
                public void onResponse(Call<hospital_log> call, Response<hospital_log> response) {

                    if (response.isSuccessful()) {
                        // progressBar.setVisibility(View.VISIBLE);
                        aadhar.setText("");
                        password.setText("");
                        hospitalLog = response.body();
                        Toast.makeText(MainLogin.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainLogin.this, patient_choice1.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else {

                        Toast.makeText(MainLogin.this, "Invalid User Credential", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<hospital_log> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }

        //For Donor Login
        else if(flag == 2) {

            String aadhar1 = aadhar.getText().toString().trim();
            String pass1 = password.getText().toString().trim();

            //aadhar
            if (aadhar1.isEmpty()) {
                aadhar.setError("Aadhar is Required");
                aadhar.requestFocus();
                return;
            }

            if (aadhar1.length()!=12) {
                aadhar.setError("Enter Valid Length");
                aadhar.requestFocus();
                return;
            }

            //for Password
            if (pass1.isEmpty()) {
                password.setError("Password Required");
                password.requestFocus();
                return;
            }
            if (pass1.length() < 6) {
                password.setError("Minimum length of Password is 6");
                password.requestFocus();
                return;
            }

            Call<lab_log> call = RetrofitClient.getInstance()
                    .getInterface().labLogin(aadhar1, pass1);

            call.enqueue(new Callback<lab_log>() {
                @Override
                public void onResponse(Call<lab_log> call, Response<lab_log> response) {

                    if (response.isSuccessful()) {

                        aadhar.setText("");
                        password.setText("");
                        labLog = response.body();
                        Toast.makeText(MainLogin.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainLogin.this, donor_inner.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else {

                        Toast.makeText(MainLogin.this, "Invalid User Credential", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<lab_log> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }

        //For Driver Login
        else if(flag == 3) {

            String aadhar1 = aadhar.getText().toString().trim();
            String pass1 = password.getText().toString().trim();

            //aadhar
            if (aadhar1.isEmpty()) {
                aadhar.setError("Aadhar is Required");
                aadhar.requestFocus();
                return;
            }

            if (aadhar1.length()!=12) {
                aadhar.setError("Enter Valid Length");
                aadhar.requestFocus();
                return;
            }

            //for Password
            if (pass1.isEmpty()) {
                password.setError("Password Required");
                password.requestFocus();
                return;
            }
            if (pass1.length() < 6) {
                password.setError("Minimum length of Password is 6");
                password.requestFocus();
                return;
            }

            Toast.makeText(MainLogin.this, "Sahi Krna Hai", Toast.LENGTH_SHORT).show();
            Call<ambulance_log> call = RetrofitClient.getInstance()
                    .getInterface().driverLogin(aadhar1, pass1);

            call.enqueue(new Callback<ambulance_log>() {
                @Override
                public void onResponse(Call<ambulance_log> call, Response<ambulance_log> response) {

                    if (response.isSuccessful()) {

                        aadhar.setText("");
                        password.setText("");
                        ambulanceLog = response.body();
                        Toast.makeText(MainLogin.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainLogin.this, ambulance_inner.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else {

                        Toast.makeText(MainLogin.this, "Invalid User Credential", Toast.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<ambulance_log> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
            }

        //For Hospital Login
        else if(flag == 4) {

            String aadhar1 = aadhar.getText().toString().trim();
            String pass1 = password.getText().toString().trim();

            //aadhar
            if (aadhar1.isEmpty()) {
                aadhar.setError("Aadhar is Required");
                aadhar.requestFocus();
                return;
            }

            if (aadhar1.length()!=12) {
                aadhar.setError("Enter Valid Length");
                aadhar.requestFocus();
                return;
            }

            //for Password
            if (pass1.isEmpty()) {
                password.setError("Password Required");
                password.requestFocus();
                return;
            }
            if (pass1.length() < 6) {
                password.setError("Minimum length of Password is 6");
                password.requestFocus();
                return;
            }

            Call<hospital_log> call = RetrofitClient.getInstance()
                    .getInterface().hospitalLogin(aadhar1, pass1);

            call.enqueue(new Callback<hospital_log>() {
                @Override
                public void onResponse(Call<hospital_log> call, Response<hospital_log> response) {

                    if (response.isSuccessful()) {

                        aadhar.setText("");
                        password.setText("");
                        hospitalLog = response.body();
                        Toast.makeText(MainLogin.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainLogin.this, hospital_inner.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else {

                        Toast.makeText(MainLogin.this, "Invalid User Credential", Toast.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<hospital_log> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }

        //For Tika Login
        else if(flag == 5) {

            String aadhar1 = aadhar.getText().toString().trim();
            String pass1 = password.getText().toString().trim();

            //aadhar
            if (aadhar1.isEmpty()) {
                aadhar.setError("Aadhar is Required");
                aadhar.requestFocus();
                return;
            }

            if (aadhar1.length()!=12) {
                aadhar.setError("Enter Valid Length");
                aadhar.requestFocus();
                return;
            }

            //for Password
            if (pass1.isEmpty()) {
                password.setError("Password Required");
                password.requestFocus();
                return;
            }
            if (pass1.length() < 6) {
                password.setError("Minimum length of Password is 6");
                password.requestFocus();
                return;
            }

            Call<tika_log> call = RetrofitClient.getInstance()
                    .getInterface().tikaLogin(aadhar1, pass1);

            call.enqueue(new Callback<tika_log>() {
                @Override
                public void onResponse(Call<tika_log> call, Response<tika_log> response) {

                    if (response.isSuccessful()) {
                        // progressBar.setVisibility(View.VISIBLE);
                        aadhar.setText("");
                        password.setText("");
                        tikaLog = response.body();
                        Toast.makeText(MainLogin.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainLogin.this, hospital_tika.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else {

                        Toast.makeText(MainLogin.this, "Invalid User Credential", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<tika_log> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }

        //For Ward Login
        else if(flag == 6) {

            String aadhar1 = aadhar.getText().toString().trim();
            String pass1 = password.getText().toString().trim();

            //aadhar
            if (aadhar1.isEmpty()) {
                aadhar.setError("Aadhar is Required");
                aadhar.requestFocus();
                return;
            }

            if (aadhar1.length()!=12) {
                aadhar.setError("Enter Valid Length");
                aadhar.requestFocus();
                return;
            }

            //for Password
            if (pass1.isEmpty()) {
                password.setError("Password Required");
                password.requestFocus();
                return;
            }
            if (pass1.length() < 6) {
                password.setError("Minimum length of Password is 6");
                password.requestFocus();
                return;
            }

            Call<lab_log> call = RetrofitClient.getInstance()
                    .getInterface().labLogin(aadhar1, pass1);

            call.enqueue(new Callback<lab_log>() {
                @Override
                public void onResponse(Call<lab_log> call, Response<lab_log> response) {

                    if (response.isSuccessful()) {

                        aadhar.setText("");
                        password.setText("");
                        labLog = response.body();
                        Toast.makeText(MainLogin.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainLogin.this, hospital_test.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else {

                        Toast.makeText(MainLogin.this, "Invalid User Credential", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<lab_log> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }

        //For Blood Bank Login
        else if(flag == 7) {

            String aadhar1 = aadhar.getText().toString().trim();
            String pass1 = password.getText().toString().trim();

            //aadhar
            if (aadhar1.isEmpty()) {
                aadhar.setError("Aadhar is Required");
                aadhar.requestFocus();
                return;
            }

            if (aadhar1.length()!=12) {
                aadhar.setError("Enter Valid Length");
                aadhar.requestFocus();
                return;
            }

            //for Password
            if (pass1.isEmpty()) {
                password.setError("Password Required");
                password.requestFocus();
                return;
            }
            if (pass1.length() < 6) {
                password.setError("Minimum length of Password is 6");
                password.requestFocus();
                return;
            }

            Call<blood_log> call = RetrofitClient.getInstance()
                    .getInterface().bloodLogin(aadhar1, pass1);

            call.enqueue(new Callback<blood_log>() {
                @Override
                public void onResponse(Call<blood_log> call, Response<blood_log> response) {

                    if (response.isSuccessful()) {

                        aadhar.setText("");
                        password.setText("");
                        bloodLog = response.body();
                        Toast.makeText(MainLogin.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainLogin.this, blood_inner.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else {

                        Toast.makeText(MainLogin.this, "Invalid User Credential", Toast.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<blood_log> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }

        //For Organisation Login
        else if(flag == 8) {

            String aadhar1 = aadhar.getText().toString().trim();
            String pass1 = password.getText().toString().trim();

            //aadhar
            if (aadhar1.isEmpty()) {
                aadhar.setError("Aadhar is Required");
                aadhar.requestFocus();
                return;
            }

            if (aadhar1.length()!=12) {
                aadhar.setError("Enter Valid Length");
                aadhar.requestFocus();
                return;
            }

            //for Password
            if (pass1.isEmpty()) {
                password.setError("Password Required");
                password.requestFocus();
                return;
            }
            if (pass1.length() < 6) {
                password.setError("Minimum length of Password is 6");
                password.requestFocus();
                return;
            }

            Call<community_log> call = RetrofitClient.getInstance()
                    .getInterface().organisationLogin(aadhar1, pass1);

            call.enqueue(new Callback<community_log>() {
                @Override
                public void onResponse(Call<community_log> call, Response<community_log> response) {

                    if (response.isSuccessful()) {

                        aadhar.setText("");
                        password.setText("");
                        communityLog = response.body();
                        Toast.makeText(MainLogin.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainLogin.this, ambulance_inner.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    } else {

                        Toast.makeText(MainLogin.this, "Invalid User Credential", Toast.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<community_log> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }

        //For Doctor Login
        else if(flag == 9) {

            Toast.makeText(MainLogin.this, "Sahi Krna Hai", Toast.LENGTH_SHORT).show();


//            Call<doctor_log> call = RetrofitClient.getInstance()
//                    .getInterface().doctorLogin(aadhar1, pass1);
//
//            call.enqueue(new Callback<doctor_log>() {
//                @Override
//                public void onResponse(Call<doctor_log> call, Response<doctor_log> response) {
//
//                    if (response.isSuccessful()) {
//
//                        aadhar.setText("");
//                        password.setText("");
//                        doctorLog = response.body();
//                        Toast.makeText(MainLogin.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(MainLogin.this, doctor_inner.class);
//                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        startActivity(intent);
//                    } else {
//
//                        Toast.makeText(MainLogin.this, "Invalid User Credential", Toast.LENGTH_LONG).show();
//                    }
//                }
//                @Override
//                public void onFailure(Call<doctor_log> call, Throwable t) {
//                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//
//                }
//            });
        }


    }

    private void user_alert(){
        final AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
        alt_bld.setTitle("Select a Group Name");
        alt_bld.setSingleChoiceItems(items, -1, new DialogInterface
                .OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                if(items[item] == items[0]) {
                    Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainLogin.this, patient_reg.class);
                    getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    dialog.dismiss();// dismiss the alertbox after chose option
                }
                else if(items[item] == items[1]) {
                    Toast.makeText(getApplicationContext(), ""+items[item], Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainLogin.this, donor_reg.class);
                    getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    dialog.dismiss();// dismiss the alertbox after chose option
                }
                else if(items[item] == items[2]) {
                    Toast.makeText(getApplicationContext(), ""+items[item], Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainLogin.this,operator_reg.class);
                    getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    dialog.dismiss();// dismiss the alertbox after chose option
                }
                else if(items[item] == items[3]) {
                    Toast.makeText(getApplicationContext(), ""+items[item], Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainLogin.this,hospital_reg.class);
                    getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    dialog.dismiss();// dismiss the alertbox after chose option
                }

                else if(items[item] == items[4]) {
                    Toast.makeText(getApplicationContext(), ""+items[item], Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainLogin.this, lab_operator_reg.class);
                    getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    dialog.dismiss();// dismiss the alertbox after chose option
                }
                else if(items[item] == items[5]) {
                    Toast.makeText(getApplicationContext(), ""+items[item], Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainLogin.this, test_register.class);
                    getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    dialog.dismiss();// dismiss the alertbox after chose option
                }
                else if(items[item] == items[6]) {
                    Toast.makeText(getApplicationContext(), ""+items[item], Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainLogin.this, blood_reg.class);
                    getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    dialog.dismiss();// dismiss the alertbox after chose option
                }
                else if(items[item] == items[7]) {
                    Toast.makeText(getApplicationContext(), ""+items[item], Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainLogin.this, community_reg.class);
                    getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    dialog.dismiss();// dismiss the alertbox after chose option
                }
//                else if(items[item] == items[8]) {
//                    Toast.makeText(getApplicationContext(), ""+items[item], Toast.LENGTH_SHORT).show();
//                    Intent i = new Intent(MainLogin.this,doctor_reg.class);
//                    getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(i);
//                    dialog.dismiss();// dismis7s the alertbox after chose option
//                }

            }

        });
        AlertDialog alert = alt_bld.create();
        alert.show();
    }

    //for Calling Fucntion
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.main_login_button:
                sp = getSharedPreferences("login",MODE_PRIVATE);
                if(sp.getBoolean("logged",false)) {
                    hospital_login();
                }
                hospital_login();
                sp.edit().putBoolean("logged",true).apply();
                break;
            case R.id.main_register_button:
                user_alert();
//                Intent i = new Intent(hospital_login.this, hospital_reg.class);
//                startActivity(i);
                break;
        }

    }
}
