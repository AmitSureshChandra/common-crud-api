package com.github.amitsureshchandra.commonfeature.advice;

import com.github.amitsureshchandra.commonfeature.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationAdvice {
    @ExceptionHandler(ValidationException.class)
    ResponseEntity<String> validate(ValidationException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
