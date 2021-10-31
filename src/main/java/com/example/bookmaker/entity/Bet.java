package com.example.bookmaker.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bets")
@Getter
@Setter
@NoArgsConstructor
@Data
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer userId;
    private Integer matchId;
    private String teamName;
    private float coefficient;
    private float betMoney;

    public Bet(int userId, int matchId, String teamName, float coefficient, float betMoney) {
        this.userId = userId;
        this.matchId = matchId;
        this.teamName = teamName;
        this.coefficient = coefficient;
        this.betMoney = betMoney;
    }
}
