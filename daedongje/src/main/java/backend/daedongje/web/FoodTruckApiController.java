package backend.daedongje.web;

import backend.daedongje.domain.FoodTruck;
import backend.daedongje.service.FoodTruckService;
import backend.daedongje.web.dto.AddFoodTruckRequest;
import backend.daedongje.web.dto.FoodTruckResponseDto;
import backend.daedongje.web.dto.UpdateFoodTruckRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


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
    @GetMapping("/api/latest/foodTrucks")
    public ResponseEntity<List<FoodTruckResponseDto>> findAllFoodTruck() {
        List<FoodTruckResponseDto>  foodTrucks = foodTruckService.findAll()
                .stream()
                .map(FoodTruckResponseDto::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(foodTrucks);

    }

    @GetMapping("/api/latest/foodTrucks/{date}")
    public ResponseEntity<List<FoodTruckResponseDto>> findAllFoodTruckByDate(@PathVariable Integer date) {
        List<FoodTruckResponseDto>  foodTrucks = foodTruckService.findAllByDate(date)
                .stream()
                .map(FoodTruckResponseDto::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(foodTrucks);
    }

//    @PostMapping("/api/latest/foodTruck/likes/{id}")
//    public ResponseEntity<FoodTruckResponseDto> updateLikes(@PathVariable Long id){
//        FoodTruck updatedFoodTruck = foodTruckService.updateLikes(id);
//        return ResponseEntity.ok().body(new FoodTruckResponseDto(updatedFoodTruck));
//    }

    @DeleteMapping("/api/latest/foodTruck/{id}")
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
