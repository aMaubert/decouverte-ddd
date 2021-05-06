package com.example.project.models;

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
