package com.example.authenticator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = ObjectNotFoundException.class)
    public ResponseEntity<Object> throwObjectNotFoundException (ObjectNotFoundException objectNotFoundException){
        return new ResponseEntity<>("An error has occurred  !!!", HttpStatus.I_AM_A_TEAPOT);
    }
}
