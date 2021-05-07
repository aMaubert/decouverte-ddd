package com.example.project.mocks;

import com.example.project.models.statistique.joueur.Absence;
import com.example.project.models.statistique.joueur.AbsenceRepository;

import java.util.List;

public class MockAbsenceRepository implements AbsenceRepository {

    public RepositoryMock<Absence>  repositoryMock;

    public MockAbsenceRepository() {
        this.repositoryMock = new RepositoryMock<Absence>();
    }

    @Override
    public List<Absence> recupereLesAbsences() {
        return this.repositoryMock.stock;
    }



//    @Override
//    public int recupereNombreAbsenceDunJoueur(int joueurId) {
//        var absenceDunJoueur = this.repositoryMock.stock.stream()
//                                                .filter(absence -> absence.getJoueur().id == joueurId)
//                                                .collect(Collectors.toList());
//        return absenceDunJoueur.size();
//    }
}
