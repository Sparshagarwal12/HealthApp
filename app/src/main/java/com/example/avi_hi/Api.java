package com.example.avi_hi;

import com.example.avi_hi.Log.community_log;
import com.example.avi_hi.PojoClasses.hospital_show_pojo;
import com.example.avi_hi.KeyVerification.wardVerify;
import com.example.avi_hi.Log.ambulance_log;
import com.example.avi_hi.Log.blood_log;
import com.example.avi_hi.Log.hospital_log;
import com.example.avi_hi.Log.lab_log;
import com.example.avi_hi.Log.tika_log;
import com.example.avi_hi.PojoClasses.DoctorPostPojo;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

    //For All Post Request

    @FormUrlEncoded
    @POST("/account/bloodbank/create")
    Call<ResponseBody> createUser(
            @Field("aadhar") String aadhar,
            @Field("password") String password,
            @Field("email") String email,
            @Field("first_name") String first_name,
            @Field("tahsil") String tahsil,
            @Field("latitude") String latitude,
            @Field("longitude") String longitude,
            @Field("mobile_number") String mobile_number,
            @Field("address") String address,
            @Field("region") String region,
            @Field("state") String state,
            @Field("district") String district,
            @Field("name") String name
    );

    @FormUrlEncoded
    @POST("/account/hospital/create")
    Call<ResponseBody> createHospital(
            @Field("aadhar") String aadhar,
            @Field("password") String password,
            @Field("email") String email,
            @Field("first_name") String first_name,
            @Field("tahsil") String tahsil,
            @Field("key") String key,
            @Field("latitude") String latitude,
            @Field("longitude") String longitude,
            @Field("mobile_number") String mobile_number,
            @Field("region") String region,
            @Field("state") String state,
            @Field("district") String district,
            @Field("name") String name
    );

//    @FormUrlEncoded
//    @POST("/hospital")
//    Call<ResponseBody> createHospital(
//            @Field("name") String name,
//            @Field("address") String addreess,
//            @Field("tahsil") String tahsil,
//            @Field("district") String district,
//            @Field("state") String state,
//            @Field("mobile_number") String mobile_number,
//            @Field("region") String region,
//            @Field("latitude") String latitude,
//            @Field("longitude") String longitude
//    );

    @FormUrlEncoded
    @POST("/account/hospitalstaff/create")
    Call<ResponseBody> createLab(
            @Field("aadhar") String aadhar,
            @Field("staff_type") String staff_type,
            @Field("password") String password,
            @Field("email") String email,
            @Field("first_name") String first_name,
            @Field("tahseel") String tahseel,
            @Field("hospital_id") Integer hospital_id,
            @Field("latitude") String latitude,
            @Field("longitude") String longitude,
            @Field("mobile_number") String mobile_number,
            @Field("region") String region,
            @Field("hospital_name") String hospital_name,
            @Field("village") String village,
            @Field("state") String state,
            @Field("district") String district
    );

    @FormUrlEncoded
    @POST("/account/hospitalstaff/create")
    Call<ResponseBody> createtika(
            @Field("aadhar") String aadhar,
            @Field("staff_type") String staff_type,
            @Field("password") String password,
            @Field("email") String email,
            @Field("first_name") String first_name,
            @Field("tahseel") String tahseel,
            @Field("hospital_id") Integer hospital_id,
            @Field("latitude") String latitude,
            @Field("longitude") String longitude,
            @Field("mobile_number") String mobile_number,
            @Field("region") String region,
            @Field("hospital_name") String hospital_name,
            @Field("village") String village,
            @Field("state") String state,
            @Field("district") String district
    );

    @FormUrlEncoded
    @POST("/account/community/create")
    Call<ResponseBody> createCommunity(
            @Field("aadhar") String aadhar,
            @Field("service") String service,
            @Field("first_name") String first_name,
            @Field("password") String password,
            @Field("amb_number") String amb_number,
            @Field("longitude") String longitude,
            @Field("latitude") String latitude,
            @Field("district") String district,
            @Field("mobile_number") String mobile_number,
            @Field("address") String address,
            @Field("state") String state,
            @Field("org_name") String org_name
    );

    @FormUrlEncoded
    @POST("/hos/AmbulanceCreate")
    Call<ResponseBody> ambulanceFacility(
            @Field("type") String type,
            @Field("hospital_linked") Boolean hospital_linked,
            @Field("service") String service,
            @Field("vehicle") String vehical,
            @Field("model") String model
    );

    @FormUrlEncoded
    @POST("/hos/DoctorDetailCreate")
    Call<ResponseBody> doctorDetails(
            @Field("name") String name,
            @Field("org") String org,
            @Field("doctor") String doctor,
            @Field("aadhar") String aadhar,
            @Field("type") String type,
            @Field("spec") String spec,
            @Field("address") String address,
            @Field("state") String state,
            @Field("distric") String distric,
            @Field("pincode") int pincode
    );

    @FormUrlEncoded
    @POST("/hos/HospitalDetailCreate")
    Call<ResponseBody> hospitalDetails(
            @Field("cat") String cat,
            @Field("org") String org,
            @Field("madicalFacility") boolean madicalFacility,
            @Field("bloodFacility") boolean bloodFacility
    );

    @FormUrlEncoded
    @POST("/hos/DepttCreate")
    Call<ResponseBody> tikaDetail(
            @Field("field1") Boolean field1,
            @Field("field2") Boolean field2,
            @Field("field3") Boolean field3,
            @Field("field4") Boolean field4,
            @Field("field5") Boolean field5,
            @Field("type") String type
    );



    //for All Get Request
    @GET("/account/{key}/hospital")
    Call<wardVerify> verifyOperator(
            @Path("key") String key
    );

    @GET("/account/rest-auth/login/")
    Call<ResponseBody> getBlood(@Header("Authorization")String authToken);

    @GET("/hos/HospitalDetailList")
    Call<List<hospital_show_pojo>> getHospitalJson();

    @GET("/hos/DoctorDetailList")
    Call<List<DoctorPostPojo>> getdoctorDetail();


    //for All Login Post Request
    @FormUrlEncoded
    @POST("/account/rest-auth/login/")
    Call<blood_log> bloodLogin(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("/account/rest-auth/login/")
    Call<hospital_log> hospitalLogin(
            @Field("username") String username,
            @Field("password") String password
    );
    @FormUrlEncoded
    @POST("/account/rest-auth/login/")
    Call<lab_log> labLogin(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("/account/rest-auth/login/")
    Call<tika_log> tikaLogin(
            @Field("username") String username,
            @Field("password") String password
    );
    @FormUrlEncoded
    @POST("/account/rest-auth/login/")
    Call<ambulance_log> driverLogin(
            @Field("username") String username,
            @Field("password") String password
    );
    @FormUrlEncoded
    @POST("/account/rest-auth/login/")
    Call<community_log> organisationLogin(
            @Field("username") String username,
            @Field("password") String password
    );

}
