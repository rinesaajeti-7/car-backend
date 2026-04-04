package com.carproject.service;

import com.carproject.dto.LoginRequest;
import com.carproject.dto.RegisterRequest;

public interface AuthService {
    String login(LoginRequest loginRequest);
    String register(RegisterRequest registerRequest);
}