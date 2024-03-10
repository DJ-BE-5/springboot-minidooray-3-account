package com.nhnacademy.springbootminidooray3accountapi.dto;

import com.nhnacademy.springbootminidooray3accountapi.entity.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseDto {

    private String id;
    private String email;
    private String State;

    public ResponseDto(String id, String email, String State){
        this.id = id;
        this.email = email;
        this.State = State;
    }

    public static ResponseDto from(Account acocunt) {
        return new ResponseDto(acocunt.getId(), acocunt.getEmail(), acocunt.getState());
    }
}
