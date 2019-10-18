package com.ahansondev.sportsstats.service.cfb.impl;

import com.ahansondev.sportsstats.model.cfb.GameType;
import com.ahansondev.sportsstats.repository.cfb.GameTypeRepository;
import com.ahansondev.sportsstats.service.cfb.GameTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameTypeServiceImpl implements GameTypeService {

    @Autowired
    private GameTypeRepository gameTypeRepository;

    @Override
    public Optional<GameType> getGameTypeById(int id) {
        return gameTypeRepository.findById((long) id);
    }
}
