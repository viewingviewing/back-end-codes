package com.example.vngvng.service;

import com.example.vngvng.domain.review.DTO.ReviewCreateRequestDto;
import com.example.vngvng.domain.review.DTO.ReviewResponseDto;
import com.example.vngvng.domain.review.DTO.ReviewUpdateRequestDto;
import com.example.vngvng.domain.review.Review;
import com.example.vngvng.domain.review.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Transactional //C
    public Long postReview(ReviewCreateRequestDto requestDto) {
        return reviewRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional //R
    public ReviewResponseDto findById(Long id){
        Review entity = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 리뷰입니다 id="+ id));
        return new ReviewResponseDto(entity);
    }

    @Transactional //U
    public Long updateReview(Long id, ReviewUpdateRequestDto requestDto) {
        Review entity = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 리뷰가 존재하지 않습니다."));

        entity.reviewUpdate(requestDto.getShow(),
                requestDto.getVenue(),
                requestDto.getArtist(),
                requestDto.getTextReview(),
                requestDto.getPhotoReviews(),
                requestDto.getEvaluation(),
                requestDto.getSeat());
        return reviewRepository.save(entity).getId();
    }

    @Transactional //D
    public Long deleteReview(Long id){
        Review entity = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 리뷰입니다."));
        reviewRepository.deleteById(id);
        return entity.getId();
    }

    public List<ReviewResponseDto> findAll() {
        List<Review> reviewList = reviewRepository.findAll();
        log.info(reviewList.toString());

        List<ReviewResponseDto> dtos = new ArrayList<ReviewResponseDto>();

        for (Review review : reviewList) {
            System.out.println(review);
            dtos.add(new ReviewResponseDto(review));
        }
        log.info(dtos.toString());

        return dtos;
    }
    //scrap 및 취소 기능 필요
}
