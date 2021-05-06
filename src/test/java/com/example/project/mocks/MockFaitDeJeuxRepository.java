package com.example.project.mocks;

import com.example.project.models.Entrainement;
import com.example.project.models.EntrainementRepository;
import com.example.project.models.FaitDeJeu;
import com.example.project.models.FaitDeJeuRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MockFaitDeJeuxRepository implements FaitDeJeuRepository {
    public final RepositoryMock<FaitDeJeu>  repositoryMock;

    public MockFaitDeJeuxRepository() {
        this.repositoryMock = new RepositoryMock<FaitDeJeu>();
    }

    @Override
    public List<FaitDeJeu> recupereFaitDeJeuParIdDeMatch(int matchId) {
        return repositoryMock.stock.stream().collect(Collectors.toList());
    }
}
