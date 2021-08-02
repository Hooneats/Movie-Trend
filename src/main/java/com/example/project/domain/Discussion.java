package com.example.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "DISCUSSION")
@Getter
@NoArgsConstructor
public class Discussion {

    @Id
    @GeneratedValue
    @Column(name = "discussion_id")
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;

    @Column(name = "subject")
    private String subject;

    @Column(name = "content")
    private String content;

    @Column(name = "create_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createTime;

    @Embedded
    private Movie movie;

//    public void addUser(User user) {
//        this.user = user;
//        user.getDiscussionList().add(this);
//    }

    public Discussion(String subject, String content, Movie movie, Date createTime) {
        this.subject = subject;
        this.content = content;
        this.movie = movie;
        this.createTime = createTime;
    }
    public Discussion(String subject, String content, Date createTime) {
        this.subject = subject;
        this.content = content;
        this.movie = movie;
        this.createTime = createTime;
    }
}
