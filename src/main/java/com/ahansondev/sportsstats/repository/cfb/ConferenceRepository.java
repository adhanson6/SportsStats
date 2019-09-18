package com.ahansondev.sportsstats.repository.cfb;

import com.ahansondev.sportsstats.model.cfb.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This class is responsible for retrieving the data stored in the database for the {@link Conference} object.
 * @version 0.0.1
 * @author Alex Hanson
 */
public interface ConferenceRepository extends JpaRepository<Conference, Long> {

}
