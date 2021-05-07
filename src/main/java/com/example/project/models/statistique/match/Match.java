package com.example.project.models.statistique.match;

import com.example.project.models.statistique.match.faitDeJeu.FaitDeJeu;
import com.example.project.models.Identifier;

import java.util.List;

public class Match extends Identifier {

    public int id;
    public List<FaitDeJeu> faitsDeJeuList;
    public Equipe equipe;

    public Match(int id, List<FaitDeJeu> faitsDeJeuList, Equipe equipe) {
        this.id = id;
        this.faitsDeJeuList = faitsDeJeuList;
        this.equipe = equipe;
    }
}
