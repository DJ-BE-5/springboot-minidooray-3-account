package com.nhnacademy.springbootminidooray3accountapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class IdDuplicatedResponse {
    private boolean idDuplicated;

    public IdDuplicatedResponse(boolean idDuplicated) {
        this.idDuplicated = idDuplicated;
    }

    public boolean isIdDuplicated() {
        return idDuplicated;
    }

    public void setIdDuplicated(boolean idDuplicated) {
        this.idDuplicated = idDuplicated;
    }
}
