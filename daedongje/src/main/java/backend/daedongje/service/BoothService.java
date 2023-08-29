package backend.daedongje.service;


import backend.daedongje.domain.Booth;
import backend.daedongje.repository.BoothRepository;
import backend.daedongje.web.dto.AddBoothRequest;
import backend.daedongje.web.dto.UpdateBoothRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor // 생성자를 대신해준다.
@Service
public class BoothService {
    private final BoothRepository boothRepository;


    //save
    public Booth save(AddBoothRequest requestDto){
        return boothRepository.save(requestDto.toEntity());
    }


    // 단건 조회
    public Booth findById(Long id) {
        return boothRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("booth not exist ! : " + id));
    }

    public List<Booth> findAll() {
        return boothRepository.findAll();   }

    public void delete(Long id) {
        boothRepository.deleteById(id);
    }

    // 수정하는 코드를 넣으면 된다.
    @Transactional
    public Booth update(Long id, UpdateBoothRequestDto requestDto) {
        Booth booth = boothRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("booth not exist! : " + id));
        booth.update(requestDto.getName());
        return  booth;
    }

    @Transactional
    public Booth updateLikes(Long id){
        Booth booth = boothRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("booth not exist! : " + id));
        booth.likesUp(booth);
        return booth;
    }
}
