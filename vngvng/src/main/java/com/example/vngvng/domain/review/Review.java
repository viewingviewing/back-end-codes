package com.example.vngvng.domain.review;

import com.example.vngvng.domain.artist.Artist;
import com.example.vngvng.domain.member.Member;
import com.example.vngvng.domain.photoreview.PhotoReview;
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

@Table(name = "Review")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @Column(name = "writeTime", nullable = false)
    private LocalDateTime writeTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Embedded
    private Seat seat;

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

    @Column(name = "text_review", nullable = false, columnDefinition = "varchar")
    private String textReview;  //서술형 후기

    @OneToMany(
            mappedBy = "review",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true
    )
    private List<PhotoReview> photoReviews = new ArrayList<>();

    @Builder
    public Review(Member member,  LocalDateTime writeTime, Seat seat, Artist artist, Show show, Venue venue, Evaluation evaluation, String textReview, List<PhotoReview> photoReviews){
        this.member = member;
        this.writeTime = writeTime;
        this.seat = seat;
        this.artist = artist;
        this.show = show;
        this.venue = venue;
        this.evaluation = evaluation;
        this.textReview = textReview;
        this.photoReviews = photoReviews;
    }

    public void reviewUpdate(Show show, Venue venue, Artist artist, String textReview, List<PhotoReview> photoReviews, Evaluation evaluation, Seat seat){
        this.seat = seat;
        this.artist = artist;
        this.show = show;
        this.venue = venue;
        this.evaluation = evaluation;
        this.textReview = textReview;
        this.photoReviews = photoReviews;
    }
}
