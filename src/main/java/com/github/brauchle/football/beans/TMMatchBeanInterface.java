package com.github.brauchle.football.beans;

/**
 * Created by andreasbrauchle on 13.04.17.
 */
public interface TMMatchBeanInterface {

    void setMatchID(String matchID);

    void setLeagueName(String leagueName);

    void setSaison(String saison);

    void setTeamNameHome(String teamNameHome);

    void setTeamNameAway(String teamNameAway);

    void setMatchday(String matchday);

    void setDate(String date);

    void setTime(String time);

    void setGoalsShotHome(Integer goalsShotHome);

    void setGoalsShotAway(Integer goalsShotAway);

    void setGoalsHalftimeHome(Integer goalsHalftimeHome);

    void setGoalsHalftimeAway(Integer goalsHalftimeAway);

    void setMatchResult(String matchResult);

    void setAttendance(Integer Attendance);

    void setBallPossession(boolean home, Integer ballPossession);

    void setTotalShots(boolean home, Integer totalShots);

    void setShotsOnGoal(boolean home, Integer shotsOnGoal);

    void setShotsMissedGoal(boolean home, Integer shotsMissedGoal);

    void setSavedShotsOnGoal(boolean home, Integer savedShotsOnGoal);

    void setCorners(boolean home, Integer corners);

    void setFreekicks(boolean home, Integer freekicks);

    void setFouls(boolean home, Integer fouls);

    void setOffsides(boolean home, Integer offsides);

}
