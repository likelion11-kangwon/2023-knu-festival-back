package backend.daedongje.web;

import backend.daedongje.domain.Notice;
import backend.daedongje.service.NoticeService;
import backend.daedongje.web.dto.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class NoticeApiController {

    private final NoticeService noticeService;

    @GetMapping("/notices")
    public Page<NoticeListResponseDto> showAllNotice(@RequestParam(value="page", defaultValue = "0") int page){ // 모든 공지사항 각각의 제목과 id가 담긴 리스트 보여줌(모든공지사항 리스트)
        Page<Notice> noticePage = noticeService.showAllNotice(page);
        return noticePage.map(notice -> new NoticeListResponseDto(notice));
    }

    @GetMapping("/notice/{id}")
    public NoticeResponseDto showNotice(@PathVariable Long id){ // 해당 아이디의 공지사항 제목과 본문 반환
        return noticeService.showNotice(id);
    }

    @PostMapping("/notice/admin")
    public NoticeResponseDto saveNotice(@RequestBody NoticeRequestDto noticeRequest) {

        return noticeService.saveNotice(noticeRequest);
    }

    @PatchMapping("/notice/admin")
    public NoticeResponseDto modifyNotice(@RequestBody NoticeModifyDto noticeModify) {

        return noticeService.modifyNotice(noticeModify);
    }

    @DeleteMapping("/notice/admin")
    public boolean modifyNotice(@RequestBody NoticeDeleteDto noticeDelete) {

        return noticeService.delete(noticeDelete);
    }

    @GetMapping("/list/{category}")
    public Page<NoticeResponseDto> getCategoryPosts(
            @PathVariable("category") String category,
            @RequestParam(value="page", defaultValue="0") int page) {

        Page<Notice> paging = noticeService.getCategoryNotice(category, page);
        return paging.map(notice -> new NoticeResponseDto(notice));
    }
}
