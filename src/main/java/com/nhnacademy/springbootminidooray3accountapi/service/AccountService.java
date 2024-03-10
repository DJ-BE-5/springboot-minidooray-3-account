package com.nhnacademy.springbootminidooray3accountapi.service;

import com.nhnacademy.springbootminidooray3accountapi.dto.*;
import com.nhnacademy.springbootminidooray3accountapi.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    ResponseDto login(LoginRequestDto loginRequestDto);

    List<ResponseDto> getAccounts(String xUserId);

    ResponseDto getAccount(String xUserId, String id);

    Account createAccount(SignupRequestDto request);

    void deleteAccount(String xUserId, String id);

    ResponseDto updateAccountState(String xUserId, String id, UpdateAccountStateRequestDto requestDto);

}
