package com.example.UberAuthService.services;

import com.example.UberAuthService.entities.User;
import com.example.UberAuthService.helpers.AuthUserDetails;
import com.example.UberAuthService.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(()-> {
            return new UsernameNotFoundException("User not found");
        });
        return new AuthUserDetails(user);
    }
}

