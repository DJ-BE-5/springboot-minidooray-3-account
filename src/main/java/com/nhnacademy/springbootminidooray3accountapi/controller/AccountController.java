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
    public ResponseEntity<ResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        ResponseDto responseDto  = accountService.login(loginRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createAccount(@Valid @RequestBody SignupRequestDto requestDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }

        try {
            Account savedAccount = accountService.createAccount(requestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(savedAccount.getId(), savedAccount.getEmail(), savedAccount.getState()));
        } catch (AccountAlreadyExistsException exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
        }
    }

    @GetMapping("/accounts")
    public List<ResponseDto> getAccounts(@RequestHeader(name = "X-USER-ID") String xUserId) {
        return accountService.getAccounts(xUserId);
    }

    @GetMapping("/accounts/{id}")
    public ResponseDto getAccount(@PathVariable("id") String id, @RequestHeader(name = "X-USER-ID") String xUserId) {
        ResponseDto responseDto = accountService.getAccount(xUserId, id);
        if (Objects.isNull(responseDto)) {
            throw new MemeberNotFoundException();
        }
        return responseDto;
    }

     //회원 상태 수정 api
     @PutMapping("/accounts/{id}/state")
     public ResponseEntity<ResponseDto> updateAccountState(@PathVariable("id") String id,
                                                         @RequestBody UpdateAccountStateRequestDto requestDto,
                                                         @RequestHeader(name = "X-USER-ID") String xUserId) {
         ResponseDto responseDto = accountService.getAccount(xUserId, id);
         if (Objects.isNull(responseDto)) {
             throw new MemeberNotFoundException();
         }
         accountService.updateAccountState(xUserId, responseDto.getId(), requestDto);
         return ResponseEntity.status(HttpStatus.OK).body(responseDto);
     }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String id, @RequestHeader(name = "X-USER-ID") String xUserId) {
        accountService.deleteAccount(xUserId, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
