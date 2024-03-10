package com.nhnacademy.springbootminidooray3accountapi.service;

import com.nhnacademy.springbootminidooray3accountapi.dto.SignupRequest;
import com.nhnacademy.springbootminidooray3accountapi.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Account> getAccounts();

    Optional<Account> getAccount(String id);

    Account createAccount(SignupRequest request);

    void deleteAccount(String id);

    Account modifyAccount(Account account);
}
