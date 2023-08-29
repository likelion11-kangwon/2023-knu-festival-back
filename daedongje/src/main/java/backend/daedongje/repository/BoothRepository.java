package backend.daedongje.repository;

import backend.daedongje.domain.Booth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoothRepository extends JpaRepository<Booth, Long> {
}
