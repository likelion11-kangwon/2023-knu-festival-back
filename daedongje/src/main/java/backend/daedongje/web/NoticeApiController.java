package backend.daedongje.web;

import backend.daedongje.domain.Notice;
import backend.daedongje.service.NoticeService;
import backend.daedongje.web.dto.NoticeListResponseDto;
import backend.daedongje.web.dto.NoticeResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/notice")
public class NoticeApiController {

    private final NoticeService noticeService;

    @GetMapping("/list")
    public Page<NoticeListResponseDto> showAllNotice(@RequestParam(value="page", defaultValue = "0") int page){ // 모든 공지사항 각각의 제목과 id가 담긴 리스트 보여줌(모든공지사항 리스트)
        Page<Notice> noticePage = noticeService.showAllNotice(page);
        return noticePage.map(notice -> new NoticeListResponseDto(notice));
    }

    @GetMapping("/{id}")
    public NoticeResponseDto showNotice(@PathVariable Long id){ // 해당 아이디의 공지사항 제목과 본문 반환
        return noticeService.showNotice(id);
    }

}
