package com.example.ecf3springspringdata.repository;

import com.example.ecf3springspringdata.entity.Tournament;
import org.springframework.data.repository.CrudRepository;

public interface TournamentRepository  extends CrudRepository<Tournament, Long> {
    boolean existsTournamentByName(String name);

    void deleteTournamentByName(String name);


}
