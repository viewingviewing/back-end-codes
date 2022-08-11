package com.example.vngvng.domain.cast;

import com.example.vngvng.domain.artist.Artist;
import com.example.vngvng.domain.show.Show;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cast")
@Getter
@NoArgsConstructor
public class Cast { //artist-show 간 bridge entity
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
}
