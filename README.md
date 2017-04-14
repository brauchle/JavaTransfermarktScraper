### About this project
This projects loads data from the german site www.transfermarkt.de, using the JSOUP-library for crawling the data.
Tested for the German Bundesliga and the English Premier-League.

Loaded Data are:
- matchID
- saison
- date
- time
- teamNameHome
- teamNameAway
- matchday
- matchResult
- goalsShotHome
- goalsShotAway
- goalsHalftimeHome
- goalsHalftimeAway
- attendance

And the following stats for each team:
- ballPossession
- totalShots
- shotsOnGoal
- shotsMissedGoal
- savedShotsOnGoal
- corners
- freekicks
- fouls
- offsides

### Usage:
#### Loader
Loads Matches, two possible Usages:
- using the provided SimpleTMMatchBean
    ```
    LEAGUE leagueType = LEAGUE.BUNDESLIGA;
    // LEAGUE leagueType = LEAGUE.PREMIER_LEAGUE;

    List<List<SimpleTMMatchBean>> lists = Loader.loadData(leagueType, 2015, 1, 1, leagueType.getCountMatchdays());
    
    for (List<SimpleTMMatchBean> matchday : lists) {
        for (SimpleTMMatchBean singleMatch : matchday) {
            System.out.println(singleMatch.toString());
        }
    }
    ```
- using a List of your own Beans implementing the TMMatchBeanInterface
    ```
    LEAGUE leagueType = LEAGUE.BUNDESLIGA;
    List<List<YourOwnBean>> lists = Loader.loadData(leagueType, 2015, 1, 1, leagueType.getCountMatchdays(), new MatchBeanFactory() {
        @Override
        public TMMatchBeanInterface createTMMatchBean() {
            return new YourOwnBean();
        }
    });
    ```

### Examples
```
SimpleTMMatchBean{
    matchID='2581147', saison='2015', date='14.08.2015', time='20:30', matchday='1', attendance=75024,
    teamNameHome='FC Bayern München', teamNameAway='Hamburger SV', matchResult='1', 
    goalsShotHome=5, goalsShotAway=0, goalsHalftimeHome=1, goalsHalftimeAway=0, 
    ballPossessionHOME=65, totalShotsHOME=18, shotsOnGoalHOME=8, shotsMissedGoalHOME=10, 
    savedShotsOnGoalHOME=1, cornersHOME=7, freekicksHOME=12, foulsHOME=10, offsidesHOME=3, 
    ballPossessionAWAY=35, totalShotsAWAY=4, shotsOnGoalAWAY=1, shotsMissedGoalAWAY=3, 
    savedShotsOnGoalAWAY=3, cornersAWAY=0, freekicksAWAY=13, foulsAWAY=12, offsidesAWAY=0
}

SimpleTMMatchBean{
    matchID='2581150', saison='2015', date='15.08.2015', time='15:30', matchday='1', attendance=27125,  
    teamNameHome='Bayer 04 Leverkusen', teamNameAway='TSG 1899 Hoffenheim', matchResult='1', 
    goalsShotHome=2, goalsShotAway=1, goalsHalftimeHome=1, goalsHalftimeAway=1, 
    ballPossessionHOME=52, totalShotsHOME=15, shotsOnGoalHOME=7, shotsMissedGoalHOME=8,
    savedShotsOnGoalHOME=2, cornersHOME=13, freekicksHOME=19, foulsHOME=12, offsidesHOME=2,
    ballPossessionAWAY=48, totalShotsAWAY=5, shotsOnGoalAWAY=3, shotsMissedGoalAWAY=2,
    savedShotsOnGoalAWAY=5, cornersAWAY=5, freekicksAWAY=14, foulsAWAY=18, offsidesAWAY=1
}

SimpleTMMatchBean{
    matchID='2581153', saison='2015', date='15.08.2015', time='15:30', attendance=17000,  
    matchday='1', teamNameHome='SV Darmstadt 98', teamNameAway='Hannover 96', matchResult='X', 
    goalsShotHome=2, goalsShotAway=2, goalsHalftimeHome=1, goalsHalftimeAway=0, 
    ballPossessionHOME=52, totalShotsHOME=8, shotsOnGoalHOME=5, shotsMissedGoalHOME=3, 
    savedShotsOnGoalHOME=3, cornersHOME=5, freekicksHOME=23, foulsHOME=19, offsidesHOME=0, 
    ballPossessionAWAY=48, totalShotsAWAY=7, shotsOnGoalAWAY=5, shotsMissedGoalAWAY=2, 
    savedShotsOnGoalAWAY=2, cornersAWAY=9, freekicksAWAY=19, foulsAWAY=22, offsidesAWAY=1
}
```
    
### License
This package is licensed under MIT license. See LICENSE for details.