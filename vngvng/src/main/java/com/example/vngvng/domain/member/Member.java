package com.example.vngvng.domain.member;

import com.example.vngvng.domain.review.Review;
import com.example.vngvng.domain.scrap.Scrap;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Table(name = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

    @Id //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 50, columnDefinition = "varchar")
    private String id;

    @Column(name = "name", nullable = false, length = 50, columnDefinition = "nvarchar")
    private String name;

    @Column(name = "nickname", nullable = false, unique = true, length = 50, columnDefinition = "nvarchar")
    private String nickName;

    @Column(name = "email", unique = true, length = 50, columnDefinition = "varchar")
    private String email;

    @Column(name = "birthday", columnDefinition = "LocalDate")
    private LocalDate birthday;

    @Column(name = "gender", columnDefinition = "char")
    private String gender;

    @Column(name = "glasses", columnDefinition = "boolean")
    private boolean wearGlasses;

    @Embedded
    private Height height;

    @OneToMany(mappedBy = "member", cascade = ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Scrap> scraps = new ArrayList<>();

    public void update(boolean wearGlasses, Height height){
        this.wearGlasses = wearGlasses;
        this.height = height;
    }

    @Builder
    public Member(String id, String name, String nickName, String email){
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.email = email;
    }

    public void mappingScrap(Scrap scrap){
        this.scraps.add(scrap);
    }

}