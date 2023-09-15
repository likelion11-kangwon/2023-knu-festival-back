package backend.daedongje.repository;


import backend.daedongje.domain.FoodTruck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FoodTruckRepository extends JpaRepository<FoodTruck, Long> {



    Optional<FoodTruck> findByName(String name);

    @Query("select f from FoodTruck f where f.startDate <= :date and f.endDate >= :date")
    List<FoodTruck> findByStartDateAndEndDate(Integer date);
}
