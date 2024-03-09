package com.nhnacademy.springbootminidooray3accountapi.advice;

import com.nhnacademy.springbootminidooray3accountapi.exception.LoginFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AccountControllerAdvice {
    @ExceptionHandler(LoginFailedException.class)
    public ResponseEntity<Void> loginFailedHandler(LoginFailedException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
