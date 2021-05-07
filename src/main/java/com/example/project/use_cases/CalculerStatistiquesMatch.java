package com.example.project.use_cases;

import com.example.project.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculerStatistiquesMatch {

    //TODO: TO IMPLEMENT

    /*FaitDeJeuRepository faitDeJeuRepository;

    public CalculerStatistiquesMatch(FaitDeJeuRepository faitDeJeuRepository) {
        this.faitDeJeuRepository = faitDeJeuRepository;
    }

    public List<StatistiqueMatch> calcul(List<Match> matchs ) {
        return matchs.stream()
                     .map(match -> {
                            List<FaitDeJeu> faitDeJeuList = faitDeJeuRepository.recupereFaitDeJeuParIdDeMatch(match.id);
                            var statsParFaitsDeJeu = calculStatsParFaitsDeJeu(faitDeJeuList);

                         return new StatistiqueMatch( statsParFaitsDeJeu );
                     })
                     .collect(Collectors.toList());
    }

    private Map<MatchPeriod, Map<FaitDeJeuType, Integer>> calculStatsParFaitsDeJeu(List<FaitDeJeu> faitsDeJeu) {
        Map<MatchPeriod, Map<FaitDeJeuType, Integer>> ret = new HashMap<>();
        for (MatchPeriod period : MatchPeriod.values()) {
            for(FaitDeJeuType type : FaitDeJeuType.values()) {
                Map<FaitDeJeuType, Integer> mapFaitsDeJeu = new HashMap<FaitDeJeuType, Integer>();
                mapFaitsDeJeu.put(type, 0);
                ret.put(period, mapFaitsDeJeu);
            }
        }
        return ret;
    }
*/

}
