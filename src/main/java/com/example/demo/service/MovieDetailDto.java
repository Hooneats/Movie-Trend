package com.example.demo.service;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MovieDetailDto {

    private Boolean adult;
    private String backdrop_path;
    private String poster_path;
    private String homepage;
    private String original_language;
    private String original_title;
    private String title;
    private String overview;
    private String release_date;
    private Long runtime;
    private String status;
    private Long vote_average;
    private Long vote_count;
    private List<String> genres;

    public MovieDetailDto(Boolean adult, String backdrop_path, String poster_path, String homepage, String original_language, String original_title, String title, String overview, String release_date, Long runtime, String status, Long vote_average, Long vote_count) {
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.poster_path = poster_path;
        this.homepage = homepage;
        this.original_language = original_language;
        this.original_title = original_title;
        this.title = title;
        this.overview = overview;
        this.release_date = release_date;
        this.runtime = runtime;
        this.status = status;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }
}
