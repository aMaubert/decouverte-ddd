package com.example.project.use_cases;

import com.example.project.models.FaitDeJeu;
import com.example.project.models.FaitDeJeuRepository;
import com.example.project.models.Match;
import com.example.project.models.StatistiqueMatch;

import java.util.List;
import java.util.stream.Collectors;

public class CalculerStatistiquesMatch {

    FaitDeJeuRepository faitDeJeuRepository;

    public List<StatistiqueMatch> calcul(List<Match> matchs ) {
        return matchs.stream().map(match -> {
            List<FaitDeJeu> faitDeJeuList = faitDeJeuRepository.recupereFaitDeJeuParIdDeMatch(match.id);
        }).collect(Collectors.toList());
    }


}
