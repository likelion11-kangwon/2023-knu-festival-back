package backend.daedongje.web.dto;


import backend.daedongje.domain.Booth;
import lombok.Getter;

@Getter
public class BoothResponseDto {
    private Integer id;
    private String name;
    private Long likes;

    public BoothResponseDto(Booth booth) {
        this.id = booth.getId();
        this.name = booth.getName();
        this.likes = booth.getLikes();
    }
}
