package com.example.ProductsShopping.controller;


import com.example.ProductsShopping.dto.LoginRequest;
import com.example.ProductsShopping.dto.RegisterRequest;
import com.example.ProductsShopping.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        try {
            String responseMessage = authService.registerUser(registerRequest);
            return ResponseEntity.ok(responseMessage);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            String token = authService.loginUser(loginRequest);
            return ResponseEntity.ok(token);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(400).body(ex.getMessage());
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        try {
            authService.logoutUser();
            return ResponseEntity.ok("Logout successful!");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(400).body(ex.getMessage());
        }
    }
}
