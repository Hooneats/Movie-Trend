package com.example.project.service;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class JsonDetailVo {

    private Boolean adult;
    private String backdrop_path;
    private Object belongs_to_collection;
    private int budget;
    private List<Map> genres;
    private String homepage;
    private int id;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private Long popularity;
    private String poster_path;
    private List<Map> production_companies;
    private List<Map> production_countries;
    private String release_date;
    private int revenue;
    private Long runtime;
    private List<Map> spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private Boolean video;
    private Long vote_average;
    private Long vote_count;


}
