package com.github.brauchle.football.loaderClasses;

import com.github.brauchle.football.beans.MatchBeanFactory;
import com.github.brauchle.football.beans.TMMatchBeanInterface;
import com.github.brauchle.football.util.JSoupLoader;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by andreasbrauchle on 22.06.16.
 */
public class MatchLoader {

    public static TMMatchBeanInterface getData(String url, String matchID, MatchBeanFactory matchBeanFactory) {
        Document doc = JSoupLoader.getDocument(url);
        if (doc == null) {
            System.out.println("   Jsoup get Document failed");
            return null;
        }

        TMMatchBeanInterface match = matchBeanFactory.createTMMatchBean();
        match.setMatchID(matchID);

        Elements generalDataHead = doc.select(".sb-spielbericht-head").select(".box-content");

        Element homeTeamElement = generalDataHead.select(".sb-heim").get(0).select("a").get(0);
        String homeTeamName = homeTeamElement.select("img").attr("alt");
        match.setTeamNameHome(homeTeamName);

        Element awayTeamElement = generalDataHead.select(".sb-gast").get(0).select("a").get(0);
        String awayTeamName = awayTeamElement.select("img").attr("alt");
        match.setTeamNameAway(awayTeamName);

        Elements matchData = generalDataHead.select(".sb-spieldaten");

        //Datum + Spieltag
        Elements dateElement = matchData.select(".sb-datum").select("a");
        String matchday = dateElement.get(0).html().replace(". Spieltag", "");
        String date = dateElement.get(1).html();
        date = date.substring(date.indexOf(",") + 2, date.length());

        String time = matchData.select(".sb-datum").get(0).getAllElements().get(0).text();
        time = time.substring(time.length() - 9, time.length()).replace(" Uhr", "");
        match.setMatchday(matchday);
        match.setDate(date);
        match.setTime(time);

        String matchResult = matchData.select(".ergebnis-wrap").select(".sb-endstand").text();

        if (matchResult != null && !matchResult.equals("-:-")) {
            String[] split = matchResult.replace("(", "").replace(")", "").split(" ");
            String[] fullResult = split[0].split(":");
            String[] halftimeResult = split[1].split(":");

            int goalsShotHome = Integer.parseInt(fullResult[0]);
            int goalsShotAway = Integer.parseInt(fullResult[1]);

            match.setGoalsShotHome(goalsShotHome);
            match.setGoalsShotAway(goalsShotAway );
            match.setGoalsHalftimeHome(Integer.parseInt(halftimeResult[0]));
            match.setGoalsHalftimeAway(Integer.parseInt(halftimeResult[1]));

            if (goalsShotAway  > goalsShotHome) {
                match.setMatchResult("2");
            }else if (goalsShotAway < goalsShotHome){
                match.setMatchResult("1");
            }else {
                match.setMatchResult("X");
            }

            String attendanceData = matchData.select(".sb-zusatzinfos").select(".hide-for-small").select("strong").text();

            try {
                match.setAttendance(Integer.parseInt(attendanceData.replace(" Zuschauer", "").replace(".", "")));
            }catch (Exception e){
                //does not matter
            }

            //Attendance can be found in the Script-Part (as it's not a normal div-element)
            for (Element element : doc.select("script")) {
                String innerHtml = element.html().toLowerCase();
                String home = find("'name':'heim',", innerHtml);
                String away = find("'name':'gast',", innerHtml);

                if (home != null && away != null) {
                    Integer attendanceHome = findAttendance(home);
                    Integer attendanceAway = findAttendance(away);

                    if (attendanceHome == null || attendanceAway == null) {
                        System.out.println(url);
                    }else if (attendanceHome + attendanceAway != 100){
                        System.out.println("   --> Sum Attendance != 100!");
                    }else {
                        match.setBallPossession(true, attendanceHome);
                        match.setBallPossession(false, attendanceAway);
                    }
                }
            }

            //Rest are normal divs
            Elements select = doc.select(".sb-statistik");
            if (select.isEmpty()) {
                System.out.println("   --> could not load sb.statistik");
            }
            for (Element element : select) {
                String homeValue = element.select(".sb-statistik-heim").select(".sb-statistik-zahl").html();
                String awayValue = element.select(".sb-statistik-gast").select(".sb-statistik-zahl").html();
                int intHeim = Integer.parseInt(homeValue);
                int intGast = Integer.parseInt(awayValue);

                String text = element.previousElementSibling().html();
                switch (text) {
                    case "Torschüsse gesamt":
                        match.setTotalShots(true, intHeim);
                        match.setTotalShots(false, intGast);
                        break;
                    case "Schüsse auf das Tor":
                        match.setShotsOnGoal(true, intHeim);
                        match.setShotsOnGoal(false, intGast);
                        break;
                    case "Schüsse neben das Tor":
                        match.setShotsMissedGoal(true, intHeim);
                        match.setShotsMissedGoal(false, intGast);
                        break;
                    case "Torschüsse gehalten":
                        match.setSavedShotsOnGoal(true, intHeim);
                        match.setSavedShotsOnGoal(false, intGast);
                        break;
                    case "Eckbälle":
                        match.setCorners(true, intHeim);
                        match.setCorners(false, intGast);
                        break;
                    case "Freistöße":
                        match.setFreekicks(true, intHeim);
                        match.setFreekicks(false, intGast);
                        break;
                    case "Fouls":
                        match.setFouls(true, intHeim);
                        match.setFouls(false, intGast);
                        break;
                    case "Abseits":
                        match.setOffsides(true, intHeim);
                        match.setOffsides(false, intGast);
                        break;
                    default:
                        System.out.println("   --> case not found: " + text);
                }
            }
            System.out.println("   " + date + ", " + time + ", GameID " + matchID + ": " + homeTeamName + " vs. " + awayTeamName + " - " + goalsShotHome + ":" + goalsShotAway);
        }else {
            System.out.println("   " + date + ", " + time + ", GameID " + matchID + ": " + homeTeamName + " vs. " + awayTeamName + " (no Result loaded)");
        }

        return match;
    }


    private static Integer findAttendance(String element) {
        int pos = element.indexOf("'y':");
        String attendance = element.substring(pos + 4, pos + 6);
        try {
            return Integer.parseInt(attendance);
        }catch (NumberFormatException e){
            System.out.println("   --> failed to get Attendance");
            return null;
        }
    }

    private static String find(String search, String html) {
        if (html.contains(search)) {
            int i = html.indexOf(search);
            String subString = html.substring(i, i + 50);
            return subString;
        }
        return null;

    }
}
