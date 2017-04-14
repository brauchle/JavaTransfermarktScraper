package com.github.brauchle.football.beans;

/**
 * Created by andreasbrauchle on 14.04.17.
 */
public class SimpleTMMatchBean implements TMMatchBeanInterface{

    private String matchID;
    private String leagueName;
    private String saison;
    private String teamNameHome;
    private String teamNameAway;
    private String date;
    private String time;
    private String matchday;
    private String matchResult;

    private Integer goalsShotHome;
    private Integer goalsShotAway;
    private Integer goalsHalftimeHome;
    private Integer goalsHalftimeAway;
    private Integer attendance;

    private Integer ballPossessionHOME;
    private Integer totalShotsHOME;
    private Integer shotsOnGoalHOME;
    private Integer shotsMissedGoalHOME;
    private Integer savedShotsOnGoalHOME;
    private Integer cornersHOME;
    private Integer freekicksHOME;
    private Integer foulsHOME;
    private Integer offsidesHOME;

    private Integer ballPossessionAWAY;
    private Integer totalShotsAWAY;
    private Integer shotsOnGoalAWAY;
    private Integer shotsMissedGoalAWAY;
    private Integer savedShotsOnGoalAWAY;
    private Integer cornersAWAY;
    private Integer freekicksAWAY;
    private Integer foulsAWAY;
    private Integer offsidesAWAY;

    public String getMatchID() {
        return matchID;
    }

    @Override
    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }

    public String getLeagueName() {
        return leagueName;
    }

    @Override
    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getSaison() {
        return saison;
    }

    @Override
    public void setSaison(String saison) {
        this.saison = saison;
    }

    public String getTeamNameHome() {
        return teamNameHome;
    }

    @Override
    public void setTeamNameHome(String teamNameHome) {
        this.teamNameHome = teamNameHome;
    }

    public String getTeamNameAway() {
        return teamNameAway;
    }

    @Override
    public void setTeamNameAway(String teamNameAway) {
        this.teamNameAway = teamNameAway;
    }

    public String getDate() {
        return date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public void setTime(String time) {
        this.time = time;
    }

    public String getMatchday() {
        return matchday;
    }

    @Override
    public void setMatchday(String matchday) {
        this.matchday = matchday;
    }

    public String getMatchResult() {
        return matchResult;
    }

    @Override
    public void setMatchResult(String matchResult) {
        this.matchResult = matchResult;
    }

    public Integer getGoalsShotHome() {
        return goalsShotHome;
    }

    @Override
    public void setGoalsShotHome(Integer goalsShotHome) {
        this.goalsShotHome = goalsShotHome;
    }

    public Integer getGoalsShotAway() {
        return goalsShotAway;
    }

    @Override
    public void setGoalsShotAway(Integer goalsShotAway) {
        this.goalsShotAway = goalsShotAway;
    }

    public Integer getGoalsHalftimeHome() {
        return goalsHalftimeHome;
    }

    @Override
    public void setGoalsHalftimeHome(Integer goalsHalftimeHome) {
        this.goalsHalftimeHome = goalsHalftimeHome;
    }

    public Integer getGoalsHalftimeAway() {
        return goalsHalftimeAway;
    }

    @Override
    public void setGoalsHalftimeAway(Integer goalsHalftimeAway) {
        this.goalsHalftimeAway = goalsHalftimeAway;
    }

    public Integer getAttendance() {
        return attendance;
    }

    @Override
    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    public Integer getBallPossessionHOME() {
        return ballPossessionHOME;
    }

    public void setBallPossessionHOME(Integer ballPossessionHOME) {
        this.ballPossessionHOME = ballPossessionHOME;
    }

    public Integer getTotalShotsHOME() {
        return totalShotsHOME;
    }

    public void setTotalShotsHOME(Integer totalShotsHOME) {
        this.totalShotsHOME = totalShotsHOME;
    }

    public Integer getShotsOnGoalHOME() {
        return shotsOnGoalHOME;
    }

    public void setShotsOnGoalHOME(Integer shotsOnGoalHOME) {
        this.shotsOnGoalHOME = shotsOnGoalHOME;
    }

    public Integer getShotsMissedGoalHOME() {
        return shotsMissedGoalHOME;
    }

    public void setShotsMissedGoalHOME(Integer shotsMissedGoalHOME) {
        this.shotsMissedGoalHOME = shotsMissedGoalHOME;
    }

    public Integer getSavedShotsOnGoalHOME() {
        return savedShotsOnGoalHOME;
    }

    public void setSavedShotsOnGoalHOME(Integer savedShotsOnGoalHOME) {
        this.savedShotsOnGoalHOME = savedShotsOnGoalHOME;
    }

    public Integer getCornersHOME() {
        return cornersHOME;
    }

    public void setCornersHOME(Integer cornersHOME) {
        this.cornersHOME = cornersHOME;
    }

    public Integer getFreekicksHOME() {
        return freekicksHOME;
    }

    public void setFreekicksHOME(Integer freekicksHOME) {
        this.freekicksHOME = freekicksHOME;
    }

    public Integer getFoulsHOME() {
        return foulsHOME;
    }

    public void setFoulsHOME(Integer foulsHOME) {
        this.foulsHOME = foulsHOME;
    }

    public Integer getOffsidesHOME() {
        return offsidesHOME;
    }

    public void setOffsidesHOME(Integer offsidesHOME) {
        this.offsidesHOME = offsidesHOME;
    }

    public Integer getBallPossessionAWAY() {
        return ballPossessionAWAY;
    }

    public void setBallPossessionAWAY(Integer ballPossessionAWAY) {
        this.ballPossessionAWAY = ballPossessionAWAY;
    }

    public Integer getTotalShotsAWAY() {
        return totalShotsAWAY;
    }

    public void setTotalShotsAWAY(Integer totalShotsAWAY) {
        this.totalShotsAWAY = totalShotsAWAY;
    }

    public Integer getShotsOnGoalAWAY() {
        return shotsOnGoalAWAY;
    }

    public void setShotsOnGoalAWAY(Integer shotsOnGoalAWAY) {
        this.shotsOnGoalAWAY = shotsOnGoalAWAY;
    }

    public Integer getShotsMissedGoalAWAY() {
        return shotsMissedGoalAWAY;
    }

    public void setShotsMissedGoalAWAY(Integer shotsMissedGoalAWAY) {
        this.shotsMissedGoalAWAY = shotsMissedGoalAWAY;
    }

    public Integer getSavedShotsOnGoalAWAY() {
        return savedShotsOnGoalAWAY;
    }

    public void setSavedShotsOnGoalAWAY(Integer savedShotsOnGoalAWAY) {
        this.savedShotsOnGoalAWAY = savedShotsOnGoalAWAY;
    }

    public Integer getCornersAWAY() {
        return cornersAWAY;
    }

    public void setCornersAWAY(Integer cornersAWAY) {
        this.cornersAWAY = cornersAWAY;
    }

    public Integer getFreekicksAWAY() {
        return freekicksAWAY;
    }

    public void setFreekicksAWAY(Integer freekicksAWAY) {
        this.freekicksAWAY = freekicksAWAY;
    }

    public Integer getFoulsAWAY() {
        return foulsAWAY;
    }

    public void setFoulsAWAY(Integer foulsAWAY) {
        this.foulsAWAY = foulsAWAY;
    }

    public Integer getOffsidesAWAY() {
        return offsidesAWAY;
    }

    public void setOffsidesAWAY(Integer offsidesAWAY) {
        this.offsidesAWAY = offsidesAWAY;
    }

    @Override
    public void setBallPossession(boolean home, Integer ballPossession) {
        if (home) {
            setBallPossessionHOME(ballPossession);
        }else {
            setBallPossessionAWAY(ballPossession);
        }
    }

    @Override
    public void setTotalShots(boolean home, Integer totalShots) {
        if (home) {
            setTotalShotsHOME(totalShots);
        }else {
            setTotalShotsAWAY(totalShots);
        }
    }

    @Override
    public void setShotsOnGoal(boolean home, Integer shotsOnGoal) {
        if (home) {
            setShotsOnGoalHOME(shotsOnGoal);
        }else {
            setShotsOnGoalAWAY(shotsOnGoal);
        }
    }

    @Override
    public void setShotsMissedGoal(boolean home, Integer shotsMissedGoal) {
        if (home) {
            setShotsMissedGoalHOME(shotsMissedGoal);
        }else {
            setShotsMissedGoalAWAY(shotsMissedGoal);
        }
    }

    @Override
    public void setSavedShotsOnGoal(boolean home, Integer savedShotsOnGoal) {
        if (home) {
            setSavedShotsOnGoalHOME(savedShotsOnGoal);
        }else {
            setSavedShotsOnGoalAWAY(savedShotsOnGoal);
        }
    }

    @Override
    public void setCorners(boolean home, Integer corners) {
        if (home) {
            setCornersHOME(corners);
        }else {
            setCornersAWAY(corners);
        }
    }

    @Override
    public void setFreekicks(boolean home, Integer freekicks) {
        if (home) {
            setFreekicksHOME(freekicks);
        }else {
            setFreekicksAWAY(freekicks);
        }
    }

    @Override
    public void setFouls(boolean home, Integer fouls) {
        if (home) {
            setFoulsHOME(fouls);
        }else {
            setFoulsAWAY(fouls);
        }
    }

    @Override
    public void setOffsides(boolean home, Integer offsides) {
        if (home) {
            setOffsidesHOME(offsides);
        }else {
            setOffsidesAWAY(offsides);
        }
    }

    @Override
    public String toString() {
        return "SimpleTMMatchBean{" +
                "matchID='" + matchID + '\'' +
                ", saison='" + saison + '\'' +
                ", teamNameHome='" + teamNameHome + '\'' +
                ", teamNameAway='" + teamNameAway + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", matchday='" + matchday + '\'' +
                ", matchResult='" + matchResult + '\'' +
                ", goalsShotHome=" + goalsShotHome +
                ", goalsShotAway=" + goalsShotAway +
                ", goalsHalftimeHome=" + goalsHalftimeHome +
                ", goalsHalftimeAway=" + goalsHalftimeAway +
                ", attendance=" + attendance +
                '}';
    }
}
