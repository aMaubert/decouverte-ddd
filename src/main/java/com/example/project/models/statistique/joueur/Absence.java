package com.example.project.models.statistique.joueur;

import com.example.project.models.Identifier;
import com.example.project.models.statistique.joueur.Joueur;

public class Absence extends Identifier {
    private Joueur joueur;

    public Absence(Joueur joueur) {
        this.joueur = joueur;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
}
