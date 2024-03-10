package com.nhnacademy.springbootminidooray3accountapi.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Account {
    @Id
    @Column(length = 50)
    private String id;

    @Column(length = 50)
    private String password;

    @Column(length = 100)
    private String email;

    @Column(length = 10)
    private String state;

    //builder pattern
    @Builder
    public Account(String id, String password, String email, String state){
        this.id = id;
        this.password = password;
        this.email = email;
        this.state = state;
    }

}
