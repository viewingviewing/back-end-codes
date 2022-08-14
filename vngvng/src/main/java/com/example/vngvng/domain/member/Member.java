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

@Table(name = "Member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

    @Id //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false, length = 50, columnDefinition = "varchar")
    private String id;

    @Column(name = "member_name", nullable = false, length = 50, columnDefinition = "nvarchar")
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

    @Column(name = "standing_height")
    private int standingHeight;


    @Column(name = "sitting_height", columnDefinition = "String")
    @Enumerated(value = EnumType.STRING)
    private SittingHeight sittingHeight;

    @OneToMany(mappedBy = "member")
    private List<Review> reviews = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Scrap> scraps = new ArrayList<>();

    public void update(boolean wearGlasses, int standingHeight, SittingHeight sittingHeight){
        this.wearGlasses = wearGlasses;
        this.standingHeight = standingHeight;
        this.sittingHeight = sittingHeight;
    }

    @Builder
    public Member(String id, String name, String nickName, String email){
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.email = email;
    }

}