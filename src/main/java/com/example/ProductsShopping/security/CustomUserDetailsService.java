package com.example.ProductsShopping.security;

import com.example.ProductsShopping.entity.User;
import com.example.ProductsShopping.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername (username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username:" + username)
                        );
        return org.springframework.security.core.userdetails. User
                .withUsername (user.getUsername())
                .password(user.getPassword())
                .authorities ("USER")
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
