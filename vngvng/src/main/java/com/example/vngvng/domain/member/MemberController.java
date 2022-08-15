package com.example.vngvng.domain.member;

import com.example.vngvng.domain.member.dto.MemberResponseDto;
import com.example.vngvng.domain.member.dto.MemberSaveRequestDto;
import com.example.vngvng.domain.member.dto.MemberUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    /*
     * 회원 등록 api
     * */
    @PostMapping("/registration")
    public String save(@RequestBody MemberSaveRequestDto requestDto){
        return memberService.save(requestDto);
    }

    /*
     * 회원 정보 조회 api
     * */
    @GetMapping("/{id}")
    public MemberResponseDto findById (@PathVariable String id){
        return memberService.findById(id);
    }

    /*
     * 회원 정보 수정 api
     * */
    @PatchMapping("/{id}")
    public String update (@PathVariable String id, @RequestBody MemberUpdateRequestDto requestDto){
        return memberService.update(id,requestDto);
    }
}