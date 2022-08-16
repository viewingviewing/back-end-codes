package com.example.vngvng.domain.venue;

import com.example.vngvng.domain.review.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "venue")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Venue {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "name")
    private String name;

    @Column(name = "hall_name")
    private String hallName;

    @Column(name = "img")
    private String venueImg;

    @Column(name = "type")
    private VenueType type;

    @OneToMany(mappedBy = "venue")
    private List<Review> reviews = new ArrayList<>();

    @Column(name = "seat_map")
    private String seatMap;

    @Builder
    public Venue(String zipcode, String name, String hallName, VenueType type, String seatMap){
        this.zipcode = zipcode;
        this.name = name;
        this.hallName = hallName;
        this.type = type;
        this.seatMap = seatMap;
    }
}