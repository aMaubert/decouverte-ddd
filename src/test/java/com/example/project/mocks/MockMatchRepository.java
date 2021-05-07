package com.example.project.mocks;

import com.example.project.models.statistique.match.Match;
import com.example.project.models.MatchRepository;

import java.util.ArrayList;

public class MockMatchRepository implements MatchRepository {
    public final RepositoryMock<Match>  repositoryMock;

    public MockMatchRepository() {
        this.repositoryMock = new RepositoryMock<Match>();
    }

    @Override
    public int recupereNombreMatch(int equipeId) {
        var matchsDuneEquipe = new ArrayList<>(this.repositoryMock.stock);
        return matchsDuneEquipe.size();
    }
}
