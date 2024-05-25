package com.hamzabekkaoui.freelancerestapi.security.service;


import com.hamzabekkaoui.freelancerestapi.entities.User;
import com.hamzabekkaoui.freelancerestapi.repositories.UserRepository;
import com.hamzabekkaoui.freelancerestapi.security.model.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userByEmail = userRepository.findByEmail(username);

        return userByEmail.map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));

    }
}
