package backend.daedongje.web.dto;

import backend.daedongje.domain.Notice;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class NoticeListResponseDto {

    private Long id;
    private String title;

    //Entity -> Dto
    public NoticeListResponseDto(Notice notice){
        this.title = notice.getTitle();
        this.id = notice.getId();
    }
}
