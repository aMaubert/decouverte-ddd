package com.example.project.use_cases;

import com.example.project.models.Joueur;

import java.util.List;

public class CalculerStatistiqueEntrainement {

    public List<StatistiqueEntrainement> calcul( List<Joueur> joueurs ) {
        return joueurs.stream().map(joueur -> {

        } );
    }

    public double calculTauxPresence(Joueur joueur, List<Entrainement> entrainements) {

    }

}
