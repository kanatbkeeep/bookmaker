package com.example.bookmaker.controllers;

import com.example.bookmaker.entity.Matches;
import com.example.bookmaker.models.MatchesRequest;
import com.example.bookmaker.services.BetService;
import com.example.bookmaker.services.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matches")
public class MatchesController {
    private MatchesService matchesService;
    private BetService betService;

    @Autowired
    public MatchesController(MatchesService matchesService, BetService betService) {
        this.matchesService = matchesService;
        this.betService = betService;
    }

    @PostMapping("/add")
    public ResponseEntity addMatch(@RequestBody MatchesRequest matchesRequest) {
        boolean result = matchesService.addMatches(matchesRequest);
        if (result) {
            return new ResponseEntity("match created", HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().body("bad request");
    }

    @PostMapping("/updateCoefficient")
    public ResponseEntity updateCoefficient(@RequestParam Integer id, double coefficient1, double coefficient2) {
        if (matchesService.findMatch(id) == null) {
            return ResponseEntity.badRequest().body("incorrect id");
        }

        matchesService.updateCoefficient(id, coefficient1, coefficient2);
        return ResponseEntity.ok("Updated");
    }

    @PostMapping("/finish")
    public ResponseEntity finishMatch(@RequestParam Integer id, String wonTeam) {
        Matches match = matchesService.findMatch(id);
        betService.finishBet(id, wonTeam);
        if(match != null && matchesService.finishMatches(id)) {
            return ResponseEntity.ok("finished");
        }

        return ResponseEntity.badRequest().body("bad request");
    }

}
