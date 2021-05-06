package com.example.project;

import com.example.project.mocks.MockAbsenceRepository;
import com.example.project.mocks.MockEntrainementRepository;
import com.example.project.mocks.RepositoryMock;
import com.example.project.models.*;
import com.example.project.use_cases.CalculerStatistiqueEntrainement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculStatistiqueEntrainementTests {

    private static CalculerStatistiqueEntrainement calculerStatistiqueEntrainement;
    private static MockAbsenceRepository mockAbsenceRepository;
    private static MockEntrainementRepository mockEntrainementRepository;
    private static List<Joueur> joueurs;

    @BeforeAll
    public static void setup() {

        CalculStatistiqueEntrainementTests.joueurs = Arrays.asList(new Joueur(1), new Joueur(2), new Joueur(3));

        CalculStatistiqueEntrainementTests.mockAbsenceRepository = new MockAbsenceRepository();
        CalculStatistiqueEntrainementTests.mockEntrainementRepository = new MockEntrainementRepository();


        CalculStatistiqueEntrainementTests.calculerStatistiqueEntrainement = new CalculerStatistiqueEntrainement(
                CalculStatistiqueEntrainementTests.mockAbsenceRepository,
                CalculStatistiqueEntrainementTests.mockEntrainementRepository
        );

    }

    @Test
    public void testCalcul() {

        CalculStatistiqueEntrainementTests.mockEntrainementRepository.repositoryMock.create(new Entrainement(CalculStatistiqueEntrainementTests.joueurs));
        CalculStatistiqueEntrainementTests.mockEntrainementRepository.repositoryMock.create(new Entrainement(CalculStatistiqueEntrainementTests.joueurs));

        Joueur bernard = CalculStatistiqueEntrainementTests.joueurs.get(0);
        CalculStatistiqueEntrainementTests.mockAbsenceRepository.repositoryMock.create(new Absence(bernard));


        var statistiqueEntrainements = CalculStatistiqueEntrainementTests.calculerStatistiqueEntrainement.calcul(CalculStatistiqueEntrainementTests.joueurs);


        var statBernard = statistiqueEntrainements.stream().filter( statistiqueEntrainement -> statistiqueEntrainement.getJoueur().id == bernard.id).findFirst();

        Assertions.assertTrue(statBernard.isPresent());

        Assertions.assertEquals(statBernard.get(), new StatistiqueEntrainement(bernard, 50.0));
    }


}
