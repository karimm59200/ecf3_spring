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
public class Game {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany (mappedBy = "games")
    private List<User> users;

    @ManyToOne
    @JoinColumn(name = "TOURNAMENT_id")
    private Tournament tournament;

    public Game(String name, Tournament tournament, List<User> users) {
        this.name = name;
        this.tournament = tournament;
        this.users = users;
    }
}
