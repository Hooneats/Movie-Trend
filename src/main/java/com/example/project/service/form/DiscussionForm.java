package com.example.project.service.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscussionForm {

    @NotEmpty(message = "Subject can't be Empty")
    private String subject;
    @NotEmpty(message = "Content can't be Empty")
    private String content;

    private String movieTitle;
    private String movieImage;

    public void ifNullMovie(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }

    public void existMovie(String movieTitle, String movieImage) {
        this.movieTitle = movieTitle;
        this.movieImage = movieImage;
    }


}
