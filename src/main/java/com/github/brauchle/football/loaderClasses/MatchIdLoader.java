package com.github.brauchle.football.loaderClasses;

import com.github.brauchle.football.util.JSoupLoader;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andreasbrauchle on 22.06.16.
 */
public class MatchIdLoader {

    public static List<List<String>> loadMatchIds(int start, String url, int count, int countPerDay) {
        List<List<String>> saison= new ArrayList<>();

        for (int i = start; i <= count; i++) {
            System.out.println("Matchday: " + i + " - ");
            List<String> matchday = new ArrayList<>();
            saison.add(matchday);

            Document doc = JSoupLoader.getDocument(url + i);
            if (doc == null) {
                System.out.println("   --> Jsoup get Document failed");
                return null;
            }

            Elements select = doc.select(".large-8");
            for (Element footer : select.select(".footer")) {
                Elements select1 = footer.select("a");
                if (select1 != null && select1.size() > 0) {
                    String link = select1.attr("href");
                    link = link.substring(link.lastIndexOf("/") + 1, link.length());

                    if (link.isEmpty()) {
                        link = footer.previousElementSibling().select(".ergebnis-box").select("a").attr("href");
                        link = link.substring(link.lastIndexOf("/") + 1, link.length());
                        if (link.isEmpty()) {
                            System.out.println("   --> link is empty!!!");
                        }
                    }

                    matchday.add(link);
                }
            }

            if (matchday.size() != countPerDay) {
                System.out.println("   --> incorrect amount of matches!");
            }else {
                System.out.println("   found " + matchday.size() + " matches");
            }

        }

        return saison;

    }
}
