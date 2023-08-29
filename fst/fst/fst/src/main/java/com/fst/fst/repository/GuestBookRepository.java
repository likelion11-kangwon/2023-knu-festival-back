package com.fst.fst.repository;

import com.fst.fst.entity.GuestBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestBookRepository {
    public interface GuestbookRepository extends JpaRepository<GuestBook, Long> {

    }

}
