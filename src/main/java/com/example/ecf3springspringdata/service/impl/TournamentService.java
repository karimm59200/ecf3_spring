package com.example.ecf3springspringdata.service.impl;

import com.example.ecf3springspringdata.entity.Tournament;
import com.example.ecf3springspringdata.repository.TournamentRepository;
import com.example.ecf3springspringdata.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TournamentService {

    @Autowired
    LoginService loginService;

    @Autowired
    TournamentRepository tournamentRepository;


    public boolean createTournament(String name) {

        if (loginService.isLogged()) {
            if (loginService.isAdmin()) {
                if (!tournamentRepository.existsTournamentByName(name)) {
                    tournamentRepository.save(new Tournament(name));
                    return true;
                }
            }

        }
        return false;
    }

    public boolean deleteTournament(String name) {
        if (loginService.isLogged()) {
            if (loginService.isAdmin()) {
                if (tournamentRepository.existsTournamentByName(name)) {
                    tournamentRepository.deleteTournamentByName(name);
                    return true;
                }
            }
        }
        return false;
    }


}
