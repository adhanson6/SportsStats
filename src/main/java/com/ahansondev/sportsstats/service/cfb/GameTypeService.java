package com.ahansondev.sportsstats.service.cfb;

import com.ahansondev.sportsstats.model.cfb.GameType;

import java.util.Optional;

public interface GameTypeService {

    public Optional<GameType> getGameTypeById(int id);

}
