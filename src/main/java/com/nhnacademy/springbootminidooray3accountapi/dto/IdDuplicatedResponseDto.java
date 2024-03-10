package com.nhnacademy.springbootminidooray3accountapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class IdDuplicatedResponseDto {
    private boolean idDuplicated;

    public IdDuplicatedResponseDto(boolean idDuplicated) {
        this.idDuplicated = idDuplicated;
    }

    public boolean isIdDuplicated() {
        return idDuplicated;
    }

    public void setIdDuplicated(boolean idDuplicated) {
        this.idDuplicated = idDuplicated;
    }
}
