package com.example.project.models.statistique.joueur;

public class StatistiqueEntrainement {


    private final int joueurId;
    private final long nbAbsences;
    private final long nbEntrainements;
    private final double tauxAbsence;

    public StatistiqueEntrainement(int joueurId, long nbAbsences, long  nbEntrainements) {
        this.joueurId = joueurId;
        this.nbAbsences = nbAbsences;
        this.nbEntrainements = nbEntrainements;
        this.tauxAbsence = this.computeTauxAbsence();
    }

    private double computeTauxAbsence() {
        if (this.nbEntrainements == 0) throw new IllegalArgumentException("Le nombre d'entrainements doit être plus grand que 0");
        else if (this.nbAbsences >this.nbEntrainements) throw new IllegalArgumentException("Le nombre d'entrainements ne peut pas être inférieur au nombre d'absences");
        else if (this.nbAbsences < 0) throw new IllegalArgumentException("Le nombre d'absences ne doit pas être négative");
        return (double) this.nbAbsences / this.nbEntrainements;
    }

    public int getJoueurId() {
        return joueurId;
    }

    public long getNbAbsences() {
        return nbAbsences;
    }

    public long getNbEntrainements() {
        return nbEntrainements;
    }

    public double getTauxAbsence() {
        return tauxAbsence;
    }
}
