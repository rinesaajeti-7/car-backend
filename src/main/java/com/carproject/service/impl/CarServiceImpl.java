package com.carproject.service.impl;

import com.carproject.dto.CarRequest;
import com.carproject.dto.CarResponse;
import com.carproject.exception.ResourceNotFoundException;
import com.carproject.model.Car;
import com.carproject.repository.CarRepository;
import com.carproject.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    private CarResponse mapToResponse(Car car) {
        CarResponse response = new CarResponse();
        response.setId(car.getId());
        response.setMake(car.getMake());
        response.setModel(car.getModel());
        response.setYear(car.getYear());
        response.setPrice(car.getPrice());
        response.setMileage(car.getMileage());
        response.setFuelType(car.getFuelType());
        response.setImageUrl(car.getImageUrl());
        response.setDescription(car.getDescription());
        response.setCreatedAt(car.getCreatedAt());
        return response;
    }

    private Car mapToEntity(CarRequest request) {
        Car car = new Car();
        car.setMake(request.getMake());
        car.setModel(request.getModel());
        car.setYear(request.getYear());
        car.setPrice(request.getPrice());
        car.setMileage(request.getMileage());
        car.setFuelType(request.getFuelType());
        car.setImageUrl(request.getImageUrl());
        car.setDescription(request.getDescription());
        return car;
    }

    @Override
    public List<CarResponse> getAllCars() {
        return carRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CarResponse getCarById(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with id: " + id));
        return mapToResponse(car);
    }

    @Override
    public CarResponse createCar(CarRequest carRequest) {
        Car car = mapToEntity(carRequest);
        Car saved = carRepository.save(car);
        return mapToResponse(saved);
    }

    @Override
    public CarResponse updateCar(Long id, CarRequest carRequest) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with id: " + id));
        car.setMake(carRequest.getMake());
        car.setModel(carRequest.getModel());
        car.setYear(carRequest.getYear());
        car.setPrice(carRequest.getPrice());
        car.setMileage(carRequest.getMileage());
        car.setFuelType(carRequest.getFuelType());
        car.setImageUrl(carRequest.getImageUrl());
        car.setDescription(carRequest.getDescription());
        Car updated = carRepository.save(car);
        return mapToResponse(updated);
    }

    @Override
    public void deleteCar(Long id) {
        if (!carRepository.existsById(id)) {
            throw new ResourceNotFoundException("Car not found with id: " + id);
        }
        carRepository.deleteById(id);
    }

    @Override
    public List<CarResponse> searchCars(String keyword) {
        return carRepository.searchByKeyword(keyword).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
}