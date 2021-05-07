package com.example.project.models.statistique.match.faitDeJeu;

import com.example.project.models.Identifier;

public class FaitDeJeu extends Identifier {
    public FaitDeJeuType type;

    public FaitDeJeu(FaitDeJeuType type) {
        this.type = type;
    }
}
