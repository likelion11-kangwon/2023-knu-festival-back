package backend.daedongje.web;

import backend.daedongje.entity.Guestbook;
import backend.daedongje.service.GuestbookService;
import backend.daedongje.web.dto.AddGuestbookRequestDTO;
import backend.daedongje.web.dto.GuestbookResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class GuestbookController {
    private final GuestbookService guestbookService;

    //방명록 등록
    @PostMapping("/guestbook/register")
    public ResponseEntity<Guestbook> registerGuestbook(@RequestBody AddGuestbookRequestDTO requestDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(guestbookService.save(requestDTO));
    }
    //단건조회
    @GetMapping("/guestbook/list/{id}")
    public ResponseEntity<GuestbookResponseDTO> findGuestbook(@PathVariable Long id){
        return ResponseEntity.ok().body(new GuestbookResponseDTO(guestbookService.findById(id)));
    }

    //전건조회
    @GetMapping("/guestbook/list")
    public ResponseEntity<List<GuestbookResponseDTO>> findAllGuestbook(){
        List<GuestbookResponseDTO> guestbooks=guestbookService.findAll()
                .stream()
                .map(GuestbookResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(guestbooks);
    }
}
