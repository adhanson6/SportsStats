package com.ahansondev.sportsstats.repository.cfb;

import com.ahansondev.sportsstats.model.cfb.TeamGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamGameRepository extends JpaRepository<TeamGame, Long>{

}
