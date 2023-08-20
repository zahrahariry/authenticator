package com.example.authenticator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = ObjectNotFoundException.class)
    public ResponseEntity<Object> throwObjectNotFoundException (ObjectNotFoundException objectNotFoundException){
        return new ResponseEntity<>("ObjectNotFoundException", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ObjectCurrentlyIsExistsException.class)
    public ResponseEntity<Object> throwObjectCurrentlyIsExistsException (ObjectCurrentlyIsExistsException objectCurrentlyIsExistsException){
        return new ResponseEntity<>("ObjectCurrentlyIsExistsException", HttpStatus.BAD_REQUEST);
    }
}
