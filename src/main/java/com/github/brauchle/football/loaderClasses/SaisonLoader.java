package com.github.brauchle.football.loaderClasses;

import com.github.brauchle.football.beans.LEAGUE;
import com.github.brauchle.football.beans.MatchBeanFactory;
import com.github.brauchle.football.beans.TMMatchBeanInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andreasbrauchle on 23.06.16.
 */
public class SaisonLoader {

    public static List<List<TMMatchBeanInterface>> loadSeason(LEAGUE league, String saisonToLoad, int start, int anzahl, MatchBeanFactory matchBeanFactory) {
        System.out.println("Start - Loading the Match-IDs");
        List<List<String>> matchIdList = MatchIdLoader.loadMatchIds(start, "http://www.transfermarkt.de/jumplist/spieltag/wettbewerb/" + league.getLigaID() + "/saison_id/" + saisonToLoad + "/spieltag/", anzahl, league.getCountMatchesPerMatchday());

        System.out.println("");
        System.out.println("Start - Loading all Matches");
        List<List<TMMatchBeanInterface>> season = new ArrayList<>();

        if (matchIdList != null) {
            String urlSingleMatch = "http://www.transfermarkt.de/xxx/statistik/spielbericht/";

            for (List<String> s : matchIdList) {
                ArrayList<TMMatchBeanInterface> matchdayList = new ArrayList<>();
                System.out.println("Matchday " + (season.size() + 1));
                for (String matchId : s) {
                    try {
                        TMMatchBeanInterface match = MatchLoader.getData(urlSingleMatch + matchId, matchId, matchBeanFactory);
                        if (match == null) {
                            break;
                        }

                        match.setSaison(saisonToLoad);
                        if (matchId.equals("2321201")) {
                            //Mistake in the German Bundesliga
                            match.setSaison("2013");
                            match.setDate("22.12.2013");
                        }

                        matchdayList.add(match);
                    }catch (Exception e){
                        String matchURL =  urlSingleMatch + matchId;
                        System.out.println("--> Failed to load Match with URL: " + matchURL);
                        e.printStackTrace();
                    }
                }

                season.add(matchdayList);
                System.out.println("");
            }

            int count = 0;
            for (List<TMMatchBeanInterface> matchBeanInterfaceList: season) {
                count += matchBeanInterfaceList.size();
            }

            if (count != league.getCountMatchesPerSeason()) {
                System.out.println("--> wrong Number of Matchdays loaded: " + count + " statt " + league.getCountMatchesPerSeason());
            }else {
                System.out.println(count + " Matches loaded");
            }
        }
        return season;
    }
}
