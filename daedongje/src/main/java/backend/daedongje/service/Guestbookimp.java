package backend.daedongje.service;

import backend.daedongje.dto.GuestbookDTO;
import backend.daedongje.entity.Guestbook;
import backend.daedongje.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class Guestbookimp implements GuestbookService {
    private final GuestbookRepository guestbookRepository;

    public Guestbookimp(GuestbookRepository guestbookRepository) {
        this.guestbookRepository = guestbookRepository;
    }

    @Override
    public Long register(GuestbookDTO guestbookDTO) {


        Guestbook guestbook = dtoToEntity(guestbookDTO);

        Guestbook result = guestbookRepository.save(guestbook);


        return result.getNum();

    }

}
