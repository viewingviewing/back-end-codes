package com.example.vngvng.domain.member.dto;

import com.example.vngvng.domain.member.Height;
import com.example.vngvng.domain.member.SittingHeight;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MemberUpdateRequestDto {
    private boolean wearGlasses;
    private Height height;

    @Builder
    public MemberUpdateRequestDto(boolean wearGlasses, Height height){
        this.wearGlasses = wearGlasses;
        this.height = height;
    }
}
