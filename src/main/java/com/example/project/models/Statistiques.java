package com.example.project.models;

import java.util.ArrayList;
import java.util.List;

public class Statistiques {


    public List<StatistiqueEntrainement> computeStatistiquesEntrainements(List<Joueur> joueurs, List<Entrainement> entrainements, List<Absence> absences) {
        List<StatistiqueEntrainement> statistiqueEntrainements = new ArrayList<>();

        for (Joueur joueur : joueurs) {
            var statistiqueEntrainement = joueur.computeEntrainement(absences, entrainements);
            statistiqueEntrainements.add(statistiqueEntrainement);
        }

        return statistiqueEntrainements;
    }
}
