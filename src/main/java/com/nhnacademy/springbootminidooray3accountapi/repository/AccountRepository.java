package com.nhnacademy.springbootminidooray3accountapi.repository;

import com.nhnacademy.springbootminidooray3accountapi.dto.LoginResponseDto;
import com.nhnacademy.springbootminidooray3accountapi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<LoginResponseDto> findByIdAndPassword(String id, String password);

    Optional<LoginResponseDto> findAccountById(String id);
}