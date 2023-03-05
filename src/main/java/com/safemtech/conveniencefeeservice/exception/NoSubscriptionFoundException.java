package com.safemtech.conveniencefeeservice.exception;

import com.safemtech.conveniencefeeservice.dto.ErrorCode;

public class NoSubscriptionFoundException extends RuntimeException{

    public NoSubscriptionFoundException(String message, ErrorCode errorCode){
        super(message);
    }
}
