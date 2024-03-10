package com.nhnacademy.springbootminidooray3accountapi.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UpdateAccountStateRequestDto {

    private String state;
}
