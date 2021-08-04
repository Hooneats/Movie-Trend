package com.example.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Embeddable
@Data
@NoArgsConstructor
public class DiscussionMovie {

    private String movieTitle;
    private String movieImage;


    public DiscussionMovie(String movieTitle, String movieImage) {
        this.movieTitle = movieTitle;
        this.movieImage = movieImage;

    }
}
