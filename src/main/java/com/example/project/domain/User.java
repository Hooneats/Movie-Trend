package com.example.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;

    private String pwd;

    private String email;

    @Temporal(value = TemporalType.DATE)
    private Date createDate;

//    @OneToMany(mappedBy = "user")
//    private List<Discussion> discussionList = new ArrayList<>();

    public User(String name, String pwd, String email, Date createDate) {
        this.name = name;
        this.pwd = pwd;
        this.email = email;
        this.createDate = createDate;
    }
}
