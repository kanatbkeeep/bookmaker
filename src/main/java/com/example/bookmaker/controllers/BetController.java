package com.example.bookmaker.controllers;

import com.example.bookmaker.entity.Bet;
import com.example.bookmaker.services.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bets")
public class BetController {
    private BetService betService;
    @Autowired
    public BetController(BetService betService) {
        this.betService = betService;
    }

    @PostMapping("/add")
    public ResponseEntity addBet(@RequestParam Integer userId, Integer matchId, String teamName, float coefficient, float betMoney) {
        Bet bet = new Bet(userId, matchId, teamName, coefficient, betMoney);
        betService.addBet(bet);
        return ResponseEntity.ok("Add matches");
    }
}
