package com.example.project.use_cases;

import com.example.project.models.*;

import java.util.List;
import java.util.stream.Collectors;

public class CalculerStatistiqueEntrainement {

    AbsenceRepository absenceRepository;
    EntrainementRepository entrainementRepository;

    public List<StatistiqueEntrainement> calcul(List<Joueur> joueurs ) {
        return joueurs.stream().map(joueur -> {
             int nbAbsences = absenceRepository.recupereNombreAbsenceDunJoueur(joueur.id);
             int nbEntrainement = entrainementRepository.recupereNombreEntrainement(joueur.id);
             double taux = (double) nbAbsences /  (double) nbEntrainement;
             return new StatistiqueEntrainement(joueur, taux);
        }).collect(Collectors.toList());
    }

}
