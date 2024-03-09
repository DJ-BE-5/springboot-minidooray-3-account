package com.nhnacademy.springbootminidooray3accountapi.controller;

import com.nhnacademy.springbootminidooray3accountapi.entity.Account;
import com.nhnacademy.springbootminidooray3accountapi.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/login") // 로그인 api
    public String login(@RequestParam String id, @RequestParam String password) {
        return accountService.login(id, password);
    }

    @PostMapping("/signup") // 회원가입 api
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/accounts/{id}") // 회원 정보 조회 api
    public Optional<Account> getAccount(@PathVariable String id) {
        return accountService.getAccount(id);
    }

    @GetMapping("/accounts") // 회원 리스트 조회 api
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @PutMapping("/accounts/{id}/state") // 회원 상태 수정 api
    public String updateAccountState(@PathVariable String id, @RequestParam String state) {
        return accountService.updateAccountState(id, state);
    }


    @DeleteMapping("/accounts/{id}") // 회원 정보 삭제 api
    public void deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
    }

}