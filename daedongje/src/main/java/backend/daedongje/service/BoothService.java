package com.example.quickly.service;

import com.example.quickly.domain.Booth;
import com.example.quickly.repository.BoothRepository;
import com.example.quickly.web.dto.AddBoothRequest;
import com.example.quickly.web.dto.UpdateBoothRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
