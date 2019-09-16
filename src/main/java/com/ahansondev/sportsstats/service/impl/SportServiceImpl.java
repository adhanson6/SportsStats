package com.ahansondev.sportsstats.service.impl;

import com.ahansondev.sportsstats.model.Sport;
import com.ahansondev.sportsstats.repository.SportRepository;
import com.ahansondev.sportsstats.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation file of the {@link SportService} interface.
 * @version 0.0.1
 * @author Alex Hanson
 */
@Service
public class SportServiceImpl implements SportService {

    @Autowired
    SportRepository sportRepository;

    /**
     * {@InheritDoc}
     */
    @Override
    public List<Sport> getAllSports() {
        return sportRepository.findAll();
    }
}
