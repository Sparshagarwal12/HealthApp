package com.example.avi_hi.KeyVerification;

import com.google.gson.annotations.SerializedName;

public class wardVerify {


    @SerializedName("id")
    private Integer StaffId;
    @SerializedName("name")
    private String first_name;

    public wardVerify(Integer staffId, String first_name) {
        StaffId = staffId;
        this.first_name = first_name;
    }

    public Integer getStaffId() {
        return StaffId;
    }

    public void setStaffId(Integer staffId) {
        StaffId = staffId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
