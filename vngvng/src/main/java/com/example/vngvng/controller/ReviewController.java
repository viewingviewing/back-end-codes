package com.example.vngvng.controller;

import com.example.vngvng.DTO.review.PostReviewRequestDto;
import com.example.vngvng.DTO.review.UpdateReviewRequestDto;
import com.example.vngvng.service.ReviewService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public Long postReview(@RequestBody PostReviewRequestDto requestDto) {
        return reviewService.postReview(requestDto);
    }

    @PatchMapping("/{id}")
    public Long updateReview(@PathVariable Long id, @RequestBody UpdateReviewRequestDto requestDto) {
        return reviewService.updateReview(id, requestDto);
    }
