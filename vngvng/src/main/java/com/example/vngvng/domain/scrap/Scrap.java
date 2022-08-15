package com.example.vngvng.domain.scrap;

import com.example.vngvng.domain.member.Member;
import com.example.vngvng.domain.review.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Table(name = "Scrap")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity

public class Scrap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    private LocalDateTime scrapTime; //스크랩 날짜

    @Builder
    public Scrap(Member member, Review review, LocalDateTime scrapTime){
        this.member = member;
        this.review = review;
        this.scrapTime = scrapTime;
    }

    public void mappingReview(Review review){
        this.review = review;
        member.mappingScrap(this);
    }

    public void mappingMember(Member member){
        this.member = member;
        member.mappingScrap(this);
    }

    public static boolean isScrapedReview(Optional<Scrap> optionalScrap){
        return optionalScrap.isPresent();
    }

}
