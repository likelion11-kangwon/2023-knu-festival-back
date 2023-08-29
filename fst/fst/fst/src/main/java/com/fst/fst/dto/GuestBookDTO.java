package com.fst.fst.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GuestBookDTO {

    private Long num;
    private String content;
    private String writer;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}