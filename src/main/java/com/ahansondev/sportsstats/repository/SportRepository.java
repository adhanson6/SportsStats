package com.ahansondev.sportsstats.repository;

import com.ahansondev.sportsstats.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This class is responsible for retrieving the data stored in the database for the {@link Sport} object.
 * @version 0.0.1
 * @author Alex Hanson
 */
@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {

}
