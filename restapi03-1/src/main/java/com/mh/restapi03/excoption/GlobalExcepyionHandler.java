package com.mh.restapi03.excoption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class GlobalExcepyionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LogicException.class)
    public final ResponseEntity<ErrorResponse> hanleLogException(LogicException ex){
        System.out.println(ex.toString());
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(ex.getErrorCode().getErrorCode())
                .errorMessage(ex.getErrorCode().getMessage())
                .build();
        return  ResponseEntity.status(ex.getErrorCode().getHttpStatus()).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleException(UsersException e)
    {

     ErrorResponse errorResponse =
             ErrorResponse.builder()
                     .errorMessage(e.getErrorCode().getMessage())
                     .errorCode(e.getErrorCode().getErrorCode())
                     .errorDateTime(LocalDateTime.now())
                     .build();

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }





}
