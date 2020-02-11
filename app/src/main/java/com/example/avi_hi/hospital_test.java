package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.avi_hi.Adapter.Labs_CheckboxAdapter;
import com.example.avi_hi.Adapter.test_CheckboxAdapter;

import java.util.Arrays;
import java.util.List;

public class hospital_test extends AppCompatActivity {

    RecyclerView recyclerView_test;
    test_CheckboxAdapter adapter_test;
    RecyclerView recyclerView_labs;
    Labs_CheckboxAdapter adapter_labs;

    String[] list_test = {
            "ग्लूकोज जाँच", "कैल्शियम जाँच", "कार्डियक एन्ज़ाइम्स जाँच", "कोलेस्ट्रॉल जाँच", "लिपिड जाँच",
            "सीबीसी जाँच", "एमआरआई", "सीटीस्कैन", "कैटस्कैन", "पैट स्कैन", "एक्सरे", "थाइरोइड फंक्शन जाँच",
            "लिवर जाँच  ", "खून की जाँच", "किडनी जाँच", "सी-रीएक्टीवप्रोटीन", "डी-डाइमर टेस्ट ", "एरीथ्रोसाइट अवसादन",
            "फोलेट परीक्षण", "पूर्ण खून जाँच", "एचबीए आईसी परीक्षण", "एचसीपी परीक्षण","एच.ऑय.वी टेस्ट"
    };
    List<String> checkList_test = Arrays.asList(list_test);
    String[] list_labs= {
            "रुधिर प्रयोगशाला (हेमटोलॉजी)",
            "ऊतकविकृति प्रयोगशाला (हिस्टोपैथोलॉजी)",
            "कोशिका प्रयोगशाला (साइटोलॉजी)",
            "नियमित पैथोलॉजी प्रयोगशाला (रूटीन पैथोलॉजी)",
            "जीवाणुतत्व प्रयोगशाला (बक्टेरिओलॉजी)",
            "वायरोलॉजी  प्रयोगशाला",
            "कवक प्रयोगशाला (माइकोलॉजी)",
            "प्रतिरक्षा प्रयोगशाला (इम्म्युंनोलॉजी)",
            "सीरम प्रयोगशाला (सिरोलॉजी)",
            "हार्मोन प्रयोगशाला (हॉर्मोनोलॉजी)",
            "परजीवी प्रयोगशाला (पैरासाइटोलॉजी)"
    };
    List<String> checkList_labs = Arrays.asList(list_labs);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_test);

        recyclerView_test = findViewById(R.id.recyclerView_test);
        recyclerView_test.setHasFixedSize(true);
        recyclerView_test.setLayoutManager(new LinearLayoutManager(hospital_test.this));


        adapter_test = new test_CheckboxAdapter(hospital_test.this, checkList_test);
        recyclerView_test.setAdapter(adapter_test);

        recyclerView_labs = findViewById(R.id.recyclerView_lab);
        recyclerView_labs.setHasFixedSize(true);
        recyclerView_labs.setLayoutManager(new LinearLayoutManager(hospital_test.this));
        adapter_labs = new Labs_CheckboxAdapter(hospital_test.this, checkList_labs);
        recyclerView_labs.setAdapter(adapter_labs);

    }
}
