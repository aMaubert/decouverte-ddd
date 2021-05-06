package com.example.project.mocks;

import com.example.project.models.Entrainement;
import com.example.project.models.EntrainementRepository;

import java.util.stream.Collectors;

public class MockEntrainementRepository implements EntrainementRepository {
    public final RepositoryMock<Entrainement>  repositoryMock;

    public MockEntrainementRepository() {
        this.repositoryMock = new RepositoryMock<Entrainement>();
    }


    @Override
    public int recupereNombreEntrainement(int joueurId) {
        var entrainementDunJoueur =  this.repositoryMock.stock.stream()
                                        .filter(entrainement -> estPresent(entrainement, joueurId))
                                            .collect(Collectors.toList()) ;
        return entrainementDunJoueur.size();
    }
    private boolean estPresent(Entrainement entrainement, int joueurId) {
        var found =  entrainement.getJoueurs().stream().filter(joueur -> joueur.id == joueurId).findFirst();
        return found.isPresent();
    }
}
