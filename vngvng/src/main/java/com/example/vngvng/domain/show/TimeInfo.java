package com.example.vngvng.domain.show;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.time.LocalDate; //시간 정보까지 넣을지

@Embeddable
@Getter
public class TimeInfo {
    private LocalDate startDate;
    private LocalDate endDate;
}
