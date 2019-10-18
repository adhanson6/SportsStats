package com.ahansondev.sportsstats.repository.cfb;

import com.ahansondev.sportsstats.model.cfb.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}
