package com.example.vngvng.domain.review;

import com.example.vngvng.domain.artist.Artist;
import com.example.vngvng.domain.member.Member;
import com.example.vngvng.domain.photoreview.PhotoReview;
import com.example.vngvng.domain.scrap.Scrap;
import com.example.vngvng.domain.show.Show;
import com.example.vngvng.domain.venue.Venue;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "review")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "write_time")
    private LocalDateTime writeTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Embedded
    private Seat seatInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id")
    private Show show;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @Embedded
    private Evaluation evaluation;

    @Column(name = "text_review")
    private String textReview;  //서술형 후기

    @OneToMany(
            mappedBy = "review",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true
    )
    private List<PhotoReview> photoReviews = new ArrayList<>();

    @OneToMany(mappedBy = "review")
    private List<Scrap> scraps = new ArrayList<>();
    private Long scrapCount;

    @Builder
    public Review(Member member, Seat seatInfo, Evaluation evaluation, LocalDateTime writeTime, Artist artist, Show show, Venue venue, String textReview, List<PhotoReview> photoReviews){
        this.member = member;
        this.seatInfo = seatInfo;
        this.evaluation = evaluation;
        this.writeTime = writeTime;
        this.artist = artist;
        this.show = show;
        this.venue = venue;
        this.textReview = textReview;
        this.photoReviews = photoReviews;
    }

    public void reviewUpdate(Show show, Venue venue, Artist artist, String textReview, List<PhotoReview> photoReviews, Evaluation evaluation, Seat seatInfo){
        this.seatInfo = seatInfo;
        this.artist = artist;
        this.show = show;
        this.venue = venue;
        this.evaluation = evaluation;
        this.textReview = textReview;
        this.photoReviews = photoReviews;
    }

    public void mappingScrap(Scrap scrap){
        this.scraps.add(scrap);
    }

    public void updateScrapCount(){
        this.scrapCount = (long) this.scraps.size();
    }

    public void discountScrap(Scrap scrap){
        this.scraps.remove(scrap);
    }
}
