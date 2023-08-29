package com.fst.fst.Service;

import com.fst.fst.dto.GuestBookDTO;
import com.fst.fst.entity.GuestBook;

public interface GuestBookService {
    @Override
    Long register(GuestBookDTO guestbookDTO);

    @Override
    default GuestBook dtoToEntity(GuestBookDTO guestbookDTO) {

        GuestBook guestbook = GuestBook.builder()
                .num(guestbookDTO.getnum())
                .content(guestbookDTO.getContent())
                .writer(guestbookDTO.getWriter())
                .build();

        return guestbook;
    }

}