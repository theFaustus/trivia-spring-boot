package com.tekwill.java.fundamentals.triviaspringboot.controller;

import com.tekwill.java.fundamentals.triviaspringboot.domain.exceptions.InvalidLevelException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(InvalidLevelException.class)
    public ResponseEntity<String> invalidLevel(InvalidLevelException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
