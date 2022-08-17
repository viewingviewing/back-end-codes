package com.example.vngvng.domain.artist;

import com.example.vngvng.domain.casts.Casts;
import com.example.vngvng.domain.review.Review;
import com.example.vngvng.domain.show.Show;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "artist")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Artist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "artist")
//    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "artist")
    private List<Casts> casts = new ArrayList<>();

    @Builder
    public Artist(String name){
        this.name = name;
    }
}

