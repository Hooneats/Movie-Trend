package com.example.project.service.vo;


import lombok.Data;

import java.sql.Date;

//original_title, poster_path, vote_average, overview, release_date, title, original_language , id, backdrop_path
// id   original_title  title   original_language   release_date    vote_average    overview    poster_path     backdrop_path
@Data
public class MovieVo {

    private Long id;
    private String original_title;
    private String title;
    private String original_language;
    private Date release_date;
    private String vote_average;
    private String overview;
    private String poster_path;
    private String backdrop_path;


}
