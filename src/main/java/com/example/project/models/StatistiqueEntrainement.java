package com.example.project.models;

public class StatistiqueEntrainement {

    private Joueur joueur;
    private double tauxAbsence;


    public StatistiqueEntrainement(Joueur joueur, double tauxAbsence) {
        this.joueur = joueur;
        this.tauxAbsence = tauxAbsence;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public double getTauxAbsence() {
        return tauxAbsence;
    }
}
