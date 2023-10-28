package com.wyeben.musiz05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Entity()
@Data
@Component
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int songId;
    private String songTitle;
    private String artistName;
    private String lastUpdate;
}
