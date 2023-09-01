package backend.daedongje.repository;


import backend.daedongje.domain.FoodTruck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodTruckRepository extends JpaRepository<FoodTruck, Long> {
}
