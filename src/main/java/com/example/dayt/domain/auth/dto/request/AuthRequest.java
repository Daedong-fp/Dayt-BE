package com.example.dayt.domain.auth.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthRequest {

    private String username;

    private String password;

    private String name;

    private String introduce;
}
