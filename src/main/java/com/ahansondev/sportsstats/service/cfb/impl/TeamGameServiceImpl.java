package com.ahansondev.sportsstats.service.cfb.impl;

import com.ahansondev.sportsstats.model.cfb.TeamGame;
import com.ahansondev.sportsstats.repository.cfb.TeamGameRepository;
import com.ahansondev.sportsstats.service.cfb.TeamGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamGameServiceImpl implements TeamGameService {

    @Autowired
    TeamGameRepository teamGameRepository;

    @Override
    public List<TeamGame> getAllTeamGames() {
        return teamGameRepository.findAll();
    }

    @Override
    public TeamGame saveTeamGame(TeamGame teamGame) {
        return teamGameRepository.save(teamGame);
    }

}
