package backend.daedongje.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length=1000)
    private String content;

    private boolean delCheck;

    private String category;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @Builder
    public Notice(boolean delCheck, String title, String content, String category) {
        this.delCheck = delCheck;
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public void modifyTitle(String title) {
        this.title = title;
    }

    public void modifyContent(String content) {
        this.content = content;
    }

    public boolean delete() {
        this.delCheck = true;
        return true;
    }
}
