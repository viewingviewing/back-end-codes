package com.example.vngvng.domain.member;

import com.example.vngvng.domain.member.dto.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    /*
    * 회원 정보 조회 api
    * */
    @GetMapping("/{id}")
    public MemberResponseDto findById (@PathVariable String id){
        return memberService.findById(id);
    }
}
