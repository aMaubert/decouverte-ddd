package com.example.project.models;

import java.util.Map;

public class StatistiqueMatch {

    private Map<MatchPeriod, Map<FaitDeJeuType, Integer>> statsParFaitsDeJeu;

    public StatistiqueMatch(Map<MatchPeriod, Map<FaitDeJeuType, Integer>> statsParFaitsDeJeu) {
        this.statsParFaitsDeJeu = statsParFaitsDeJeu;
    }
}
