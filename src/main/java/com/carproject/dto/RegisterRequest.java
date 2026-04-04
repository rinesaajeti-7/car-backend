package com.carproject.dto;

import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
}