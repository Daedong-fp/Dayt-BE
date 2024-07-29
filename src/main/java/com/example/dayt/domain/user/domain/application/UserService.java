package com.example.dayt.domain.user.domain.application;

import com.example.dayt.domain.user.domain.User;
import com.example.dayt.domain.user.domain.dao.UserRepository;
import com.example.dayt.domain.user.domain.dto.UpdateUserDto;
import com.example.dayt.domain.user.domain.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserDto getUserDetail(String username){
        User user =userRepository.findByUsername(username)
                .orElseThrow(()->new IllegalArgumentException("User not found"));
        return new UserDto(user.getUsername(),user.getPassword(),user.getName());
    }

    @Transactional
    public UserDto updateUserDetails(String username, UpdateUserDto updateUserDto){
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new IllegalArgumentException("User not found"));

        user.setName(updateUserDto.getName());
        user.setUsername(updateUserDto.getUsername());
        userRepository.save(user);

        return new UserDto(user.getUsername(), user.getPassword(), user.getName());
    }

    @Transactional
    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new IllegalArgumentException("User not found"));
        userRepository.delete(user);
    }

}
