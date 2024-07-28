package com.example.dayt.domain.user.domain.application;

import com.example.dayt.domain.user.domain.dao.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


}
