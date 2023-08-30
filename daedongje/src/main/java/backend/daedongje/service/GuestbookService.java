package backend.daedongje.service;

import backend.daedongje.dto.GuestbookDTO;
import backend.daedongje.dto.PageRequestDTO;
import backend.daedongje.dto.PageResponseDTO;
import backend.daedongje.entity.Guestbook;

public interface GuestbookService {
    Long register(GuestbookDTO guestbookDTO);
    PageResponseDTO<GuestbookDTO, Guestbook> list(PageRequestDTO pageRequestDTO);

    GuestbookDTO read(Long id); //단일조회떄 쓸거
    default Guestbook dtoToEntity(GuestbookDTO guestbookDTO) {

        Guestbook guestbook = Guestbook.builder()
                .id(guestbookDTO.getId())
                .content(guestbookDTO.getContent())
                .writer(guestbookDTO.getWriter())
                .build();

        return guestbook;
    }

    default GuestbookDTO entityToDto(Guestbook guestbook) {

        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .id(guestbook.getId())
                .content(guestbook.getContent())
                .writer(guestbook.getWriter())
                .build();

        return guestbookDTO;
    }

}
