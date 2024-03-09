package com.nhnacademy.springbootminidooray3accountapi.service;

import com.nhnacademy.springbootminidooray3accountapi.entity.Account;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface AccountService {

    String login(String id, String password);

    Account createAccount(Account account);

    Optional<Account> getAccount(String id);

    List<Account> getAccounts();

    String updateAccountState(String id, String state);

    void deleteAccount(String id);

}
