package com.example.project.mocks;

import com.example.project.models.Absence;
import com.example.project.models.AbsenceRepository;

import java.util.stream.Collectors;

public class MockAbsenceRepository implements AbsenceRepository {

    public RepositoryMock<Absence>  repositoryMock;

    public MockAbsenceRepository() {
        this.repositoryMock = new RepositoryMock<Absence>();
    }


    @Override
    public int recupereNombreAbsenceDunJoueur(int joueurId) {
        var absenceDunJoueur =   this.repositoryMock.stock.stream()
                                                .filter(absence -> absence.getJoueur().id == joueurId)
                                                .collect(Collectors.toList());
        return absenceDunJoueur.size();
    }
}
