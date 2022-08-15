package com.example.vngvng.domain.show;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate; //시간 정보까지 넣을지

@Embeddable
@Getter
public class TimeInfo {
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
}
