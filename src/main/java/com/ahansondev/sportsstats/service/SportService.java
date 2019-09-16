package com.ahansondev.sportsstats.service;

import com.ahansondev.sportsstats.model.Sport;

import java.util.List;

/**
 * The service interface for the Sport Entity. Contains the methods used to access
 * Sport data.
 * @version 0.0.1
 * @author Alex Hanson
 */
public interface SportService {

    /**
     * This method will return all the Sport objects stored in the tables.
     * @return A {@link List} of {@link Sport} stored in the database.
     */
    public List<Sport> getAllSports();
}
