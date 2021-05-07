package com.example.project.models;

import java.util.List;

public class StatistiqueEntrainement {

    private final Joueur joueur;
    private final List<Absence> absences;
    private final List<Entrainement> entrainements;
    private double tauxAbsences ;


    public StatistiqueEntrainement(Joueur joueur, List<Absence> absences, List<Entrainement>  entrainements) {
        this.joueur = joueur;
        this.absences = absences;
        this.entrainements = entrainements;
        this.tauxAbsences = 0.0;
    }

    public StatistiqueEntrainement computeStatistiqueUnJoueur() {
        var statistiqueEntrainement = new StatistiqueEntrainement(this.joueur, this.absences, this.entrainements);
        long nbAbsencesDuJoueur = this.joueur.recupererMonNombreDAbsences(absences);
        long nbEntrainement = this.joueur.recupererMonNombreDEntrainments(entrainements);
        statistiqueEntrainement.setTauxAbsences(nbAbsencesDuJoueur, nbEntrainement);
        return statistiqueEntrainement;
    }

    public double getTauxAbsences() {
        return tauxAbsences;
    }

    public void setTauxAbsences(long nbAbsencesDuJoueur, long nbEntrainement) {
        if (nbEntrainement == 0) throw new IllegalArgumentException("Le nombre d'entrainements doit être plus grand que 0");
        else if (nbAbsencesDuJoueur > nbEntrainement) throw new IllegalArgumentException("Le nombre d'entrainements ne peut pas être inférieur au nombre d'absences");
        else if (nbAbsencesDuJoueur < 0) throw new IllegalArgumentException("Le nombre d'absences ne doit pas être négative");
        this.tauxAbsences = (double) nbAbsencesDuJoueur / nbEntrainement;
    }
}
