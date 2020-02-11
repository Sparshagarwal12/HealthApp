package com.example.avi_hi.Login_Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.avi_hi.Log.ambulance_log;
import com.example.avi_hi.Log.community_log;
import com.example.avi_hi.R;
import com.example.avi_hi.Registration_Activity.community_reg;
import com.example.avi_hi.Registration_Activity.operator_reg;
import com.example.avi_hi.RetrofitClient;
import com.example.avi_hi.ambulance_inner;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ambulance_login extends AppCompatActivity implements View.OnClickListener{


    EditText aadhar, password;
    private FirebaseAuth mAuth;
    ambulance_log ambulanceLog;
    community_log communityLog;
    Spinner ltype;
    String ltitem;
    int lt;
    final CharSequence[] items = {"organisation","driver"};

    ArrayList<String> login_type = new ArrayList<>(Arrays.asList(
            "driver", "organisation"
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance_login);

        aadhar = findViewById(R.id.ambulance_aadhar);
        password = findViewById(R.id.ambulance_password);
//        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.ambulance_register).setOnClickListener(this);
        findViewById(R.id.ambulance_login).setOnClickListener(this);
        ltype = findViewById(R.id.login_types);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(ambulance_login.this, android.R.layout.simple_spinner_item, login_type);
        ltype.setAdapter(dataAdapter);
        ltype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                ltitem = parent.getItemAtPosition(position).toString();
                lt = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void ambulance_login() {
        String aadhar1 = aadhar.getText().toString().trim();
        String pass1 = password.getText().toString().trim();

        //aadhar
        if (aadhar1.isEmpty()) {
            aadhar.setError("Email is Required");
            aadhar.requestFocus();
            return;
        }

        if (aadhar1.length()!=12) {
            aadhar.setError("Enter Valid Aadhar");
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


        if (lt == 0) {
            Call<ambulance_log> call = RetrofitClient.getInstance()
                    .getInterface().driverLogin(aadhar1, pass1);

            call.enqueue(new Callback<ambulance_log>() {
                @Override
                public void onResponse(Call<ambulance_log> call, Response<ambulance_log> response) {

                    if (response.isSuccessful()) {
                        // progressBar.setVisibility(View.VISIBLE);
                        aadhar.setText("");
                        password.setText("");
                        ambulanceLog= response.body();
                        Toast.makeText(ambulance_login.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ambulance_login.this, ambulance_inner.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else {

                        Toast.makeText(ambulance_login.this, "Invalid User Credential", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<ambulance_log> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
            }
        else if (lt == 1) {
           Call<community_log> call = RetrofitClient.getInstance()
                    .getInterface().organisationLogin(aadhar1, pass1);

            call.enqueue(new Callback<community_log>() {
                @Override
                public void onResponse(Call<community_log> call, Response<community_log> response) {

                    if (response.isSuccessful()) {
                       // progressBar.setVisibility(View.VISIBLE);
                        aadhar.setText("");
                        password.setText("");
                        communityLog= response.body();
                        Toast.makeText(ambulance_login.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ambulance_login.this, ambulance_inner.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else {

                        Toast.makeText(ambulance_login.this, "Invalid User Credential", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<community_log> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.ambulance_login:
                ambulance_login();
                break;
            case R.id.ambulance_register:
                final AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
                alt_bld.setTitle("Select a Group Name");
                alt_bld.setSingleChoiceItems(items, -1, new DialogInterface
                        .OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        if(items[item] == items[0]) {
                            Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(ambulance_login.this, community_reg.class);
                            getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(i);
                            dialog.dismiss();// dismiss the alertbox after chose option
                        }
                        else if(items[item] == items[1]) {
                            Toast.makeText(getApplicationContext(), "wha yr"+items[item], Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(ambulance_login.this, operator_reg.class);
                            getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(i);
                            dialog.dismiss();// dismiss the alertbox after chose option
                        }
                    }
                });
                AlertDialog alert = alt_bld.create();
                alert.show();
                break;
        }

    }
}
