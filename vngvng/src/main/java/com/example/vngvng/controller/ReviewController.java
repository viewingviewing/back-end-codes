package com.example.vngvng.controller;

import com.example.vngvng.domain.review.DTO.ReviewCreateRequestDto;
import com.example.vngvng.domain.review.DTO.ReviewResponseDto;
import com.example.vngvng.domain.review.DTO.ReviewUpdateRequestDto;
import com.example.vngvng.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewResponseDto> findAll(){
        return reviewService.findAll();
    }
    @PostMapping
    public Long postReview(@RequestBody ReviewCreateRequestDto requestDto) {
        return reviewService.postReview(requestDto);
    }

    @GetMapping("/{id}")
    public ReviewResponseDto findById(@PathVariable Long id){
        return reviewService.findById(id);
    }

    @PatchMapping("/{id}")
    public Long updateReview(@PathVariable Long id, @RequestBody ReviewUpdateRequestDto requestDto) {
        return reviewService.updateReview(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public Long deleteReview(@PathVariable Long id){
        return reviewService.deleteReview(id);
    }
}
