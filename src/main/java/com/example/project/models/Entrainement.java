package com.example.project.models;

import com.example.project.models.Identifier;
import com.example.project.models.statistique.joueur.Joueur;

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
