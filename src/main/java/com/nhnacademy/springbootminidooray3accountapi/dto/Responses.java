package com.nhnacademy.springbootminidooray3accountapi.dto;

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
}
