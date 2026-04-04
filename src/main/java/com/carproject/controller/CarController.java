package com.carproject.controller;

import com.carproject.dto.CarRequest;
import com.carproject.dto.CarResponse;
import com.carproject.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin(origins = "http://localhost:3000")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<CarResponse>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarResponse> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<CarResponse>> searchCars(@RequestParam String keyword) {
        return ResponseEntity.ok(carService.searchCars(keyword));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CarResponse> createCar(@RequestBody CarRequest carRequest) {
        CarResponse created = carService.createCar(carRequest);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CarResponse> updateCar(@PathVariable Long id, @RequestBody CarRequest carRequest) {
        CarResponse updated = carService.updateCar(id, carRequest);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}