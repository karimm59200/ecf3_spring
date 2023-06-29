package com.example.ecf3springspringdata.service;

import com.example.ecf3springspringdata.entity.Game;
import com.example.ecf3springspringdata.entity.Tournament;
import com.example.ecf3springspringdata.entity.User;
import com.example.ecf3springspringdata.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private LoginService loginService;

    @Autowired
    private GameRepository gameRepository;

    public boolean createGame(String name, Tournament tournament, List<User> users) {
        if (loginService.isLogged()) {
            gameRepository.save(new Game(name, tournament, users));
            return true;
        }
        return false;
    }

    public List<Game> getAllGames() {
        return (List<Game>) gameRepository.findAll();
    }



}
