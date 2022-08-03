package com.example.vngvng.domain.scrap;

import com.example.vngvng.domain.member.Member;
import com.example.vngvng.domain.review.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "Scrap")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity

public class Scrap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    private Date scrapDate; //스크랩 날짜.

    @Builder
    public Scrap(Member member, Review review){
        this.member = member;
        this.review = review;
    }
}
