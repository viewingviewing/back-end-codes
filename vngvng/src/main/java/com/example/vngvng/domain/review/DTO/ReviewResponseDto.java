package com.example.vngvng.domain.review.DTO;

import com.example.vngvng.domain.artist.Artist;
import com.example.vngvng.domain.member.Member;
import com.example.vngvng.domain.review.Evaluation;
import com.example.vngvng.domain.review.Review;
import com.example.vngvng.domain.review.Seat;
import com.example.vngvng.domain.show.Show;
import com.example.vngvng.domain.venue.Venue;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ReviewResponseDto {
    private Member writer;
    private Show show;
    private Artist artist;
    private Venue venue;
    private Seat seat;

    private Evaluation evaluation;
    private String textReview;

    @Builder
    public ReviewResponseDto(Review entity){
        this.artist = entity.getArtist();
        this.evaluation = entity.getEvaluation();
        this.show = entity.getShow();
        this.textReview = entity.getTextReview();
        this.venue = entity.getVenue();
        this.writer = entity.getMember();
        this.seat = entity.getSeat();
    }
}
