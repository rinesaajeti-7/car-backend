package com.carproject.repository;

import com.carproject.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("SELECT c FROM Car c WHERE LOWER(c.make) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(c.model) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Car> searchByKeyword(@Param("keyword") String keyword);
}