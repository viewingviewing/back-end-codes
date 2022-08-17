package com.example.vngvng.domain.review.dto;

import com.example.vngvng.domain.artist.Artist;
import com.example.vngvng.domain.photoreview.PhotoReview;
import com.example.vngvng.domain.review.Evaluation;
import com.example.vngvng.domain.review.Seat;
import com.example.vngvng.domain.show.Show;
import com.example.vngvng.domain.venue.Venue;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ReviewUpdateRequestDto {
    private Show show;
    private Venue venue;
    //private Artist artist;
    private String textReview;
    private List<PhotoReview> photoReviews;
    private Evaluation evaluation;
    private Seat seat;

    private Long scrapCount;

    @Builder
    public ReviewUpdateRequestDto(Show show, Venue venue, String textReview, List<PhotoReview> photoReviews, Evaluation evaluation, Seat seat, Long scrapCount) {
        this.seat = seat;
        //this.artist = artist;
        this.show = show;
        this.venue = venue;
        this.evaluation = evaluation;
        this.textReview = textReview;
        this.photoReviews = photoReviews;
        this.scrapCount = scrapCount;
    }

    public void reviewUpdate(Show show, Venue venue, String textReview, List<PhotoReview> photoReviews, Evaluation evaluation, Seat seat){
        this.seat = seat;
        //this.artist = artist;
        this.show = show;
        this.venue = venue;
        this.evaluation = evaluation;
        this.textReview = textReview;
        this.photoReviews = photoReviews;
    }
}
