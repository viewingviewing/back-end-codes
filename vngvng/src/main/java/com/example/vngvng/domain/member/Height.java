package com.example.vngvng.domain.member;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Height {
    @Column(name = "standing_height")
    private int standingHeight;

    @Column(name = "sitting_height")
    @Enumerated(value = EnumType.STRING)
    private SittingHeight sittingHeight;

    @Builder
    public Height(int standingHeight, SittingHeight sittingHeight){
        this.standingHeight = standingHeight;
        this.sittingHeight = sittingHeight;
    }

    public Height() {

    }
}
