package com.example.vngvng.domain.review;

import com.example.vngvng.domain.artist.Artist;
import com.example.vngvng.domain.member.Member;
import com.example.vngvng.domain.photoreview.PhotoReview;
import com.example.vngvng.domain.show.Show;
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
    public Review(Seat floor, Seat seat, Evaluation evaluation){
        this.seat = seat;
        this.evaluation = evaluation;
    }

}
