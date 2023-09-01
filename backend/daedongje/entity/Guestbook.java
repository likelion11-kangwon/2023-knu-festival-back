package backend.daedongje.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Guestbook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;


    @Column(name="content",length = 150, nullable = false)
    private String content;

    @Column(name="writer",length = 15, nullable = false)
    private String writer;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;

    @Builder
    public Guestbook(String content, String writer){
        this.content=content;
        this.writer=writer;
    }

}
