package com.ahansondev.sportsstats.service.cfb.impl;

import com.ahansondev.sportsstats.model.cfb.Season;
import com.ahansondev.sportsstats.repository.cfb.SeasonRepository;
import com.ahansondev.sportsstats.service.cfb.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonServiceImpl implements SeasonService {

    @Autowired
    private SeasonRepository seasonRepository;

    @Override
    public Optional<Season> getSeasonById(int id) {
        return seasonRepository.findById((long) id);
    }

    @Override
    public Optional<Season> getSeasonByNumber(String year) {
        return seasonRepository.findByYear(year);
    }

    @Override
    public List<Season> getAllSeasons() {
        return seasonRepository.findAll();
    }

}
