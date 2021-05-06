package com.example.project.use_cases;

import com.example.project.mocks.MockAbsenceRepository;
import com.example.project.mocks.MockEntrainementRepository;
import com.example.project.models.*;
import com.example.project.use_cases.CalculerStatistiqueEntrainement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class CalculStatistiqueEntrainementTests {

    private MockEntrainementRepository mockEntrainementRepository;
    private MockAbsenceRepository mockAbsenceRepository;

    @Before
    public void setup() {
        this.mockEntrainementRepository = new MockEntrainementRepository();
        this.mockAbsenceRepository = new MockAbsenceRepository();
    }

    @Test
    public void devraitAvoir0EnTauxAbsence() {

        // Given :
        var joueurs = Arrays.asList(new Joueur(1), new Joueur(2), new Joueur(3));
        var calculerStatistiqueEntrainement = new CalculerStatistiqueEntrainement(mockAbsenceRepository, mockEntrainementRepository);

        mockEntrainementRepository.repositoryMock.create(new Entrainement(joueurs));
        mockEntrainementRepository.repositoryMock.create(new Entrainement(joueurs));

        //When
        var statistiqueEntrainements = calculerStatistiqueEntrainement.calcul(joueurs);
        //Then
        statistiqueEntrainements.forEach( statistiqueEntrainement -> {

            Assert.assertEquals(statistiqueEntrainement.getTauxAbsence(), 0.0, 0.0);
        });
    }

    @Test
    public void devraitAvoir1EnTauxAbsence() {

        // Given :
        var joueurs = Arrays.asList(new Joueur(1), new Joueur(2));
        var calculerStatistiqueEntrainement = new CalculerStatistiqueEntrainement(mockAbsenceRepository, mockEntrainementRepository);

        mockEntrainementRepository.repositoryMock.create(new Entrainement(joueurs));

        joueurs.forEach(joueur -> mockAbsenceRepository.repositoryMock.create(new Absence(joueur)) );

        //When
        var statistiqueEntrainements = calculerStatistiqueEntrainement.calcul(joueurs);
        //Then
        statistiqueEntrainements.forEach( statistiqueEntrainement -> {

            Assert.assertEquals(statistiqueEntrainement.getTauxAbsence(), 1.0, 0.0);
        });
    }


}