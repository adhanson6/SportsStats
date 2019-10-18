package com.ahansondev.sportsstats.controller;

import com.ahansondev.sportsstats.model.Sport;
import com.ahansondev.sportsstats.model.cfb.*;
import com.ahansondev.sportsstats.service.SportService;
import com.ahansondev.sportsstats.service.cfb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Controller class for requests relating to College Football.
 * @version 0.0.1
 * @author Alex Hanson
 */
@RestController
@RequestMapping("/api/cfb")
public class CFBAPIController {

    @Autowired
    private SportService sportService;

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private TeamGameService teamGameService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private GameTypeService gameTypeService;

    @Autowired
    private SeasonService seasonService;

    /**
     * Handles GET requests sent to the /sports path.
     * @return A {@link List} of all {@link Sport} objects stored in the database.
     */
    @GetMapping("/sports")
    public List<Sport> getAllSports() {
        return sportService.getAllSports();
    }

    /**
     * Handles GET requests sent to the /conferences path.
     * @return A {@link List} of all {@link Conference} objects stored in the database.
     */
    @GetMapping("/conferences")
    public List<Conference> getAllConferences() {
        return conferenceService.getAllConferences();
    }

    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping("/teams")
    public String saveTeam(@RequestParam String schoolName,
                           @RequestParam String mascotName,
                           @RequestParam String teamName,
                           @RequestParam String abbreviation,
                           @RequestParam String primaryColor,
                           @RequestParam String secondaryColor,
                           @RequestParam String tertiaryColor) {
        Team team = new Team();
        team.setSchoolName(schoolName);
        team.setMascotName(mascotName);
        team.setTeamName(teamName);
        team.setAbbreviation(abbreviation);
        team.setPrimaryColor(primaryColor);
        team.setSecondaryColor(secondaryColor);
        team.setTertiaryColor(tertiaryColor);
        team = teamService.saveTeam(team);
        return "Successfully saved the game with an id of " + team.getTeamId();
    }

    @GetMapping("/team/{id}")
    public Optional<Team> getTeamById(@PathVariable("id") int id ) {
        return teamService.getTeamById(id);
    }

    @GetMapping("/gametype/{id}")
    public Optional<GameType> getGameTypeById(@PathVariable("id") int id ) {
        return gameTypeService.getGameTypeById(id);
    }

    @GetMapping("/season/{id}")
    public Optional<Season> getSeasonById(@PathVariable("id") int id ) {
        return seasonService.getSeasonById(id);
    }

    @GetMapping("/season")
    public List<Season> getSeasonByYear(@RequestParam(required = false) String year) {
        if (year != null)
            return Arrays.asList(seasonService.getSeasonByNumber(year).get());
        else
            return seasonService.getAllSeasons();
    }

    @GetMapping("/teamgames")
    public List<TeamGame> getAllTeamGames() {
        return teamGameService.getAllTeamGames();
    }

    @PostMapping("/teamgames")
    public String saveTeamGame(@RequestParam int homeTeamId,
                               @RequestParam int awayTeamId,
                               @RequestParam int gameTypeId,
                               @RequestParam int seasonId,
                               @RequestParam int homeScore,
                               @RequestParam int awayScore,
                               @RequestParam String result,
                               @RequestParam boolean homeFlag,
                               @RequestParam double totalYards,
                               @RequestParam double rushingYards,
                               @RequestParam int rushingAttempts,
                               @RequestParam double passingYards,
                               @RequestParam int passingAttempts,
                               @RequestParam int passingCompletions,
                               @RequestParam double sacks,
                               @RequestParam int penalties) {
        TeamGame tg = new TeamGame();
        tg.setHomeTeamId(teamService.getTeamById(homeTeamId).get());
        tg.setAwayTeamId(teamService.getTeamById(awayTeamId).get());
        tg.setGameTypeId(gameTypeService.getGameTypeById(gameTypeId).get());
        tg.setSeasonId(seasonService.getSeasonById(seasonId).get());
        tg.setHomeScore(homeScore);
        tg.setAwayScore(awayScore);
        tg.setResult(result);
        tg.setHomeFlag(homeFlag);
        tg.setTotalYards(totalYards);
        tg.setRushingYards(rushingYards);
        tg.setRushingAttempts(rushingAttempts);
        tg.setPassingYards(passingYards);
        tg.setPassingAttempts(passingAttempts);
        tg.setPassingCompletions(passingCompletions);
        tg.setSacks(sacks);
        tg.setPenalties(penalties);
        tg = teamGameService.saveTeamGame(tg);
        return "Successfully saved the game with an id of " + tg.getTeamGameId();
    }

}
