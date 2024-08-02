package com.example.dayt.domain.user.domain.api;

import com.example.dayt.domain.user.domain.application.UserService;
import com.example.dayt.domain.user.domain.dto.request.UserRequest;
import com.example.dayt.domain.user.domain.dto.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Operation(summary = "자신의 정보 조회", description = "자신의 정보를 조회합니다")
    @GetMapping("/inquiry")
    public ResponseEntity<UserResponse> getUserDetail(Authentication authentication){
        String username = authentication.getName();
        UserResponse userResponse = userService.getUser(username);
        return ResponseEntity.ok(userResponse);
    }
    @Operation(summary = "자신의 회원 정보 수정", description = "자신의 회원 정보를 수정합니다")
    @PatchMapping("/update")
    public ResponseEntity<UserResponse> updateUserDetails(Authentication authentication, @RequestBody UserRequest userRequest) {
        UserResponse updatedUserResponse = userService.updateUser(authentication.getName(), userRequest);
        return ResponseEntity.ok(updatedUserResponse);
    }

    @Operation(summary = "자신의 회원 정보 삭제", description = "자신의 회원 정보를 삭제합니다")
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(Authentication authentication) {
        userService.deleteUser(authentication.getName());
        return ResponseEntity.ok("회원 정보가 성공적으로 삭제되었습니다.");
    }


}
