package com.ahansondev.sportsstats.repository.cfb;

import com.ahansondev.sportsstats.model.cfb.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {

    @Query("SELECT s FROM Season s WHERE s.season = ?1")
    Optional<Season> findByYear(String year);

}
