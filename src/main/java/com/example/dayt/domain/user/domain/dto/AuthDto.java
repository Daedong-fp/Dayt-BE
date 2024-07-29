package com.example.dayt.domain.user.domain.dto;

import com.example.dayt.domain.user.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthDto {

    private Role role;

}
