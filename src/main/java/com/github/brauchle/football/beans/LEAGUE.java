package com.github.brauchle.football.beans;

/**
 * Created by andreasbrauchle on 23.06.16.
 */
public enum LEAGUE{
    BUNDESLIGA,
    PREMIER_LEAGUE;

    public int getCountMatchesPerSeason(){
        return getCountMatchdays() * getCountMatchesPerMatchday();
    }

    public int getCountMatchesPerMatchday(){
        switch (this) {
            case BUNDESLIGA:
                return 9;
            case PREMIER_LEAGUE:
                return 10;
        }
        return 9;
    }

    public int getCountMatchdays(){
        switch (this) {
            case BUNDESLIGA:
                return 34;
            case PREMIER_LEAGUE:
                return 38;
        }

        return 34;
    }

    public String getLigaID(){
        switch (this) {
            case PREMIER_LEAGUE:
                return "GB1";
            case BUNDESLIGA:
                return "L1";
        }

        return null;
    }
}
