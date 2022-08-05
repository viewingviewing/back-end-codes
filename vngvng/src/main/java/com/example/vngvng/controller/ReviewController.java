package com.example.vngvng.controller;

import com.example.vngvng.DTO.review.PostReviewDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @PostMapping
    public Long postReview(@RequestBody PostReviewDto reviewDto){
        public Long
    }
}
