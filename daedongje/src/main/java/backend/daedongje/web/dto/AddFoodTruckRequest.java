package backend.daedongje.web.dto;


import backend.daedongje.domain.FoodTruck;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddFoodTruckRequest {
    private String name;
    private String place;
    private Integer startDate;
    private Integer endDate;

    public FoodTruck toEntity() { //데이터 베이스 형식으로 변화를 일으킴, 데이터가 의도적으로 변화되는것을 방지
        return FoodTruck.builder()
                .name(name)
                .place(place)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
