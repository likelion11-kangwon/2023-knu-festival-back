package backend.daedongje.web.dto;

import backend.daedongje.domain.Notice;
import lombok.Getter;

@Getter
public class NoticeResponseDto {
    private String title;
    private String content;

    //Entity -> Dto
    public NoticeResponseDto(Notice notice){
        this.title = notice.getTitle();
        this.content = notice.getContent();
    }

}
