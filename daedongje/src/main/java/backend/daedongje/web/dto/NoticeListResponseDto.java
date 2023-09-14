package backend.daedongje.web.dto;

import backend.daedongje.domain.Notice;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class NoticeListResponseDto {

    private Long noticeId;
    private String title;
    private String content;
    private LocalDateTime createDate;

    //Entity -> Dto
    public NoticeListResponseDto(Notice notice){
        this.noticeId = notice.getId();
        this.title = notice.getTitle();
        this.content = notice.getContent();
        this.createDate = notice.getCreatedDate();
    }
}
