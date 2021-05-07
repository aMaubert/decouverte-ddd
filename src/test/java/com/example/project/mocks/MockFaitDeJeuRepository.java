package com.example.project.mocks;

import com.example.project.models.statistique.match.faitDeJeu.FaitDeJeu;
import com.example.project.models.statistique.match.faitDeJeu.FaitDeJeuRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MockFaitDeJeuRepository implements FaitDeJeuRepository {
    public final RepositoryMock<FaitDeJeu>  repositoryMock;

    public MockFaitDeJeuRepository() {
        this.repositoryMock = new RepositoryMock<FaitDeJeu>();
    }

    @Override
    public List<FaitDeJeu> recupereFaitDeJeuParIdDeMatch(int matchId) {

        return repositoryMock.stock.stream().collect(Collectors.toList());
    }
}
