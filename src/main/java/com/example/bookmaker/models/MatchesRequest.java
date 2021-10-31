package com.example.bookmaker.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MatchesRequest {
    private Integer id;
    private String firstTeamName;
    private String secondTeamName;
    private double firstTeamCoefficient;
    private double secondTeamCoefficient;

    public MatchesRequest(String firstTeamName, String secondTeamName, double firstTeamCoefficient, double secondTeamCoefficient) {
        this.firstTeamName = firstTeamName;
        this.secondTeamName = secondTeamName;
        this.firstTeamCoefficient = firstTeamCoefficient;
        this.secondTeamCoefficient = secondTeamCoefficient;
    }

    public MatchesRequest(Integer id, String firstTeamName, String secondTeamName, double firstTeamCoefficient, double secondTeamCoefficient) {
        this.id = id;
        this.firstTeamName = firstTeamName;
        this.secondTeamName = secondTeamName;
        this.firstTeamCoefficient = firstTeamCoefficient;
        this.secondTeamCoefficient = secondTeamCoefficient;
    }

    public MatchesRequest() {
    }

    public String getFirstTeamName() {
        return firstTeamName;
    }

    public void setFirstTeamName(String firstTeamName) {
        this.firstTeamName = firstTeamName;
    }

    public String getSecondTeamName() {
        return secondTeamName;
    }

    public void setSecondTeamName(String secondTeamName) {
        this.secondTeamName = secondTeamName;
    }

    public double getFirstTeamCoefficient() {
        return firstTeamCoefficient;
    }

    public void setFirstTeamCoefficient(double firstTeamCoefficient) {
        this.firstTeamCoefficient = firstTeamCoefficient;
    }

    public double getSecondTeamCoefficient() {
        return secondTeamCoefficient;
    }

    public void setSecondTeamCoefficient(double secondTeamCoefficient) {
        this.secondTeamCoefficient = secondTeamCoefficient;
    }
}
