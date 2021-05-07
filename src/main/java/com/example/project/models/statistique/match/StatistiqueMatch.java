package com.example.project.models.statistique.match;

import com.example.project.models.statistique.match.faitDeJeu.MatchPeriod;
import com.example.project.models.statistique.match.faitDeJeu.FaitDeJeuType;

import java.util.Map;

public class StatistiqueMatch {

    private Map<MatchPeriod, Map<FaitDeJeuType, Integer>> statsParFaitsDeJeu;

    public StatistiqueMatch(Map<MatchPeriod, Map<FaitDeJeuType, Integer>> statsParFaitsDeJeu) {
        this.statsParFaitsDeJeu = statsParFaitsDeJeu;
    }
}
