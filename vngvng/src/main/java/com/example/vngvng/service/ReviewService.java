package com.example.vngvng.service;

import com.example.vngvng.DTO.review.PostReviewRequestDto;
import com.example.vngvng.DTO.review.UpdateReviewRequestDto;
import com.example.vngvng.domain.review.Review;
import com.example.vngvng.domain.review.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public Long postReview(PostReviewRequestDto requestDto) {
        return reviewRepository.save(requestDto.toEntity()).getId();
    }

    public Long updateReview(Long id, UpdateReviewRequestDto requestDto) {
        Review review = ReviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 리뷰가 존재하지 않습니다."));
        review.reviewUpdate(requestDto.getShow(),
                requestDto.getVenue(),
                requestDto.getArtist(),
                requestDto.getTextReview(),
                requestDto.getPhotoReviews(),
                requestDto.getEvaluation(),
                requestDto.getSeat());
        return id;
    }
}
