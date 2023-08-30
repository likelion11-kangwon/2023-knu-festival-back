package backend.daedongje.web;

import backend.daedongje.domain.Booth;
import backend.daedongje.service.BoothService;
import backend.daedongje.web.dto.AddBoothRequest;
import backend.daedongje.web.dto.BoothResponseDto;
import backend.daedongje.web.dto.UpdateBoothRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/api/latest/booths")
    public ResponseEntity<List<BoothResponseDto>> findAllBooth() {
        List<BoothResponseDto> booths = boothService.findAll()
                .stream()
                .map(BoothResponseDto::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(booths);

    }

//    @PostMapping("/api/latest/booth/likes/{id}")
//    public ResponseEntity<BoothResponseDto> updateLikes(@PathVariable Long id){
//        Booth updatedBooth = boothService.updateLikes(id);
//        return ResponseEntity.ok().body(new BoothResponseDto(updatedBooth));
//    }

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
