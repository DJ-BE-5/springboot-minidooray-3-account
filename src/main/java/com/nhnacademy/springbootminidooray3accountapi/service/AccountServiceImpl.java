package com.nhnacademy.springbootminidooray3accountapi.service;

import com.nhnacademy.springbootminidooray3accountapi.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public String login(String id, String password) {
        return null;
    }

    @Override
    public Account createAccount(Account account) {
        return null;
    }

    @Override
    public Optional<Account> getAccount(String id) {
        return Optional.empty();
    }

    @Override
    public List<Account> getAccounts() {
        return null;
    }

    @Override
    public String updateAccountState(String id, String state) {
        return null;
    }

    @Override
    public void deleteAccount(String id) {

    }
}
