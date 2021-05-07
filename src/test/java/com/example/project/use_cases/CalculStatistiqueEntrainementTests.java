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
        var statistiqueEntrainements = calculerStatistiqueEntrainement.calculStatistiques(joueurs);
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
        var statistiqueEntrainements = calculerStatistiqueEntrainement.calculStatistiques(joueurs);
        //Then
        statistiqueEntrainements.forEach( statistiqueEntrainement -> {
            Assert.assertEquals(1.0, statistiqueEntrainement.getTauxAbsence(), 0.0);
        });
    }

    @Test
    public void devraitExploserQuandIlYA0Entrainement() {
        // Given :
        var joueurs = Arrays.asList(new Joueur(1), new Joueur(2));
        var calculerStatistiqueEntrainement = new CalculerStatistiqueEntrainement(mockAbsenceRepository, mockEntrainementRepository);

        Assert.assertThrows( "Le nombre d'entrainements doit être plus grand que 0",IllegalArgumentException.class, () -> {
             calculerStatistiqueEntrainement.calculStatistiques(joueurs);
        });

    }

    @Test
    public void devraitExploserQuandLeNombreDAbsencesEstPlusEleveesQueLeNombreDEntrainements() {
        // Given :
        var joueurs = Arrays.asList(new Joueur(1), new Joueur(2));
        var calculerStatistiqueEntrainement = new CalculerStatistiqueEntrainement(mockAbsenceRepository, mockEntrainementRepository);

        //1 entrainement
        mockEntrainementRepository.repositoryMock.create(new Entrainement(joueurs));

        for (Joueur joueur: joueurs) {
            //2 absences
            mockAbsenceRepository.repositoryMock.create(new Absence(joueur));
            mockAbsenceRepository.repositoryMock.create(new Absence(joueur));
        }

        Assert.assertThrows( "Le nombre d'entrainements ne peut pas être inférieur au nombre d'absences",IllegalArgumentException.class, () -> {
            calculerStatistiqueEntrainement.calculStatistiques(joueurs);
        });

    }


}
