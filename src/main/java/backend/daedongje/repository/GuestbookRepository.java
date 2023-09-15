package backend.daedongje.repository;

import backend.daedongje.domain.Guestbook;
import backend.daedongje.domain.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long> {
    @Override
    Page<Guestbook> findAll(Pageable pageable);

    Page<Guestbook> findByDelCheckFalse(Pageable pageable);
}
