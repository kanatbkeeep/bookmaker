package com.example.bookmaker.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Matches")
@Getter
@Setter
@NoArgsConstructor
public class Matches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstTeamName;
    private String secondTeamName;
    private double firstTeamCoefficient;
    private double secondTeamCoefficient;

    public Matches(String firstTeamName, String secondTeamName, double firstTeamCoefficient, double secondTeamCoefficient) {
        this.firstTeamName = firstTeamName;
        this.secondTeamName = secondTeamName;
        this.firstTeamCoefficient = firstTeamCoefficient;
        this.secondTeamCoefficient = secondTeamCoefficient;
    }
}
