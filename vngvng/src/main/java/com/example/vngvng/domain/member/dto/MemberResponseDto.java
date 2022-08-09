package com.example.vngvng.domain.member.dto;

import com.example.vngvng.domain.member.Member;
import lombok.Builder;
import lombok.Getter;

@Getter

public class MemberResponseDto {
    private String id;
    private String name;
    private String nickname;
    private String email;

    @Builder
    public MemberResponseDto(Member entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.nickname = entity.getNickName();
        this.email = entity.getEmail();
    }
}
