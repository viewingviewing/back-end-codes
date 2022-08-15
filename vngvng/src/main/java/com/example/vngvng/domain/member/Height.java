package com.example.vngvng.domain.member;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Height {
    @Column(name = "standing_height")
    private int standingHeight;

    @Column(name = "sitting_height")
    @Enumerated(value = EnumType.STRING)
    private SittingHeight sittingHeight;

    @Builder
    public Height(int standingHeignt, SittingHeight sittingHeight){
        this.standingHeignt = standingHeignt;
        this.sittingHeight = sittingHeight;
    }
}
