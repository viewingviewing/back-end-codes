package com.example.vngvng.domain.review;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Seat {
    @Column(name = "floor")
    private int floor;
    @Column(name = "seat")
    private String seat;
}
