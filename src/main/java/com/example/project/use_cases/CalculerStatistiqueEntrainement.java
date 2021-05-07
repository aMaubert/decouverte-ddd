package com.example.project.use_cases;

import com.example.project.models.AbsenceRepository;
import com.example.project.models.Entrainement;
import com.example.project.models.EntrainementRepository;
import com.example.project.models.statistique.joueur.*;
import com.example.project.models.statistique.joueur.StatistiqueEntrainement;
import com.example.project.models.statistique.Statistiques;

import java.util.List;


public class CalculerStatistiqueEntrainement {

    private final AbsenceRepository absenceRepository;
    private final EntrainementRepository entrainementRepository;

    public CalculerStatistiqueEntrainement(AbsenceRepository absenceRepository, EntrainementRepository entrainementRepository) {
        this.absenceRepository = absenceRepository;
        this.entrainementRepository = entrainementRepository;
    }

    public List<StatistiqueEntrainement> calculStatistiques(List<Joueur> joueurs ) {
        List<Absence> absences = absenceRepository.recupereLesAbsences();
        List<Entrainement> entrainements = entrainementRepository.recupereLesEntrainement();

        return new Statistiques().computeStatistiquesEntrainements(joueurs, entrainements, absences);
    }
}
