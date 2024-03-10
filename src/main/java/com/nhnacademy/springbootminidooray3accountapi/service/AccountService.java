package com.nhnacademy.springbootminidooray3accountapi.service;

import com.nhnacademy.springbootminidooray3accountapi.dto.LoginRequestDto;
import com.nhnacademy.springbootminidooray3accountapi.dto.LoginResponseDto;
import com.nhnacademy.springbootminidooray3accountapi.dto.UpdateAccountStateRequestDto;
import com.nhnacademy.springbootminidooray3accountapi.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    LoginResponseDto login(LoginRequestDto requestDto);

    Account createAccount(Account account);

    Optional<Account> getAccount(String id);

    List<Account> getAccounts();

    LoginResponseDto updateAccountState(String id, UpdateAccountStateRequestDto requestDto);

    void deleteAccount(String id);
}
