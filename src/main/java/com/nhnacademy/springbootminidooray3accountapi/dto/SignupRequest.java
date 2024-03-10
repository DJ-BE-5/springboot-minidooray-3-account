package com.nhnacademy.springbootminidooray3accountapi.dto;


import com.nhnacademy.springbootminidooray3accountapi.entity.Account;
import com.nhnacademy.springbootminidooray3accountapi.entity.State;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class SignupRequest {

    @Length(max = 50)
    @NotBlank
    private String id;
    @Length(max = 50)
    @NotBlank
    private String password;
    @Length(max = 100)
    @NotBlank
    private String email;


    public Account toEntity(){
        return Account.builder()
                .id(id)
                .password(password)
                .email(email)
                .state(State.active.name())
                .build();
    }

}
