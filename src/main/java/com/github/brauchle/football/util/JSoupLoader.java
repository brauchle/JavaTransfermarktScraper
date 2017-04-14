package com.github.brauchle.football.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by andreasbrauchle on 23.06.16.
 */
public class JSoupLoader {

    public static Document getDocument(String s) {
        Document document = null;
        for (int i = 0; i < 15; i++) {
            try {
                document = Jsoup.connect(s)
                        .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                        .referrer("http://www.google.com")
                        .get();
            } catch (IOException e) {
                System.out.println("   --> Failed to load " + s);
            }

            if (document != null) {
                return document;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
