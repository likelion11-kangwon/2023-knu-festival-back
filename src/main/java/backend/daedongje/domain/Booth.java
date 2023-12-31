package backend.daedongje.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
@Entity
public class Booth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "place")
    private String place;

    @ColumnDefault("0")
    @Column(name = "likes")
    private Long likes;

    @Builder
    public Booth(String name, String place){
        this.name = name;
        this.place = place;
    }

    public void update(String name) {
        this.name = name;
    }

    public void likesUp(Booth booth){
        booth.likes++;
    }

    public void likesDown(Booth booth){
        booth.likes--;
    }
}
