package com.example.dayt.domain.user.domain.dto;

import com.example.dayt.domain.user.domain.enums.Role;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UserDto {

    private String username;

    @Column(length = 255)
    private String password;

    @Column(length = 4)
    private String name;



}
