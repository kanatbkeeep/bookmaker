package com.example.bookmaker.repository;

import com.example.bookmaker.entity.Bet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BetRepository extends CrudRepository<Bet, Long> {
    List<Bet> findByMatchId(int id);
}
