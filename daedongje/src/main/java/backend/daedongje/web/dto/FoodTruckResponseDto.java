package backend.daedongje.web.dto;

import backend.daedongje.domain.FoodTruck;
import lombok.Getter;

@Getter
public class FoodTruckResponseDto {
    private Long id;
    private String name;
    private Long likes;

    public FoodTruckResponseDto(FoodTruck foodTruck) {
        this.id = foodTruck.getId();
        this.name = foodTruck.getName();
        this.likes = foodTruck.getLikes();
    }
}
