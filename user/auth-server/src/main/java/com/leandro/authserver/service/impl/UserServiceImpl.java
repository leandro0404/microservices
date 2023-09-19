package com.leandro.authserver.service.impl;

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

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found"));

    }

    @Override
    public void registration(String username, String email, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userRepository.save(User
                .builder()
                .username(username)
                .email(email)
                .password(passwordEncoder.encode(password))
                .build());


    }
}