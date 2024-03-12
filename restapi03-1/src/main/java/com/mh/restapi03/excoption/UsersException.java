package com.mh.restapi03.excoption;

import lombok.Getter;

@Getter
public class UsersException extends RuntimeException{

    private ErrorCode errorCode;

    public UsersException(ErrorCode errorCode)
    {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
