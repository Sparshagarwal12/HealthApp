package com.example.avi_hi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.avi_hi.Adapter.medicine_CheckboxAdapter;
import com.example.avi_hi.Adapter.tika_CheckboxAdapter;

import java.util.Arrays;
import java.util.List;

public class hospital_tika extends AppCompatActivity {


    RecyclerView recyclerView_tika,recyclerView_medicine;
    tika_CheckboxAdapter adapter_tika;
    medicine_CheckboxAdapter adapter_medicine;

    String[] list_tika= {
            "टीटी- का  टीका",
            "टीटी- का  टीका",
            "टीटी- बूस्टर का  टीका",
            "ओपीवी-0 का  टीका",
            "ओपीवी- का  टीका",
            "ओपीवी- का  टीका",
            "ओपीवी-3 का  टीका",
            "बी.सी.जी. का  टीका",
            "डी.पी.टी.-का  टीका",
            "डी.पी.टी.- का  टीका",
            "डी.पी.टी.-3 का  टीका",
            "हेपेटाइटिस ’बी’ का  टीका",
            "हेपेटाइटिस बी - का  टीका",
            "हेपेटाइटिस बी - का  टीका",
            "हेपेटाइटिस बी -3 का  टीका",
            "पोलियो (आईपीवी)  का  टीका",
            "खसरा का  टीका",
            "विटामिन-ए पहली खुराक",
            "डीपीटी बूस्टर । का  टीका",
            "ओपीवी बूस्टर का  टीका",
            "विटामिन-ए दूसरी से नौवीं खुराक तक",
            "डीपीटी बूस्टर ।। का  टीका",
            "टेटनस का  टीका",
            "हेपेटाइटिस बी (दूसरी खुराक) ",
            "डिप्थीरिया का  टीका",
            "काली खांसी (पर्टुसिस) (DTaP) का  टीका",
            "हीमोफिलस इन्फ्लुएंजा टाइप बी (हिब) का  टीका",
            "न्यूमोकोकल (पीसीवी) का  टीका ",
            "रोटावायरस (आरवी) का  टीका",
            "चिकनपॉक्स (वैरीसेला) का  टीका",
            "कण्ठमाला का  टीका",
            " रूबेला  का  टीका",
            "मेनिंगोकोकल संयुग्म का  टीका",
            "एचपीवी का  टीका",
            "फ्लू का  टीका",
            "ज़ोस्टर का  टीका",
            "एडिनोवायरस का  टीका",
            "बिसहरिया का  टीका",
            "हैज़ा का  टीका",
            "जापानी एन्सेफलाइटिस (जेई) का  टीका",
            "रेबीज का  टीका",
            "चेचक का  टीका",
            "यक्ष्मा का  टीका",
            "टॉ़यफायड बुखार का  टीका",
            "पीत ज्वर का  टीका"
    };
    String[] list_medicine= {
            "आयरन की गोलियाँ ",
            "कैल्शियम की गोलियाँ  ",
            "विटामिन A की गोलियाँ",
            "विटामिन A की गोलियाँ",
            "विटामिन A की गोलियाँ",
            "मैग्नीशियम की गोलियाँ",
            "फोलिक एसिड ",
            "आयोडीन की गोलियाँ",
            "विटामिन के- विटामिन के लिए",
            "क्लोरहेक्सिडिन डिगलुकोनेट- अतिशेष पथ काठिन्य के लिए",
            "कैफीन साइट्रेट-साँस लेने में अवरोध के लिए",
            "आइसोनियाज़िड / सह-ट्राइमेक्साज़ोल-एचआईवी के ",
            "आइसोनियाज़िड / सह-ट्राइमेक्साज़ोल-, टीबी प्रोफिलैक्सिस, ",
            "आइसोनियाज़िड / सह-ट्राइमेक्साज़ोल -न्यूमोसिस्टिस कारिनी निमोनिया",
            "इथाम्बुटोल: तपेदिक के लिए",
            "रिफैम्पिसिन: तपेदिक के लिए",
            "आइसोनियाजिड: तपेदिक के लिए",
            "पीरजीनॉमिड: पोस्ट-पार्टम हेमरेज के लिए",
            "मॉर्फिन-पोस्ट-पार्टम हेमरेज के लिए",
            "ऑक्सीटोसिन-पोस्ट-पार्टम हैमरेज के लिए",
            "सोडियम क्लोराइड-पोस्ट-पार्टम हेमरेज के लिए",
            "मैग्नीशियम सल्फेट-दर्द के लिए",
            "एम्पीसिलीन-निमोनिया के लिए ",
            "जेंटामाइसिन- नवजात सेप्सिस के लिए",
            "सेफ्ट्रियक्सोन - नवजात सेप्सिस के लिए",
            "नवजात सेप्सिस",
            "जेंटामाइसिन - न्यूमोनिया के लिए",
            "अमोक्सिसिलिन-निमोनिया के लिए",
            "आर्टीसुनेट - मलेरिया के लिए",
            "जिंक-दस्त के लिए",
            "ORS- दस्त के लिए"
    };
    List<String> checkList_tika = Arrays.asList(list_tika);
    List<String> checkList_medicine = Arrays.asList(list_medicine);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_tika);

        recyclerView_tika = findViewById(R.id.recyclerView_tika);
        recyclerView_tika.setHasFixedSize(true);
        recyclerView_tika.setLayoutManager(new LinearLayoutManager(hospital_tika.this));
        adapter_tika = new tika_CheckboxAdapter(hospital_tika.this, checkList_tika);
        recyclerView_tika.setAdapter(adapter_tika);

        recyclerView_medicine = findViewById(R.id.recyclerView_medicine);
        recyclerView_medicine.setHasFixedSize(true);
        recyclerView_medicine.setLayoutManager(new LinearLayoutManager(hospital_tika.this));
        adapter_medicine = new medicine_CheckboxAdapter(hospital_tika.this, checkList_medicine);
        recyclerView_medicine.setAdapter(adapter_medicine);

    }
}
