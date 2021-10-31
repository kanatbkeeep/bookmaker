package com.example.bookmaker.services;


import com.example.bookmaker.entity.Bet;
import com.example.bookmaker.entity.User;
import com.example.bookmaker.repository.BetRepository;
import com.example.bookmaker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetService {
    @Autowired
    private BetRepository BetRepository;
    @Autowired
    private UserRepository UserRepository;

    public boolean addBet(Bet bet) {
        User user = UserRepository.findById(bet.getUserId().longValue()).orElse(null);
        user.setBalance(user.getBalance() - bet.getBetMoney());
        UserRepository.save(user);
        if (bet == null) return false;
        BetRepository.save(bet);
        return true;
    }

    public void finishBet(int matchId, String wonTeam) {
        List<Bet> bets = BetRepository.findByMatchId(matchId);
        for (int i = 0; i < bets.size(); i++) {
            if(bets.get(i).getTeamName().equals(wonTeam)) {
                User user = UserRepository.findById(bets.get(i).getUserId().longValue()).orElse(null);
                float balance = user.getBalance();
                balance += (bets.get(i).getBetMoney() * bets.get(i).getCoefficient());
                user.setBalance(balance);
            }
        }
    }
}
