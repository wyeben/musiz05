package com.wyeben.musiz05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Entity()
@Data
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int actorId;
    @Column(name = "firstName")
    @JsonProperty("firstName")
    private String firstName;
    @Column(name = "lastName")
    @JsonProperty("lastName")
    private String lastName;
    @Column(updatable = true)
    private String lastUpdate;
}
