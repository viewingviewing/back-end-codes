package com.example.vngvng.domain.photoreview;

import com.example.vngvng.domain.review.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "photo_review")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter

public class PhotoReview {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @Column(nullable = false)
    private String origFileName;  // 파일 원본명

    @Column(nullable = false)
    private String filePath;  // 파일 저장 경로

    //private Long fileSize;

    @Builder
    public PhotoReview(String origFileName, String filePath){
        this.origFileName = origFileName;
        this.filePath = filePath;
        //this.fileSize = fileSize;
    }
}
