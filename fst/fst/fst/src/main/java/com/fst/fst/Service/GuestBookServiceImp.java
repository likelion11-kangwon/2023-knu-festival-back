package com.fst.fst.Service;

import com.fst.fst.dto.GuestBookDTO;
import com.fst.fst.entity.GuestBook;
import com.fst.fst.repository.GuestBookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuestBookServiceImp {
    private final GuestBookRepository guestbookRepository;

    public GuestBookServiceImp(GuestBookRepository guestbookRepository) {
        this.guestbookRepository = guestbookRepository;
    }


    public Long register(GuestBookDTO guestbookDTO) {

        GuestBook guestbook = dtoToEntity(guestbookDTO);

        GuestBook result = guestbookRepository.save(guestbook);

        return result.getnum();

    }


}
