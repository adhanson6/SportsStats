package com.ahansondev.sportsstats.service.cfb;

import com.ahansondev.sportsstats.model.cfb.Conference;

import java.util.List;

/**
 * The service interface for the Conference Entity. Contains the methods used to access
 * Conference data.
 * @version 0.0.1
 * @author Alex Hanson
 */
public interface ConferenceService {

    /**
     * This method will return all the Sport objects stored in the tables.
     * @return A {@link List} of {@link Conference} stored in the database.
     */
    public List<Conference> getAllConferences();

}
