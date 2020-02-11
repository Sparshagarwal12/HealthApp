package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class donor_blood extends AppCompatActivity {

    ArrayList<String> blood_group = new ArrayList<>(Arrays.asList(
            "ब्लड ग्रुप डालें ","A+","A-","B+","B-","AB+","AB-"
    ));
    ArrayList<String> blood_component = new ArrayList<>(Arrays.asList(
            "ब्लड के कॉम्पोनेन्ट डालें ","संपूर्ण रक्त","लाल रक्त कोशिकाएँ","प्लाज़्मा","प्लटेलेटस","कृायो पृसीटीपीटेट","गृनुलोसाइट्स","श्वेत रक्त कोशिकाएँ"
    ));
    ArrayList<String> blood_sex= new ArrayList<>(Arrays.asList(
            "अपनी ऐज डालें ","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","31","32","33","34","35","36","37","38","39","40","51","52","53","54","55","56","57","58","59","60"
    ));
    ArrayList<String> blood_age= new ArrayList<>(Arrays.asList(
            "अपना जेंडर डालें","Male","Female"
    ));
    ArrayList<String> blood_height= new ArrayList<>(Arrays.asList(
            "अपनी हाइट डालें ","4'0''","4'1''","4'2''","4'3''","4'4''","4'5''","4'6''","4'7''","4'8''","4'9''","5'0''","5'1''","5'2''","5'3''","5'4''","5'5''","5'6''","5'7''","5'8''","5'9''","6'0''"
    ));
    ArrayList<String> blood_diabities= new ArrayList<>(Arrays.asList(
            "डॉयबिटीज़ स्टेटस डालें ","Yes","No"
    ));
    ArrayList<String> blood_aspirin= new ArrayList<>(Arrays.asList(
            " एस्पिरिन स्टेटस डालें ","Yes","No"
    ));
    ArrayList<String> blood_smallpox= new ArrayList<>(Arrays.asList(
            "स्मॉलपॉक्स स्टेटस डालें ","Yes","No"
    ));
    ArrayList<String> blood_tb= new ArrayList<>(Arrays.asList(
            "टीबी स्टेटस डालें ","Yes","No"
    ));
    ArrayList<String> blood_malaria= new ArrayList<>(Arrays.asList(
            "मलेरिया स्टेटस डालें ","Yes","No"
    ));
    ArrayList<String> blood_hepatis = new ArrayList<>(Arrays.asList(
            "हेपीटिटिस स्टेटस डालें ","Yes","No"
    ));
    ArrayList<String> blood_jondis = new ArrayList<>(Arrays.asList(
            "जॉन्डिस स्टेटस डालें ","Yes","No"
    ));
    ArrayList<String> blood_heart= new ArrayList<>(Arrays.asList(
            "हार्ट अटैक ६ महा में ","Yes","No"
    ));
    ArrayList<String> blood_bypass= new ArrayList<>(Arrays.asList(
            "बाईपास स्टेटस डालें ","Yes","No"
    ));
    ArrayList<String> blood_flu= new ArrayList<>(Arrays.asList(
            "ब्लड फ्लू डालें ","Yes","No"
    ));
    ArrayList<String> blood_cancer= new ArrayList<>(Arrays.asList(
                    "कैंसर स्टेटस ","Yes","No"
    ));
//    ArrayList<String> blood_pregnant= new ArrayList<>(Arrays.asList(
//            "Enter Your Pregnancy Status","Yes","No"
//    ));
//    ArrayList<String> blood_platellte= new ArrayList<>(Arrays.asList(
//            "Enter Your Cancer Status","Yes","No"
//    ));

    Spinner bld_grp,bld_cmp,bld_sex,bld_age,bld_ht,bld_diab,bld_aspirin,bld_smallpox,bld_tb,bld_malaria,bld_hepitites,bld_jondis,bld_heart,bld_bypass,bld_flu,bld_cancer;
    int group,component,sex,age,height,diabities,aspirin,smallpox,tb,malaria,hepitites,jondis,heart,bypass,flu,cancer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_blood);

        bld_grp = findViewById(R.id.blood_group_donor);
        bld_cmp = findViewById(R.id.blood_component_donor);
        bld_sex = findViewById(R.id.blood_sex_donor);
        bld_age = findViewById(R.id.blood_age_donor);
        bld_ht = findViewById(R.id.blood_height_donor);
        bld_diab = findViewById(R.id.blood_diab_donor);
        bld_aspirin = findViewById(R.id.blood_aspirin_donor);
        bld_smallpox = findViewById(R.id.blood_smallpox_donor);
        bld_tb = findViewById(R.id.blood_tb_donor);
        bld_malaria = findViewById(R.id.blood_malaria_donor);
        bld_hepitites = findViewById(R.id.blood_hepitites_donor);
        bld_jondis = findViewById(R.id.blood_jondis_donor);
        bld_heart = findViewById(R.id.blood_heart_donor);
        bld_bypass = findViewById(R.id.blood_bypass_donor);
        bld_flu = findViewById(R.id.blood_flu_donor);
        bld_cancer = findViewById(R.id.blood_cancer_donor);


        ArrayAdapter<String> dataAdapter_grp = new ArrayAdapter<>(donor_blood.this, android.R.layout.simple_spinner_item, blood_group);
        bld_grp.setAdapter(dataAdapter_grp);
        bld_grp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                group = position;

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> dataAdapter_component = new ArrayAdapter<>(donor_blood.this, android.R.layout.simple_spinner_item,blood_component);
        bld_cmp.setAdapter(dataAdapter_component);
        bld_cmp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                component = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> dataAdapter_age = new ArrayAdapter<>(donor_blood.this, android.R.layout.simple_spinner_item,blood_age);
        bld_age.setAdapter(dataAdapter_age);
        bld_age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                age = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(donor_blood.this, android.R.layout.simple_spinner_item,blood_sex);
        bld_sex.setAdapter(dataAdapter);
        bld_sex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sex = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> dataAdapter_ht = new ArrayAdapter<>(donor_blood.this, android.R.layout.simple_spinner_item, blood_height);
        bld_ht.setAdapter(dataAdapter_ht);
        bld_ht.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                height= position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_diab= new ArrayAdapter<>(donor_blood.this, android.R.layout.simple_spinner_item, blood_diabities);
        bld_diab.setAdapter(dataAdapter_diab);
        bld_diab.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                diabities= position;
                if(diabities == 2){
                    Toast.makeText(getApplicationContext(),"Your Not Eligible to Give Blood",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> dataAdapter_aspirin= new ArrayAdapter<>(donor_blood.this, android.R.layout.simple_spinner_item,blood_aspirin);
        bld_aspirin.setAdapter(dataAdapter_aspirin);
        bld_aspirin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                aspirin = position;
                if(aspirin == 2){
                    Toast.makeText(getApplicationContext(),"Your Not Eligible to Give Blood",Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> dataAdapter_small= new ArrayAdapter<>(donor_blood.this, android.R.layout.simple_spinner_item,blood_smallpox);
        bld_smallpox.setAdapter(dataAdapter_small);
        bld_smallpox.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                smallpox= position;
                if(smallpox == 2){
                    Toast.makeText(getApplicationContext(),"Your Not Eligible to Give Blood",Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> dataAdapter_tb = new ArrayAdapter<>(donor_blood.this, android.R.layout.simple_spinner_item,blood_tb);
        bld_tb.setAdapter(dataAdapter_tb);
        bld_tb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tb= position;
                if(tb == 2){
                    Toast.makeText(getApplicationContext(),"Your Not Eligible to Give Blood",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> dataAdapter_malaria = new ArrayAdapter<>(donor_blood.this, android.R.layout.simple_spinner_item, blood_malaria);
        bld_malaria.setAdapter(dataAdapter_malaria);
        bld_malaria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                malaria = position;
                if(malaria == 2){
                    Toast.makeText(getApplicationContext(),"Your Not Eligible to Give Blood",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_hepatitis= new ArrayAdapter<>(donor_blood.this, android.R.layout.simple_spinner_item, blood_hepatis);
        bld_hepitites.setAdapter(dataAdapter_hepatitis);
        bld_hepitites.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                hepitites= position;
                if(hepitites== 2){
                    Toast.makeText(getApplicationContext(),"Your Not Eligible to Give Blood",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_jondis= new ArrayAdapter<>(donor_blood.this, android.R.layout.simple_spinner_item, blood_jondis);
        bld_jondis.setAdapter(dataAdapter_jondis);
        bld_jondis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                jondis = position;
                if(jondis == 2){
                    Toast.makeText(getApplicationContext(),"Your Not Eligible to Give Blood",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_heart= new ArrayAdapter<>(donor_blood.this, android.R.layout.simple_spinner_item, blood_heart);
        bld_heart.setAdapter(dataAdapter_heart);
        bld_heart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                heart= position;
                if(heart== 2){
                    Toast.makeText(getApplicationContext(),"Your Not Eligible to Give Blood",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_bypass= new ArrayAdapter<>(donor_blood.this, android.R.layout.simple_spinner_item, blood_bypass);
        bld_bypass.setAdapter(dataAdapter_bypass);
        bld_bypass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                bypass = position;
                if(bypass == 2){
                    Toast.makeText(getApplicationContext(),"Your Not Eligible to Give Blood",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_flu= new ArrayAdapter<>(donor_blood.this, android.R.layout.simple_spinner_item, blood_flu);
        bld_flu.setAdapter(dataAdapter_flu);
        bld_flu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                flu= position;
                if(flu == 2){
                    Toast.makeText(getApplicationContext(),"Your Not Eligible to Give Blood",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_cancer= new ArrayAdapter<>(donor_blood.this, android.R.layout.simple_spinner_item, blood_cancer);
        bld_cancer.setAdapter(dataAdapter_cancer);
        bld_cancer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                cancer = position;
                if(cancer == 2){
                    Toast.makeText(getApplicationContext(),"Your Not Eligible to Give Blood",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
