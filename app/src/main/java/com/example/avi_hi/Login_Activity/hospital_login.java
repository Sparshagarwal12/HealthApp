package com.example.avi_hi.Login_Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.avi_hi.Log.hospital_log;
import com.example.avi_hi.Log.lab_log;
import com.example.avi_hi.Log.tika_log;
import com.example.avi_hi.R;
import com.example.avi_hi.Registration_Activity.community_reg;
import com.example.avi_hi.Registration_Activity.operator_reg;
import com.example.avi_hi.RetrofitClient;
import com.example.avi_hi.hospital_inner;
import com.example.avi_hi.hospital_test;
import com.example.avi_hi.hospital_tika;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class hospital_login extends AppCompatActivity implements View.OnClickListener{

    EditText aadhar,password;
    String user_item;
    Spinner user;
    private ProgressBar progressBar;
    Dialog dialog;
    hospital_log hospitalLog;
    lab_log labLog;
    tika_log tikaLog;
    int u;
    int flag =0;

    final CharSequence[] items = { "Hospital Operator","Lab Operator","Tika Operator"};
    ArrayList<String> login_user= new ArrayList<>(Arrays.asList(
        "Hospital Operator","Lab Operator","Tika Operator"
));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_login);

        aadhar= findViewById(R.id.hospital_aadhar_login);
        password = findViewById(R.id.hospital_login_password);
//        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.hospital_register_button).setOnClickListener(this);
        findViewById(R.id.hospital_login_button).setOnClickListener(this);

        user = findViewById(R.id.login_users);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(hospital_login.this, android.R.layout.simple_spinner_item, login_user);
        user.setAdapter(dataAdapter);
        user.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                user_item = parent.getItemAtPosition(position).toString();
                u = position;
                if(u==0){
                    flag =1;
                }

                if(u==1){
                    flag=2;
                }

                if(u==2){
                    flag =3;
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

       // progressBar = findViewById(R.id.simpleProgressBar);

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

        if(flag == 1) {

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
                        Toast.makeText(hospital_login.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(hospital_login.this, hospital_inner.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else {

                        Toast.makeText(hospital_login.this, "Invalid User Credential", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<hospital_log> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }

        else if(flag == 2) {

                       Call<lab_log> call = RetrofitClient.getInstance()
                    .getInterface().labLogin(aadhar1, pass1);

            call.enqueue(new Callback<lab_log>() {
                @Override
                public void onResponse(Call<lab_log> call, Response<lab_log> response) {

                    if (response.isSuccessful()) {

                        aadhar.setText("");
                        password.setText("");
                        labLog = response.body();
                        Toast.makeText(hospital_login.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(hospital_login.this, hospital_test.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else {

                        Toast.makeText(hospital_login.this, "Invalid User Credential", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<lab_log> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }

        else if(flag == 3) {

            Call<tika_log> call = RetrofitClient.getInstance()
             .getInterface().tikaLogin(aadhar1, pass1);

            call.enqueue(new Callback<tika_log>() {
                @Override
                public void onResponse(Call<tika_log> call, Response<tika_log> response) {

                    if (response.isSuccessful()) {

                        aadhar.setText("");
                        password.setText("");
                        tikaLog = response.body();
                        Toast.makeText(hospital_login.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(hospital_login.this, hospital_tika.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else {

                        Toast.makeText(hospital_login.this, "Invalid User Credential", Toast.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<tika_log> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }


    }

   //for DialogBox
//    private void user_alert(){
//
//        Dialog dialog;
//        final String[] items = {"Hospital Operator","Ward Operator","Test Operator"};
//        final ArrayList itemsSelected = new ArrayList();
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Select your Operator Type : ");
//        builder.setMultiChoiceItems(items, null,
//                new DialogInterface.OnMultiChoiceClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int selectedItemId,
//                                        boolean isSelected) {
//                        if (isSelected) {
//                            if(selectedItemId==0) {
//                                  Intent intent = new Intent(hospital_login.this,hospital_reg.class);
//                                  intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                  startActivity(intent);
//                            }
//                            else if(selectedItemId==1) {
//                                Intent intent = new Intent(hospital_login.this,lab_operator_reg.class);
//                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                startActivity(intent);
//                            }
//                            else if(selectedItemId==2) {
//                                Intent intent = new Intent(hospital_login.this,test_register.class);
//                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                startActivity(intent);
//                            }
//                        }
//                         else if (itemsSelected.contains(selectedItemId)) {
//                             Toast.makeText(getApplicationContext(),"hey sanchit",Toast.LENGTH_SHORT).show();
//                            itemsSelected.remove(Integer.valueOf(selectedItemId));
//                        }
//                    }
//                });
////                .setPositiveButton("Done!", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialog, int id) {
////                        //Your logic when OK button is clicked
//////                        Toast.makeText(getApplicationContext(),"hey sanchit"+id,Toast.LENGTH_SHORT).show();
////
//////                                  Intent intent = new Intent(hospital_login.this,hospital_reg.class);
//////                                  startActivity(intent);
//////                                Intent intent = new Intent(hospital_login.this,lab_operator_reg.class);
//////                                startActivity(intent);
//////                                Intent intent = new Intent(hospital_login.this,test_register.class);
//////                                startActivity(intent);
////                    }
////                })
////                  .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
////            @Override
////            public void onClick(DialogInterface dialog, int id) {
////            }
////        });
//        dialog = builder.create();
//        dialog.show();
//        dialog.closeOptionsMenu();
//    }

    private void user_alert(){
        final AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
        alt_bld.setTitle("Select a Group Name");
        alt_bld.setSingleChoiceItems(items, -1, new DialogInterface
                .OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                if(items[item] == items[0]) {
                    Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(hospital_login.this, community_reg.class);
                    getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    dialog.dismiss();// dismiss the alertbox after chose option
                }
                else if(items[item] == items[1]) {
                    Toast.makeText(getApplicationContext(), ""+items[item], Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(hospital_login.this, operator_reg.class);
                    getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    dialog.dismiss();// dismiss the alertbox after chose option
                }
                else if(items[item] == items[2]) {
                    Toast.makeText(getApplicationContext(), ""+items[item], Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(hospital_login.this, hospital_tika  .class);
                    getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    dialog.dismiss();// dismiss the alertbox after chose option
                }
            }
        });
        AlertDialog alert = alt_bld.create();
        alert.show();
    }

    //for Calling Fucntion
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.hospital_login_button:
                hospital_login();
                break;
            case R.id.hospital_register_button:
                user_alert();
//                Intent i = new Intent(hospital_login.this, hospital_reg.class);
//                startActivity(i);
                break;
        }

    }
}
