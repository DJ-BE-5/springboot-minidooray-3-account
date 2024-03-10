package com.nhnacademy.springbootminidooray3accountapi.controller;

import com.nhnacademy.springbootminidooray3accountapi.dto.*;
import com.nhnacademy.springbootminidooray3accountapi.entity.Account;
import com.nhnacademy.springbootminidooray3accountapi.exception.AccountAlreadyExistsException;
import com.nhnacademy.springbootminidooray3accountapi.exception.MemeberNotFoundException;
import com.nhnacademy.springbootminidooray3accountapi.exception.ValidationFailedException;
import com.nhnacademy.springbootminidooray3accountapi.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/login")
    public ResponseEntity<Responses> login(@RequestBody LoginRequestDto loginRequestDto) {
        Responses responses1  = accountService.login(loginRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(responses1);
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

//    @GetMapping("/signup/{id}/exist")
//    public ResponseEntity<IdDuplicatedResponse> idCheck(@PathVariable String id, @RequestHeader(name = "X-USER-ID") String xUserId){
//        boolean idDuplicated = accountService.getAccount(xUserId,id).equals();
//        if (idDuplicated) {
//            IdDuplicatedResponse duplicatedResponse = new IdDuplicatedResponse(true);
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(duplicatedResponse);
//        }else {
//            IdDuplicatedResponse duplicatedResponse = new IdDuplicatedResponse(false);
//            return ResponseEntity.ok(duplicatedResponse);
//        }
//    }

    @GetMapping("/accounts")
    public List<Responses> getAccounts(@RequestHeader(name = "X-USER-ID") String xUserId) {
        return accountService.getAccounts(xUserId);
    }

    @GetMapping("/accounts/{id}")
    public Responses getAccount(@PathVariable("id") String id, @RequestHeader(name = "X-USER-ID") String xUserId) {
        Responses responses = accountService.getAccount(xUserId, id);
        if (Objects.isNull(responses)) {
            throw new MemeberNotFoundException();
        }
        return responses;
    }

     //회원 상태 수정 api
     @PutMapping("/accounts/{id}/state")
     public ResponseEntity<Responses> updateAccountState(@PathVariable("id") String id,
                                                         @RequestBody UpdateAccountStateRequestDto requestDto,
                                                         @RequestHeader(name = "X-USER-ID") String xUserId) {
         Responses responses = accountService.getAccount(xUserId, id);

         Responses responses1 = accountService.updateAccountState(id, requestDto);
         return ResponseEntity.status(HttpStatus.OK).body(responses);
     }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String id, @RequestHeader(name = "X-USER-ID") String xUserId) {
        accountService.deleteAccount(xUserId, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
