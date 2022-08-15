package com.example.vngvng.domain.member;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable

enum SittingHeight{
    TALL, REGULAR, SHORT
}

public class Height {
    @Column(name = "standing_height")
    private int standingHeignt;
    @Column(name = "sitting_height")
    private SittingHeight sittingHeight;

    @Builder
    public Height(int standingHeignt, SittingHeight sittingHeight){
        this.standingHeignt = standingHeignt;
        this.sittingHeight = sittingHeight;
    }
}
