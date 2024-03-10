package com.nhnacademy.springbootminidooray3accountapi.controller;

import com.nhnacademy.springbootminidooray3accountapi.dto.LoginRequestDto;
import com.nhnacademy.springbootminidooray3accountapi.dto.LoginResponseDto;
import com.nhnacademy.springbootminidooray3accountapi.dto.UpdateAccountStateRequestDto;
import com.nhnacademy.springbootminidooray3accountapi.entity.Account;
import com.nhnacademy.springbootminidooray3accountapi.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // 로그인 api
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto requestDto) {
        LoginResponseDto loginResponseDto = accountService.login(requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(loginResponseDto);
    }

    // 회원가입 api
    @PostMapping("/signup")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    // 회원 정보 조회 api
    @GetMapping("/accounts/{id}")
    public Optional<Account> getAccount(@PathVariable String id) {
        return accountService.getAccount(id);
    }

    // 회원 리스트 조회 api
    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    // 회원 상태 수정 api
    @PutMapping("/accounts/{id}/state")
    public ResponseEntity<LoginResponseDto> updateAccountState(@PathVariable("id") String id,
                                                               @RequestBody UpdateAccountStateRequestDto requestDto) {
        LoginResponseDto loginResponseDto = accountService.updateAccountState(id, requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(loginResponseDto);
    }

    // 회원 정보 삭제 api
    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
    }



}