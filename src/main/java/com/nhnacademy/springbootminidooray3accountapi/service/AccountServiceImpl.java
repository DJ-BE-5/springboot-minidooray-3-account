package com.nhnacademy.springbootminidooray3accountapi.service;

import com.nhnacademy.springbootminidooray3accountapi.dto.LoginRequestDto;
import com.nhnacademy.springbootminidooray3accountapi.dto.LoginResponseDto;
import com.nhnacademy.springbootminidooray3accountapi.entity.Account;
import com.nhnacademy.springbootminidooray3accountapi.exception.LoginFailedException;
import com.nhnacademy.springbootminidooray3accountapi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // 로그인
    @Override
    public LoginResponseDto login(LoginRequestDto requestDto) {
        Optional<LoginResponseDto> optionalAccount =
                accountRepository.findByIdAndPassword(requestDto.getId(), requestDto.getPassword());
        if (optionalAccount.isPresent()) {
            return optionalAccount.get();
        } else {
            throw new LoginFailedException();
        }
    }

    // 회원가입
    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    // 회원 정보 조회
    @Override
    public Optional<Account> getAccount(String id) {
        return accountRepository.findById(id);
    }

    // 회원 리스트 조회
    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    // 회원 상태 수정
    @Override
    public String updateAccountState(String id, String state) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setState(state);
            accountRepository.save(account);
            return "회원 상태 업데이트";
        } else {
            return "존재하지 않는 계정";
        }
    }

    // 회원 정보 삭제
    @Override
    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }
}
