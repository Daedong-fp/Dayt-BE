package com.example.dayt.domain.user.domain.dto.response;

import com.example.dayt.domain.user.domain.enums.Role;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UserResponse {

    private String username;

    @Column(length = 255)
    private String password;

    @Column(length = 4)
    private String name;

    private String introduce;

    private Role role;


}
