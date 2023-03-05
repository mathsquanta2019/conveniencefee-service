package com.safemtech.conveniencefeeservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity
@RequiredArgsConstructor
@Getter
@ToString
public class Customer {

    @Id
    @GenericGenerator(name = "id-gen", strategy = "com.safemtech.conveniencefeeservice.util.CustomIdGenerator")
    @GeneratedValue(generator = "id-gen")
    private Long id;

    private String username;

    @Setter
    private String password;

    private String roles;
}
