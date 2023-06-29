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
public class User {

    @Id
    @GeneratedValue (strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private boolean isAdmin = false;



    private String password;

    private int result;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_tournament", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tournament_id"))
    List<Tournament> tournaments;

    @ManyToMany (cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_game", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private List<Game> games;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

//    public User(User user) {
//        this.name = user.getName();
//        this.password = user.getPassword();
//        this.email = user.getEmail();
//        this.isAdmin = user.isAdmin();
//        this.result = user.getResult();
//        this.tournaments = user.getTournaments();
//        this.games = user.getGames();
//    }
}
