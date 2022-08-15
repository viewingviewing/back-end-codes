package com.example.vngvng.domain.member.dto;

import com.example.vngvng.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

public class MemberSaveRequestDto {
    private String id;
    private String name;
    private String nickname;
    private String email;

    @Builder
    public MemberSaveRequestDto(String id, String name, String nickname, String email){
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
    }

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .name(name)
                .nickName(nickname)
                .email(email)
                .build();
    }
}
