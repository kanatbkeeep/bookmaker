package com.example.bookmaker.services;

import com.example.bookmaker.entity.Matches;
import com.example.bookmaker.models.MatchesRequest;
import com.example.bookmaker.repository.MatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchesService {
    @Autowired
    private MatchesRepository MatchesRepository;
    private BetService betService;

    public boolean addMatches(MatchesRequest matchesRequest) {
        Matches matches = new Matches(matchesRequest.getFirstTeamName(), matchesRequest.getSecondTeamName(), matchesRequest.getFirstTeamCoefficient(), matchesRequest.getSecondTeamCoefficient());
        MatchesRepository.save(matches);
        return true;
    }

    public void updateCoefficient(Integer id, double coefficient1, double coefficient2) {
        Matches matches = MatchesRepository.findById(id.longValue()).orElse(null);
        matches.setFirstTeamCoefficient(coefficient1);
        matches.setSecondTeamCoefficient(coefficient2);
        MatchesRepository.save(matches);
    }


    //NEED TO CHANGE IN FUTURE, AFTER CREATING BET CLASSES
    public boolean finishMatches(Integer id) {
        Matches matches = MatchesRepository.findById(id.longValue()).orElse(null);
        MatchesRepository.delete(matches);
        return true;
    }

    public Matches findMatch(Integer id) {
        return MatchesRepository.findById(id.longValue()).orElse(null);
    }
}
