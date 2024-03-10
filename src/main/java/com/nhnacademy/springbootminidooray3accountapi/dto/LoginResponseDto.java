package com.nhnacademy.springbootminidooray3accountapi.dto;

import com.nhnacademy.springbootminidooray3accountapi.entity.Account;
import lombok.Value;

public class LoginResponseDto {
    private String id;
    private String email;
    private String state;

    public LoginResponseDto(String id, String email, String state) {
        this.id = id;
        this.email = email;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getState() {
        return state;
    }

    public static LoginResponseDto from(Account acocunt) {
        return new LoginResponseDto(acocunt.getId(), acocunt.getEmail(), acocunt.getState());
    }
}
