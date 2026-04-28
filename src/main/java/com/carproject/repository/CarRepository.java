package com.carproject.repository;

import com.carproject.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    // Case-insensitive search on make or model
    List<Car> findByMakeContainingIgnoreCaseOrModelContainingIgnoreCase(String make, String model);
}