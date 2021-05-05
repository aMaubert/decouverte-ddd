package com.example.project.models;

import java.util.List;

public interface FaitDeJeuRepository {

    List<FaitDeJeu> recupereFaitDeJeuParIdDeMatch(int matchId);
}
