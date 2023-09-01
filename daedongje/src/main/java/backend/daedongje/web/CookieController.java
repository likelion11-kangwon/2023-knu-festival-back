package backend.daedongje.web;

import backend.daedongje.domain.Booth;
import backend.daedongje.domain.FoodTruck;
import backend.daedongje.service.BoothService;
import backend.daedongje.service.FoodTruckService;
import backend.daedongje.web.dto.BoothResponseDto;
import backend.daedongje.web.dto.FoodTruckResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@RestController
public class CookieController {

    private final BoothService boothService;
    private final FoodTruckService foodTruckService;

    @Transactional
    @PostMapping ("/api/latest/foodTruck/likesUpdate/{id}")
    public ResponseEntity<FoodTruckResponseDto> updateFoodTruckLikes(HttpServletResponse response, HttpServletRequest request, @PathVariable Long id){
        Cookie[] foodTruckCookies = request.getCookies();
        Cookie existingCookie = findCookieByName(foodTruckCookies, Long.toString(id));
        if(existingCookie!=null){
            existingCookie.setMaxAge(0);
            response.addCookie(existingCookie);
            FoodTruck updatedFoodTruck = foodTruckService.downLikes(id);
            return ResponseEntity.ok().body(new FoodTruckResponseDto(updatedFoodTruck));
        }
        FoodTruck updatedFoodTruck = foodTruckService.updateLikes(id);
        Cookie foodTruckcookie = new Cookie(Long.toString(id),"liked");
        foodTruckcookie.setMaxAge(24*60*60*4); //유효기간 4일
        response.addCookie(foodTruckcookie);
        return ResponseEntity.ok().body(new FoodTruckResponseDto(updatedFoodTruck));
    }
    @Transactional
    @PostMapping ("/api/latest/booth/likesUpdate/{id}")
    public ResponseEntity<BoothResponseDto> updateBoothLikes(HttpServletResponse response, HttpServletRequest request, @PathVariable Long id){
        Cookie[] boothCookies = request.getCookies();
        Cookie existingCookie = findCookieByName(boothCookies, Long.toString(id));
        if(existingCookie!=null){
            existingCookie.setMaxAge(0);
            response.addCookie(existingCookie);
            Booth updatedBooth = boothService.downLikes(id);
            return ResponseEntity.ok().body(new BoothResponseDto(updatedBooth));
        }
        Booth updatedBooth = boothService.upLikes(id);
        Cookie boothCookie = new Cookie(Long.toString(id),"liked");
        boothCookie.setMaxAge(24*60*60*4); //유효기간 4일
        response.addCookie(boothCookie);
        return ResponseEntity.ok().body(new BoothResponseDto(updatedBooth));
    }

    private Cookie findCookieByName(Cookie[] cookies, String name){
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals(name)){
                    return cookie;
                }
            }
        }
        return null;
    }
}
