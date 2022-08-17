package com.example.vngvng.domain.review.dto;

import com.example.vngvng.domain.artist.Artist;
import com.example.vngvng.domain.member.Member;
import com.example.vngvng.domain.photoreview.PhotoReview;
import com.example.vngvng.domain.review.Evaluation;
import com.example.vngvng.domain.review.Review;
import com.example.vngvng.domain.review.Seat;
import com.example.vngvng.domain.show.Show;
import com.example.vngvng.domain.venue.Venue;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ReviewCreateRequestDto {
    private Member member;
    private Long reviewId;
    private LocalDateTime writeTime;
    private Seat seatInfo;
    //private Artist artist;
    private Show show;
    private Venue venue;
    private Evaluation evaluation;
    private  String textReview;
//    private List<PhotoReview> photoReviews;

    @Builder
    public ReviewCreateRequestDto(Member member, Long reviewId, LocalDateTime writeTime, Seat seatInfo, Show show, Venue venue, Evaluation evaluation, String textReview, List<PhotoReview> photoReviews){
        this.member = member;
        this.reviewId = reviewId;
        this.writeTime = writeTime;
        this.seatInfo = seatInfo;
        //this.artist = artist;
        this.show = show;
        this.venue = venue;
        this.evaluation = evaluation;
        this.textReview = textReview;
//        this.photoReviews = photoReviews;
    }

    public Review toEntity() {
        return Review.builder()
                .member(member)
                .writeTime(writeTime)
                .seatInfo(seatInfo)
                //.artist(artist)
                .show(show)
                .venue(venue)
                .evaluation(evaluation)
                .textReview(textReview)
//                .photoReviews(photoReviews)
                .build();
    }
}
