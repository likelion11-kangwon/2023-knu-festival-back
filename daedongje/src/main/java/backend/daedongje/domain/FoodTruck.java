package backend.daedongje.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity
public class FoodTruck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @ColumnDefault("0")
    @Column(name = "likes")
    private Long likes;

    @Builder
    public FoodTruck(String name){
        this.name = name;
    }

    public void update(String name) {
        this.name = name;
    }
    public void likesUp(FoodTruck foodTruck){
        foodTruck.likes++;
    }
}
