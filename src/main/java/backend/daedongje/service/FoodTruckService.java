package backend.daedongje.service;

import backend.daedongje.domain.FoodTruck;
import backend.daedongje.repository.FoodTruckRepository;
import backend.daedongje.web.dto.AddFoodTruckRequest;
import backend.daedongje.web.dto.UpdateFoodTruckRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor // 생성자를 대신해준다.
@Service
public class FoodTruckService {
    private final FoodTruckRepository foodTruckRepository;


    //save
    public FoodTruck save(AddFoodTruckRequest requestDto){
        return foodTruckRepository.save(requestDto.toEntity());
    }

    public List<FoodTruck> findAll() {
        return foodTruckRepository.findAll();   }

    public List<FoodTruck> findAllByDate(Integer date){
        return foodTruckRepository.findByStartDateAndEndDate(date);
    }

    // 단건 조회(id로)
    public FoodTruck findById(Long id) {
        return foodTruckRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("foodTruck not exist ! : " + id));
    }

    public FoodTruck findByName(String name) {
        return foodTruckRepository.findByName(name).orElseThrow(()-> new IllegalArgumentException("foodTruck not exist! : " + name));
    }

    public void delete(Long id) {
        foodTruckRepository.deleteById(id);
    }

    // 수정하는 코드를 넣으면 된다.
    @Transactional
    public FoodTruck update(Long id, UpdateFoodTruckRequestDto requestDto) {
        FoodTruck foodTruck = foodTruckRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("foodTruck not exist! : " + id));
        foodTruck.update(requestDto.getName(), requestDto.getPlace(), requestDto.getStartDate(), requestDto.getStartDate());
        return  foodTruck;
    }

    @Transactional
    public FoodTruck updateLikes(Long id){
        FoodTruck foodTruck = foodTruckRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("foodTruck not exist! : " + id));
        foodTruck.likesUp(foodTruck);
        return foodTruck;
    }

    @Transactional
    public FoodTruck downLikes(Long id){
        FoodTruck foodTruck = foodTruckRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("booth not exist! : " + id));
        foodTruck.likesDown(foodTruck);
        return foodTruck;
    }
}
