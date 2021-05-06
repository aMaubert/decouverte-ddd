package com.example.project.use_cases;

import com.example.project.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CalculerStatistiqueEntrainement {

    private final AbsenceRepository absenceRepository;
    private final EntrainementRepository entrainementRepository;

    public CalculerStatistiqueEntrainement(AbsenceRepository absenceRepository, EntrainementRepository entrainementRepository) {
        this.absenceRepository = absenceRepository;
        this.entrainementRepository = entrainementRepository;
    }

    public List<StatistiqueEntrainement> calculStatistiques( List<Joueur> joueurs ) {
//        List<Integer> joueurIds = joueurs.stream()
//                                         .map(joueur -> joueur.id)
//                                         .collect(Collectors.toList());

        List<Absence> absences = absenceRepository.recupereLesAbsences();
        List<Entrainement> entrainements = entrainementRepository.recupereLesEntrainement();

        List<StatistiqueEntrainement> statistiqueEntrainements = new ArrayList<>();

        for (Joueur joueur : joueurs) {
            long nbAbsencesDuJoueur = joueur.recupererMonNombreDAbsences(absences);
            long nbEntrainement = joueur.recupererMonNombreDEntrainments(entrainements);
            var statistiqueEntrainement =  computeStatistiqueUnJoeur( joueur, nbAbsencesDuJoueur, nbEntrainement);
            statistiqueEntrainements.add(statistiqueEntrainement);
        }

        return statistiqueEntrainements;

    }

    private StatistiqueEntrainement computeStatistiqueUnJoeur(Joueur joueur, long nbAbsences, long nbEntrainement) {
        if (nbEntrainement == 0) throw new IllegalArgumentException("Le nombre d'entrainements doit être plus grand que 0");
        else if (nbAbsences > nbEntrainement) throw new IllegalArgumentException("Le nombre d'entrainements ne peut pas être inférieur au nombre d'absences");
        else if (nbAbsences < 0) throw new IllegalArgumentException("Le nombre d'absences ne doit pas être négative");
        double taux = (double) nbAbsences / nbEntrainement;
        return new StatistiqueEntrainement(joueur, taux);
    }


}
