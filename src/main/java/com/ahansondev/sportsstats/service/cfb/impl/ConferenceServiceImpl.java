package com.ahansondev.sportsstats.service.cfb.impl;

import com.ahansondev.sportsstats.model.cfb.Conference;
import com.ahansondev.sportsstats.repository.cfb.ConferenceRepository;
import com.ahansondev.sportsstats.service.cfb.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation file of the {@link ConferenceRepository} interface.
 * @version 0.0.1
 * @author Alex Hanson
 */
@Service
public class ConferenceServiceImpl implements ConferenceService {

    @Autowired
    ConferenceRepository conferenceRepository;

    /**
     * {@InheritDoc}
     */
    @Override
    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }

}
