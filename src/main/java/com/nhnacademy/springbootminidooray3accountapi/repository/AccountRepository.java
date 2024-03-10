package com.nhnacademy.springbootminidooray3accountapi.repository;

import com.nhnacademy.springbootminidooray3accountapi.dto.ResponseDto;
import com.nhnacademy.springbootminidooray3accountapi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {
    @Override
    Optional<Account> findById(String s);

    Optional<ResponseDto> findByIdAndPassword(String id, String password);

}
