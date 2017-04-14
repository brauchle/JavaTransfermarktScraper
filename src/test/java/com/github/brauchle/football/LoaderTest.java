package com.github.brauchle.football;

import com.github.brauchle.football.beans.LEAGUE;
import com.github.brauchle.football.beans.SimpleTMMatchBean;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by andreasbrauchle on 14.04.17.
 */
public class LoaderTest {
    @Test
    public void loadData() throws Exception {
        LEAGUE leagueType = LEAGUE.PREMIER_LEAGUE;

        List<List<SimpleTMMatchBean>> lists = Loader.loadData(leagueType, 2015, 1, 1, leagueType.getCountMatchdays());
        assertEquals(lists.size(), leagueType.getCountMatchdays());
        int allMatches = 0;
        for (List<SimpleTMMatchBean> matchday : lists) {
            assertEquals(matchday.size(), leagueType.getCountMatchesPerMatchday());
            for (SimpleTMMatchBean singleMatch : matchday) {
                System.out.println(singleMatch.toString());
                allMatches++;
            }
            System.out.println();
        }
        assertEquals(allMatches, leagueType.getCountMatchesPerSeason());
    }

}