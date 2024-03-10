package com.nhnacademy.springbootminidooray3accountapi.service;

import com.nhnacademy.springbootminidooray3accountapi.dto.*;
import com.nhnacademy.springbootminidooray3accountapi.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    Responses login(LoginRequestDto loginRequestDto);

    List<Responses> getAccounts(String xUserId);

    Responses getAccount(String xUserId, String id);

    Account createAccount(SignupRequest request);

    void deleteAccount(String id);

    Responses updateAccountState(String id, UpdateAccountStateRequestDto requestDto);

}
