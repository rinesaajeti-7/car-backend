package com.carproject.service.impl;

import com.carproject.dto.LoginRequest;
import com.carproject.dto.RegisterRequest;
import com.carproject.model.User;
import com.carproject.repository.UserRepository;
import com.carproject.security.JwtTokenProvider;
import com.carproject.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        return tokenProvider.generateToken(authentication);
    }

    @Override
    public String register(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        User user = new User();
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole("USER"); // Regjistrimi normal bën USER, ADMIN mund të shtohet manualisht në DB
        userRepository.save(user);

        // Pas regjistrimit, kryej login automatik dhe kthe token
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(registerRequest.getEmail(), registerRequest.getPassword()));
        return tokenProvider.generateToken(authentication);
    }
}