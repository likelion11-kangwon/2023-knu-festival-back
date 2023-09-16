package backend.daedongje.repository;

import backend.daedongje.domain.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    Page<Notice> findByDelCheckFalse(Pageable pageable);

    Page<Notice> findByCategoryAndDelCheckFalse(String category, Pageable pageable);
}
