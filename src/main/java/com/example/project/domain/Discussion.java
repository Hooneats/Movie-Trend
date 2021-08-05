package com.example.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @Column(name = "content", length = 1000)
    private String content;

    @Column(name = "create_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createTime;

    @Embedded
    private DiscussionMovie discussionMovie;

//    public void addUser(User user) {
//        this.user = user;
//        user.getDiscussionList().add(this);
//    }

    public Discussion(Long id, String subject, String content, DiscussionMovie discussionMovie, Date createTime) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.discussionMovie = discussionMovie;
        this.createTime = createTime;
    }
    public Discussion(Long id, String subject, String content, Date createTime) {
        this.subject = subject;
        this.content = content;
        this.createTime = createTime;
    }

    public void inputMovie(DiscussionMovie movie) {
        this.discussionMovie = movie;
    }
}
