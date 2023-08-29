package backend.daedongje.service;

import backend.daedongje.dto.GuestbookDTO;
import backend.daedongje.entity.Guestbook;

public interface GuestbookService {
    Long register(GuestbookDTO guestbookDTO);

    default Guestbook dtoToEntity(GuestbookDTO guestbookDTO) {

        Guestbook guestbook = Guestbook.builder()
                .id(guestbookDTO.getId())
                .content(guestbookDTO.getContent())
                .writer(guestbookDTO.getWriter())
                .build();

        return guestbook;
    }

}
