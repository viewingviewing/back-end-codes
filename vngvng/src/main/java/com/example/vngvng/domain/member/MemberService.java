package com.example.vngvng.domain.member;


import com.example.vngvng.domain.member.dto.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponseDto findById(String id){
        Member entity = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 사용자가 없습니다."));
        return new MemberResponseDto(entity);
    }
}
