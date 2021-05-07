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
        List<Absence> absences = absenceRepository.recupereLesAbsences();
        List<Entrainement> entrainements = entrainementRepository.recupereLesEntrainement();

        List<StatistiqueEntrainement> statistiqueEntrainements = new ArrayList<>();

        for (Joueur joueur : joueurs) {
            var statistiqueEntrainement = new StatistiqueEntrainement(joueur, absences, entrainements);
            statistiqueEntrainements.add(statistiqueEntrainement.computeStatistiqueUnJoueur());
        }

        return statistiqueEntrainements;

    }





}
