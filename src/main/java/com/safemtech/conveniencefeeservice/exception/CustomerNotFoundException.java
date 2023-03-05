package com.safemtech.conveniencefeeservice.exception;

import com.safemtech.conveniencefeeservice.dto.ErrorCode;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String message, ErrorCode errorCode){
        super(message);
    }
}
