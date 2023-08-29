package backend.daedongje.repository;


import backend.daedongje.domain.FoodTruck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodTruckRepository extends JpaRepository<FoodTruck, Long> {
}
