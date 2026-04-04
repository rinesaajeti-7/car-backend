package com.carproject.dto;

import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Data
public class CarRequest {
    @NotNull
    private String make;

    @NotNull
    private String model;

    @NotNull
    @Min(1900)
    private Integer year;

    @NotNull
    @Min(0)
    private Double price;

    @NotNull
    @Min(0)
    private Integer mileage;

    @NotNull
    private String fuelType;

    private String imageUrl;
    private String description;

    // getters and setters
}