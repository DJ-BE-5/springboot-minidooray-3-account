package com.nhnacademy.springbootminidooray3accountapi.dto;

import com.nhnacademy.springbootminidooray3accountapi.entity.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Responses {

    private String id;
    private String email;
    private String State;

    public Responses(String id, String email, String State){
        this.id = id;
        this.email = email;
        this.State = State;
    }

    public static Responses from(Account acocunt) {
        return new Responses(acocunt.getId(), acocunt.getEmail(), acocunt.getState());
    }
}
