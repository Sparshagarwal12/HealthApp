package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.avi_hi.Adapter.Surgery_CheckboxAdapter;
import com.example.avi_hi.Adapter.Ward_CheckboxAdapter;

import java.util.Arrays;
import java.util.List;

public class hospital_ward extends AppCompatActivity {

    RecyclerView recyclerView,recyclerView_surgery;
    Ward_CheckboxAdapter adapter;
    Surgery_CheckboxAdapter adapter_surgery;

    String[] list = {
            "जनरल वार्ड ( महिला )",
            "जनरल वार्ड ( पुरुष )",
            "मेजर ऑपरेशन थिएटर वार्ड",
            "माइनर ऑपरेशन थिएटर वार्ड ",
            "आई सी यू",
            "मनोरोग वार्ड",
            "ट्रॉमा सेंटर वार्ड",
            "नवजात गहन देखभाल इकाई (NICU)",
            "बाल गहन चिकित्सा इकाई (PICU)",
            "कोरोनरी देखभाल इकाई (CCU)",
            " कार्डियोथोरेसिक  इकाई ( CTU)",
            "सर्जिकल गहन देखभाल इकाई (SICU)",
            "चिकित्सा गहन देखभाल इकाई",
            "दीर्घकालिक गहन देखभाल इकाई ",
            "नवजात इकाई",
            "बाल चिकित्सा इकाई",
            "ऑन्कोलॉजी इकाई",
            "सर्जिकल इकाई",
            "पुनर्वास इकाई",
            "बर्न इकाई",
            "प्रसूति इकाई"
    };
    String[] list_surgery = {
            "हृदय सर्जरी विभाग ( कार्डिएक )", "दन्त सर्जरी विभाग", "न्यूरो सर्जरी ", " संयुक्त प्रतिस्थापन और सर्जरी",
            "बेरिएट्रिक सर्जरी", "बाल चिकित्सा सर्जरी ", "रीढ़ की हड्डी की सर्जरी", "ऑन्कोलॉजी सर्जरी", "वक्ष सर्जरी(थोरेसिक )",
            "संवहनी और एंडोवस्कुलर सर्जरी", "रोबोट सर्जरी", "ब्रैस्ट बाईओप्सी ", "प्लास्टिक और कॉस्मेटिक सर्जरी"
    };

    List<String> checkList = Arrays.asList(list);
    List<String> checkList_surgery = Arrays.asList(list_surgery);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_ward);

        recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(hospital_ward.this));

        adapter = new Ward_CheckboxAdapter(hospital_ward.this, checkList);
        recyclerView.setAdapter(adapter);


        recyclerView_surgery= findViewById(R.id.recyclerView_surgery);
        recyclerView_surgery.setHasFixedSize(true);
        recyclerView_surgery.setLayoutManager(new LinearLayoutManager(hospital_ward.this));
        adapter_surgery = new Surgery_CheckboxAdapter(hospital_ward.this, checkList_surgery);
        recyclerView_surgery.setAdapter(adapter_surgery);
    }
}
