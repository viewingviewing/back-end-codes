package com.example.vngvng.controller;

import com.example.vngvng.domain.review.DTO.ReviewCreateRequestDto;
import com.example.vngvng.domain.review.DTO.ReviewResponseDto;
import com.example.vngvng.domain.review.DTO.ReviewUpdateRequestDto;
import com.example.vngvng.service.ReviewService;
import com.example.vngvng.tools.SuccessResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("review")
    public List<ReviewResponseDto> findAll(){
        return reviewService.findAll();
    }
    @PostMapping("review")
    public Long postReview(@RequestBody ReviewCreateRequestDto requestDto) {
        return reviewService.postReview(requestDto);
    }

    @GetMapping("review/{id}")
    public ReviewResponseDto findById(@PathVariable Long id){
        return reviewService.findById(id);
    }

    @PatchMapping("review/{id}")
    public Long updateReview(@PathVariable Long id, @RequestBody ReviewUpdateRequestDto requestDto) {
        return reviewService.updateReview(id, requestDto);
    }
    @PostMapping("review/{id}/scrap") //api 명세 수정하기 //스크랩 추가
    public SuccessResponse<String> reviewScrap(@PathVariable Long reviewId, Long memberId){
        reviewService.reviewScrap(reviewId, memberId);
        return SuccessResponse.success(null);
    }

}
