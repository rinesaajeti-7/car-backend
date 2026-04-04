package com.carproject.service;

import com.carproject.dto.CarRequest;
import com.carproject.dto.CarResponse;
import java.util.List;

public interface CarService {
    List<CarResponse> getAllCars();
    CarResponse getCarById(Long id);
    CarResponse createCar(CarRequest carRequest);
    CarResponse updateCar(Long id, CarRequest carRequest);
    void deleteCar(Long id);
    List<CarResponse> searchCars(String keyword);
}