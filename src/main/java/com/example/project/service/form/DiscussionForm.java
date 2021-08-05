package com.example.project.service.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscussionForm {

    private Long id;

    @NotEmpty(message = "Subject can't be Empty")
    private String subject;
    @NotEmpty(message = "Content can't be Empty")
    @Size(max = 1000, message = "Content cannot exceed 1000 characters.")
    private String content;

    private String movieTitle;
    private String movieImage;

    public void ifNullMovie(Long id, String subject, String content) {
        this.id = id;
        this.subject = subject;
        this.content = content;
    }

    public void existMovie(String movieTitle, String movieImage) {
        this.movieTitle = movieTitle;
        this.movieImage = movieImage;
    }


}
