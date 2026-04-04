package com.carproject.dto;

import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
@Data
public class LoginRequest {
    private String email;
    private String password;
}