package com.example.avi_hi.Login_Activity;

import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
import android.view.View;
        import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

        import com.example.avi_hi.Log.blood_log;
import com.example.avi_hi.R;
import com.example.avi_hi.Registration_Activity.blood_reg;
import com.example.avi_hi.RetrofitClient;
import com.example.avi_hi.blood_inner;
import com.google.firebase.auth.FirebaseAuth;

import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class blood_login extends AppCompatActivity implements View.OnClickListener{

    EditText aadhar,password;
    private FirebaseAuth mAuth;
    blood_log blood;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_login);

        aadhar= findViewById(R.id.enter_aadhar);
        password = findViewById(R.id.edittext_password);
       // progressBar = findViewById(R.id.simpleProgressBar);
        findViewById(R.id.button_register).setOnClickListener(this);
        findViewById(R.id.button_login).setOnClickListener(this);
    }

    private void blood_login()
    {
        String adhar1 = aadhar.getText().toString().trim();
        String pass1 = password.getText().toString().trim();

        //aadhar
        if (adhar1.isEmpty()) {
            aadhar.setError("Aadhar Name is Required");
            aadhar.requestFocus();
            return;
        }

       if(adhar1.length()!=12){
           aadhar.setError("The Length of Aadhar is not Matched");
           aadhar.requestFocus();
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
                .getInterface().bloodLogin(adhar1,pass1);

        call.enqueue(new Callback<blood_log>() {
            @Override
            public void onResponse(Call<blood_log> call, Response<blood_log> response) {

                if(response.isSuccessful()) {

                 //   progressBar.setVisibility(View.VISIBLE);
                    blood = response.body();
                    Toast.makeText(blood_login.this,"Successfully Logged In", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(blood_login.this, blood_inner.class);
                    startActivity(intent);
                }
                else {

                    Toast.makeText(blood_login.this,"Invalid User Credential",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<blood_log> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button_login:
                blood_login();
                break;
            case R.id.button_register:
                Intent i = new Intent(blood_login.this, blood_reg.class);
                startActivity(i);
                break;
        }

    }
}
