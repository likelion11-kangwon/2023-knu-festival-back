package com.example.quickly.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Booth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ColumnDefault("0")
    @Column(name = "likes")
    private Long likes;

    @Builder
    public Booth(String name){
        this.name = name;
    }

    public void update(String name) {
        this.name = name;
    }

    public void likesUp(Booth booth){
        booth.likes++;
    }
}
