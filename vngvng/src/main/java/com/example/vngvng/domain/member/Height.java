package com.example.vngvng.domain.member;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

public class Height {
    @Column(name = "standing_height")
    private int standingHeight;
    @Column(name = "sitting_height")
    private SittingHeight sittingHeight;

    @Builder
    public Height(int standingHeignt, SittingHeight sittingHeight){
        this.standingHeight = standingHeignt;
        this.sittingHeight = sittingHeight;
    }
}
