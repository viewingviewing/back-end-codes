package com.example.vngvng.domain.review;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Evaluation {
    @Column(name = "view")
    private float evalView;
    @Column(name = "convenience")
    private float evalConvenience;
    @Column(name = "sound")
    private float evalSound;
}
