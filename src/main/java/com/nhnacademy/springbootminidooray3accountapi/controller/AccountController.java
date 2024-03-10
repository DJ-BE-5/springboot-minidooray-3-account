package com.nhnacademy.springbootminidooray3accountapi.controller;

import com.nhnacademy.springbootminidooray3accountapi.dto.IdDuplicatedResponse;
import com.nhnacademy.springbootminidooray3accountapi.dto.Responses;
import com.nhnacademy.springbootminidooray3accountapi.dto.SignupRequest;
import com.nhnacademy.springbootminidooray3accountapi.entity.Account;
import com.nhnacademy.springbootminidooray3accountapi.exception.AccountAlreadyExistsException;
import com.nhnacademy.springbootminidooray3accountapi.exception.ValidationFailedException;
import com.nhnacademy.springbootminidooray3accountapi.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createAccount(@Valid @RequestBody SignupRequest request, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }

        try {
            Account savedAccount = accountService.createAccount(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(new Responses(savedAccount.getId(), savedAccount.getEmail(), savedAccount.getState()));
        } catch (AccountAlreadyExistsException exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
        }
    }

    @GetMapping("/signup/{id}/exist")
    public ResponseEntity<IdDuplicatedResponse> idCheck(@PathVariable String id){
        boolean idDuplicated = accountService.getAccount(id).isPresent();
        if (idDuplicated) {
            IdDuplicatedResponse duplicatedResponse = new IdDuplicatedResponse(true);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(duplicatedResponse);
        }else {
            IdDuplicatedResponse duplicatedResponse = new IdDuplicatedResponse(false);
            return ResponseEntity.ok(duplicatedResponse);
        }
    }

    @GetMapping("/accounts/{id}")
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(String id) {
        accountService.deleteAccount(id);
    }

}
