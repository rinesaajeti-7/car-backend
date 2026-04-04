package com.carproject.controller;

import com.carproject.dto.LoginRequest;
import com.carproject.dto.RegisterRequest;
import com.carproject.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String token = authService.login(loginRequest);
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        String token = authService.register(registerRequest);
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }
}