package com.example.dayt.global.security.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AuthDetails implements UserDetails {

    private final UserDetails userDetails;

    public AuthDetails(UserDetails userDetails){
        this.userDetails = userDetails;
    }

    public Collection<? extends GrantedAuthority> getAuthorities(){ //? extends GrantedAuthority는 "어떤 타입이든지 GrantedAuthority를 상속받은 타입"을 의미
        return userDetails.getAuthorities(); // Spring Security UserDetails에서 권한을 가져오는 로직 추가
    }

    @Override
    public String getPassword() {
        return userDetails.getPassword();
    }

    @Override
    public String getUsername(){
        return userDetails.getUsername();
    }

    @Override
    public boolean isAccountNonExpired(){
        return userDetails.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked(){
        return userDetails.isAccountNonLocked();
    }
}
