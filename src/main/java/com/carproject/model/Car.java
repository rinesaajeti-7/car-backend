package com.carproject.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String make;

    @Column(length = 100)
    private String model;

    private Integer year;
    private Double price;
    private Integer mileage;

    @Column(length = 50)
    private String fuelType;

    @Column(length = 1000)   // shto për URL të gjata
    private String imageUrl;

    @Column(length = 5000)   // shto për përshkrime të gjata
    private String description;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}