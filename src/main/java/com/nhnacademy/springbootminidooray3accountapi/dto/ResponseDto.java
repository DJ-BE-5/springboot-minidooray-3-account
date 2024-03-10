package com.nhnacademy.springbootminidooray3accountapi.dto;

import com.nhnacademy.springbootminidooray3accountapi.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

    private String id;
    private String email;
    private String State;

    public static ResponseDto from(Account acocunt) {
        return new ResponseDto(acocunt.getId(), acocunt.getEmail(), acocunt.getState());
    }
}
