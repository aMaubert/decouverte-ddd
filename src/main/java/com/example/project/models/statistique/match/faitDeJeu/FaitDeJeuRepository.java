package com.example.project.models.statistique.match.faitDeJeu;

import com.example.project.models.statistique.match.faitDeJeu.FaitDeJeu;

import java.util.List;

public interface FaitDeJeuRepository {

    List<FaitDeJeu> recupereFaitDeJeuParIdDeMatch(int matchId);
}
