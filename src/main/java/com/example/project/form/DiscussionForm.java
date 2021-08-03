package com.example.project.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class DiscussionForm {

    @NotEmpty(message = "Subject can't be Empty")
    private String subject;
    @NotEmpty(message = "Content can't be Empty")
    private String content;

    private String movieTitle;
    private String movieImage;



}
