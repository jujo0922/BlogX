package resources;

import org.jsoup.Jsoup;

public class HTMLFilter {

    public static String htmlToText(String html) {
        return Jsoup.parse(html).text();
    }
    
}
