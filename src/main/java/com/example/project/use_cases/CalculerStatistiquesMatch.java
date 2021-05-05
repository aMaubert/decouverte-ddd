package com.example.project.use_cases;

import com.example.project.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class NumberFaitDeJeuPerMatchPeriod {
    MatchPeriod period;
    int quantite;
    FaitDeJeuType type;
}

public class CalculerStatistiquesMatch {

    FaitDeJeuRepository faitDeJeuRepository;

    public CalculerStatistiquesMatch(FaitDeJeuRepository faitDeJeuRepository) {
        this.faitDeJeuRepository = faitDeJeuRepository;
    }

    public List<StatistiqueMatch> calcul(List<Match> matchs ) {
        return matchs.stream()
                     .map(match -> {
                            List<FaitDeJeu> faitDeJeuList = faitDeJeuRepository.recupereFaitDeJeuParIdDeMatch(match.id);
                            List<FaitDeJeu> butMarques =  faitDeJeuList.stream()
                                                                        .filter(faitDeJeu -> faitDeJeu.type.equals(FaitDeJeuType.BUT_MARQUE) )
                                                                        .collect(Collectors.toList());

//                            butMarques.stream()
//                                .reduce(new ArrayList<NumberFaitDeJeuPerMatchPeriod>(),
//                                        (faitDeJeuPerMatchPeriods, faitDeJeu) -> );

                         return new StatistiqueMatch( );
                     })
                     .collect(Collectors.toList());
    }


}
