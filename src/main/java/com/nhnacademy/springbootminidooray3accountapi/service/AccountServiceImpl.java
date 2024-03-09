package com.nhnacademy.springbootminidooray3accountapi.service;

import com.nhnacademy.springbootminidooray3accountapi.dto.SignupRequest;
import com.nhnacademy.springbootminidooray3accountapi.entity.Account;
import com.nhnacademy.springbootminidooray3accountapi.exception.AccountAlreadyExistsException;
import com.nhnacademy.springbootminidooray3accountapi.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.channels.AcceptPendingException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service("accountservice")
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> getAccount(String id) {
        return accountRepository.findById(id);
    }


    @Override
    public Account createAccount(SignupRequest request) {
        if (accountRepository.findById(request.getId()).isPresent()) {
            throw new AccountAlreadyExistsException(request.getId()+"는 이미 존재하는 Id입니다");
        }
        return accountRepository.save(request.toEntity());
    }


    public void deleteAccount(String id) {
    }


    public Account modifyAccount(Account account){
        return null;
    }

}