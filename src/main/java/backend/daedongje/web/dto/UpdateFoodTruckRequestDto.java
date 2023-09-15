package backend.daedongje.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateFoodTruckRequestDto {
    private String name;
    private String place;
    private Integer startDate;
    private Integer endDate;
}
