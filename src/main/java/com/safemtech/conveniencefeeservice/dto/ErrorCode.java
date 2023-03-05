package com.safemtech.conveniencefeeservice.dto;

public enum ErrorCode {
    DNF("760"), ENF("860"), CNF("960"),NSF("512");

    private final String code;

    private ErrorCode(String code){
        this.code = code;
    }

    public String getCode(String errorCode) {
        for(ErrorCode e : ErrorCode.values()){
            if(e.code.equals(errorCode)){
                return e.code;
            }
        }

        throw new IllegalArgumentException("invalid error code");
    }
}
