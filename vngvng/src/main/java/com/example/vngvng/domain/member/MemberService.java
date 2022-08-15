package com.example.vngvng.domain.member;


import com.example.vngvng.domain.member.dto.MemberResponseDto;
import com.example.vngvng.domain.member.dto.MemberSaveRequestDto;
import com.example.vngvng.domain.member.dto.MemberUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public String save(MemberSaveRequestDto requestDto){
        return memberRepository.save(requestDto.toEntity()).getId();
    }

    public MemberResponseDto findById(String id){
        Member entity = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 사용자가 없습니다."));
        return new MemberResponseDto(entity);
    }

    @Transactional
    public String update(String id, MemberUpdateRequestDto requestDto){
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 멤버가 없습니다."));
        member.update(requestDto.isWearGlasses(), requestDto.getHeight());
        return id;
    }
}
