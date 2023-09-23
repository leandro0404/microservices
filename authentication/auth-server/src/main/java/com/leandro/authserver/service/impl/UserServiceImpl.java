package com.leandro.authserver.service.impl;

import com.leandro.authserver.entity.Authority;
import com.leandro.authserver.entity.User;
import com.leandro.authserver.model.CustomUserDetails;
import com.leandro.authserver.repository.UserRepository;
import com.leandro.authserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return new CustomUserDetails(user);

    }

    @Override
    public void registration(String username, String email, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Set<Authority> authorities = new HashSet<>();
        authorities.add( Authority.builder().authority("ROLE_USER").build());

        userRepository.create(User
                .builder()
                .id(UUID.randomUUID().toString())
                .username(username)
                .email(email)
                .password(passwordEncoder.encode(password))
                        .authorities( authorities)
                .build());
    }
}