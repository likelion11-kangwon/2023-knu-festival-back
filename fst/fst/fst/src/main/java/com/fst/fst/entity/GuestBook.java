package com.fst.fst.entity;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@ToString
public class GuestBook extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;


    @Column(length = 100, nullable = false)
    private String content;

    @Column(length = 10, nullable = false)
    private String writer;



}