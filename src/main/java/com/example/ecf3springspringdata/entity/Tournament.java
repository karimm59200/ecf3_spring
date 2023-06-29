package com.example.ecf3springspringdata.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tournament {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToMany(mappedBy = "tournaments")
    List<User> users;

    @OneToMany ( fetch = FetchType.LAZY, mappedBy = "tournament")
    private List<Game> games;

    public Tournament(String name) {
        this.name = name;
    }
}
