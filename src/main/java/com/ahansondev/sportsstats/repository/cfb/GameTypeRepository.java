package com.ahansondev.sportsstats.repository.cfb;

import com.ahansondev.sportsstats.model.cfb.GameType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameTypeRepository extends JpaRepository<GameType, Long>  {

}
