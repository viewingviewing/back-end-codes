package com.example.vngvng.domain.scrap;
import com.example.vngvng.domain.member.Member;
import com.example.vngvng.domain.review.Review;
import com.example.vngvng.domain.scrap.DTO.ScrapDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ScrapRepository extends JpaRepository<Scrap, Long> {
//    ScrapDto getReviewScrapVal(String scrapId);
//
//    void setReviewScrap(ScrapDto scrapDto);
//
//    int reviewScrapCancel(ScrapDto scrapDto);
    Optional<Scrap> findByReviewAndMember(Review review, Member member);

}
