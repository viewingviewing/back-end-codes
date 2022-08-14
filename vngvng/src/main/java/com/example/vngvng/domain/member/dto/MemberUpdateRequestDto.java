package com.example.vngvng.domain.member.dto;

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
    private int standingHeight;
    private SittingHeight sittingHeight;

    @Builder
    public MemberUpdateRequestDto(boolean wearGlasses, int standingHeight, SittingHeight sittingHeight){
        this.wearGlasses = wearGlasses;
        this.standingHeight = standingHeight;
        this.sittingHeight = sittingHeight;
    }
}
