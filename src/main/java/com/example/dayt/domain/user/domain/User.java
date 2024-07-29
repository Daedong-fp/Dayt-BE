package com.example.dayt.domain.user.domain;

import com.example.dayt.domain.user.domain.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(length = 255)
    private String password;

    @Column(length = 4)
    private String name;


    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }



}
