package com.wyeben.musiz05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity()
@Data
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int songId;
    @Column(name = "songTitle")
    @JsonProperty("songTitle")
    private String songTitle;
    @Column(name = "artisteName")
    @JsonProperty("artisteName")
    private String artisteName;
    @Column(updatable = true)
    private String lastUpdate;
}
