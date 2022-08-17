package com.example.vngvng.domain.casts;

import com.example.vngvng.domain.artist.Artist;
import com.example.vngvng.domain.show.Show;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "casts")
@Getter
@NoArgsConstructor
//@IdClass(CastsId.class)
public class Casts { //artist-show 간 bridge entity
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    @Builder
    public Casts(Long id, Artist artist, Show show){
        this.id = id;
        this.artist = artist;
        this.show = show;
    }
}
