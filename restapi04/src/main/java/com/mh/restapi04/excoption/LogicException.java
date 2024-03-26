package com.mh.restapi04.excoption;


import lombok.Getter;

@Getter
public class LogicException extends RuntimeException{

    private ErrorCode errorCode;

    public LogicException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}
