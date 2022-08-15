package com.example.vngvng.domain.review;

import com.example.vngvng.domain.member.Member;
import com.example.vngvng.domain.member.MemberRepository;
import com.example.vngvng.domain.review.dto.ReviewCreateRequestDto;
import com.example.vngvng.domain.review.dto.ReviewResponseDto;
import com.example.vngvng.domain.review.dto.ReviewUpdateRequestDto;
import com.example.vngvng.domain.scrap.Scrap;
import com.example.vngvng.domain.scrap.ScrapRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final ScrapRepository scrapRepository;

    @Transactional //C
    public Long postReview(ReviewCreateRequestDto requestDto) {
        return reviewRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional //R
    public ReviewResponseDto findById(Long id) {
        Review entity = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 리뷰입니다 id=" + id));
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
    public Long deleteReview(Long id) {
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
    //scrap 목록 가져오기

    //scrap 및 취소 기능
    public void reviewScrap(Long reviewId, String memberId) {
        Review review = reviewRepository.findById(reviewId).get();
        Member member = memberRepository.findById(memberId).get();
        Optional<Scrap> byReviewAndMember = scrapRepository.findByReviewAndMember(review, member);

        byReviewAndMember.ifPresentOrElse(
                scrap -> { // 이미 스크랩 한 리뷰 -> 스크랩 삭제
                    scrapRepository.delete(scrap);
                    review.discountScrap(scrap);
                },
                () -> {    // 스크랩 안 한 리뷰 -> 스크랩 추가
                    Scrap scrap = Scrap.builder().build();
                    scrap.mappingReview(review);
                    scrap.mappingMember(member);
                    review.updateScrapCount();

                    scrapRepository.save(scrap);
                }
        );
    }
}

