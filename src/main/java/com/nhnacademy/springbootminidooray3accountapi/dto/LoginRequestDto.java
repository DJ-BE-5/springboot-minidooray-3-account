package com.nhnacademy.springbootminidooray3accountapi.dto;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {
    private String id;
    private String password;
}
