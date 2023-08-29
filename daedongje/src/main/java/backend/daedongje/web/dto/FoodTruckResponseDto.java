package com.example.quickly.web.dto;

import com.example.quickly.domain.FoodTruck;
import lombok.Getter;

@Getter
public class FoodTruckResponseDto {
    private Integer id;
    private String name;
    private Long likes;

    public FoodTruckResponseDto(FoodTruck foodTruck) {
        this.id = foodTruck.getId();
        this.name = foodTruck.getName();
        this.likes = foodTruck.getLikes();
    }
}
