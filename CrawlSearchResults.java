package com.sagarstudios

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

/**
 * Simple Piece of Code to Crawl search results in Java
 * Created by Karthik Sagar on 4/11/2017
 */
 
public class CrawlSearchResults {


    public static void main(String[] args) {

        CrawlSearchResults crawler = new CrawlSearchResults();
        crawler.getDataFromGoogle("Enter your search Query Here");
    }


    /**
      * The function below takes in Your query, asks it to google and logs the results on the console.
      *
      * @param  query The query string for which you would like to crawl
      * @return      the image at the specified URL
      * @see         Image
      */
    private void getDataFromGoogle(String query) {

        String request = "https://www.google.com/search?q=" + query + "&num=10";
        System.out.println("Sending request..." + request);

        try {
            // For Http protocol use this as Google bot agent
            Document doc = Jsoup
                    .connect(request)
                    .userAgent("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)")
                    .timeout(1000).get();

            Elements posts = doc.select("h3");
            for (Element link : posts) {
                System.out.println(link);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
