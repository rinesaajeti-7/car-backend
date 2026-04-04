package com.carproject.dto;

import lombok.Data;
import java.time.LocalDateTime;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Data
public class CarResponse {
    private Long id;
    private String make;
    private String model;
    private Integer year;
    private Double price;
    private Integer mileage;
    private String fuelType;
    private String imageUrl;
    private String description;
    private LocalDateTime createdAt;
}