package backend.daedongje.web.dto;

import backend.daedongje.domain.Guestbook;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class GuestbookResponseDTO {

    private Long id;
    private String content;
    private String writer;
    private LocalDateTime regDate;

    public GuestbookResponseDTO(Guestbook guestbook){
        this.id=guestbook.getId();
        this.content= guestbook.getContent();
        this.writer= guestbook.getWriter();
        this.regDate=guestbook.getRegDate();
    }

}
