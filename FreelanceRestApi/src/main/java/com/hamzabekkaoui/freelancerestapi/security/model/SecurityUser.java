package com.hamzabekkaoui.freelancerestapi.security.model;


import com.hamzabekkaoui.freelancerestapi.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class SecurityUser implements UserDetails {

    private final User user;


    public SecurityUser(User user) {
        this.user = user;
    }


    @Override
    public String getUsername() {
        return user.getEmail();
    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.name()))
                .collect(Collectors.toSet());
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
