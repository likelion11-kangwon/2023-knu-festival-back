package com.example.quickly.web;

import com.example.quickly.domain.Booth;
import com.example.quickly.domain.FoodTruck;
import com.example.quickly.service.FoodTruckService;
import com.example.quickly.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class FoodTruckApiController {
    private final FoodTruckService foodTruckService;

    @PostMapping("/api/latest/foodTruck")
    public ResponseEntity<FoodTruck> addFoodTruck(@RequestBody AddFoodTruckRequest requestDto){
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(foodTruckService.save(requestDto));
    }


    @GetMapping("/api/latest/foodTruck/{id}")
    public ResponseEntity<FoodTruckResponseDto> findFoodTruck(@PathVariable Long id){
        return ResponseEntity.ok().body(new FoodTruckResponseDto(foodTruckService.findById(id)));
    }

    @GetMapping("/api/latest/foodTruck/likes/{id}")
    public ResponseEntity<FoodTruck> updateLikes(@PathVariable Long id){
        FoodTruck updatedFoodTruck = foodTruckService.updateLikes(id);
        return ResponseEntity.ok().body(updatedFoodTruck);
    }

    @DeleteMapping("api/latest/foodTruck/{id}")
    public ResponseEntity<Void> deleteFoodTruck(@PathVariable Long id){
        foodTruckService.delete(id);
        return ResponseEntity.ok().build();

    }

    //수정
    @PutMapping("/api/latest/foodTruck/{id}")
    public ResponseEntity<FoodTruck> updateFoodTruck(@PathVariable Long id, @RequestBody UpdateFoodTruckRequestDto requestDto) {
        FoodTruck updatedFoodTruck = foodTruckService.update(id, requestDto);

        return ResponseEntity.ok().body(updatedFoodTruck);

    }
}
