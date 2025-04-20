package com.example.ProductsShopping.controller;

import com.example.ProductsShopping.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile(Principal principal) {
        if (principal == null) {

            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Пользователь не авторизован");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
        return ResponseEntity.ok(userService.getUserProfile(principal.getName()));
    }
}