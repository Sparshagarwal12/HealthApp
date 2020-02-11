package com.example.avi_hi.Registration_Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.content.pm.PackageManager;
import android.view.View;
import android.Manifest;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.avi_hi.R;
import com.example.avi_hi.RetrofitClient;
import com.example.avi_hi.Login_Activity.blood_login;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class blood_reg extends AppCompatActivity implements View.OnClickListener{

   // FirebaseAuth mAuth;
    EditText email1,adhar,opt_name,blood_name,opt_mobile,blood_tehsil,blood_village,password,blood_block;
    Spinner blood_state,blood_district;
    String b_state,b_district;
    int bstate,bdistrict;
    Button loc,submit_blood;
    TextView lat1,lont;
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    private  static final int REQUEST_CODE = 101;


    ArrayList<String> states = new ArrayList<>(Arrays.asList(

            "आंध्र प्रदेश", "अरुणाचल प्रदेश","असम", "बिहार", "गोवा", "गुजरात", "हरियाणा",
            "हिमाचल प्रदेश", "जम्मू और कश्मीर", "कर्नाटका", "केरला",  "मध्य प्रदेश", "महाराष्ट्र", "मणिपुर",
            "मेघालय", "मिजोरम", "नागालैंड", " उड़ीसा","उत्तर प्रदेश","उत्तराखंड", "पंजाब", "राजस्थान", "सिक्किम",
            "तमिलनाडु", "त्रिपुरा","पश्चिम बंगाल", "छत्तीसगढ़",  "झारखंड", "तेलंगाना", "दिल्ली", "अंडमान और निकोबार",
            "दादरा और नगर हवेली", "दमन और दीव", "लक्षद्वीप – कवरेटी","पुदुच्चेरी", "लद्दाख"
    ));
    ArrayList<ArrayList<String> > districts = new ArrayList<>(Arrays.asList(

            new ArrayList<>(Arrays.asList(
                    "अनंतपुर", "चित्तूर", "पूर्व गोदावरी", "गुंटूर", "कड़प्पा", "कृष्णा", "कुर्नूल", "नेल्लौर", "प्रकाशम",
                    "श्रीकाकुलम", "विशाखापट्टनम", "विजयनगरम", "पश्चिम गोदावरी"
            )),
            new ArrayList<>(Arrays.asList(
                    "अंजॉ", "चेंगलॉन्ग", "पूर्वकमेंग", "पूर्वसियांग", "कुरुंगकुमे", "लोहित", "निचलीदिबांगघाटीजि", "निचलीसुबनसिरी",
                    "पपुमपारे", "तवांग", "तिरप", "उपरीदिबांगघाटी", "उपरीसुबनसिरी", "उपरीसियांग", "पश्चिमसियांग", "पश्चिमकमेंग"
            )),
            new ArrayList<>(Arrays.asList(
                    "तिनसुकिया", "डिब्रूगढ़", "धेमाजी", "चरैदेव", "शिवसागर", "लखीमपुर", "माजुली", "जोरहाट", "बिश्वनाथ", "गोलघाट",
                    "करगंज एंगलोंग ईस्ट", "सोनितपुर", "नागांव", "होजई", "कार्बी आंग्लोंग पश्चिम", "दीमा हसाओ", "कछार", "हैलाकांडी", "करीमगंज","मोरीगांव",
                    "उदलगुरी", "दरंग", "कामरूप महानगर", "बक्सा","नलबाड़ी","कामरूप","बारपेटा","चिरांग","बोंगाईगाँव","गोलपारा"," कोकराझार","धुबरी","दक्षिण सालारा-मनकाचर"
            )),
            new ArrayList<>(Arrays.asList(
                    "अरवल", "औरंगाबाद", "बांका", "बेगूसराय", "भागलपुर","भोजपुर", "बक्सर", "दरभंगा", "पूर्वी", "चंपारण","गया", "गोपालगंज","जमुई",
                    "जहानाबाद","कटिहार"," खगरिया","किशनगंज"," लखीसराय","मधेपुरा","मधुबनी","मुंगेर","मुजफ्फरपुर","नालंदा","नवादा","पटना", "पूर्णियाँ",
                    "सहरसा", "समस्तीपुर", "सारण", "रोहतास", "शेखपुरा", "शिवहर", "सीतामढ़ी", "सुपौल", "वैशाली", "पश्चिमी", "चंपारण"
            )),
            new ArrayList<>(Arrays.asList(
                    "चपोरा", "डाबोलिम", "मडगांव", "मर्मुगाओ (मर्मगाओ)", "पणजी पोर्ट","पंजिम", "पेलेट प्लांट जेट्टी / शिरोडा", "तलपोना"
            )),
            new ArrayList<>(Arrays.asList(
                    "अहमदाबाद", "अमरेली", "आणंद", "अरावली", "बनासकांठा", "भरुच", "भावनगर", "बोटाड", "छोटा उदयपुर", "दाहोद", "डांग",
                    "देवभूमि द्वारका", "गांधीनगर", "गिर सोमनाथ", "जामनगर", "जूनागढ़", "कच्छ", "खेड़ा", "महीसागर", "मेहसाणा", "मोरबी", "नर्मदा",
                    "नवसारी", "पंचमहल", "पाटन", "पोरबंदर", "राजकोट", "साबरकांठा", "सूरत", "सुरेंद्रनगर", "तापी", "वड़ोदरा", "वलसाड"
            )),
            new ArrayList<>(Arrays.asList(
                    "अम्बाला", "भिवानी", "फरीदाबाद", "फ़तेहाबाद", "गुड़गाँव", "हिसार", "झज्जर", "जिंद", "कैथल", "करनाल", "कुरुक्षेत्र", "महेन्द्रगढ", "नूँह",
                    "पलवल", "पंचकुला", "पानीपत", "रेवाड़ी", "रोहतक", "सिरसा", "सोनीपत", "यमुनानगर", "चरखीदादरी"
            )),
            new ArrayList<>(Arrays.asList(
                    "चम्बा", "कांगड़ा", "लाहौलऔरस्पीति", "कुल्लू", "मण्डी", "हमीरपुर", "ऊना", "बिलासपुर", "सोलन", "सिरमौर", "शिमला", "किन्नौर"
            )),
            new ArrayList<>(Arrays.asList(
                    "जम्मू", "डोडा", "किश्तवार", "राजौरी", "रियासी", "उधमपुर", "रामबन", "कठुआ", "साम्बा", "पुंछ", "श्रीनगर", "अनंतनाग", "कुलगाम",
                    "पुलवामा", "शोपियां", "बडगाम", "गांदरबल", "बांदीपोरा", "बारामुला", "कुपवाड़ा"
            )),
            new ArrayList<>(Arrays.asList(
                    "बागलकोट", "बैंगलोर", "बैंगलोर ग्रामीण", "बेलगाम", "बेल्लारी", "बीदर", "विजयपुरा", "चामराजनगर", "चिकबल्लापुर", "चिकमगलूर", "चित्रदुर्ग",
                    "दक्षिण कन्नड़", "दावणगेरे", "धारवाड़", "गदग", "गुलबर्गा", "हसन", "हावेरी", "कोडागू", "कोलार", "कोप्पल", "मांड्या", "मैसूर", "रायचूर",
                    "रामनगर", "शिमोगा", "तुमकुर", "उडुपी", "उत्तर कन्नड़", "यादगिर", "वड़ोदरा", "वलसाड"
            )),
            new ArrayList<>(Arrays.asList(
                    "कलपेट्टा", "इडुक्की", "पथानामथिट्टा", "कासरगोड", "कोट्टायम", "अलाप्पुझा", "कन्नूर", "कोल्लम", "पलक्कड़", "कोझिकोड", "त्रिशूर", "एर्नाकुलम", "थिरुवनंथपुरम", "मल्लापुरम"
            )),
            new ArrayList<>(Arrays.asList(
                    "जबलपुर", "कटनी", "भोपाल", "सीधी", "बड़वानी", "ग्वालियर", "धार", "उज्जैन", "हरदा", "शिवपुरी", "मंदसौर", "रायसेन", "शाजापुर",
                    "विदिशा", "श्योपुर", "अशोक नगर", "सतना", "गुना", "खंडवा (पूर्व निमाड़)", "डिंडोरी", "होशंगाबाद", "सिंगरोली", "उमरिया", "रतलाम", "राजगढ़",
                    "देवास", "छतरपुर", "अलिराजपुर", "बुरहानपुर", "भींड", "सागर", "नीमच", "दतिया", "पन्ना", "सिहोर", "खरगोन (पश्चिम निमाड़)", "रीवा",
                    "सिवनी", "शहडोल", "दमोह", "टीकमगढ़", "झाबुआ", "इंदौर", "मुरैना", "नरसिंहपुर", "बालाघाट", "मांडला", "छिंदवाड़ा", "बेतूल", "अनूपपुर", "आगर", "निवारी जिला"
            )),
            new ArrayList<>(Arrays.asList(
                    "अहमदनगर", "अकोला", "अमरावती", "औरंगाबाद", "बीड", "भंडारा", "बुलढाणा", "चंद्रपुर", "धुले", "गढ़चिरौली", "गोंदिया", "हिंगोली", "जलगांव",
                    "जालना", "कोल्हापुर", "लातूर", "मुंबई शहर", "मुंबई उपनगर", "नागपुर", "नांदेड", "नंदुरबार", "नासिक", "उस्मानाबाद", "परभणी", "पालघर", "पुणे",
                    "रायगढ़", "रत्नागिरि", "सांगली", "सतारा", "सिंधुदुर्ग", "सोलापुर", "ठाणे", "वर्धा", "वाशिम", "यवतमाल"
            )),
            new ArrayList<>(Arrays.asList(
                    "बिष्णुपुर", "छुरछंदपुर", "चंदेल", "इंफाल ईस्ट", "सेनापति", "तमेंगलोंग", "थौबल", "उखरूल", "इम्फाल वेस्ट", "कक्किंग", "जिरीबाम", "कमजोंग", "नोनी", "फेरजॉल", "टेंगनूपाल", "कांगपोकपि"
            )),
            new ArrayList<>(Arrays.asList(
                    "पूर्वी खासी हिल्स", "दक्षिण गारो हिल्स", "वेस्ट जयंतिया हिल्स", "पश्चिम खासी हिल्स", "पूर्वी गारो हिल्स", "री भोई", "दक्षिण पश्चिम खासी हिल्स",
                    "पूर्वी जयंतिया हिल्स", "उत्तरी गारो हिल्स", "दक्षिण पश्चिम गारो हिल्स", "वेस्ट गारो हिल्स"
            )),
            new ArrayList<>(Arrays.asList(
                    "आइजोल","कोलासिब","लॉन्गतलाई ","लुंगलेई","ममित " , "सइहा " , "सेरछिप" , "चम्फाई"
            )),
            new ArrayList<>(Arrays.asList(
                    "लोंगलेंग", "कोहिमा", "मोन", "तुएनसांग", "मोकोकचुंग", "वोखा", "फेक", "जुन्हेबोटो", "पेरेन", "कैफाइर", "दीमापुर"
            )),
            new ArrayList<>(Arrays.asList(
                    "अंगुल", "बलांगीर", "बालासोर", "बरगढ़ जिला ", "बौद्ध जिला", "भद्रक", "कटक", "देवगढ़", "ढेंकनाल", "गजपति", "गंजम",
                    "जगतसिंहपुर", "जाजपुर", "झारसुगुडा", "कालाहांडी", "कंधमाल", "केंद्रपाड़ा", "केंदुझार (क्योंझर)", "खोरधा", "कोरापुट", "मलकानगिरी",
                    "मयूरभंज", "नबरंगपुर", "नयागढ़", "नुआपाड़ा", "पुरी", "रायगडा", "संबलपुर", "सुबर्णपुर (सोनेपुर)", "सुंदरगढ़"
            )),
            new ArrayList<>(Arrays.asList(
                    "आगरा", "इलाहाबाद", "अलीगढ़ उत्तर प्रदेश", "अमेठी", "औरैया", "आजमगढ़", "बाराबंकी उत्तर प्रदेश", "बागपत", "बदायूं", "बहराइच उत्तर प्रदेश",
                    "बिजनौर", "बलिया उत्तर प्रदेश", "बांदा उत्तर प्रदेश", "बलरामपुर उत्तर प्रदेश", "बरेली", "बस्ती उत्तर प्रदेश", "बुलंदशहर", "चंदौली", "चित्रकूट", "देवरिया",
                    "एटा उत्तर प्रदेश", "इटावा", "फ़िरोज़ाबाद", "फर्रुखाबाद", "फ़तेहपुर", "फैजाबाद", "गौतम बुद्ध नगर", "गोंडा", "गाजीपुर", "गोरखपुर", "गाज़ियाबाद", "हापुड़",
                    "हमीरपुर", "हरदोई", "हाथरस", "झांसी", "अमरोहा", "जौनपुर", "अंबेडकर नगर", "कन्नौज", "कानपुर", "कानपुर देहात", "कासगंज", "कौशाम्बी", "कुशीनगर",
                    "ललितपुर", "लखीमपुर खीरी", "लखनऊ", "मउ", "मेरठ", "महाराजगंज", "महोबा", "मिर्जापुर", "मुरादाबाद", "मैनपुरी", "मथुरा", "मुज़फ़्फ़रनगर", "पीलीभीत",
                    "प्रतापगढ़", "रामपुर", "रायबरेली़", "सहारनपुर", "सीतापुर", "शाहजहांपुर", "शामली", "संभल", "सिद्धार्थनगर", "सोनभद्र", "भदोही", "सुलतानपुर", "श्रावस्ती", "उन्नाव",
                    "वाराणसी", "संत कबीर नगर", "जालौन"
            )),
            new ArrayList<>(Arrays.asList(
                    "अल्मोड़ा", "बागेश्वर", "चमोली", "चंपावत", "देहरादून", "हरिद्वार", "नैनीताल", "पौड़ी गढ़वाल", "पिथौरागढ़", "रुद्रप्रयाग", "टिहरी गढ़वाल", "उधम सिंह नगर", "उत्तरकाशी़"
            )),
            new ArrayList<>(Arrays.asList(
                    "लुधियाना", "अमृतसर", "जालंधर", "साहिबजादा अजीत सिंह नगर", "गुरदासपुर", "पटियाला", "फतेहगढ़ साहिब", "कपूरथला", "रूपनगर",
                    "शहीद भगत सिंह नगर", "होशियारपुर", "तरनतारन", "संगरूर", "मोगा", "फरीदकोट", "बरनाला", "बठिंडा", "फिरोजपुर", "मानसा", "मुक्तसर",
                    "पठानकोट", "फ़ज़िलका"
            )),
            new ArrayList<>(Arrays.asList(
                    "अजमेर", "अलवर", "बांसवाड़ा़", "बारन", "बाडमेर", "भरतपुऱ", "भीलवाड़ा़", "बीकानेर", "बूंदी", "चित्तौड़गढ़़", "चूरु", "दौसा", "धौलपुर",
                    "डूंगरपुर", "हनुमानगढ़", "जयपुर", "जैसलमेर", "जालोर", "झालावाड़", "झुन्झुनू़", "जोधपुऱ", "करौली", "कोटा़", "नागौऱ", "पाली़", "प्रतापगढ़",
                    "राजसमन्द", "सवाई माधोपुर", "सीकर", "सिरोही", "श्री गंगानगर", "टोंक", "उदयपुर"
            )),
            new ArrayList<>(Arrays.asList(
                    "पूर्वी सिक्किम", "उत्तर सिक्किम", "दक्षिण सिक्किम", "पश्चिम सिक्किम"
            )),
            new ArrayList<>(Arrays.asList(
                    "अरियालुर", "चेन्नई", "कोयंबटूर", "कुड्डालोर", "धर्मपुरी", "डिंडीगुल", "इरोड", "कांचीपुरम", "कन्याकुमारी", "करूर", "कृष्णागिरि", "मदुरई",
                    "नागपट्टनम", "नमक्कल", "पेरम्बलुर", "पुदुक्कोट्टई", "रामनाथपुरम", "सलेम", "शिवगंगा", "तंजावुर", "नीलगिरी", "थेनी", "तिरुवल्लुर", "तिरुवरुर",
                    "थूथुक्कुडी", "तिरुचिरापल्ली", "तिरुनेलवेली", "तिरुपुर", "तिरुवन्नामलाई", "वेल्लोर", "वेल्लोर", "विरुधुनगर"
            )),
            new ArrayList<>(Arrays.asList(
                    "धलाई", "उत्तर त्रिपुरा", "दक्षिणी त्रिपुरा", "पश्चिम त्रिपुरा", "खोवाई", "सिपाहीजाला", "गोमती", "उनाकोटी "
            )),
            new ArrayList<>(Arrays.asList(
                    "दक्षिण दिनाजपुर", "पुरुलिया", "दक्षिण 24 परगना", "उत्तर 24 परगना", "नादिया", "मुर्शिदाबाद", "पूर्ब मेदिनीपुर", "पश्चिम मेदिनीपुर",
                    "मालदा", "कोलकाता", "कूच बिहार", "जलपाईगुड़ी", "हावड़ा", "हुगली", "उत्तर दिनाजपुर", "दार्जिलिंग", "बर्धमान", "बांकुरा", "बीरभूम", "अलीपुरद्वार", "झारग्राम "
            )),
            new ArrayList<>(Arrays.asList(
                    "बालोद", "बलोदा बाजार", "बलरामपुर-रामानुजगंज", "बस्तर", "बेमेतरा", "बीजापुर", "बिलासपुर", "दन्तेवाड़ा", "धमतरी", "दुर्ग",
                    "गरियाबंद", "जांजगीर-चाम्पा", "जशपुर", "कवर्धा", "कांकेर", "कोण्डागांव", "कोरबा", "कोरिया", "महासमुन्द", "मुंगेली", "नारायणपुर",
                    "रायपुर", "रायगढ़", "राजनांदगांव", "सुकमा", "सूरजपुर", "सुरगुजा"
            )),
            new ArrayList<>(Arrays.asList(
                    "रांची", "धनबाद", "गिरिडीह", "पूर्वी सिंहभूम", "बोकारो", "पलामू", "हजारीबाग", "पश्चिमी सिंहभूम", "देवघर", "गढवा", "दुमका",
                    "गोड्डा", "साहिबगंज", "सरायकेला खरसावां", "चतरा", "गुमला", "रामगढ़", "पाकुड़", "जामताड़ा", "लातेहार", "कोडरमा", "सिमडेगा", "खूंटी", "लोहरदग्गा"
            )),
            new ArrayList<>(Arrays.asList(
                    "आदिलाबाद", "कोमराम भीम", "भद्राद्री कोठागुडम", "जयशंकर भूपपाल", "जोगुलबा गडवाल", "हैदराबाद", "जागतिअल", "जनगांव",
                    "कामारेड्डी", "करीमनगर", "खम्मम", "महबुबाबाद", "महबूबनगर", "मंचेरिअल", "मेडक", "मेडचाल मल्काजगिरि", "नलगोंडा", "नगरकुरनूल",
                    "निर्मल", "निजामाबाद", "रंगारेड्डी", "पेड्डापल्ली", "राजन्ना सिर्सिल्ला", "संगारेड्डी", "सिद्दिपेट", "सूर्यापेट", "विकाराबाद", "वनापर्थी", "वारंगल शहर",
                    "वारंगल (ग्रामीण)", "यदाद्रि भुवनगिरी", "नारायणपेट", "सम्मक्का मुलुगु"
            )),
            new ArrayList<>(Arrays.asList(
                    "दरयागंज", "सदरबाजार", "साकेत", "प्रीतविहार", "शाहदरा", "पालम, ", "राजौरीगार्डन", "कनाटपैलेस", "कंझावला"
            )),
            new ArrayList<>(Arrays.asList(
                    "दक्षिण अंडमान", " उत्तर और मध्य अंडमान", " निकोबार"
            )),
            new ArrayList<>(Arrays.asList(
                    "सिल्वासा"
            )),
            new ArrayList<>(Arrays.asList(
                    "दमन", "दीव"
            )),
            new ArrayList<>(Arrays.asList(
                    "लक्षद्वीप"
            )),
            new ArrayList<>(Arrays.asList(
                    "कराईकल", "माहे", "पांडिचेरी", "यानम"
            )),
            new ArrayList<>(Arrays.asList(
                    "लेह"
            ))
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_reg);


        loc = findViewById(R.id.get_loc_blood);
        lat1= findViewById(R.id.lat_blood);
        lont = findViewById(R.id.lon_blood);

        blood_state = findViewById(R.id.blood_state);
        blood_district= findViewById(R.id.blood_dist);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(blood_reg.this, android.R.layout.simple_spinner_item, states);
        blood_state.setAdapter(dataAdapter);

        blood_state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                b_state = parent.getItemAtPosition(position).toString();
                bstate = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        blood_state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(blood_reg.this, android.R.layout.simple_spinner_item, districts.get(position));
                blood_district.setAdapter(dataAdapter);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
//        mAuth = FirebaseAuth.getInstance();
        submit_blood = findViewById(R.id.button_submit_blood);
        blood_name = findViewById(R.id.blood_bank_name);
        email1 = findViewById(R.id.blood_email);
        opt_name = findViewById(R.id.blood_operator_Name);
        adhar = findViewById(R.id.blood_operator_aadhar);
        opt_mobile = findViewById(R.id.blood_operator_mobile);
        password = findViewById(R.id.blood_password);
        blood_tehsil = findViewById(R.id.blood_bank_tehsil);
        blood_village = findViewById(R.id.blood_bank_village);
        blood_block = findViewById(R.id.blood_bank_block);

        loc.setOnClickListener(this);
        submit_blood.setOnClickListener(this);
    }
    private void fetchLastLocation() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {

                    currentLocation = location;
                    lat1.setText(""+currentLocation.getLatitude());
                    lont.setText(""+currentLocation.getLongitude());
                    Toast.makeText(getApplicationContext(),currentLocation.getLatitude()+"--"+currentLocation.getLongitude(),Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    public void blood_register() {

        String blood_aadhar = adhar.getText().toString().trim();
        String blood_password = password.getText().toString().trim();
        String blood_email = email1.getText().toString().trim();
        String blood_operator_name = opt_name.getText().toString().trim();
        String blood_teh = blood_tehsil.getText().toString().trim();
        String blood_latitude = lat1.getText().toString();
        String blood_longitude = lont.getText().toString();
        String blood_mobile = opt_mobile.getText().toString().trim();
        String blood_address = blood_block.getText().toString().trim();
        String blood_region = blood_village.getText().toString().trim();
        String blood_st = blood_state.getSelectedItem().toString();
        String bld_distu = blood_district.getSelectedItem().toString();
        String blood_bank_name = blood_name.getText().toString().trim();


        Call<ResponseBody> call= RetrofitClient.getInstance()
                .getInterface()
                .createUser(blood_aadhar, blood_password, blood_email, blood_operator_name,
                        blood_teh, blood_latitude, blood_longitude, blood_mobile, blood_address,blood_region,
                         blood_st,bld_distu, blood_bank_name);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody dr=response.body();
                Toast.makeText(blood_reg.this,"User Created Successfully",Toast.LENGTH_LONG).show();
                try {
                    String s = response.body().string();
                    Toast.makeText(blood_reg.this,"User Created Successfully"+s,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(blood_reg.this, blood_login.class);
                    startActivity(intent);
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
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_submit_blood:
                blood_register();
                break;
            case R.id.get_loc_blood:
                fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(blood_reg.this);
                fetchLastLocation();
                break;
        }
    }
}

