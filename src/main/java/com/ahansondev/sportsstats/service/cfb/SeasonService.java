package com.ahansondev.sportsstats.service.cfb;

import com.ahansondev.sportsstats.model.cfb.Season;

import java.util.List;
import java.util.Optional;

public interface SeasonService {

    public Optional<Season> getSeasonById(int id);

    public Optional<Season> getSeasonByNumber(String year);

    public List<Season> getAllSeasons();
}
