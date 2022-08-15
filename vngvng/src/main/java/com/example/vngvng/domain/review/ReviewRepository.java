package com.example.vngvng.domain.review;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    //find by show, artist, venue(+seat) 필요
}
