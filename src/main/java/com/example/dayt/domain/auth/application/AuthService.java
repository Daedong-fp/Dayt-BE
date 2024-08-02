package com.example.dayt.domain.auth.application;

import com.example.dayt.domain.user.domain.dao.UserRepository;
import com.example.dayt.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.security.Password;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthDetailsService authDetailsService;

    private final String
}
