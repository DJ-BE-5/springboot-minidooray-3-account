package com.nhnacademy.springbootminidooray3accountapi.service;

import com.nhnacademy.springbootminidooray3accountapi.dto.*;
import com.nhnacademy.springbootminidooray3accountapi.entity.Account;
import com.nhnacademy.springbootminidooray3accountapi.exception.AccountAlreadyExistsException;
import com.nhnacademy.springbootminidooray3accountapi.exception.LoginFailedException;
import com.nhnacademy.springbootminidooray3accountapi.exception.UpdateAccountStateFailedException;
import com.nhnacademy.springbootminidooray3accountapi.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service("accountservice")
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    public List<ResponseDto> getAccounts(String xUserId) {
        if (!accountRepository.existsById(xUserId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access is forbidden.");
        }

        return accountRepository.findAll().stream()
                .map(ResponseDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseDto getAccount(String xUserId, String id) {
        if(!accountRepository.existsById(xUserId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return ResponseDto.from(accountRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

    }

    @Override
    public Account createAccount(SignupRequestDto request) {
        if (accountRepository.findById(request.getId()).isPresent()) {
            throw new AccountAlreadyExistsException(request.getId()+"는 이미 존재하는 Id입니다");
        }
        return accountRepository.save(request.toEntity());
    }

    @Override
    public void deleteAccount(String xUserId, String id) {
        if (!accountRepository.existsById(xUserId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else  {
            accountRepository.deleteById(id);
        }
    }

    @Override
    public ResponseDto login(LoginRequestDto requestDto) {
        Optional<ResponseDto> optionalLoginResponseDto =
                accountRepository.findByIdAndPassword(requestDto.getId(), requestDto.getPassword());
        if (optionalLoginResponseDto.isPresent()) {
            return optionalLoginResponseDto.get();
        } else {
            throw new LoginFailedException();
        }
    }

    @Override
    public ResponseDto updateAccountState(String xUserId, String id, UpdateAccountStateRequestDto requestDto) {
        if (!accountRepository.existsById(xUserId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Optional<Account> accountOptional = accountRepository.findById(id);
        if(accountOptional.isPresent()) {
            Account account = accountOptional.get();
            account.setState(requestDto.getState());
            return ResponseDto.from(account);
        } else {
            throw new UpdateAccountStateFailedException();
        }
    }

}