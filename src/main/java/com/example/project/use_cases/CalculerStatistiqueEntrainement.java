package com.example.project.use_cases;

import com.example.project.models.*;

import java.util.List;
import java.util.stream.Collectors;

public class CalculerStatistiqueEntrainement {

    AbsenceRepository absenceRepository;

    public List<StatistiqueEntrainement> calcul(List<Joueur> joueurs ) {
        return joueurs.stream().map(joueur -> {
             int absences = absenceRepository.recupereNombreAbsenceDunJoueur(joueur.id);

        }).collect(Collectors.toList());
    }

    public double calculTauxPresence(Joueur joueur, List<Entrainement> entrainements) {

    }

}
