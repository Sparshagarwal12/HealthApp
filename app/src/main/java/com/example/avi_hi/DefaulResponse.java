package com.example.avi_hi;

public class DefaulResponse {

    private boolean error;
    private String message;
    public DefaulResponse(boolean error, String message){
        this.error = error;
        this.message = message;
    }
    public boolean isError(){
        return error;
    }

    public String getMessage(){
        return message;
    }
}
