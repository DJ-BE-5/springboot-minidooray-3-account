package com.nhnacademy.springbootminidooray3accountapi.dto;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class LoginRequestDto {
    private String id;
    private String password;
}
