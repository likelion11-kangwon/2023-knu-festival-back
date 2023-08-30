package backend.daedongje.service;

import backend.daedongje.dto.GuestbookDTO;
import backend.daedongje.dto.PageRequestDTO;
import backend.daedongje.dto.PageResponseDTO;
import backend.daedongje.entity.Guestbook;
import backend.daedongje.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Transactional
public class Guestbookimp implements GuestbookService {

    private final GuestbookRepository guestbookRepository;



    @Override
    public Long register(GuestbookDTO guestbookDTO) {


        Guestbook guestbook = dtoToEntity(guestbookDTO);

        Guestbook result = guestbookRepository.save(guestbook);


        return result.getId();

    }
    
    //요청을 페이지 응답으로
    @Override
    public PageResponseDTO<GuestbookDTO, Guestbook> list(PageRequestDTO pageRequestDTO) {


        Sort sort = Sort.by("id").descending();

        Pageable pageable = pageRequestDTO.getPageable(sort);

        Page<Guestbook> findAllResult = guestbookRepository.findAll(pageable);

        Function<Guestbook, GuestbookDTO> fn = guestbook -> entityToDto(guestbook);

        return new PageResponseDTO<>(findAllResult, fn);

    }
    
    //단일 방명록 조회
    @Override
    public GuestbookDTO read(Long gno) {


        Optional<Guestbook> findByIdResult = guestbookRepository.findById(gno);

        return findByIdResult.isPresent() ? entityToDto(findByIdResult.get()) : null;
    }

}
