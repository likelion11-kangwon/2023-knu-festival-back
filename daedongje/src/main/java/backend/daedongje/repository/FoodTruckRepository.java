package com.example.quickly.repository;

import com.example.quickly.domain.FoodTruck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodTruckRepository extends JpaRepository<FoodTruck, Long> {
}
