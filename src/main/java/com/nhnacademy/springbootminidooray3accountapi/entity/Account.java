package com.nhnacademy.springbootminidooray3accountapi.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Account {

    @Id
    private String id;

    private String password;

    private String email;

    private String state;

}