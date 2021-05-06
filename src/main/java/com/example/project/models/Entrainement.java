package com.example.project.models;

import java.util.List;

public class Entrainement extends Identifier {
    List<Joueur> joueurs;

    public Entrainement(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }
}
