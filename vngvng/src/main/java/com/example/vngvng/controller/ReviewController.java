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

    @GetMapping("review") //review R -list
    public List<ReviewResponseDto> findAll() {
        return reviewService.findAll();
    }

    @PostMapping("review") //review C
    public Long postReview(@RequestBody ReviewCreateRequestDto requestDto) {
        return reviewService.postReview(requestDto);
    }

    @GetMapping("review/{id}") //review R -객체
    public ReviewResponseDto findById(@PathVariable(name = "id") Long id) {
        return reviewService.findById(id);
    }

    @PatchMapping("review/{id}") //review U
    public Long updateReview(@PathVariable(name = "id") Long id, @RequestBody ReviewUpdateRequestDto requestDto) {
        return reviewService.updateReview(id, requestDto);
    }

    @DeleteMapping("review/{id}")
    public Long deleteReview(@PathVariable(name = "id") Long id) {
        return reviewService.deleteReview(id);
    }
    @PostMapping("review/{id}/scrap") //api 명세 수정하기 //스크랩 추가
    public SuccessResponse<String> reviewScrap(@PathVariable(name = "id") Long reviewId, @RequestBody Long memberId){
        reviewService.reviewScrap(reviewId, memberId);
        return SuccessResponse.success(null);
    }

}
