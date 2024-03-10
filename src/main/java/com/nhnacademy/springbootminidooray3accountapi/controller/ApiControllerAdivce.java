package com.nhnacademy.springbootminidooray3accountapi.controller;

import com.nhnacademy.springbootminidooray3accountapi.exception.AccountAlreadyExistsException;
import com.nhnacademy.springbootminidooray3accountapi.exception.LoginFailedException;
import com.nhnacademy.springbootminidooray3accountapi.exception.UpdateAccountStateFailedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class ApiControllerAdivce {
    @ExceptionHandler(AccountAlreadyExistsException.class)
    @ResponseBody
    public ResponseEntity<String> handleAccountAlreadyExists(AccountAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler(LoginFailedException.class)
    public ResponseEntity<Void> loginFailedHandler(LoginFailedException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @ExceptionHandler(UpdateAccountStateFailedException.class)
    public ResponseEntity<Void> updateAccountFailedHandler(UpdateAccountStateFailedException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
