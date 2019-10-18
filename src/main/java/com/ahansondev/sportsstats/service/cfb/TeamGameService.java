package com.ahansondev.sportsstats.service.cfb;

import com.ahansondev.sportsstats.model.cfb.TeamGame;

import java.util.List;

public interface TeamGameService {

    public List<TeamGame> getAllTeamGames();

    public TeamGame saveTeamGame(TeamGame teamGame);
}
