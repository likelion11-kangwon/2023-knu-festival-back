package backend.daedongje.web.dto;

import backend.daedongje.domain.Notice;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeResponseDto {

    private Long noticeId;
    private String title;
    private String content;

    //Entity -> Dto
    public NoticeResponseDto(Notice notice){
        this.noticeId = notice.getId();
        this.title = notice.getTitle();
        this.content = notice.getContent();
    }

}
