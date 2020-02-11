package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.avi_hi.Adapter.CheckboxAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ambulance_facility extends AppCompatActivity {

    Boolean link;
//    FirebaseAuth mAuth;
    Button submit;
    String permission,type_item,price_list;
    int st,pr,dt,pri;
    RecyclerView recyclerView;
    CheckboxAdapter adapter;
    int flag =0;
    EditText amb_number,ambulance_model,ambulance_chassis,hos_name;

    Spinner type,info,price;

    ArrayList<String> ambulance_types = new ArrayList<>(Arrays.asList(
            "बेसिक लाइफ सपोर्ट एम्बुलेंस","एडवांस लाइफ सपोर्ट एम्बुलेंस ", "पेशेंट ट्रांसफर  सपोर्ट एम्बुलेंस ",  "मुर्दाघर एम्बुलेंस","सामान्य एम्बुलेंस"
    ));

    ArrayList<String> hospital_perm = new ArrayList<>(Arrays.asList(
            "Linked to hospital\n", "yes\n", "no\n"
    ));

    ArrayList<String> service = new ArrayList<>(Arrays.asList(
            "सेवा प्रकार","नि: शुल्क सेवा", "सशुल्क सेवा"
    ));

    String[] list = {
            "बीपी मॉनिटर ",
            "स्ट्रेचर",
            "ऑक्सीजन सिलेंडर",
            "इलेक्ट्रोकार्डियोग्राफी (ईसीजी) मशीन",
            "कार्डिएक मॉनिटर",
            "इनक्यूबेटर:  तापमान, आर्द्रता CO2 और ऑक्सीजन के लिए",
            "रक्त संग्रह की आपूर्ति के लिए",
            "इंट्रा वेनस कैथेटर्स",
            "इंट्रा वेनस प्रिपरेशन सप्लायर्स",
            "इंट्रा वेनस सॉल्यूशंस",
            "इंट्रा वेनस टूरनिकेट्स",
            "नीडलेस इंट्रा वेनस सेट्स",
            "पूर्व मिश्रित इंट्रा वेनस सॉल्यूशन बैग",
            "सुरक्षात्मक इंट्रा वेनस कैथेटर्स",
            "चुनिंदा इंट्रा वेनस सेट्स ",
            "वेंटिलेटर (श्वासयंत्र)",
            "डिफाइब्रिलेटर: दिल की धड़कन को बहाल करने के लिए",
            "ऑक्सीजन सिलेंडर",
            " नेबुलाइज़र: अस्थमा रोगी की सांस लेने के लिए",
            "रिससिटेशन किट ",
            "बीपी उपकरण",
            "चिकित्सक",
            "सहायक"
    };


    List<String> checkList = Arrays.asList(list);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance_facility);
        submit = findViewById(R.id.ambulance_submit);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference reff = database.getReference("Ambulance Registration");

        recyclerView = findViewById(R.id.recyclerView_ambulance);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(ambulance_facility.this));

        adapter = new CheckboxAdapter(ambulance_facility.this, checkList);
        recyclerView.setAdapter(adapter);

        type = findViewById(R.id.ambulance_type);
        info = findViewById(R.id.hospital_info);
        hos_name = findViewById(R.id.hospital_name_new);
        price = findViewById(R.id.hospital_price);


        ArrayAdapter<String> dataAdapter_t = new ArrayAdapter<>(ambulance_facility.this, android.R.layout.simple_spinner_item, ambulance_types);
        type.setAdapter(dataAdapter_t);
        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type_item = parent.getItemAtPosition(position).toString();
                dt = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapter_price = new ArrayAdapter<>(ambulance_facility.this, android.R.layout.simple_spinner_item, service);
        price.setAdapter(dataAdapter_price);
        price.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                price_list = parent.getItemAtPosition(position).toString();
                pri = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(ambulance_facility.this, android.R.layout.simple_spinner_item, hospital_perm);
        info.setAdapter(dataAdapter);
        info.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                permission= parent.getItemAtPosition(position).toString();
                pr = position;


//                LayoutInflater inflater = getLayoutInflater();
//                if(pr==1){
////                    LinearLayout mainLayout = (LinearLayout) findViewById(R.id.activity_ambulance_facility);
////                    View  myLayout = inflater.inflate(R.layout.new_layout, null);
////                    mainLayout.addView(myLayout);
////                    flag=1;
//////                    hos_name.setVisibility(View.VISIBLE);
////                    if(pr==2){
//////                       hos_name.setVisibility(View.INVISIBLE);
////                    }
////                    if(pr==0){
//////                        hos_name.setVisibility(View.GONE);
////                    }
//                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        amb_number = findViewById(R.id.ambulance_number);
        ambulance_model = findViewById(R.id.ambulance_model_number);
        ambulance_chassis = findViewById(R.id.ambulance_chases_number);
//        final ambulance ambulance = new ambulance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String ambulance_type = type.getSelectedItem().toString();
//                    String ambulace_linked = info.getSelectedItem().toString();
                    String ambulance_price = price.getSelectedItem().toString();
//                    String Hospital_name = hos_name.getText().toString().trim();
                    String Ambulance_number = amb_number.getText().toString().trim();
                    String Ambulance_model = ambulance_model.getText().toString().trim();
//                    String Ambulance_chassis = ambulance_chassis.getText().toString().trim();

               if(pr==1){
                   link =true ;
               }
               else{
                   link = false;
               }

                Toast.makeText(getApplicationContext(),""+link,Toast.LENGTH_SHORT).show();
                    Call<ResponseBody> call= RetrofitClient.getInstance()
                            .getInterface()
                            .ambulanceFacility(
                                    ambulance_type,
                                    link,
                                    ambulance_price,
                                    Ambulance_number,
                                    Ambulance_model
                            );

                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            try {
                                String s = response.body().string();
                                Toast.makeText(ambulance_facility.this,"Successfully Added",Toast.LENGTH_LONG).show();
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