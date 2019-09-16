package com.ahansondev.sportsstats.controller;

import com.ahansondev.sportsstats.model.Sport;
import com.ahansondev.sportsstats.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /**
     * Handles GET requests sent to the /sports path.
     * @return A {@link List} of all {@link Sport} objects stored in the database.
     */
    @GetMapping("/sports")
    public List<Sport> getAllSports() {
        return sportService.getAllSports();
    }
}
