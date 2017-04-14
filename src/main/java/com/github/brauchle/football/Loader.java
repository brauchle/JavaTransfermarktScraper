package com.github.brauchle.football;

import com.github.brauchle.football.beans.LEAGUE;
import com.github.brauchle.football.beans.MatchBeanFactory;
import com.github.brauchle.football.beans.SimpleTMMatchBean;
import com.github.brauchle.football.beans.TMMatchBeanInterface;
import com.github.brauchle.football.loaderClasses.SaisonLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andreasbrauchle on 07.07.16.
 */
public class Loader {

    public static List<List<SimpleTMMatchBean>> loadData(LEAGUE liga, int fromSaison, int countSeasons, int start, int anzahlSpieltage) {
        List<List<TMMatchBeanInterface>> lists = loadData(liga, fromSaison, countSeasons, start, anzahlSpieltage, new MatchBeanFactory() {
            @Override
            public TMMatchBeanInterface createTMMatchBean() {
                return new SimpleTMMatchBean();
            }
        });
        return (List) lists;
    }

    public static List<List<TMMatchBeanInterface>> loadData(LEAGUE liga, int fromSaison, int countSeasons, int start, int anzahlSpieltage, MatchBeanFactory matchBeanFactory) {
        List<List<List<TMMatchBeanInterface>>> all = new ArrayList<>();

        int count = 0;
        while (count < countSeasons){
            System.out.println("Loading Season " + fromSaison);
            try {
                List<List<TMMatchBeanInterface>> season = SaisonLoader.loadSeason(liga, fromSaison + "", start, anzahlSpieltage, matchBeanFactory);
                all.add(season);
            }catch (Exception e){
                e.printStackTrace();
            }
            fromSaison++;
            System.out.println("___ ___ ___ ___ ___ ___ ___ ___ ___ ___ ___ ___ ___ ___ ___ ___ ___ ___ ___ ");
            count ++;
        }

        List<List<TMMatchBeanInterface>> allMatches = new ArrayList<>();
        for (List<List<TMMatchBeanInterface>> saison : all) {
            allMatches.addAll(saison);
        }

        return allMatches;
    }
}
