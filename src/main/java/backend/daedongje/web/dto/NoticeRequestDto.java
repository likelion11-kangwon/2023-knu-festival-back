package backend.daedongje.web.dto;

import backend.daedongje.domain.Notice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeRequestDto {

    private String title;
    private String content;

    public NoticeRequestDto(Notice notice) {
        this.title = notice.getTitle();
        this.content = notice.getContent();
    }
}
