package backend.daedongje.web.dto;

import backend.daedongje.domain.Guestbook;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddGuestbookRequestDTO {
    private String content;
    private String writer;

    public Guestbook toEntity(){
        return Guestbook.builder().content(content).writer(writer).delCheck(false).build();
    }
}
