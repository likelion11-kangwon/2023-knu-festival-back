package backend.daedongje.web.dto;


import backend.daedongje.domain.Booth;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddBoothRequest {
    private String name;

    public Booth toEntity() { //데이터 베이스 형ㅅ힉으로 변화를 일으킴, 데이터가 의도적으로 변화되는것을 방지
        return Booth.builder()
                .name(name)
                .build();
    }
}
