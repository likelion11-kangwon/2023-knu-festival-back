package backend.daedongje.service;

import backend.daedongje.domain.Notice;
import backend.daedongje.repository.NoticeRepository;
import backend.daedongje.web.dto.NoticeDeleteDto;
import backend.daedongje.web.dto.NoticeModifyDto;
import backend.daedongje.web.dto.NoticeRequestDto;
import backend.daedongje.web.dto.NoticeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public Page<Notice> showAllNotice(int page){ // 디비에 존재하는 모든 공지사항 제목이 담긴 List<NoticeListResponseDto> 반환

        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createdDate")); //sorts 리스트에 createdDate을 기준으로 내림차순 하도록 리스트에 속성 부가

        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));

//        List<Notice> noticeList = noticeRepository.findAll();
//
//        List<NoticeListResponseDto> responseDtoList;
//        responseDtoList = noticeList.stream().map(notice -> new NoticeListResponseDto(notice)).collect(Collectors.toList());

        return noticeRepository.findByDelCheckFalse(pageable);
    }

    public NoticeResponseDto showNotice(Long id){ // 세부 공지사항의 제목과 본문이 담긴 dto반환
        Notice notice = noticeRepository.findById(id).orElseThrow(() -> new RuntimeException("no notice"));
        return new NoticeResponseDto(notice);
    }

    @Transactional
    public NoticeResponseDto saveNotice(NoticeRequestDto noticeRequest) {

        Notice notice = Notice.builder()
                .title(noticeRequest.getTitle())
                .content(noticeRequest.getContent())
                .delCheck(false)
                .build();

        return new NoticeResponseDto(noticeRepository.save(notice));
    }

    @Transactional
    public NoticeResponseDto modifyNotice(NoticeModifyDto noticeModify) {

        Notice notice = noticeRepository.findById(noticeModify.getNoticeId())
                .orElseThrow(() -> new RuntimeException("no notice"));

        notice.modifyTitle(noticeModify.getTitle());
        notice.modifyContent(noticeModify.getContent());
        return new NoticeResponseDto(notice);
    }

    @Transactional
    public boolean delete(NoticeDeleteDto noticeDelete) {

        Notice notice = noticeRepository.findById(noticeDelete.getNoticeId())
                .orElseThrow(() -> new RuntimeException("no notice"));

        return notice.delete();
    }
}
