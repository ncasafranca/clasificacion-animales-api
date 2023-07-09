package com.tesis.clasificacionanimalesapi.exception;

public class UserDuplicated {
    private String code;
    private String reason;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public UserDuplicated(String code, String reason){
        this.code = code;
        this.reason = reason;
    }
}
