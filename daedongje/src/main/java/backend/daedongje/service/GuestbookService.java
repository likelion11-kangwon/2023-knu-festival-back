package backend.daedongje.service;

import backend.daedongje.entity.Guestbook;
import backend.daedongje.repository.GuestbookRepository;
import backend.daedongje.web.dto.AddGuestbookRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestbookService {
    private final GuestbookRepository guestbookRepository;

    public Guestbook save(AddGuestbookRequestDTO requestDTO){
        return guestbookRepository.save(requestDTO.toEntity());
    }

    //단건조회
    public Guestbook findById(Long id){
        return guestbookRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Guestbook not exist"+id));
    }

    //전체조회
    public List<Guestbook> findAll(){
        return guestbookRepository.findAll();
    }


}
