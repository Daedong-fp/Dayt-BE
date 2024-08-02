package com.example.dayt.domain.user.domain.application;

import com.example.dayt.domain.user.domain.User;
import com.example.dayt.domain.user.domain.dao.UserRepository;
import com.example.dayt.domain.user.domain.dto.request.UserRequest;
import com.example.dayt.domain.user.domain.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserResponse getUser(String username){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return new UserResponse(user.getUsername(), user.getPassword(), user.getName(), user.getIntroduce(), user.getRole());
    }

    @Transactional
    public UserResponse updateUser(String username, UserRequest userRequest){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setName(userRequest.getName());
        user.setIntroduce(userRequest.getIntroduce());

        userRepository.save(user);

        return new UserResponse(user.getUsername(), user.getPassword(), user.getName(), user.getIntroduce(), user.getRole());
    }

    @Transactional
    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        userRepository.delete(user);
    }

}
