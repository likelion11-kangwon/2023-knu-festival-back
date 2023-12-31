package backend.daedongje.service;

import backend.daedongje.domain.Guestbook;
import backend.daedongje.repository.GuestbookRepository;
import backend.daedongje.web.dto.AddGuestbookRequestDTO;
import backend.daedongje.web.dto.GuestBookDeleteDto;
import backend.daedongje.web.dto.GuestbookResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestbookService {
    private final GuestbookRepository guestbookRepository;

    public GuestbookResponseDTO save(AddGuestbookRequestDTO requestDTO){

        Guestbook guestbook = guestbookRepository.save(requestDTO.toEntity());
        return new GuestbookResponseDTO(guestbook);
    }

    //단건조회
    public Guestbook findById(Long id){
        return guestbookRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Guestbook not exist"+id));
    }

    //전체조회
    public List<Guestbook> findAll() {
        return guestbookRepository.findAll();
    }


    /* Paging */
    @Transactional(readOnly = true)
    public Page<Guestbook> pageList(int page) {

        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("regDate"));

        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));

        return guestbookRepository.findByDelCheckFalse(pageable);
    }

    /*
    @Transactional(readOnly = true)
    public List<Guestbook> pageList(Pageable pageable){

        Page<Guestbook> pageList=guestbookRepository.findAll(pageable);
        List<Guestbook> pageToList=new ArrayList<>();
        if(pageToList!=null&&pageList.hasContent()){
            pageToList=pageList.getContent();
        }
        return pageToList;
    }
    */

    @Transactional
    public boolean delete(GuestBookDeleteDto guestBookDelete) {

        Guestbook guestBook = guestbookRepository.findById(guestBookDelete.getGuestBookId())
                .orElseThrow(() -> new RuntimeException("no guestBook"));

        return guestBook.delete();
    }
}
