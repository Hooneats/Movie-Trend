package com.example.demo.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TheMovieApiTest {

    private String my_id = "160f05c35f34aef167fabe796efb2a8e";

    public String mainPageInfo() {
        try {
            String url = "https://api.themoviedb.org/3/trending/movie/day?api_key=" + my_id;
            Connection.Response response = Jsoup.connect(url).method(Connection.Method.GET).
                    timeout(5000).ignoreContentType(true).execute();
            Document trend = response.parse();
            String mainResultText = trend.text();

            return mainResultText;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
//original_title, poster_path, vote_average, overview, release_date, title, original_language , id, backdrop_path
    public static void main(String[] args) {
        System.out.println(new TheMovieApiTest().mainPageInfo());
    }
}
