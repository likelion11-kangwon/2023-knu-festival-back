package com.example.quickly.web;

import com.example.quickly.domain.Booth;
import com.example.quickly.service.BoothService;
import com.example.quickly.web.dto.AddBoothRequest;
import com.example.quickly.web.dto.BoothResponseDto;
import com.example.quickly.web.dto.UpdateBoothRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoothApiController {
    private final BoothService boothService;

    @PostMapping("/api/latest/booth")
    public ResponseEntity<Booth> addBooth(@RequestBody AddBoothRequest requestDto){
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(boothService.save(requestDto));
    }


    @GetMapping("/api/latest/booth/{id}")
    public ResponseEntity<BoothResponseDto> findBooth(@PathVariable Long id){
        return ResponseEntity.ok().body(new BoothResponseDto(boothService.findById(id)));
    }

    @GetMapping("/api/latest/booth/likes/{id}")
    public ResponseEntity<Booth> updateLikes(@PathVariable Long id){
        Booth updatedBooth = boothService.updateLikes(id);
        return ResponseEntity.ok().body(updatedBooth);
    }

    @DeleteMapping("api/latest/booth/{id}")
    public ResponseEntity<Void> deleteBooth(@PathVariable Long id){
        boothService.delete(id);
        return ResponseEntity.ok().build();

    }

    //수정
    @PutMapping("/api/latest/booth/{id}")
    public ResponseEntity<Booth> updateBooth(@PathVariable Long id, @RequestBody UpdateBoothRequestDto requestDto) {
        Booth updatedBooth = boothService.update(id,requestDto);

        return ResponseEntity.ok().body(updatedBooth);

    }

}
