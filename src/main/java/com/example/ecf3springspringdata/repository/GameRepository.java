package com.example.ecf3springspringdata.repository;

import com.example.ecf3springspringdata.entity.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
    boolean existsGameByName(String name);


}
